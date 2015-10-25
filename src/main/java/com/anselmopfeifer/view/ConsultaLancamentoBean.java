package com.anselmopfeifer.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.anselmopfeifer.model.Lancamento;
import com.anselmopfeifer.util.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	private List<String> lancamentos = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		Session session = HibernateUtil.getSession();
		this.lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento")).list();
	}

	public List<String> getLancamentos() {
		return lancamentos;
	}

}