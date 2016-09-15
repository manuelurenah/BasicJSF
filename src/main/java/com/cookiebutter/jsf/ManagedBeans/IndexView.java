package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by luis on 11/09/16.
 */
@ManagedBean(name = "index")
@SessionScoped
public class IndexView {
    private Contact selectedContact;

    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {

        this.selectedContact = selectedContact;
    }

    public String saveAction() {
        FacesContext context = FacesContext.getCurrentInstance();
        ArrayList<Contact> contacts = (ArrayList<Contact>) context.getExternalContext().getSessionMap().get("contacts");

        for (Contact contact : contacts) {
            contact.setEditable(false);
        }

        return "index?faces-redirect=true";
    }

    public String editAction(Contact contact) {
        contact.setEditable(true);
        return null;
    }
}
