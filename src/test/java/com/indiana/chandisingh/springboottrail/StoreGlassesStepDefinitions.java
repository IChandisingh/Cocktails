package com.indiana.chandisingh.springboottrail;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
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
    int vol=10;
    String returned;
    Response response;
    int id =41;
    int noId=3;
    Glass dbGlass;

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
    @Given("the glass is in the database")
    public void the_glass_is_in_the_database() {
        glass.setType(name);
        glass.setVolume(vol);
        dbGlass=RestAssured.post("http://18.222.118.217:8080/cocktails/addGlass?type="+glass.getType()+"&volume="+glass.getVolume()).then().extract().as(Glass.class);
    }
    @Given("The glass is not in the database")
    public void the_glass_is_not_in_the_database() {
        glass.setType(name);
        glass.setVolume(vol);
        dbGlass=RestAssured.post("http://18.222.118.217:8080/cocktails/addGlass?type="+glass.getType()+"&volume="+glass.getVolume()).then().extract().as(Glass.class);
        RestAssured.delete("http://18.222.118.217:8080/cocktails/deleteGlass?idglass="+dbGlass.getIdglass());
    }
    @When("I add a glass to the database")
    public void i_add_a_glass_to_the_database() {
       response=RestAssured.post("http://18.222.118.217:8080/cocktails/addGlass?type="+glass.getType()+"&volume="+glass.getVolume());
    }
    @When("I send a request to edit the glass")
    public void i_send_a_request_to_edit_the_glass() {
        response=RestAssured.put("http://18.222.118.217:8080/cocktails/updateGlass/"+dbGlass.getIdglass()+"?type="+glass.getType()+"&volume="+glass.getVolume());
    }
    @When("I send a request to delete it")
    public void i_send_a_request_to_delete_it() {
        response=RestAssured.delete("http://18.222.118.217:8080/cocktails/deleteGlass?idglass="+dbGlass.getIdglass());
    }
    @Then("It should return a json of the new information")
    public void it_should_return_a_json_of_the_new_information() {
        Glass capturedGlass=response.then().extract().as(Glass.class);
        Assertions.assertEquals(name,capturedGlass.getType());
        Assertions.assertEquals(vol,capturedGlass.getVolume());
        Assertions.assertEquals(dbGlass.getIdglass(),capturedGlass.getIdglass());
    }
    @Then("It should return saved")
    public void it_should_return_saved() {
        Glass capturedGlass=response.then().extract().as(Glass.class);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(glass.getType(),capturedGlass.getType());
        Assertions.assertEquals(glass.getVolume(),capturedGlass.getVolume());
    }

    @Then("it should return error")
    public void it_should_return_error() {
        Assertions.assertEquals(500, response.getStatusCode());
    }
    @Then("it should return deleted")
    public void it_should_return_deleted() {
        Assertions.assertEquals("Deleted",response.getBody().asString());
    }


}
