package com.anselmopfeifer.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.anselmopfeifer.model.RamoAtividade;
import com.anselmopfeifer.util.HibernateUtil;

@FacesConverter(forClass = RamoAtividade.class)
public class RamoAtividadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		RamoAtividade retorno = null;

		if (value != null) {
			Session session = HibernateUtil.getSession();

			retorno =  (RamoAtividade) session.get(RamoAtividade.class,
					new Integer(value));

			session.close();
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			return ((RamoAtividade) value).getCodigo().toString();
		}

		return null;
	}
}