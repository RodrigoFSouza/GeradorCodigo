package com.rfs.data.GeradorDTO.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.api")
public class ApplicationProperties {
    private String packageBase;

    private String pathBase;

    private String pathScript;

    private String pathArtefatos;

    public String getPackageBase() {
        return packageBase;
    }

    public String getPathBase() {
        return pathBase;
    }

    public String getPathScript() {
        return pathScript;
    }

    public String getPathArtefatos() {
        return pathArtefatos;
    }

    public void setPackageBase(String packageBase) {
        this.packageBase = packageBase;
    }

    public void setPathBase(String pathBase) {
        this.pathBase = pathBase;
    }

    public void setPathScript(String pathScript) {
        this.pathScript = pathScript;
    }

    public void setPathArtefatos(String pathArtefatos) {
        this.pathArtefatos = pathArtefatos;
    }
}
