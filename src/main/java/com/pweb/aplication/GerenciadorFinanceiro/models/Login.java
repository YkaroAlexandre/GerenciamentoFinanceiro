package com.pweb.aplication.GerenciadorFinanceiro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long ID;
    
    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    @Email(message = "Digite o email de forma válida.")
    @NotEmpty(message = "Preencha o campo corretamente.")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty(message = "Preencha o campo corretamente.")

    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


   
}
