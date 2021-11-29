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
	@Autowired
	private GarnishRepository garnishRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	/////////////////INGREDIENTS////////////////////////////////////////////////////

	@GetMapping("/getIngredients")
	//@GetMapping("/all")
	public @ResponseBody Iterable<Ingredients> getAllIngredients(){
		return ingredientRepository.findAll();
	}


	@PostMapping("/addIngredient")
	public @ResponseBody String addIngredient (@RequestParam String name,
											   @RequestParam String type,
											   //@RequestParam Integer abv,
											   @RequestParam String description,
											   @RequestParam String storage){
		Ingredients savedIngredient = new Ingredients(name,type,description,storage);
		ingredientRepository.save(savedIngredient);
		return "Saved";
	}
	/////////////////////////GARNISH//////////////////////////////////////////////

	@GetMapping("/getGarnish")
	public @ResponseBody Iterable<Garnish> getAllGarnish(){
		return garnishRepository.findAll();
	}

	@PostMapping("/addGarnish")
	public @ResponseBody String addGarnish (@RequestParam String name,
											   @RequestParam String type,
											   @RequestParam String storage){
		Garnish savedGarnish = new Garnish(name, type, storage);
		garnishRepository.save(savedGarnish);
		return "Saved";
	}

}
