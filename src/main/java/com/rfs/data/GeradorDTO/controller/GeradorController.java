package com.rfs.data.GeradorDTO.controller;

import com.rfs.data.GeradorDTO.service.geradores.GeradorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador")
public class GeradorController {
    private GeradorEntity geradorEntity;

    @Autowired
    public GeradorController(GeradorEntity geradorEntity) {
        this.geradorEntity = geradorEntity;
    }

    @GetMapping("/entity")
    public void gerarEntity() {
        geradorEntity.lendoArquivos();
    }
}
