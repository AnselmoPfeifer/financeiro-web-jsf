package com.anselmopfeifer.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

public class FacesUtil {
	public static void addMensagem(Severity tipo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(tipo, mensagem, mensagem));
	}
	
	public static Object getRequestAttribute(String name){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		return request.getAttribute(name);
	}

}
