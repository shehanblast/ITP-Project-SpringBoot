package com.in28minutes.rest.webservices.restfulwebservices.todo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private String category;
    private Date exp;
    private Date mfd;
    private int qty;
    private boolean isDone;
    private String ppp;

    public Todo(){

    }

    public Todo(String username, String name, String category, Date exp, Date mfd, int qty, boolean isDone, String ppp) {
        this.username = username;
        this.name = name;
        this.category = category;
        this.exp = exp;
        this.mfd = mfd;
        this.qty = qty;
        this.isDone = isDone;
        this.ppp = ppp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getMfd() {
        return mfd;
    }

    public void setMfd(Date mfd) {
        this.mfd = mfd;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getPpp() {
        return ppp;
    }

    public void setPpp(String ppp) {
        this.ppp = ppp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Todo other = (Todo) obj;
        if (id != other.id)
            return false;
        return true;
    }





}
