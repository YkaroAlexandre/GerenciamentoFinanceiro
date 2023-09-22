package com.pweb.aplication.GerenciadorFinanceiro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pweb.aplication.GerenciadorFinanceiro.models.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
