package com.rfs.data.GeradorDTO.service.geradores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriteTemplate {

    @Value("${api.path-base")
    private String pathBase;

    public  void adicionaTemplateNoArquivo(String template, String nomeDoArquivo, String diretorioPackage) {
        Path diretorio = Paths.get(this.pathBase + diretorioPackage);
        if (Files.notExists(diretorio)) {
            try {
                Files.createDirectory(diretorio);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Path arquivo = diretorio.resolve(nomeDoArquivo).toAbsolutePath();
            Files.createFile(arquivo);
            Files.writeString(arquivo, template);
            System.out.println(arquivo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
