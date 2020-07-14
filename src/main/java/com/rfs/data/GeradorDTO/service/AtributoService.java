package com.rfs.data.GeradorDTO.service;

import com.rfs.data.GeradorDTO.domain.model.Atributo;
import com.rfs.data.GeradorDTO.domain.repository.AtributoRepository;
import com.rfs.data.GeradorDTO.domain.repository.EntidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class AtributoService {
    public static final String ATRIBUTO_NAO_ENCONTRADO = "Atributo não encontrado!";
    public static final String ENTIDADE_NAO_ENCONTRADA = "Entidade não encontrada!";
    private final Logger log = LoggerFactory.getLogger(AtributoService.class);

    private final AtributoRepository atributoRepository;
    private final EntidadeRepository entidadeRepository;

    @Autowired
    public AtributoService(AtributoRepository atributoRepository, EntidadeRepository entidadeRepository) {
        this.atributoRepository = atributoRepository;
        this.entidadeRepository = entidadeRepository;
    }

    @Transactional(readOnly = true)
    public Page<Atributo> buscarAtributos(Long entidadeId, Pageable pageable) {
        log.debug("SERVICE list of Atributes in Entidade with id: {}", entidadeId);

        var entidade = entidadeRepository.findById(entidadeId).orElseThrow(() -> new RuntimeException(ENTIDADE_NAO_ENCONTRADA));
        return this.atributoRepository.findByEntidade(entidade, pageable);
    }

    @Transactional(readOnly = true)
    public Atributo findByAtributo(Long id) {
        log.debug("SERVICE find by Atributo of id: {}", id);

        return this.atributoRepository.findById(id).orElseThrow(() -> new RuntimeException(ATRIBUTO_NAO_ENCONTRADO));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Atributo createOfUpdate(Atributo atributo) {
        if (isNull(atributo)) {
            return newAtributo(atributo);
        }
        return updateAtributo(atributo);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAtributo(Long id) {
        var atributo = atributoRepository.findById(id).orElseThrow(() -> new RuntimeException(ATRIBUTO_NAO_ENCONTRADO));
        atributoRepository.delete(atributo);
    }

    private Atributo newAtributo(Atributo atributo) {
        log.debug("SERVICE create a new Atributo: {}", atributo);

        return atributoRepository.save(atributo);
    }

    private Atributo updateAtributo(Atributo atributo) {
        log.debug("SERVICE update Atributo: {}", atributo);

        var atributoUpdate = atributoRepository.findById(atributo.getId())
                .map(a -> a.mergeForUpdate(atributo))
                .orElseThrow(() -> new RuntimeException(ATRIBUTO_NAO_ENCONTRADO));

        return atributoRepository.save(atributoUpdate);
    }
}
