package com.pweb.aplication.GerenciadorFinanceiro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pweb.aplication.GerenciadorFinanceiro.models.Login;


public interface LoginRepository extends CrudRepository<Login , Long>{
    
}
