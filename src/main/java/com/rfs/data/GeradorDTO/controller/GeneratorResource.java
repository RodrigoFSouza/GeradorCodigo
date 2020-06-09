package com.rfs.data.GeradorDTO.controller;

import com.rfs.data.GeradorDTO.service.geradores.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador")
public class GeneratorResource {
    private GeradorEntity geradorEntity;
    private GeradorService geradorService;
    private GeradorRepository geradorRepository;
    private GeradorController geradorController;
    private ReadTemplate readTemplate;

    public GeneratorResource(GeradorEntity geradorEntity, GeradorService geradorService, GeradorRepository geradorRepository, GeradorController geradorController, ReadTemplate readTemplate) {
        this.geradorEntity = geradorEntity;
        this.geradorService = geradorService;
        this.geradorRepository = geradorRepository;
        this.geradorController = geradorController;
        this.readTemplate = readTemplate;
    }


    @GetMapping("/criarCrud")
    private void criarCrud() {
        var listEntityTranspilers = readTemplate.readJsonScripts();
        this.geradorEntity.criaEntity(listEntityTranspilers);
        this.geradorRepository.gerarRepository(listEntityTranspilers);
        this.geradorService.gerarService(listEntityTranspilers);
        this.geradorController.gerandoController(listEntityTranspilers);
    }

}
