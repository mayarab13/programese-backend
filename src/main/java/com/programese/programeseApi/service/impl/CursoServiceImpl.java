package com.programese.programeseApi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programese.programeseApi.entity.Curso;
import com.programese.programeseApi.repository.CursoRepository;
import com.programese.programeseApi.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Curso insertOrUpdate(Curso entity) {
		return cursoRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		cursoRepository.deleteById(id);	
	}

	@Override
	public List<Curso> getAll() {
		return (List<Curso>)cursoRepository.findAll();
	}

	@Override
	public Curso getById(int id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.get();
	}

	@Override
	public List<Curso> getAllByNomeContainingIgnoreCase(String nome) {
		return (List<Curso>)cursoRepository.findAllByNomeContainingIgnoreCase(nome);
	}
}
