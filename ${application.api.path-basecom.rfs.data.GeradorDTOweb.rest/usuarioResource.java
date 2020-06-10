package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.service.usuarioService;
import com.rfs.data.GeradorDTO.web.rest.errors.BadRequestAlertException;
import com.rfs.data.GeradorDTO.service.dto.usuarioDTO;
import com.rfs.data.GeradorDTO.service.dto.usuarioCriteria;
import com.rfs.data.GeradorDTO.service.usuarioQueryService;

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
    public class usuarioResource {

        private final Logger log = LoggerFactory.getLogger(usuarioResource.class);

        private static final String ENTITY_NAME = "usuario";

        @Value("${jhipster.clientApp.name}")
        private String applicationName;

        private final usuarioService usuarioService;

        private final usuarioQueryService usuarioQueryService;

        public usuarioResource(usuarioService usuarioService, usuarioQueryService usuarioQueryService) {
            this.usuarioService = usuarioService;
            this.usuarioQueryService = usuarioQueryService;
        }

        @PostMapping("/usuarios")
        public ResponseEntity<usuarioDTO> createusuario(@Valid @RequestBody usuarioDTO usuarioDTO) throws URISyntaxException {
            log.debug("REST request to save usuario : {}", usuarioDTO);
            if (usuarioDTO.getId() != null) {
                throw new BadRequestAlertException("A new usuario cannot already have an ID", ENTITY_NAME, "idexists");
            }
            usuarioDTO result = usuarioService.save(usuarioDTO);
            return ResponseEntity.created(new URI("/api/usuarios/" + result.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                    .body(result);
        }

        @PutMapping("/usuarios")
        public ResponseEntity<usuarioDTO> updateusuario(@Valid @RequestBody usuarioDTO usuarioDTO) throws URISyntaxException {
            log.debug("REST request to update usuario : {}", usuarioDTO);
            if (usuarioDTO.getId() == null) {
                throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
            }
            usuarioDTO result = usuarioService.save(usuarioDTO);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, usuarioDTO.getId().toString()))
                    .body(result);
        }

        @GetMapping("/usuarios")
        public ResponseEntity<List<usuarioDTO>> getAllusuarios(usuarioCriteria criteria, Pageable pageable) {
            log.debug("REST request to get usuarios by criteria: {}", criteria);
            Page<usuarioDTO> page = usuarioQueryService.findByCriteria(criteria, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }

        @GetMapping("/usuarios/count")
        public ResponseEntity<Long> countusuarios(usuarioCriteria criteria) {
            log.debug("REST request to count usuarios by criteria: {}", criteria);
            return ResponseEntity.ok().body(usuarioQueryService.countByCriteria(criteria));
        }

        @GetMapping("/usuarios/{id}")
        public ResponseEntity<usuarioDTO> getusuario(@PathVariable Long id) {
            log.debug("REST request to get usuario : {}", id);
            Optional<usuarioDTO> usuarioDTO = usuarioService.findOne(id);
            return ResponseUtil.wrapOrNotFound(usuarioDTO);
        }

        @DeleteMapping("/usuarios/{id}")
        public ResponseEntity<Void> deleteusuario(@PathVariable Long id) {
            log.debug("REST request to delete usuario : {}", id);
            usuarioService.delete(id);
            return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
        }
    }
