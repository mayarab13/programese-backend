package com.programese.programeseApi.service;

import java.util.List;

import com.programese.programeseApi.entity.Curso;

public interface CursoService {
	
	Curso insertOrUpdate(Curso entity);
	void delete(int id);
	List<Curso> getAll();
	Curso getById(int id);
	List<Curso> getAllByNomeContainingIgnoreCase(String nome);
	
}
