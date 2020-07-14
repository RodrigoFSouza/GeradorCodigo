package com.rfs.data.GeradorDTO.web.rest;

import com.rfs.data.GeradorDTO.domain.model.Atributo;
import com.rfs.data.GeradorDTO.service.AtributoService;
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

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/atributos")
public class AtributoResource {
    private final Logger log = LoggerFactory.getLogger(AtributoResource.class);
    private final AtributoService atributoService;

    @Autowired
    public AtributoResource(AtributoService atributoService) {
        this.atributoService = atributoService;
    }

    @GetMapping("/{entidadeId}")
    public ResponseEntity<Page<Atributo>> listAllAtributo(@PathVariable(name = "entidadeId") Long entidadeId, Pageable pageable) {
        log.info("REST list all Atributo for Entidade: {}", entidadeId);

        return ResponseEntity.ok().body(atributoService.buscarAtributos(entidadeId, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atributo> findByAtributo(@PathVariable(name = "entidade") Long id) {
        log.info("REST find by Atributo id: {}", id);

        return ResponseEntity.ok().body(atributoService.findByAtributo(id));
    }

    @PostMapping
    public ResponseEntity<Atributo> create(@Valid @RequestBody Atributo atributo) throws URISyntaxException {
        log.info("REST create a new ATRIBUTO: {}", atributo);

        if (nonNull(atributo.getId())) {
            throw new RuntimeException("Para criar um novo atributo não é necessário informar o ID");
        }
        var result = atributoService.createOfUpdate(atributo);
        return ResponseEntity.created(new URI("/api/atributos/" + result.getId())).body(result);
    }


}
