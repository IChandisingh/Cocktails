package com.indiana.chandisingh.springbootTrail;
public class Instruction {
    private int id;
    private String description;

    public Instruction(int id, String description){
        this.id=id;
        this.description=description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\"= \"" + id +
                "\", \"description\"=\"" + description +
                "\"}";
    }
}
