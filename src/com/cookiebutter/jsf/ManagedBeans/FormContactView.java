package com.cookiebutter.jsf.ManagedBeans;

import com.cookiebutter.jsf.Objects.Contact;

import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */

@ManagedBean(name = "formContact")
@SessionScoped
public class FormContactView implements Serializable {

    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;

    public String processForm() {
        Contact contact = new Contact(name, lastname, address, phone, email);
        FacesContext context = FacesContext.getCurrentInstance();
        ArrayList<Contact> list = (ArrayList<Contact>)context.getExternalContext().getSessionMap().get("contacts");
        if(list == null) {
           list = new ArrayList<Contact>();
        }

        list.add(contact);
        context.getExternalContext().getSessionMap().put("contacts", list);
        clearForm();
        return "index?faces-redirect=true";
    }

    public void clearForm() {
        name="";
        lastname="";
        address="";
        phone="";
        email="";
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
}
