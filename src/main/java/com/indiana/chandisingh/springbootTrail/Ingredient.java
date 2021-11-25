package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import org.springframework.context.annotation.EnableMBeanExport;

public class Ingredient {
    private int id;
    private String name;
    private String type;
    private int ABV;
    private String description;
    private String storage;

    public Ingredient(int id, String name, String type,int ABV){
        this.id=id;
        this.name=name;
        this.type=type;
        this.ABV=ABV;

    }
    @Override
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\", \"ABV\"=\"" + ABV +
                "\"}";
    }
}


