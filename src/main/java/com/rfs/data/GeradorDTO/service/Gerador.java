package com.rfs.data.GeradorDTO.service;

import com.google.gson.Gson;
import com.rfs.data.GeradorDTO.transpiler.EntityTranpiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Gerador {

    public static void main(String[] args) {
        gerarEntidade();
    }

    public static void gerarEntidade() {
        File diretorio = new File("C:\\Users\\Usuario\\Desktop\\GeradorDTO\\src\\main\\java\\com\\rfs\\data\\GeradorDTO\\scripts");

        try {
            if (diretorio.isDirectory()) {
                File arquivos[] = diretorio.listFiles();
                for (File arquivo : arquivos) {
                    Gson gson = new Gson();
                    EntityTranpiler entity = gson.fromJson(new FileReader(arquivo), EntityTranpiler.class);
                    System.out.println("************************* LENDO JSON - COM GSON **************************");

                    System.out.println(entity.getGeraId());
                }
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

    }
}
