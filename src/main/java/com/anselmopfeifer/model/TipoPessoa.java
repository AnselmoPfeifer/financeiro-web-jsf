package com.anselmopfeifer.model;

public enum TipoPessoa {
	FISICA("Fisica"), 
	JURIDICA("Juridica");
	
	private String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
