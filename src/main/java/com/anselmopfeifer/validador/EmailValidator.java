package com.anselmopfeifer.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.anselmopfeifer.EmailValidator")
public class EmailValidator implements Validator{
	   private Pattern pattern;
	    private Matcher matcher;
	    private static final String EMAIL_PATTERN =
	    		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		@Override
		public void validate(FacesContext context, UIComponent component, Object value) 
				throws ValidatorException {
			if(value != null){
				pattern = Pattern.compile(EMAIL_PATTERN);
	            matcher = pattern.matcher(value.toString());
	            
	            Object label = MessageFactory.getLabel(context,component);
	             if (!matcher.matches()){
	                 String descricaoErro = value + " não é um e-mail válido.";
	                 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
	                 throw new ValidatorException(message);
	             }
			}
			
		}
	
}


