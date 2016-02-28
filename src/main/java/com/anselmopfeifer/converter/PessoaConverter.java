package com.anselmopfeifer.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.anselmopfeifer.model.Pessoa;
import com.anselmopfeifer.repository.Pessoas;
import com.anselmopfeifer.util.FacesUtil;
import com.anselmopfeifer.util.HibernateUtil;
import com.anselmopfeifer.util.Repositorios;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter {
	
	private Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if (value != null) {
			Pessoas pessoas = repositorios.getPessoas();
			retorno = pessoas.porCodigo(new Integer(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getCodigo().toString();
		}
		return null;
	}

}