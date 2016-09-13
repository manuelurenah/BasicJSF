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
        Contact contact = (Contact) o;
        if (contact.getPhone().length() < 10 || contact.getPhone().length() > 15) {
            System.out.println("El telefono de " + contact.getName() + " no es valido...");
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Teléfono no valido",
                    "Debe introducir un teléfono de entre 10 y 15 dígitos.");
            throw new ValidatorException(fm);
        } else if (contact.getName().length() < 3) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre no válido",
                    "Debe introducir un nombre de más de 3 caracteres");
            throw new ValidatorException(fm);
        } else if (contact.getName() == null || contact.getName() == "") {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre no válido",
                    "El nombre introducido no puede estar en blanco.");
            throw new ValidatorException(fm);
        } else if (contact.getLastname() == null || contact.getLastname() == "") {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Apellido no válido",
                    "El apellido introducido no puede estar en blanco.");
            throw new ValidatorException(fm);
        } else if (EmailValidator.getInstance().isValid(contact.getEmail())) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo no válido",
                    "Introduzca un email válido.");
            throw new ValidatorException(fm);
        }
    }

}
