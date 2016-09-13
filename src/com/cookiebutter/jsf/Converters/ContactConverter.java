package com.cookiebutter.jsf.Converters;

import com.cookiebutter.jsf.Objects.Contact;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */

@FacesConverter(value = "ContactConverter")
public class ContactConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        String[] fullname = s.split(" ");
        String name = fullname[0];
        String lastname = fullname[1];

        Contact contact = new Contact(name, lastname);
        return contact;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Contact contact = (Contact) o;
        return contact.getName() + " " + contact.getLastname();
    }

}
