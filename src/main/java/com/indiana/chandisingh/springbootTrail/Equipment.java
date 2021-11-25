package com.indiana.chandisingh.springbootTrail;
import com.google.gson.Gson;

import java.util.List;

public class Equipment {
    private int id;
    private String name;
    private String type;

    public Equipment(int id, String name, String type){
        this.name=name;
        this.type=type;
        this.id=id;
    }
    @Override
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\", \"id\"=\"" + id +
                "\"}";
    }


}
