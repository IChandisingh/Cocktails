package com.indiana.chandisingh.springboottrail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@RestController
@CrossOrigin
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

	public SpringbootTrailApplication(IngredientRepository ingredientRepository,
									  GarnishRepository garnishRepository,
									  EquipmentRepository equipmentRepository,
									  InstructionRepository instructionRepository,
									  GlassRepository glassRepository,
									  CocktailRepository cocktailRepository){
		this.ingredientRepository=ingredientRepository;
		this.garnishRepository=garnishRepository;
		this.equipmentRepository=equipmentRepository;
		this.instructionRepository=instructionRepository;
		this.glassRepository=glassRepository;
		this.cocktailRepository=cocktailRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrailApplication.class, args);}

	String saved ="Saved";
	String deleted="Deleted";
	String updated ="Updated";

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
	public @ResponseBody Ingredients addIngredient (Ingredients ingredient){
		ingredientRepository.save(ingredient);
		return ingredient;
	}
	@PutMapping("/updateIngredient/{id}")
	public @ResponseBody Ingredients updateIngredient (Ingredients ingredient,
												  @PathVariable int id){
		Ingredients existingIngredient=ingredientRepository.findById(id).get();
		existingIngredient.setStorage(ingredient.getStorage());
		existingIngredient.setType(ingredient.getType());
		existingIngredient.setName(ingredient.getName());
		existingIngredient.setDescription(ingredient.getDescription());
		ingredientRepository.save(existingIngredient);
		return existingIngredient;
	}
	@DeleteMapping("/deleteIngredient")
	public @ResponseBody String deleteIngredient(@RequestParam int idingredientid){
		Ingredients existingIngredient=ingredientRepository.findById(idingredientid).get();
		ingredientRepository.delete(existingIngredient);
		return deleted;
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
	public @ResponseBody Garnish addGarnish (Garnish garnish){
		garnishRepository.save(garnish);
		return garnish;
	}

	@PutMapping("/updateGarnish/{id}")
	public @ResponseBody Garnish updateGarnish (Garnish garnish, @PathVariable int id){
		Garnish existingGarnish=garnishRepository.findById(id).get();
		existingGarnish.setStorage(garnish.getStorage());
		existingGarnish.setType(garnish.getType());
		existingGarnish.setName(garnish.getName());
		garnishRepository.save(existingGarnish);
		return existingGarnish;
	}
	@DeleteMapping("/deleteGarnish")
	public @ResponseBody String deleteGarnish(@RequestParam int idgarnish){
		Garnish existingGarnish=garnishRepository.findById(idgarnish).get();
		garnishRepository.delete(existingGarnish);
		return deleted;
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
	public @ResponseBody Equipment addEquipment (Equipment equipment) {
		equipmentRepository.save(equipment);
		return equipment;
	}
	@PutMapping("/updateEquipment/{id}")
	public @ResponseBody Equipment updateEquipment (Equipment equipment,
												@PathVariable int id){
		Equipment existingEquipment=equipmentRepository.findById(id).get();
		existingEquipment.setType(equipment.getType());
		existingEquipment.setName(equipment.getName());
		equipmentRepository.save(existingEquipment);
		return existingEquipment;
	}
	@DeleteMapping("/deleteEquipment")
	public @ResponseBody String deleteEquipment(@RequestParam int idequipment){
		Equipment existingEquipment=equipmentRepository.findById(idequipment).get();
		equipmentRepository.delete(existingEquipment);
		return deleted;
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
	public @ResponseBody Glass addGlass (Glass glass){
		glassRepository.save(glass);
		return glass;
	}
	@PutMapping("/updateGlass/{id}")
	public @ResponseBody Glass updateGlass (Glass glass, @PathVariable int id){
		Glass existingGlass=glassRepository.findById(id).get();
		existingGlass.setType(glass.getType());
		existingGlass.setVolume(glass.getVolume());
		glassRepository.save(existingGlass);
		return existingGlass;
	}
	@DeleteMapping("/deleteGlass")
	public @ResponseBody String deleteGlass(@RequestParam int idglass){
		Glass existingGlass=glassRepository.findById(idglass).get();
		glassRepository.delete(existingGlass);
		return deleted;
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
	public @ResponseBody String addInstruction (Instruction instruction){
		instructionRepository.save(instruction);
		return saved;
	}
	@PutMapping("/updateInstruction/{id}")
	public @ResponseBody Instruction updateInstruction (Instruction instruction,
														@PathVariable int id){
		Instruction existingInstruction=instructionRepository.findById(id).get();
		existingInstruction.setDescription(instruction.getDescription());
		instructionRepository.save(existingInstruction);
		return existingInstruction;
	}
	@DeleteMapping("/deleteInstruction")
	public @ResponseBody String deleteInstruction(@RequestParam int idinstruction){
		Instruction existingInstruction=instructionRepository.findById(idinstruction).get();
		instructionRepository.delete(existingInstruction);
		return deleted;
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
	public @ResponseBody Cocktail addCocktail (Cocktail cocktail){
		cocktailRepository.save(cocktail);
		return cocktail;
	}
	@PutMapping("/updateCocktail/{id}")
	public @ResponseBody Cocktail updateCocktail (Cocktail cocktail, @PathVariable int id){
		Cocktail existingCocktail=cocktailRepository.findById(id).get();
		existingCocktail.setPrice(cocktail.getPrice());
		existingCocktail.setAbv(cocktail.getAbv());
		existingCocktail.setName(cocktail.getName());
		existingCocktail.setVolume(cocktail.getVolume());
		cocktailRepository.save(existingCocktail);
		return existingCocktail;
	}
	@DeleteMapping("/deleteCocktail")
	public @ResponseBody String deleteCocktail(@RequestParam int idcocktail){
		Cocktail existingCocktail=cocktailRepository.findById(idcocktail).get();
		cocktailRepository.delete(existingCocktail);
		return deleted;
	}





}
