package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.models.Contato;
import com.example.demo.repositories.ContatoRepositorio;

//@RestController
@Controller
@RequestMapping("/agenda")
public class ContatoController {

	@Autowired
	ContatoRepositorio contatoRepo;

	ContatoController(ContatoRepositorio contatoRepo) {
		this.contatoRepo = contatoRepo;
	}
	
	@GetMapping
	public ModelAndView index() {
		return listar();
	}

	@GetMapping("/listaContatos")
	public ModelAndView listar() {
		List<Contato> lista = contatoRepo.findAll();

		ModelAndView modelAndView = new ModelAndView("listaContatos");
		
		modelAndView.addObject("contatos", lista);

		return modelAndView;
	}

	@GetMapping("/adicionaContato")
	public ModelAndView formAdicionar() {
		ModelAndView modelAndView = new ModelAndView("adicionaContato");
		modelAndView.addObject(new Contato());
		return modelAndView;
	}
	
	@PostMapping("/adicionaContato")
	public String salvar(Contato contato) {
		this.contatoRepo.save(contato);
		return "redirect:/agenda/listaContatos";
	}
	
	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		return contatoRepo.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}

	/*@PutMapping(value = "/editar/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Contato contact) {
		return contatoRepo.findById(id).map(record -> {
			record.setNome(contact.getNome());
			record.setEmail(contact.getEmail());
			record.setTelefone(contact.getTelefone());
			Contato updated = contatoRepo.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}*/
	
	@GetMapping("/editar/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") long id) {
	    Contato contato = contatoRepo.findById(id)
	    		.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
	    
		ModelAndView modelAndView = new ModelAndView("editaContato");
		modelAndView.addObject(contato);
	    return modelAndView;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView updateUser(@PathVariable("id") long id, Contato contato) {
		contatoRepo.save(contato);
		
		return new ModelAndView("redirect:/agenda");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView deleteUser(@PathVariable("id") long id) {
	    Contato aRemover = contatoRepo.findById(id)
	    	.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
	    contatoRepo.delete(aRemover);
	    return new ModelAndView("redirect:/agenda");
	}
	
	/*
	@GetMapping("/remover/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return contatoRepo.findById(id).map(record -> {
			contatoRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}*/
}