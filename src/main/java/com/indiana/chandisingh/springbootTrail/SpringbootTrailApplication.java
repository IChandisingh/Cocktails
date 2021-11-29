package com.indiana.chandisingh.springbootTrail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;


@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
public class SpringbootTrailApplication {

	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private GarnishRepository garnishRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	/////////////////INGREDIENTS////////////////////////////////////////////////////

	@GetMapping("/getAllIngredients")
	public @ResponseBody Iterable<Ingredients> getAllIngredients(){
		return ingredientRepository.findAll();
	}

	@GetMapping("/getIngredient")
	public @ResponseBody String getIngredient(@RequestParam int id){
		return ingredientRepository.findById(id).get().toString();
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

	@GetMapping("/getAllGarnish")
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
	///////////////////////////////////////////////////////////////////////////////////


	@GetMapping("/getAllEquipment")
	public @ResponseBody Iterable<Equipment> getAllEquipment(){
		return equipmentRepository.findAll();
	}

	@PostMapping("/addEquipment")
	public @ResponseBody String addEquipment (@RequestParam String name,
											@RequestParam String type) {
		Equipment savedEquipment = new Equipment(name,type);
		equipmentRepository.save(savedEquipment);
		return "Saved";
	}


}
