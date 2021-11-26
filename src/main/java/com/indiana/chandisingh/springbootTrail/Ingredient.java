package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idIngredientid;
    private String name;
    private String type;
    private int ABV;
    private String description;
    private String storage;

    public Ingredient(String name, String type, int ABV, String description, String storage){
        this.name=name;
        this.type=type;
        this.ABV=ABV;
        this.description=description;
        this.storage=storage;
    }
    public Ingredient(){}

//////////////////////////////GETTERS////////////////////////////////
    public int getABV() {
        return ABV;
    }
    public int getIdIngredientid() {
        return idIngredientid;
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

    public void setABV(int ABV) {
        this.ABV = ABV;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIdIngredientid(int idIngredientid) {
        this.idIngredientid = idIngredientid;
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
    @Override
    public String toString() {
        return "{" +
                "\"id\"= \"" + idIngredientid +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\", \"ABV\"=\"" + ABV +
                "\"}";
    }
}


