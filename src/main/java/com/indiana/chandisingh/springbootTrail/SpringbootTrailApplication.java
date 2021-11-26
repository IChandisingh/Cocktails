package com.indiana.chandisingh.springbootTrail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
public class SpringbootTrailApplication {

	@Autowired
	private IngredientRepository ingredientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	/*
	@GetMapping("/getIngredient")
	public String ingredientResponse(){
		Ingredient ingredient = new Ingredient(1,"Vodka","Alcohol",40);
		return ingredient.toString();
	}
	 */
	@GetMapping("/getIngredients")
	//@GetMapping("/all")
	public @ResponseBody Iterable<Ingredient> getAllUsers(){
		return ingredientRepository.findAll();
	}


	@PostMapping("/addIngredient")
	public @ResponseBody String addIngredient (@RequestParam String name, @RequestParam String type, @RequestParam int ABV, @RequestParam String description, @RequestParam String storage){
		Ingredient savedIngredient= new Ingredient(name, type, ABV,description,storage);
		ingredientRepository.save(savedIngredient);
		return "Saved";
	}


	/*
	@GetMapping("/getIngredients")
	public String ingredientsResponse(){
		Ingredients ingredients = new Ingredients();
		return ingredients.toString();
	}

	@GetMapping("/getGlasses")
	public String glassesResponse(){
		Glasses glasses = new Glasses();
		return glasses.toString();
	}

	 */

}
