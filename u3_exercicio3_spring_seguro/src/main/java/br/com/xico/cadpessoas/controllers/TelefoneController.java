package br.com.xico.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xico.cadpessoas.model.Telefone;
import br.com.xico.cadpessoas.repositories.TelefoneRepository;

@Controller
@RequestMapping("/telefone")
public class TelefoneController {
	@Autowired
	TelefoneRepository telefoneRepo;

	TelefoneController(TelefoneRepository pessoaRepo) {
		this.telefoneRepo = pessoaRepo;
	}

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarTelefones")
	public ModelAndView listarTelefones() {
		List<Telefone> todasAsTelefones = telefoneRepo.findAll();

		ModelAndView modelAndView = new ModelAndView("listarTelefones");

		modelAndView.addObject("todasAsTelefones", todasAsTelefones);

		return modelAndView;
	}

	@GetMapping("/adicionarTelefone")
	public ModelAndView formAdicionarTelefone() {
		ModelAndView modelAndView = new ModelAndView("adicionarTelefone");
		modelAndView.addObject(new Telefone());
		return modelAndView;
	}

	
	@PostMapping("/adicionarTelefone")
	public String adicionarTelefone(Telefone t) {
		this.telefoneRepo.save(t);
		return "redirect:/listarTelefones";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView formEditarTelefone(@PathVariable("id") long id) {
		Telefone pessoa = telefoneRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		ModelAndView modelAndView = new ModelAndView("editarTelefone");
		modelAndView.addObject(pessoa);
		return modelAndView;
	}

	@PostMapping("/editar/{id}")
	public ModelAndView editarTelefone(@PathVariable("id") long id, Telefone pessoa) {
		telefoneRepo.save(pessoa);
		return new ModelAndView("redirect:/listarTelefones");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView removerTelefone(@PathVariable("id") long id) {
		Telefone aRemover = telefoneRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		telefoneRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarTelefones");
	}
}
