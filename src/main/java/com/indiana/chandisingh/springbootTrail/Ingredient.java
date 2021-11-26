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


