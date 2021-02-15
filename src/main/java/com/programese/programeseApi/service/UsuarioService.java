package com.programese.programeseApi.service;

import java.util.List;

import com.programese.programeseApi.entity.Usuario;

public interface UsuarioService {

	Usuario insertOrUpdate(Usuario entity);
	void delete(int id);
	List<Usuario> getAll();
	Usuario getById(int id);

}
