package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import java.util.List;

public class Cocktail {
    private List<Ingredient> ingredients;
    private String name;
    private int volume;
    private int ABV;
    private int price;

    public Cocktail(String name){
        this.name=name;
    }


}
