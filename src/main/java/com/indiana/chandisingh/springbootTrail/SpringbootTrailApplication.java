package com.indiana.chandisingh.springbootTrail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
	@Autowired
	private InstructionRepository instructionRepository;
	@Autowired
	private GlassRepository glassRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	/////////////////INGREDIENTS////////////////////////////////////////////////////

	@GetMapping("/getAllIngredients")
	public @ResponseBody Iterable<Ingredients> getAllIngredients(){
		return ingredientRepository.findAll();
	}

	@GetMapping("/getIngredient")
	public @ResponseBody Ingredients getIngredient(@RequestParam int id){
		return ingredientRepository.findById(id).get();
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
	@PutMapping("/updateIngredient/{id}")
	public @ResponseBody Ingredients updateIngredient (@RequestParam String name,
												  @RequestParam String type,
												  @RequestParam String description,
												  @RequestParam String storage,
												  @PathVariable int id){
		Ingredients existingIngredient=ingredientRepository.findById(id).get();
		existingIngredient.setStorage(storage);
		existingIngredient.setType(type);
		existingIngredient.setName(name);
		existingIngredient.setDescription(description);
		ingredientRepository.save(existingIngredient);
		return existingIngredient;
	}
	@DeleteMapping("/deleteIngredient")
	public @ResponseBody String deleteIngredient(@RequestParam int idingredientid){
		Ingredients existingIngredient=ingredientRepository.findById(idingredientid).get();
		ingredientRepository.delete(existingIngredient);
		return "Deleted";
	}

	/////////////////////////GARNISH//////////////////////////////////////////////

	@GetMapping("/getAllGarnish")
	public @ResponseBody Iterable<Garnish> getAllGarnish(){
		return garnishRepository.findAll();
	}

	@GetMapping("/getGarnish")
	public @ResponseBody Garnish getGarnish(@RequestParam int id){
		return garnishRepository.findById(id).get();
	}
	@PostMapping("/addGarnish")
	public @ResponseBody String addGarnish (@RequestParam String name,
											   @RequestParam String type,
											   @RequestParam String storage){
		Garnish savedGarnish = new Garnish(name, type, storage);
		garnishRepository.save(savedGarnish);
		return "Saved";
	}

	@PutMapping("/updateGarnish/{id}")
	public @ResponseBody Garnish updateGarnish (@RequestParam String name,
													   @RequestParam String type,
													   @RequestParam String storage,
													   @PathVariable int id){
		Garnish existingGarnish=garnishRepository.findById(id).get();
		existingGarnish.setStorage(storage);
		existingGarnish.setType(type);
		existingGarnish.setName(name);
		garnishRepository.save(existingGarnish);
		return existingGarnish;
	}
	@DeleteMapping("/deleteGarnish")
	public @ResponseBody String deleteGarnish(@RequestParam int idgarnish){
		Garnish existingGarnish=garnishRepository.findById(idgarnish).get();
		garnishRepository.delete(existingGarnish);
		return "Deleted";
	}
	///////////////////////////////////////////////////////////////////////////////////


	@GetMapping("/getAllEquipment")
	public @ResponseBody Iterable<Equipment> getAllEquipment(){
		return equipmentRepository.findAll();
	}

	@GetMapping("/getEquipment")
	public @ResponseBody Equipment getEquipment(@RequestParam int id){
		return equipmentRepository.findById(id).get();
	}

	@PostMapping("/addEquipment")
	public @ResponseBody String addEquipment (@RequestParam String name,
											@RequestParam String type) {
		Equipment savedEquipment = new Equipment(name,type);
		equipmentRepository.save(savedEquipment);
		return "Saved";
	}
	@PutMapping("/updateEquipment/{id}")
	public @ResponseBody Equipment updateEquipment (@RequestParam String name,
												@RequestParam String type,
												@PathVariable int id){
		Equipment existingEquipment=equipmentRepository.findById(id).get();
		existingEquipment.setType(type);
		existingEquipment.setName(name);
		equipmentRepository.save(existingEquipment);
		return existingEquipment;
	}
	@DeleteMapping("/deleteEquipment")
	public @ResponseBody String deleteEquipment(@RequestParam int idequipment){
		Equipment existingEquipment=equipmentRepository.findById(idequipment).get();
		equipmentRepository.delete(existingEquipment);
		return "Deleted";
	}
	/////////////////////////////GLASS////////////////////////////////////////////


	//////////////////////////INSTRUCTION/////////////////////////////////////////


	/////////////////////////COCKTAIL////////////////////////////////////////////







}
