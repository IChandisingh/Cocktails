package com.indiana.chandisingh.springbootTrail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringbootTrailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	@GetMapping("/getIngredients")
	public String ingredientsResponse(){
		Ingredients ingredients = new Ingredients();
		return ingredients.toString();
	}


}
