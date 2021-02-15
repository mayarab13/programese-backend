package com.programese.programeseApi.service;

import java.util.List;

import com.programese.programeseApi.entity.Venda;

public interface VendaService {

	Venda insertOrUpdate(Venda entity);
	void delete(int id);
	List<Venda> getAll();
	Venda getById(int id);
}
