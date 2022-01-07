package com.indiana.chandisingh.springboottrail;

import io.cucumber.java.en.Given;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StoreGlassesStepDefinitions {

    Glass glass= new Glass();
    String name="name";
    int vol=10;

    @Given("I have set a type")
    public void i_have_set_a_type()  {
        glass.setType(name);
    }
    @Given("I have not set a type")
    public void i_have_not_set_a_type()  {
        glass.setType(null);
    }
    @Given("I have set a volume")
    public void i_have_set_a_volume()  {
        glass.setVolume(vol);
    }
    @Given("I have not set a volume")
    public void i_have_not_set_a_volume()  {
        glass.setVolume(0);
    }






}