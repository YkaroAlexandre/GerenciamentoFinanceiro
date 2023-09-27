package com.pweb.aplication.GerenciadorFinanceiro.models;

import java.io.File;

import jakarta.validation.constraints.NotEmpty;

public class Csv {
    @NotEmpty
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
