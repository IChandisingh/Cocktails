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
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private InstructionRepository instructionRepository;
	@Autowired
	private GlassRepository glassRepository;
	@Autowired
	private CocktailRepository cocktailRepository;

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
											   @RequestParam Integer abv,
											   @RequestParam String description,
											   @RequestParam String storage){
		Ingredients savedIngredient = new Ingredients(abv,name,type,description,storage);
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
	//////////////////////////////////////Equipment/////////////////////////////////////////////


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
		Equipment newEquipment = new Equipment(name,type);
		equipmentRepository.save(newEquipment);
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

	@GetMapping("/getAllGlasses")
	public @ResponseBody Iterable<Glass> getAllGlasses(){
		return glassRepository.findAll();
	}
	@GetMapping("/getGlass")
	public @ResponseBody Glass getGlass(@RequestParam int id){
		return glassRepository.findById(id).get();
	}
	@PostMapping("/addGlass")
	public @ResponseBody String addGlass (@RequestParam String type,@RequestParam int volume){
		Glass newGlass = new Glass(type,volume);
		glassRepository.save(newGlass);
		return "Saved";
	}
	@PutMapping("/updateGlass/{id}")
	public @ResponseBody Glass updateGlass (@RequestParam String type,
													@RequestParam int volume,
													@PathVariable int id){
		Glass existingGlass=glassRepository.findById(id).get();
		existingGlass.setType(type);
		existingGlass.setVolume(volume);
		glassRepository.save(existingGlass);
		return existingGlass;
	}
	@DeleteMapping("/deleteGlass")
	public @ResponseBody String deleteGlass(@RequestParam int idglass){
		Glass existingGlass=glassRepository.findById(idglass).get();
		glassRepository.delete(existingGlass);
		return "Deleted";
	}
	//////////////////////////INSTRUCTION/////////////////////////////////////////
	@GetMapping("/getAllInstructions")
	public @ResponseBody Iterable<Instruction> getAllInstructions(){
		return instructionRepository.findAll();
	}
	@GetMapping("/getInstruction")
	public @ResponseBody Instruction getInstruction(@RequestParam int id){
		return instructionRepository.findById(id).get();
	}
	@PostMapping("/addInstruction")
	public @ResponseBody String addInstruction (@RequestParam String description){
		Instruction newInstruction = new Instruction(description);
		instructionRepository.save(newInstruction);
		return "Saved";
	}
	@PutMapping("/updateInstruction/{id}")
	public @ResponseBody Instruction updateInstruction (@RequestParam String description,
														@PathVariable int id){
		Instruction existingInstruction=instructionRepository.findById(id).get();
		existingInstruction.setDescription(description);
		instructionRepository.save(existingInstruction);
		return existingInstruction;
	}
	@DeleteMapping("/deleteInstruction")
	public @ResponseBody String deleteInstruction(@RequestParam int idinstruction){
		Instruction existingInstruction=instructionRepository.findById(idinstruction).get();
		instructionRepository.delete(existingInstruction);
		return "Deleted";
	}
	/////////////////////////COCKTAIL////////////////////////////////////////////
	@GetMapping("/getAllCocktails")
	public @ResponseBody Iterable<Cocktail> getAllCocktails(){
		return cocktailRepository.findAll();
	}
	@GetMapping("/geCocktail")
	public @ResponseBody Cocktail getCocktail(@RequestParam int id){
		return cocktailRepository.findById(id).get();
	}
	@PostMapping("/addCocktail")
	public @ResponseBody String addCocktail (@RequestParam String name,
											 @RequestParam int volume,
											 @RequestParam int ABV,
											 @RequestParam int price){
		Cocktail newCocktail = new Cocktail(name,volume,ABV,price);
		cocktailRepository.save(newCocktail);
		return "Saved";
	}
	@PutMapping("/updateCocktail/{id}")
	public @ResponseBody Cocktail updateCocktail (@RequestParam String name,
												  @RequestParam int volume,
												  @RequestParam int ABV,
												  @RequestParam int price,
												  @PathVariable int id){
		Cocktail existingCocktail=cocktailRepository.findById(id).get();
		existingCocktail.setPrice(price);
		existingCocktail.setABV(ABV);
		existingCocktail.setName(name);
		existingCocktail.setVolume(volume);
		cocktailRepository.save(existingCocktail);
		return existingCocktail;
	}
	@DeleteMapping("/deleteCocktail")
	public @ResponseBody String deleteCocktail(@RequestParam int idcocktail){
		Cocktail existingCocktail=cocktailRepository.findById(idcocktail).get();
		cocktailRepository.delete(existingCocktail);
		return "Deleted";
	}






}
