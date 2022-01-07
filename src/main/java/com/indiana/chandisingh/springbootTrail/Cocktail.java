package com.indiana.chandisingh.springbootTrail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idcocktail;
    private String name;
    private int volume;
    private int ABV;
    private int price;

    public Cocktail(){}
    public Cocktail(String name,int volume,int ABV,int price){
        this.name=name;
        this.volume=volume;
        this.ABV=ABV;
        this.price=price;
    }
    /////////////////////////////GETTERS/////////////////////////////
    public String getName() {return name;}
    public int getVolume() {return volume;}
    public int getABV() {return ABV;}
    public int getIdcocktail() {return idcocktail;}
    public int getPrice() {return price;}
    ///////////////////////SETTERS////////////////////////////////
    public void setVolume(int volume) {this.volume = volume;}
    public void setName(String name) {this.name = name;}
    public void setABV(int ABV) {this.ABV = ABV;}
    public void setIdcocktail(int idcocktail) {this.idcocktail = idcocktail;}
    public void setPrice(int price) {this.price = price;}




}
