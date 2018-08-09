package com.s1challenge.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.s1challenge.api.exception.OrderingException;
import com.s1challenge.api.service.Livros;

@RequestMapping()
@Controller
public class OrdenacaoController {

	@GetMapping("/ordenar") 
	public String ordernarPage() {
		return  "servico-de-ordenacao.html";
	}
	
	@RequestMapping(value="/ordenar", method=RequestMethod.POST)
    public String doOrdenar(@RequestParam("id") List<Long> ids, @RequestParam("titulo") List<String> titulos,
    						@RequestParam("autor") List<String> autores, @RequestParam("anoEdicao") List<String> anosEdicoes,
    						@RequestParam("ordenacao") List<String> regrasOrdenacao, Model model) {
		
		if(ids.isEmpty() || titulos.isEmpty() || autores.isEmpty() || anosEdicoes.isEmpty()) {
			model.addAttribute("erro", "Não foi possivel executar a tarefa!");
			return "servico-de-ordenacao.html";
		}
		
		Livros livros = new Livros(ids, titulos, autores, anosEdicoes);
		
		try {
			livros.ordernar(regrasOrdenacao);
		} catch (OrderingException exc) {
			model.addAttribute("erro", "OrderingException");
			
			return "servico-de-ordenacao.html";
		}
		
		model.addAttribute("livros", livros.getLivros());
		return "lista-ordenada.html";
	}
}
