package br.com.cliente.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.api.models.Cliente;
import br.com.cliente.api.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	ClienteRepository clienteRepository;

	public ClienteController(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping
	public List<Cliente> listaTodos() {
		return clienteRepository.findAll();
	}

	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
}
