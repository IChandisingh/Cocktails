package com.indiana.chandisingh.springbootTrail;
import javax.persistence.Entity;

@Entity
public class Instruction {
    private int idinstruction;
    private String description;

    public Instruction(int idinstruction, String description){
        this.idinstruction = idinstruction;
        this.description=description;
    }

    //////////////////////GETTERS//////////////////////////////////////
    public String getDescription() {
        return description;
    }

    public int getIdinstruction() {
        return idinstruction;
    }
    //////////////////////SETTERS/////////////////////////////////////
    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdinstruction(int idinstruction) {
        this.idinstruction = idinstruction;
    }
}
