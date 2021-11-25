package com.indiana.chandisingh.springbootTrail;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Ingredients {
    private List<Ingredient> ingredientsList= new ArrayList();

    public Ingredients(){
        this.ingredientsList.add(new Ingredient("Vodka", "Alcohol"));
    }


    public List<Ingredient> getIngredientsList(){
        return this.ingredientsList;
    }

    public void addIngredient(Ingredient ingredient){
        ingredientsList.add(ingredient);
    }

    public String toString(){
        String json = new Gson().toJson(ingredientsList);
        return  json;
    }
}
