package com.programese.programeseApi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programese.programeseApi.entity.Usuario;
import com.programese.programeseApi.repository.UsuarioRepository;
import com.programese.programeseApi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario insertOrUpdate(Usuario entity) {
		return usuarioRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		usuarioRepository.deleteById(id);
		
	}

	@Override
	public List<Usuario> getAll() {
		return (List<Usuario>)usuarioRepository.findAll();
	}

	@Override
	public Usuario getById(int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

}
