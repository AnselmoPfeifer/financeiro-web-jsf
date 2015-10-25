package com.anselmopfeifer;

import java.util.List;

import org.hibernate.Session;

import com.anselmopfeifer.model.Pessoa;
import com.anselmopfeifer.util.HibernateUtil;

public class TestHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();

		List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
		
		session.close();
	}
	
}