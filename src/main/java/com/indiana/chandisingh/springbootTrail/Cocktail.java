package com.indiana.chandisingh.springbootTrail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idcocktail;
    private String name;
    private int volume;
    private int abv;
    private int price;

    public Cocktail(){}
    public Cocktail(String name,int volume,int ABV,int price){
        this.name=name;
        this.volume=volume;
        this.abv =ABV;
        this.price=price;
    }
    /////////////////////////////GETTERS/////////////////////////////
    public String getName() {return name;}
    public int getVolume() {return volume;}
    public int getAbv() {return abv;}
    public int getIdcocktail() {return idcocktail;}
    public int getPrice() {return price;}
    ///////////////////////SETTERS////////////////////////////////
    public void setVolume(int volume) {this.volume = volume;}
    public void setName(String name) {this.name = name;}
    public void setAbv(int abv) {this.abv = abv;}
    public void setIdcocktail(int idcocktail) {this.idcocktail = idcocktail;}
    public void setPrice(int price) {this.price = price;}




}
