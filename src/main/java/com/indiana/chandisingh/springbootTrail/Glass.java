package com.indiana.chandisingh.springbootTrail;
public class Glass {
    private int id;
    private String name;
    private int volume;

    public Glass(int id, String name, int volume){
        this.id=id;
        this.name=name;
        this.volume=volume;
    }
    @Override
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"id\"=\"" + id +
                "\", \"volume\"=\"" + volume +
                "\"}";
    }
}
