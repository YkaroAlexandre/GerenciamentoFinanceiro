package com.pweb.aplication.GerenciadorFinanceiro.controllers;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pweb.aplication.GerenciadorFinanceiro.models.Csv;
import com.pweb.aplication.GerenciadorFinanceiro.models.Login;
import com.pweb.aplication.GerenciadorFinanceiro.models.Transacao;
import com.pweb.aplication.GerenciadorFinanceiro.repositories.TransacaoRepository;


@Controller
public class WebController implements WebMvcConfigurer {

	@Autowired
	TransacaoRepository transacaoRepository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/cadastroDeFinancas").setViewName("cadastroDeFinancas");
		registry.addViewController("/listaDeTransacoes").setViewName("listaDeTransacoes");
	}

	@GetMapping("/")
	
	public String showForm(Login login) {
		return "login";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid Login login, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "login";
		}

		System.out.println(login.getID());
		System.out.println(login.getEmail());
		System.out.println(login.getSenha());
		return "redirect:/listaDeTransacoes";
	}
	
	@GetMapping("/cadastroTransacao")
	public String showForm(Transacao transacao) {
		return "cadastroTransacao";
	}
	
	@PostMapping("/cadastroTransacao")
	public String checkPersonInfo(@Valid Transacao transacao, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			if (bindingResult.hasErrors()) {
				for (FieldError error : bindingResult.getFieldErrors()) {
					System.out.println("Campo com erro: " + error.getField());
					System.out.println("Mensagem de erro: " + error.getDefaultMessage());
				}
			}

			return "cadastroTransacao";
		}


		
		transacaoRepository.save(transacao);


		return "redirect:/listaDeTransacoes";
	}


	@GetMapping("/cadastroCSV")
	public String showForm(Csv csv) {
		return "cadastroCSV";
	}

	@PostMapping("/cadastroCSV")
	public String checkPersonInfo(@Valid Csv csv, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "cadastroCSV";
		}

		
		return "redirect:/listaDeTransacoes";
	}

	// Passando os dados do banco de dados para o front-end
	@GetMapping(value="/listaDeTransacoes")
  	public String showUsers(Model model) {
    Iterable<Transacao> transacao = transacaoRepository.findAll();
    model.addAttribute("transacao", transacao);
    return "listaDeTransacoes";
  }
}
