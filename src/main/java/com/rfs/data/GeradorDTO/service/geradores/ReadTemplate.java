package com.rfs.data.GeradorDTO.service.geradores;

import com.google.gson.Gson;
import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ReadTemplate {
    private static final Logger log = LoggerFactory.getLogger(ReadTemplate.class);

    private ApplicationProperties applicationProperties;

    @Autowired
    public ReadTemplate(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public List<EntityTranspiler> readJsonScripts() {
        String pathScript = applicationProperties.getPathScript();
        System.out.println("Lendo Arquivos Json, no seguinte caminho: " + pathScript);

        if (isNull(pathScript)) {
            throw new RuntimeException("O caminho do arquivo não foi encontrado. Verifique a configuração do caminho do arquivo de Scripts!");
        }

        File diretorio = new File(pathScript);
        List<EntityTranspiler> transpilers = new ArrayList<>();

        try {
            if (diretorio.isDirectory()) {
                File arquivos[] = diretorio.listFiles();
                for (File arquivo : arquivos) {
                    Gson gson = new Gson();
                    transpilers.add(gson.fromJson(new FileReader(arquivo), EntityTranspiler.class));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return transpilers;
    }
}
