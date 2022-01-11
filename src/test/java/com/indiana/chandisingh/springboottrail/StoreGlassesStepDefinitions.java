package com.indiana.chandisingh.springboottrail;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import io.restassured.response.Response;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StoreGlassesStepDefinitions {

    @LocalServerPort
    private int port;

    Glass glass= new Glass();
    String name="name";
    //int vol=10;
    String returned;
    Response response;

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
        glass.setVolume(10);
    }
    @Given("I have not set a volume")
    public void i_have_not_set_a_volume()  {

        //no vol set
    }

    @When("I add a glass to the database")
    public void i_add_a_glass_to_the_database() {
       response=RestAssured.post("http://18.222.118.217:8080/cocktails/addGlass?type="+glass.getType()+"&volume="+glass.getVolume());
    }
    @Then("It should return saved")
    public void it_should_return_saved() {
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("Saved",response.getBody().asString());
    }
    @Then("It should return error")
    public void it_should_return_error() {
        Assertions.assertEquals(400, response.getStatusCode());
    }







}
