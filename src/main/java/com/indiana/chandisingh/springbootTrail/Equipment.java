package com.indiana.chandisingh.springbootTrail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idequipment;

    private String name;
    private String type;

    public Equipment(){}

    public Equipment( String name, String type){
        this.name=name;
        this.type=type;

    }
    /////////////////////////////GETTERS/////////////////////////////

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getIdequipment() {
        return idequipment;
    }

    ////////////////////////////SETTERS//////////////////////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdequipment(int idequipment) {
        this.idequipment = idequipment;
    }

    ///////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "{" +
                "\"name\"= \"" + name +
                "\", \"type\"=\"" + type +
                "\", \"id\"=\"" + idequipment +
                "\"}";
    }


}
