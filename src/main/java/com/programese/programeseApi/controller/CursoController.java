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

import com.programese.programeseApi.entity.Curso;
import com.programese.programeseApi.service.CursoService;

@RestController
@CrossOrigin
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@PostMapping("/curso")
	public ResponseEntity<Curso> post(@RequestBody Curso entity){
		try {
			Curso cursoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(cursoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}	
	}
	
	@PutMapping("/curso")
	public ResponseEntity<Curso> put(@RequestBody Curso entity){
		try {
			Curso cursoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(cursoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}	
	}
	
	@DeleteMapping("/curso/{id}")
	public void delete(@PathVariable int id) {
			this.service.delete(id);
	}
	
	@GetMapping("/curso/{id}")
	public ResponseEntity<Curso> getById(@PathVariable int id) {
		Curso curso = this.service.getById(id);
		
		if(curso == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(curso);	
	}
	
	@GetMapping("/curso")
	public ResponseEntity<List<Curso>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/curso-busca/{nome}")
	public ResponseEntity<List<Curso>> getAllByNomeContainingIgnoreCase(@PathVariable String nome) {
		return ResponseEntity.ok(this.service.getAllByNomeContainingIgnoreCase(nome));
	}
}
