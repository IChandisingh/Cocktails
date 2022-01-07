package com.indiana.chandisingh.springboottrail;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idinstruction;

    private String description;

    public Instruction(){}

    public Instruction( String description){
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
