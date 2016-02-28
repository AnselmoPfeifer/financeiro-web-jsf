package com.anselmopfeifer.view;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.anselmopfeifer.model.Lancamento;
import com.anselmopfeifer.model.Pessoa;
import com.anselmopfeifer.model.TipoLancamento;
import com.anselmopfeifer.repository.Pessoas;
import com.anselmopfeifer.service.GestaoLancamentos;
import com.anselmopfeifer.service.RegraNegocioException;
import com.anselmopfeifer.util.FacesUtil;
import com.anselmopfeifer.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
			}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamento());
		try {
			gestaoLancamentos.salvar(lancamento);
			this.lancamento = new Lancamento();
			FacesUtil.addMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.addMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}

	}
	
	public boolean isEditando(){
		return this.lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
		if(this.lancamento == null){
			this.lancamento = new Lancamento();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
}