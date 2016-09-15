package com.cookiebutter.jsf.Objects;

/**
 * Created by MEUrena on 9/10/16.
 * All rights reserved.
 */
public class Contact {

    public static int idCounter = 1;

    private int id;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;

    private boolean editable = false;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Contact(String name, String lastname) {
        this.id = idCounter;
        this.name = name;
        this.lastname = lastname;
        idCounter ++;
    }

    public Contact(String name, String lastname, String address, String phone, String email) {
        this.id = idCounter;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;

        idCounter ++;
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

}
