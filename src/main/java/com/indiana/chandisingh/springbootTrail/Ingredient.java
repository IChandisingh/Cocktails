package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import org.springframework.context.annotation.EnableMBeanExport;

public class Ingredient {
    private String name;
    private String type;
    private int ABV;
    private String description;
    private String storage;

    public Ingredient(String name, String type){
        this.name=name;
        this.type=type;

    }
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\"}";
    }
}


