package com.indiana.chandisingh.springbootTrail;
public class Garnish {
    private int id;
    private String name;
    private String type;
    private String storage;

    public Garnish(int id, String name, String type, String storage){
        this.id=id;
        this.name=name;
        this.type=type;
        this.storage=storage;
    }
    @Override
    public String toString() {
        return "{" +
                "\", \"id\"=\"" + id +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\", \"storage\"=\"" + storage +
                "\"}";
    }

}
