package com.indiana.chandisingh.springbootTrail;

import java.util.List;

public class Cocktail {
    private List<Ingredients> ingredients;
    private int id;
    private String name;
    private int volume;
    private int ABV;
    private int price;

    public Cocktail(int id,String name){
        this.name=name;
        this.id=id;
    }
    @Override
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"id\"=\"" + id +
                "\", \"ABV\"=\"" + ABV +
                "\"}";
    }


}
