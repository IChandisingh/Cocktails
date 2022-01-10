package com.indiana.chandisingh.springboottrail;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StoreGlassesStepDefinitions {
    private GlassRepository glassRepository;

    //SpringbootTrailApplication main= new SpringbootTrailApplication();

    Glass glass= new Glass();
    String name="name";
    int vol=10;

    @Given("The app is running")
    public void the_app_is_running() throws IOException {
        URL url =new URL("http://18.222.118.217:8080/cocktails/getAllGlasses");
        try{
            HttpURLConnection connect = (HttpURLConnection) url.openConnection(); //connects to url
            assertEquals(HttpURLConnection.HTTP_OK, connect.getResponseCode(),"Connected"); //checks the connection is working correctly
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
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

    @When("I add a glass to the database")
    public void i_add_a_glass_to_the_database() {
        //main.addGlass(glass);
    }
    @Then("It should return saved")
    public void it_should_return_saved() {
        //assertEquals("Saved",main.addGlass(glass));
    }







}
