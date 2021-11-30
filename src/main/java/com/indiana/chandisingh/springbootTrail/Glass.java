package com.indiana.chandisingh.springbootTrail;
import javax.persistence.Entity;

@Entity
public class Glass {
    private int idglass;
    private String type;
    private int volume;

    public Glass(){}

    public Glass(int idglass, String type, int volume){
        this.idglass=idglass;
        this.type = type;
        this.volume=volume;
    }
    ///////////////////GETTERS/////////////////////////////////////////////
    public String getType() {
        return type;
    }

    public int getIdglass() {
        return idglass;
    }

    public int getVolume() {
        return volume;
    }
    /////////////////////////////SETTERS/////////////////////////////////
    public void setType(String type) {
        this.type = type;
    }

    public void setIdglass(int idglass) {
        this.idglass = idglass;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
