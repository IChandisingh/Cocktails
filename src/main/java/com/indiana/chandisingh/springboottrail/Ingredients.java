package com.indiana.chandisingh.springboottrail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idingredientid;
    private String name;
    private String type;
    private Integer abv;
    private String description;
    private String storage;


    public Ingredients(){}

    public Ingredients(int abv, String name, String type, String description, String storage){
        this.name=name;
        this.type=type;
        this.abv=abv;
        this.description=description;
        this.storage=storage;
    }

    //////////////////////////////GETTERS////////////////////////////////
   public int getAbv() {
        return abv;
    }


    public int getIdingredientid() {
        return idingredientid;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String getStorage() {
        return storage;
    }
    public String getType() {
        return type;
    }
    ///////////////////////////////SETTERS////////////////////////////////////////

    public void setAbv(int abv) {
        this.abv = abv;
    }



    public void setDescription(String description) {
        this.description = description;
    }
    public void setIdingredientid(int idingredientid) {
        this.idingredientid = idingredientid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public void setType(String type) {
        this.type = type;
    }
    //////////////////////////////////////////////////////////////////////////////////



}