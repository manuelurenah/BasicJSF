package com.cookiebutter.jsf.Validators;

import com.cookiebutter.jsf.Objects.Contact;
import org.apache.commons.validator.EmailValidator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */

@FacesValidator(value = "contactValidator")
public class ContactValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(o);
        Contact contact = (Contact) o;

        if (contact.getName() == null || contact.getName() == "") {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre no válido",
                    "El nombre introducido no puede estar en blanco.");
            throw new ValidatorException(fm);
        } else if (contact.getName().length() < 3) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre no válido",
                    "Debe introducir un nombre de más de 3 caracteres");
            throw new ValidatorException(fm);
        } else if (contact.getLastname() == null || contact.getLastname() == "") {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Apellido no válido",
                    "El apellido introducido no puede estar en blanco.");
            throw new ValidatorException(fm);
        }
    }

}
