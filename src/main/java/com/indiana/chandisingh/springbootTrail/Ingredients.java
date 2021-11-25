package com.indiana.chandisingh.springbootTrail;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Ingredients {
    private List<Ingredient> ingredientsList= new ArrayList();

    public Ingredients(){
        this.ingredientsList.add(new Ingredient(1,"Vodka", "Alcohol",40));
    }


    public List<Ingredient> getIngredientsList(){
        return this.ingredientsList;
    }


    public String toString(){
        String json = new Gson().toJson(ingredientsList);
        return  json;
    }
}
