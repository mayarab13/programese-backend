package com.programese.programeseApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programese.programeseApi.entity.Token;
import com.programese.programeseApi.entity.Usuario;
import com.programese.programeseApi.service.UsuarioService;
import com.programese.programeseApi.util.Auth;

@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> post(@RequestBody Usuario entity) {
		try {
			Usuario usuarioSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(usuarioSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Token> login(@RequestBody Usuario usuario) {
		service.getAll();
		List<Usuario> user = service.getAll();
		for (Usuario usuario2 : user) {
			if (usuario.getEmail().equals(usuario2.getEmail())&& usuario.getSenha().equals(usuario2.getSenha())){
				Token token = new Token(Auth.encode(usuario));
				return ResponseEntity.ok(token);
			}
		}
		return ResponseEntity.status(403).build();

	}

	@PutMapping("/usuario")
	public ResponseEntity<Usuario> put(@RequestBody Usuario entity) {
		try {
			Usuario usuarioSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(usuarioSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable int id) {
		this.service.delete(id);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable int id) {
		Usuario usuario = this.service.getById(id);

		if (usuario == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(usuario);
	}

	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

}
