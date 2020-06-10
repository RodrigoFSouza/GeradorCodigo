package com.rfs.data.GeradorDTOservice.impl;

import com.rfs.data.GeradorDTOservice.AuditoriaService;
import com.rfs.data.GeradorDTOservice.UsuarioService;
import com.rfs.data.GeradorDTOdomain.Usuario;
import com.rfs.data.GeradorDTOrepository.UsuarioRepository;
import com.rfs.data.GeradorDTOservice.dto.UsuarioDTO;
import com.rfs.data.GeradorDTOservice.exceptions.DbsFlexoBusinessException;
import com.rfs.data.GeradorDTOservice.mapper.UsuarioMapper;
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
public class UsuarioServiceImpl implements UsuarioService {
    private static final String VEICULO_NAO_ENCONTRADO = "Usuario não encontrado.";
    private final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final AuditoriaService auditoriaService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, AuditoriaService auditoriaService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.auditoriaService = auditoriaService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        log.debug("Request to save Usuario : {}", usuarioDTO);
        if (isNull(usuarioDTO.getId())) {
            return create(usuarioDTO);
        }
        return update(usuarioDTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        log.debug("Criando uma nova usuario: {}", usuarioDTO);

        var usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setId(usuarioRepository.getUltimoId().orElse(0L) + 1L);
        usuario.setAuditoria(auditoriaService.setInclusao());

        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UsuarioDTO update(UsuarioDTO usuarioDTO) {
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
    public Page<UsuarioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Usuarios");
        return usuarioRepository.findAll(pageable)
                .map(usuarioMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findOne(Long id) {
        log.debug("Request to get Usuario : {}", id);
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Usuario : {}", id);
        usuarioRepository.deleteById(id);
    }
}

