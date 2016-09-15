package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by luis on 11/09/16.
 */
@ManagedBean(name = "index")
@SessionScoped
public class IndexView {
    @ManagedProperty(value = "#{contactService}")
    private ContactService contactService;
    private Contact selectedContact;

    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {

        this.selectedContact = selectedContact;
    }

    public String saveAction() {
        ArrayList<Contact> contacts = contactService.getContacts();
        for (Contact contact : contacts) {
            contact.setEditable(false);
        }

        contactService.setContacts(contacts);

        return "index?faces-redirect=true";
    }



    public String editAction(Contact contact) {
        contact.setEditable(true);
        return null;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }
}
