package com.in28minutes.rest.webservices.restfulwebservices.Medicine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Medicine {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String name;
    private String category;
    private int qty;
    private Date mfd;
    private Date exp;

    public Medicine(Long id, String username, String name, String category, int qty, Date mfd, Date exp) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.category = category;
        this.qty = qty;
        this.mfd = mfd;
        this.exp = exp;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNmae() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQty() {
        return qty;
    }

    public Date getMfd() {
        return mfd;
    }

    public Date getExp() {
        return exp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNmae(String nmae) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setMfd(Date mfd) {
        this.mfd = mfd;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", qty=" + qty +
                ", mfd=" + mfd +
                ", exp=" + exp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return qty == medicine.qty &&
                Objects.equals(id, medicine.id) &&
                Objects.equals(username, medicine.username) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(category, medicine.category) &&
                Objects.equals(mfd, medicine.mfd) &&
                Objects.equals(exp, medicine.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, category, qty, mfd, exp);
    }
}
