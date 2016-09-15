package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */

@ManagedBean(name = "formContact")
@SessionScoped
public class FormContactView implements Serializable {

    @ManagedProperty(value="#{contactService}")
    private
    ContactService contactService;
    private int id = -1;
    @Size(min = 3, message = "El nombre propuesto es demasiado corto.")
    private String name;
    @Size(min = 3, message = "El apellido propuesto es demasiado corto.")
    private String lastname;
    private String address;
    private String phone;
    private String email;

    @PostConstruct
    public void init() {

    }

    public String processForm() {
        Contact contact = new Contact(name, lastname, address, phone, email);
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(id != -1) {
            contact.setId(id);
            Contact toRemove = contactService.find(id);
            contactService.deleteContact(toRemove);
        }

        getContactService().add(contact);
        clearForm();
        return "index?faces-redirect=true";
    }

    public void clearForm() {
        id = -1;
        name = "";
        lastname = "";
        address = "";
        phone = "";
        email = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public String setEditContact(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.lastname = contact.getLastname();
        this.email = contact.getEmail();
        this.address = contact.getAddress();
        this.phone = contact.getPhone();
        return "formContact?faces-redirect=true";
    }
}
