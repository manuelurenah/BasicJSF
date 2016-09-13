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

    public ArrayList<Contact> getContacts() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (ArrayList<Contact>)context.getExternalContext().getSessionMap().get("contacts");
    }

    public void setContacts(ArrayList<Contact> contacts) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("contacts", contacts);
    }

    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {

        this.selectedContact = selectedContact;
    }
}
