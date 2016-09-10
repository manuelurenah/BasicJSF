package com.cookiebutter.jsf.ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

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
        return "index?faces-redirect=true";
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
