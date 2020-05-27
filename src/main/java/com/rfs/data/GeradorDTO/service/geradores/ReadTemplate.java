package com.rfs.data.GeradorDTO.service.geradores;

import com.google.gson.Gson;
import com.rfs.data.GeradorDTO.transpiler.EntityTranspiler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadTemplate {
    @Value("${api.path-script}")
    private static String pathScript;

    public static List<EntityTranspiler> readJsonScripts() {
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
