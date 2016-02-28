package com.anselmopfeifer.repository;

import java.util.List;

import com.anselmopfeifer.model.Pessoa;

public interface Pessoas {
	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);

}
