package com.anselmopfeifer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.anselmopfeifer.model.RamoAtividade;
import com.anselmopfeifer.util.HibernateUtil;

public class GestaoRamosAtividades {
private static Map<Integer, RamoAtividade> atividades = new HashMap<Integer, RamoAtividade>();
	
public void init() {
	Session session = HibernateUtil.getSession();
	this.atividades = (Map<Integer, RamoAtividade>) session.createCriteria(RamoAtividade.class).addOrder(Order.asc("descricao")).list();
	
	session.close();
}
	
	public List<RamoAtividade> listarTodas() {
		List<RamoAtividade> atividades = new ArrayList<RamoAtividade>();
		atividades.addAll(GestaoRamosAtividades.atividades.values());
		return atividades;
	}
	
	public RamoAtividade buscarPorCodigo(Integer codigo) {
		return atividades.get(codigo);
	}
}
