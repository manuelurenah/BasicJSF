package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private int id;
    @Size(min = 3, max = 15)
    private String name;
    @Size(min = 3, max = 15)
    private String lastname;
    private String address;
    @Size(min = 10, max = 14)
    private String phone;
    private String email;

    @PostConstruct
    private void viewDidAppear() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println(context.getExternalContext().getSessionMap().get("contacts"));
    }

    @PreDestroy
    private void viewWillDisappear() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println(context.getExternalContext().getSessionMap().get("contacts"));
    }

    public String processForm() {
        Contact contact = new Contact(name, lastname, address, phone, email);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        getContactService().add(contact);
        return "index?faces-redirect=true";
    }

    private void clearForm() {
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
}
