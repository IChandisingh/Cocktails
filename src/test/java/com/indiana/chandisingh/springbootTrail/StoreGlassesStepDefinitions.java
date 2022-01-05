package com.indiana.chandisingh.springbootTrail;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StoreGlassesStepDefinitions {
    @Given("I have inputted a type")
    public void i_have_inputted_a_type()  {
        Glass glass= new Glass();
        glass.setType("name");

    }

    @Given("I have inputted a volume")
    public void i_have_inputted_a_volume()  {
        Glass glass= new Glass();
        glass.setVolume(10);
    }



}
