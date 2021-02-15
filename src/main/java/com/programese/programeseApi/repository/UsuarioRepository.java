package com.programese.programeseApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.programese.programeseApi.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
}
