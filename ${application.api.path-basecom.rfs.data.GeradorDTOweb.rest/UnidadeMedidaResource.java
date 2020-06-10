package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.service.UnidadeMedidaService;
import com.rfs.data.GeradorDTO.web.rest.errors.BadRequestAlertException;
import com.rfs.data.GeradorDTO.service.dto.UnidadeMedidaDTO;
import com.rfs.data.GeradorDTO.service.dto.UnidadeMedidaCriteria;
import com.rfs.data.GeradorDTO.service.UnidadeMedidaQueryService;

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
    public class UnidadeMedidaResource {

        private final Logger log = LoggerFactory.getLogger(UnidadeMedidaResource.class);

        private static final String ENTITY_NAME = "unidadeMedida";

        @Value("${jhipster.clientApp.name}")
        private String applicationName;

        private final UnidadeMedidaService unidadeMedidaService;

        private final UnidadeMedidaQueryService unidadeMedidaQueryService;

        public UnidadeMedidaResource(UnidadeMedidaService unidadeMedidaService, UnidadeMedidaQueryService unidadeMedidaQueryService) {
            this.unidadeMedidaService = unidadeMedidaService;
            this.unidadeMedidaQueryService = unidadeMedidaQueryService;
        }

        @PostMapping("/unidadeMedidas")
        public ResponseEntity<UnidadeMedidaDTO> createUnidadeMedida(@Valid @RequestBody UnidadeMedidaDTO unidadeMedidaDTO) throws URISyntaxException {
            log.debug("REST request to save UnidadeMedida : {}", unidadeMedidaDTO);
            if (unidadeMedidaDTO.getId() != null) {
                throw new BadRequestAlertException("A new unidadeMedida cannot already have an ID", ENTITY_NAME, "idexists");
            }
            UnidadeMedidaDTO result = unidadeMedidaService.save(unidadeMedidaDTO);
            return ResponseEntity.created(new URI("/api/unidadeMedidas/" + result.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                    .body(result);
        }

        @PutMapping("/unidadeMedidas")
        public ResponseEntity<UnidadeMedidaDTO> updateUnidadeMedida(@Valid @RequestBody UnidadeMedidaDTO unidadeMedidaDTO) throws URISyntaxException {
            log.debug("REST request to update UnidadeMedida : {}", unidadeMedidaDTO);
            if (unidadeMedidaDTO.getId() == null) {
                throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
            }
            UnidadeMedidaDTO result = unidadeMedidaService.save(unidadeMedidaDTO);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, unidadeMedidaDTO.getId().toString()))
                    .body(result);
        }

        @GetMapping("/unidadeMedidas")
        public ResponseEntity<List<UnidadeMedidaDTO>> getAllUnidadeMedidas(UnidadeMedidaCriteria criteria, Pageable pageable) {
            log.debug("REST request to get UnidadeMedidas by criteria: {}", criteria);
            Page<UnidadeMedidaDTO> page = unidadeMedidaQueryService.findByCriteria(criteria, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }

        @GetMapping("/unidadeMedidas/count")
        public ResponseEntity<Long> countUnidadeMedidas(UnidadeMedidaCriteria criteria) {
            log.debug("REST request to count UnidadeMedidas by criteria: {}", criteria);
            return ResponseEntity.ok().body(unidadeMedidaQueryService.countByCriteria(criteria));
        }

        @GetMapping("/unidadeMedidas/{id}")
        public ResponseEntity<UnidadeMedidaDTO> getUnidadeMedida(@PathVariable Long id) {
            log.debug("REST request to get UnidadeMedida : {}", id);
            Optional<UnidadeMedidaDTO> unidadeMedidaDTO = unidadeMedidaService.findOne(id);
            return ResponseUtil.wrapOrNotFound(unidadeMedidaDTO);
        }

        @DeleteMapping("/unidadeMedidas/{id}")
        public ResponseEntity<Void> deleteUnidadeMedida(@PathVariable Long id) {
            log.debug("REST request to delete UnidadeMedida : {}", id);
            unidadeMedidaService.delete(id);
            return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
        }
    }
