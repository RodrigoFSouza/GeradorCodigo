package com.rfs.data.GeradorDTO.service;

import com.rfs.data.GeradorDTO.domain.model.Entidade;
import com.rfs.data.GeradorDTO.domain.repository.EntidadeRepository;
import com.rfs.data.GeradorDTO.domain.repository.filter.EntidadeFilter;
import com.rfs.data.GeradorDTO.repository.spec.EntidadeSpecs;
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
public class EntidadeService {
    private final Logger log = LoggerFactory.getLogger(EntidadeService.class);
    private final EntidadeRepository entidadeRepository;

    @Autowired
    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    @Transactional(readOnly = true)
    public Page<Entidade> findAllEntidades(EntidadeFilter filtros, Pageable pageable) {
        log.debug("SERVICE find by Entidades witch filters: {} and pagination: {}", filtros, pageable);

        return entidadeRepository.findAll(EntidadeSpecs.applyFilters(filtros), pageable);
    }

    @Transactional(readOnly = true)
    public Entidade findByEntidade(Long id) {
        log.debug("SERVICE find by Entidade with filter by id: {}", id);

        return entidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível encontrar uma entidade com esse id"));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Entidade createOrUpdate(Entidade entidade) {
        if (isNull(entidade.getId())) {
            return newEntidade(entidade);
        }
        return updateEntidade(entidade);
    }

    private Entidade updateEntidade(Entidade entidade) {
        log.debug("SERVICE persist new Entidade : {}", entidade);

        return this.entidadeRepository.save(entidade);
    }

    private Entidade newEntidade(Entidade entidade) {
        log.debug("SERVICE modify Entidade: {}", entidade);

        var entidadeUpdate = entidadeRepository.findById(entidade.getId()).map(e -> {
                e.mergeForUpdate(entidade);
                return e;
            }).orElseThrow();

        return this.entidadeRepository.save(entidadeUpdate);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteEntidade(Long id) {
        log.debug("SERVICE deleting Entidade with id: {}", id);

        var entidade = entidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada!"));
        this.entidadeRepository.delete(entidade);
    }
}
