package com.cookiebutter.jsf.Validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by luis on 15/09/16.
 */
@FacesValidator(value = "cookieButter.phoneValidator")

public class PhoneValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String phone = (String) o;
        if(!phone.equals("") && !(phone.length() >= 10 && phone.length() <= 14)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Telefono no válido",
                    "El telefono ha de tener entre 10 - 14 digitos.");

            throw new ValidatorException(fm);
        }
    }
}
