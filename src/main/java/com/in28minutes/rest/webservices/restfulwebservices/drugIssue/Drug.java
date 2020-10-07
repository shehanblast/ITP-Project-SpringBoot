package com.in28minutes.rest.webservices.restfulwebservices.drugIssue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drug {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String drugName;
    private double sPrice;
    private int quantity;
    private double total;

    public Drug(){

    }



    public Drug(Long id, String username, String drugName, double sPrice, int quantity, double total) {
        super();
        this.id = id;
        this.username = username;
        this.drugName = drugName;
        this.sPrice = sPrice;
        this.quantity = quantity;
        this.total = total;
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



    public String getDrugName() {
        return drugName;
    }



    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }



    public double getsPrice() {
        return sPrice;
    }



    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }



    public int getQuantity() {
        return quantity;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public double getTotal() {
        return total;
    }



    public void setTotal(double total) {
        this.total = total;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Drug other = (Drug) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }






}
