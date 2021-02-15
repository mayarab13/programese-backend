package com.programese.programeseApi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programese.programeseApi.entity.Venda;
import com.programese.programeseApi.repository.VendaRepository;
import com.programese.programeseApi.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public Venda insertOrUpdate(Venda entity) {
		return vendaRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		vendaRepository.deleteById(id);	
	}

	@Override
	public List<Venda> getAll() {
		return (List<Venda>)vendaRepository.findAll();
	}

	@Override
	public Venda getById(int id) {
		Optional<Venda> curso = vendaRepository.findById(id);
		return curso.get();
	}
}
