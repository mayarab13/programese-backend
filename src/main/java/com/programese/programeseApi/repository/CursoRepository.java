package com.programese.programeseApi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programese.programeseApi.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {
	
	public List<Curso> findAllByNomeContainingIgnoreCase(String nome);  
	
}
