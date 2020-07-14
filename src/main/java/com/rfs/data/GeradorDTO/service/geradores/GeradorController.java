package com.rfs.data.GeradorDTO.service.geradores;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.domain.model.Entidade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradorController {
    private ApplicationProperties applicationProperties;
    private WriteTemplate writeTemplate;

    @Autowired
    public GeradorController(ApplicationProperties applicationProperties, WriteTemplate writeTemplate) {
        this.applicationProperties = applicationProperties;
        this.writeTemplate = writeTemplate;
    }
   
    
    private String template = """
            package <packageNameBase>.web.rest;
                        
            import <packageNameBase>.service.<entityName>Service;
            import <packageNameBase>.web.rest.errors.BadRequestAlertException;
            import <packageNameBase>.service.dto.<entityName>DTO;
            import <packageNameBase>.service.dto.<entityName>Criteria;
            import <packageNameBase>.service.<entityName>QueryService;
                        
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
                public class <entityName>Resource {
                        
                    private final Logger log = LoggerFactory.getLogger(<entityName>Resource.class);
                        
                    private static final String ENTITY_NAME = "<entityNameUncapitalize>";
                        
                    @Value("${jhipster.clientApp.name}")
                    private String applicationName;
                        
                    private final <entityName>Service <entityNameUncapitalize>Service;
                        
                    private final <entityName>QueryService <entityNameUncapitalize>QueryService;
                        
                    public <entityName>Resource(<entityName>Service <entityNameUncapitalize>Service, <entityName>QueryService <entityNameUncapitalize>QueryService) {
                        this.<entityNameUncapitalize>Service = <entityNameUncapitalize>Service;
                        this.<entityNameUncapitalize>QueryService = <entityNameUncapitalize>QueryService;
                    }
                        
                    @PostMapping("/<entityNameUncapitalize>s")
                    public ResponseEntity<<entityName>DTO> create<entityName>(@Valid @RequestBody <entityName>DTO <entityNameUncapitalize>DTO) throws URISyntaxException {
                        log.debug("REST request to save <entityName> : {}", <entityNameUncapitalize>DTO);
                        if (<entityNameUncapitalize>DTO.getId() != null) {
                            throw new BadRequestAlertException("A new <entityNameUncapitalize> cannot already have an ID", ENTITY_NAME, "idexists");
                        }
                        <entityName>DTO result = <entityNameUncapitalize>Service.save(<entityNameUncapitalize>DTO);
                        return ResponseEntity.created(new URI("/api/<entityNameUncapitalize>s/" + result.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                                .body(result);
                    }
                        
                    @PutMapping("/<entityNameUncapitalize>s")
                    public ResponseEntity<<entityName>DTO> update<entityName>(@Valid @RequestBody <entityName>DTO <entityNameUncapitalize>DTO) throws URISyntaxException {
                        log.debug("REST request to update <entityName> : {}", <entityNameUncapitalize>DTO);
                        if (<entityNameUncapitalize>DTO.getId() == null) {
                            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
                        }
                        <entityName>DTO result = <entityNameUncapitalize>Service.save(<entityNameUncapitalize>DTO);
                        return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, <entityNameUncapitalize>DTO.getId().toString()))
                                .body(result);
                    }
                        
                    @GetMapping("/<entityNameUncapitalize>s")
                    public ResponseEntity<List<<entityName>DTO>> getAll<entityName>s(<entityName>Criteria criteria, Pageable pageable) {
                        log.debug("REST request to get <entityName>s by criteria: {}", criteria);
                        Page<<entityName>DTO> page = <entityNameUncapitalize>QueryService.findByCriteria(criteria, pageable);
                        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
                        return ResponseEntity.ok().headers(headers).body(page.getContent());
                    }
                        
                    @GetMapping("/<entityNameUncapitalize>s/count")
                    public ResponseEntity<Long> count<entityName>s(<entityName>Criteria criteria) {
                        log.debug("REST request to count <entityName>s by criteria: {}", criteria);
                        return ResponseEntity.ok().body(<entityNameUncapitalize>QueryService.countByCriteria(criteria));
                    }
                        
                    @GetMapping("/<entityNameUncapitalize>s/{id}")
                    public ResponseEntity<<entityName>DTO> get<entityName>(@PathVariable Long id) {
                        log.debug("REST request to get <entityName> : {}", id);
                        Optional<<entityName>DTO> <entityNameUncapitalize>DTO = <entityNameUncapitalize>Service.findOne(id);
                        return ResponseUtil.wrapOrNotFound(<entityNameUncapitalize>DTO);
                    }
                        
                    @DeleteMapping("/<entityNameUncapitalize>s/{id}")
                    public ResponseEntity<Void> delete<entityName>(@PathVariable Long id) {
                        log.debug("REST request to delete <entityName> : {}", id);
                        <entityNameUncapitalize>Service.delete(id);
                        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
                    }
                }
            """;

    public void gerandoController(List<Entidade> entidades) {
        String packageBase = applicationProperties.getPackageBase();
        for (Entidade entidade: entidades) {
            var templateController = template.replaceAll("<packageNameBase>", packageBase)
                    .replaceAll("<entityName>", StringUtils.capitalize(entidade.getNomeEntity()))
                    .replaceAll("<entityNameUncapitalize>", StringUtils.uncapitalize(entidade.getNomeEntity()));

            var nomeArquivo = entidade.getNomeEntity() + "Resource.java";
            var packageDiretorio = packageBase + "web.rest";

            writeTemplate.adicionaTemplateNoArquivo(templateController, nomeArquivo, packageDiretorio);
        }
    }

}
