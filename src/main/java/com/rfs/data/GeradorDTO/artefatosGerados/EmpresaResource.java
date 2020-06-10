package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.service.EmpresaService;
import com.rfs.data.GeradorDTO.web.rest.errors.BadRequestAlertException;
import com.rfs.data.GeradorDTO.service.dto.EmpresaDTO;
import com.rfs.data.GeradorDTO.service.dto.EmpresaCriteria;
import com.rfs.data.GeradorDTO.service.EmpresaQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api")
    public class EmpresaResource {

        private final Logger log = LoggerFactory.getLogger(EmpresaResource.class);

        private static final String ENTITY_NAME = "empresa";

        @Value("${jhipster.clientApp.name}")
        private String applicationName;

        private final EmpresaService empresaService;

        private final EmpresaQueryService empresaQueryService;

        public EmpresaResource(EmpresaService empresaService, EmpresaQueryService empresaQueryService) {
            this.empresaService = empresaService;
            this.empresaQueryService = empresaQueryService;
        }

        @PostMapping("/empresas")
        public ResponseEntity<EmpresaDTO> createEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) throws URISyntaxException {
            log.debug("REST request to save Empresa : {}", empresaDTO);
            if (empresaDTO.getId() != null) {
                throw new BadRequestAlertException("A new empresa cannot already have an ID", ENTITY_NAME, "idexists");
            }
            EmpresaDTO result = empresaService.save(empresaDTO);
            return ResponseEntity.created(new URI("/api/empresas/" + result.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                    .body(result);
        }

        @PutMapping("/empresas")
        public ResponseEntity<EmpresaDTO> updateEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) throws URISyntaxException {
            log.debug("REST request to update Empresa : {}", empresaDTO);
            if (empresaDTO.getId() == null) {
                throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
            }
            EmpresaDTO result = empresaService.save(empresaDTO);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, empresaDTO.getId().toString()))
                    .body(result);
        }

        @GetMapping("/empresas")
        public ResponseEntity<List<EmpresaDTO>> getAllEmpresas(EmpresaCriteria criteria, Pageable pageable) {
            log.debug("REST request to get Empresas by criteria: {}", criteria);
            Page<EmpresaDTO> page = empresaQueryService.findByCriteria(criteria, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }

        @GetMapping("/empresas/count")
        public ResponseEntity<Long> countEmpresas(EmpresaCriteria criteria) {
            log.debug("REST request to count Empresas by criteria: {}", criteria);
            return ResponseEntity.ok().body(empresaQueryService.countByCriteria(criteria));
        }

        @GetMapping("/empresas/{id}")
        public ResponseEntity<EmpresaDTO> getEmpresa(@PathVariable Long id) {
            log.debug("REST request to get Empresa : {}", id);
            Optional<EmpresaDTO> empresaDTO = empresaService.findOne(id);
            return ResponseUtil.wrapOrNotFound(empresaDTO);
        }

        @DeleteMapping("/empresas/{id}")
        public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
            log.debug("REST request to delete Empresa : {}", id);
            empresaService.delete(id);
            return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
        }
    }
