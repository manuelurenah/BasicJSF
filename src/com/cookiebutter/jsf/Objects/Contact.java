package com.cookiebutter.jsf.Objects;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */
public class Contact {

    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;

    public Contact(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Contact(String name, String lastname, String address, String phone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
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
