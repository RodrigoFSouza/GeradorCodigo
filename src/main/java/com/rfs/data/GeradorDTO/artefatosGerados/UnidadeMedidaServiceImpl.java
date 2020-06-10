package com.rfs.data.GeradorDTOservice.impl;

import com.rfs.data.GeradorDTOservice.AuditoriaService;
import com.rfs.data.GeradorDTOservice.UnidadeMedidaService;
import com.rfs.data.GeradorDTOdomain.UnidadeMedida;
import com.rfs.data.GeradorDTOrepository.UnidadeMedidaRepository;
import com.rfs.data.GeradorDTOservice.dto.UnidadeMedidaDTO;
import com.rfs.data.GeradorDTOservice.exceptions.DbsFlexoBusinessException;
import com.rfs.data.GeradorDTOservice.mapper.UnidadeMedidaMapper;
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
public class UnidadeMedidaServiceImpl implements UnidadeMedidaService {
    private static final String VEICULO_NAO_ENCONTRADO = "UnidadeMedida não encontrado.";
    private final Logger log = LoggerFactory.getLogger(UnidadeMedidaServiceImpl.class);
    private final UnidadeMedidaRepository unidadeMedidaRepository;
    private final UnidadeMedidaMapper unidadeMedidaMapper;
    private final AuditoriaService auditoriaService;

    @Autowired
    public UnidadeMedidaServiceImpl(UnidadeMedidaRepository unidadeMedidaRepository, UnidadeMedidaMapper unidadeMedidaMapper, AuditoriaService auditoriaService) {
        this.unidadeMedidaRepository = unidadeMedidaRepository;
        this.unidadeMedidaMapper = unidadeMedidaMapper;
        this.auditoriaService = auditoriaService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UnidadeMedidaDTO save(UnidadeMedidaDTO unidadeMedidaDTO) {
        log.debug("Request to save UnidadeMedida : {}", unidadeMedidaDTO);
        if (isNull(unidadeMedidaDTO.getId())) {
            return create(unidadeMedidaDTO);
        }
        return update(unidadeMedidaDTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UnidadeMedidaDTO create(UnidadeMedidaDTO unidadeMedidaDTO) {
        log.debug("Criando uma nova unidadeMedida: {}", unidadeMedidaDTO);

        var unidadeMedida = unidadeMedidaMapper.toEntity(unidadeMedidaDTO);
        unidadeMedida.setId(unidadeMedidaRepository.getUltimoId().orElse(0L) + 1L);
        unidadeMedida.setAuditoria(auditoriaService.setInclusao());

        return unidadeMedidaMapper.toDto(unidadeMedidaRepository.save(unidadeMedida));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UnidadeMedidaDTO update(UnidadeMedidaDTO unidadeMedidaDTO) {
        log.debug("Atualizando uma unidadeMedida: {}", unidadeMedidaDTO);

        var unidadeMedida = unidadeMedidaMapper.toEntity(unidadeMedidaDTO);
        var unidadeMedidaUpdate = unidadeMedidaRepository.findById(unidadeMedida.getId())
                .map(r -> {
                    r.mergeForUpdate(unidadeMedida);
                    r.setAuditoria(auditoriaService.setAlteracao(r.getAuditoria()));
                    return r;
                })
                .orElseThrow(() -> new DbsFlexoBusinessException(VEICULO_NAO_ENCONTRADO));

        return unidadeMedidaMapper.toDto(unidadeMedidaRepository.save(unidadeMedidaUpdate));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UnidadeMedidaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UnidadeMedidas");
        return unidadeMedidaRepository.findAll(pageable)
                .map(unidadeMedidaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UnidadeMedidaDTO> findOne(Long id) {
        log.debug("Request to get UnidadeMedida : {}", id);
        return unidadeMedidaRepository.findById(id)
                .map(unidadeMedidaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete UnidadeMedida : {}", id);
        unidadeMedidaRepository.deleteById(id);
    }
}

