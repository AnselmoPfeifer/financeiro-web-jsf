package com.anselmopfeifer.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.anselmopfeifer.model.Lancamento;
import com.anselmopfeifer.repository.Lancamentos;
import com.anselmopfeifer.repository.Pessoas;
import com.anselmopfeifer.repository.infra.LancamentosHibernate;
import com.anselmopfeifer.repository.infra.PessoasHibernate;

public class Repositorios implements Serializable {
	
	public Pessoas getPessoas(){
		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamento(){
		return new LancamentosHibernate(this.getSession());
	}
	private Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}
}
