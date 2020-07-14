package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.domain.model.Entidade;
import com.rfs.data.GeradorDTO.domain.repository.filter.EntidadeFilter;
import com.rfs.data.GeradorDTO.service.EntidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api")
public class EntidadeResource {
    private Logger log = LoggerFactory.getLogger(EntidadeResource.class);

    private EntidadeService entidadeService;

    @Autowired
    public EntidadeResource(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    @GetMapping("/entidades")
    public ResponseEntity<Page<Entidade>> listar(EntidadeFilter filtros, Pageable pageable) {
        log.info("REST find Entidade with filters: {}", filtros);

        return ResponseEntity.ok().body(entidadeService.findAllEntidades(filtros, pageable));
    }

    @GetMapping("/entidades/{id}")
    public ResponseEntity<Entidade> buscarPorId(@PathVariable(name = "id") Long id) {
        log.info("REST find Entidade with id: {}", id);

        return ResponseEntity.ok().body(entidadeService.findByEntidade(id));
    }

    @PostMapping("/entidades")
    public ResponseEntity<Entidade> createEntidade(@Valid @RequestBody Entidade entidade) throws URISyntaxException {
        log.debug("REST create of Entity : {}", entidade);

        if (nonNull(entidade.getId())) {
            throw new RuntimeException("Uma nova entidade não deve possuir um ID.");
        }

        var result = entidadeService.createOrUpdate(entidade);

        return ResponseEntity.created(new URI("/api/entidades/" + result.getId())).body(result);
    }

    @PutMapping("/entidades")
    public ResponseEntity<Entidade> updateEntidade(@Valid @RequestBody Entidade entidade) {
        log.debug("REST update of Entity: {}", entidade);

        if(isNull(entidade.getId())) {
            throw new RuntimeException("Para atualizar uma entidade é necessário informar o ID");
        }

        var result = entidadeService.createOrUpdate(entidade);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/entidades/{id}")
    public ResponseEntity<Void> deleteEntidade(@PathVariable Long id) {
        log.debug("REST request to delete Entidade: {}", id);
        entidadeService.deleteEntidade(id);

        return ResponseEntity.noContent().build();
    }
}
