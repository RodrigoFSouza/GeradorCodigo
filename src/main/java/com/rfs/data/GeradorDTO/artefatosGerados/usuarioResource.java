package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.service.UsuarioService;
import com.rfs.data.GeradorDTO.web.rest.errors.BadRequestAlertException;
import com.rfs.data.GeradorDTO.service.dto.UsuarioDTO;
import com.rfs.data.GeradorDTO.service.dto.UsuarioCriteria;
import com.rfs.data.GeradorDTO.service.UsuarioQueryService;

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
    public class UsuarioResource {

        private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);

        private static final String ENTITY_NAME = "usuario";

        @Value("${jhipster.clientApp.name}")
        private String applicationName;

        private final UsuarioService usuarioService;

        private final UsuarioQueryService usuarioQueryService;

        public UsuarioResource(UsuarioService usuarioService, UsuarioQueryService usuarioQueryService) {
            this.usuarioService = usuarioService;
            this.usuarioQueryService = usuarioQueryService;
        }

        @PostMapping("/usuarios")
        public ResponseEntity<UsuarioDTO> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
            log.debug("REST request to save Usuario : {}", usuarioDTO);
            if (usuarioDTO.getId() != null) {
                throw new BadRequestAlertException("A new usuario cannot already have an ID", ENTITY_NAME, "idexists");
            }
            UsuarioDTO result = usuarioService.save(usuarioDTO);
            return ResponseEntity.created(new URI("/api/usuarios/" + result.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                    .body(result);
        }

        @PutMapping("/usuarios")
        public ResponseEntity<UsuarioDTO> updateUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
            log.debug("REST request to update Usuario : {}", usuarioDTO);
            if (usuarioDTO.getId() == null) {
                throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
            }
            UsuarioDTO result = usuarioService.save(usuarioDTO);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, usuarioDTO.getId().toString()))
                    .body(result);
        }

        @GetMapping("/usuarios")
        public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(UsuarioCriteria criteria, Pageable pageable) {
            log.debug("REST request to get Usuarios by criteria: {}", criteria);
            Page<UsuarioDTO> page = usuarioQueryService.findByCriteria(criteria, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }

        @GetMapping("/usuarios/count")
        public ResponseEntity<Long> countUsuarios(UsuarioCriteria criteria) {
            log.debug("REST request to count Usuarios by criteria: {}", criteria);
            return ResponseEntity.ok().body(usuarioQueryService.countByCriteria(criteria));
        }

        @GetMapping("/usuarios/{id}")
        public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
            log.debug("REST request to get Usuario : {}", id);
            Optional<UsuarioDTO> usuarioDTO = usuarioService.findOne(id);
            return ResponseUtil.wrapOrNotFound(usuarioDTO);
        }

        @DeleteMapping("/usuarios/{id}")
        public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
            log.debug("REST request to delete Usuario : {}", id);
            usuarioService.delete(id);
            return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
        }
    }
