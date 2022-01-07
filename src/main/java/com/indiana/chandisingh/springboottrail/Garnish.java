package com.indiana.chandisingh.springboottrail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garnish {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idgarnish;
    private String name;
    private String type;
    private String storage;

    public Garnish(){}

    public Garnish(String name, String type, String storage){
        this.name=name;
        this.type=type;
        this.storage=storage;
    }
    //////////////GETTERS////////////////////////////////////////////////////////////
    public String getType() {
        return type;
    }

    public String getStorage() {
        return storage;
    }

    public String getName() {
        return name;
    }

    public int getIdgarnish() {
        return idgarnish;
    }
    //////////////////////////SETTERS////////////////////////////////////////////////


    public void setType(String type) {
        this.type = type;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdgarnish(int idgarnish) {
        this.idgarnish = idgarnish;
    }
}
