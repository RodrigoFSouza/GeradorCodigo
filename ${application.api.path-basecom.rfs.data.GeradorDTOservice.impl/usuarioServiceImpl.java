package com.rfs.data.GeradorDTOservice.impl;

import com.rfs.data.GeradorDTOservice.AuditoriaService;
import com.rfs.data.GeradorDTOservice.usuarioService;
import com.rfs.data.GeradorDTOdomain.usuario;
import com.rfs.data.GeradorDTOrepository.usuarioRepository;
import com.rfs.data.GeradorDTOservice.dto.usuarioDTO;
import com.rfs.data.GeradorDTOservice.exceptions.DbsFlexoBusinessException;
import com.rfs.data.GeradorDTOservice.mapper.usuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class usuarioServiceImpl implements usuarioService {
    private static final String VEICULO_NAO_ENCONTRADO = "usuario não encontrado.";
    private final Logger log = LoggerFactory.getLogger(usuarioServiceImpl.class);
    private final usuarioRepository usuarioRepository;
    private final usuarioMapper usuarioMapper;
    private final AuditoriaService auditoriaService;

    @Autowired
    public usuarioServiceImpl(usuarioRepository usuarioRepository, usuarioMapper usuarioMapper, AuditoriaService auditoriaService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.auditoriaService = auditoriaService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public usuarioDTO save(usuarioDTO usuarioDTO) {
        log.debug("Request to save usuario : {}", usuarioDTO);
        if (isNull(usuarioDTO.getId())) {
            return create(usuarioDTO);
        }
        return update(usuarioDTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public usuarioDTO create(usuarioDTO usuarioDTO) {
        log.debug("Criando uma nova usuario: {}", usuarioDTO);

        var usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setId(usuarioRepository.getUltimoId().orElse(0L) + 1L);
        usuario.setAuditoria(auditoriaService.setInclusao());

        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public usuarioDTO update(usuarioDTO usuarioDTO) {
        log.debug("Atualizando uma usuario: {}", usuarioDTO);

        var usuario = usuarioMapper.toEntity(usuarioDTO);
        var usuarioUpdate = usuarioRepository.findById(usuario.getId())
                .map(r -> {
                    r.mergeForUpdate(usuario);
                    r.setAuditoria(auditoriaService.setAlteracao(r.getAuditoria()));
                    return r;
                })
                .orElseThrow(() -> new DbsFlexoBusinessException(VEICULO_NAO_ENCONTRADO));

        return usuarioMapper.toDto(usuarioRepository.save(usuarioUpdate));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<usuarioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all usuarios");
        return usuarioRepository.findAll(pageable)
                .map(usuarioMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<usuarioDTO> findOne(Long id) {
        log.debug("Request to get usuario : {}", id);
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete usuario : {}", id);
        usuarioRepository.deleteById(id);
    }
}

