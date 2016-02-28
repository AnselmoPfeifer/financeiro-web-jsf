package com.anselmopfeifer.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.anselmopfeifer.model.Lancamento;
import com.anselmopfeifer.repository.Lancamentos;
import com.anselmopfeifer.service.GestaoLancamentos;
import com.anselmopfeifer.service.RegraNegocioException;
import com.anselmopfeifer.util.FacesUtil;
import com.anselmopfeifer.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {
	
	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamento();
		this.lancamentos = lancamentos.todos();
	}

	public void excluir() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamento());
		try {
			gestaoLancamentos.excluir(this.lancamentoSelecionado);
			
			this.inicializar();
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR,
					"Lançamento já foi pago e nao pode ser excluido!");
		} catch (RegraNegocioException e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage());
		}
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}