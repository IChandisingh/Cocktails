package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import java.util.List;

public class Cocktail {
    private List<Ingredient> ingredients;
    private int id;
    private String name;
    private int volume;
    private int ABV;
    private int price;

    public Cocktail(int id,String name){
        this.name=name;
        this.id=id;
    }


}
