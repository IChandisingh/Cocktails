package com.indiana.chandisingh.springbootTrail;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
public class Glasses {
    private List<Glass> glassList= new ArrayList();

    public Glasses(){
        this.glassList.add(new Glass(1,"Pint", 473));
    }


    public List<Glass> getGlassList(){
        return this.glassList;
    }


    public String toString(){
        String json = new Gson().toJson(glassList);
        return  json;
    }
}
