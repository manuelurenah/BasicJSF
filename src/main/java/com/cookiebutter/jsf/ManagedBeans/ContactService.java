package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by luis on 14/09/16.
 */
@ManagedBean(name="contactService")
@SessionScoped
public class ContactService {
    private ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts() {
        FacesContext context = FacesContext.getCurrentInstance();
        ArrayList<Contact> contacts =  (ArrayList<Contact>)context.getExternalContext().getSessionMap().get("contacts");
        if(contacts == null) {
            return new ArrayList<Contact>();
        }
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("contacts", contacts);
    }

    public void deleteContact(Contact contact) {
        ArrayList<Contact> contacts = getContacts();
        if(contacts.remove(contact)) {
            setContacts(contacts);
        }
    }

    public Contact find(int id) {
        ArrayList<Contact> contacts = getContacts();
        for(Contact c : contacts) {
            if(c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public boolean add(Contact contact) {
        ArrayList<Contact> contacts = getContacts();
        boolean added = contacts.add(contact);
        if(added) {
            setContacts(contacts);
        }

        return added;
    }
}
