package com.rfs.data.GeradorDTO.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.rfs.data.GeradorDTO.transpiler.EntityTranpiler;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class Gerador {

    @PostConstruct
    public void gerarEntidade() {
        File diretorio = new File("/home/rodrigo/Documentos/projetos-spring/codeGenerator/codeGenerator/src/main/java/com/rfs/data/GeradorDTO/scripts/");

        try {
            EntityTranpiler entity = null;
            if (diretorio.isDirectory()) {
                File arquivos[] = diretorio.listFiles();
                for (File arquivo : arquivos) {
                    Gson gson = new Gson();

                    JsonReader reader = new JsonReader(new FileReader(arquivo));
                    entity = gson.fromJson(reader, EntityTranpiler.class);
                    System.out.println("************************* LENDO JSON - COM GSON **************************");
                    System.out.println(entity.getNomeDaTabela());
                }
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

    }
}
