package com.in28minutes.rest.webservices.restfulwebservices.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    private String name;
    private String companyname;
    private int telno;
    private String email;
    private String manuname;

    public Supplier(){

    }

    public Supplier(Long id, String username, String name, String companyname, int telno, String email,
                    String manuname) {
        super();
        this.id = id;
        this.username = username;
        this.name = name;
        this.companyname = companyname;
        this.telno = telno;
        this.email = email;
        this.manuname = manuname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getTelno() {
        return telno;
    }

    public void setTelno(int telno) {
        this.telno = telno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getManuname() {
        return manuname;
    }

    public void setManuname(String manuname) {
        this.manuname = manuname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((companyname == null) ? 0 : companyname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((manuname == null) ? 0 : manuname.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + telno;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Supplier other = (Supplier) obj;
        if (companyname == null) {
            if (other.companyname != null)
                return false;
        } else if (!companyname.equals(other.companyname))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (manuname == null) {
            if (other.manuname != null)
                return false;
        } else if (!manuname.equals(other.manuname))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (telno != other.telno)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }





}
