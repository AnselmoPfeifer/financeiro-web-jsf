package com.anselmopfeifer.service;

import com.anselmopfeifer.model.Lancamento;
import com.anselmopfeifer.repository.Lancamentos;

public class GestaoLancamentos {
	private Lancamentos lancamentos;

	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if (exixteLancamentoSemehante(lancamento)) {
			throw new RegraNegocioException("Já existe um lançamento igual a este!");
		}
		this.lancamentos.guardar(lancamento);
	}

	private boolean exixteLancamentoSemehante(Lancamento lancamento) {
		Lancamento lancamentoSemmelhante = this.lancamentos.comDadosIguais(lancamento);

		return lancamentoSemmelhante != null && !lancamentoSemmelhante.equals(lancamento);
	}

	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lancamento pago nao pode ser excluido!");
		}
		this.lancamentos.remover(lancamento);
	}
}
