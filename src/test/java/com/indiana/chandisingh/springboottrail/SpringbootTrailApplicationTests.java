package com.indiana.chandisingh.springboottrail;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class SpringbootTrailApplicationTests {

    @Mock
    private IngredientRepository ingredientRepository;
    @Mock
    private GarnishRepository garnishRepository;
    @Mock
    private EquipmentRepository equipmentRepository;
    @Mock
    private InstructionRepository instructionRepository;
    @Mock
    private GlassRepository glassRepository;
    @Mock
    private CocktailRepository cocktailRepository;

    private AutoCloseable autoCloseable;
    private SpringbootTrailApplication main;
    @BeforeMethod
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        main=new SpringbootTrailApplication(ingredientRepository,garnishRepository,equipmentRepository,instructionRepository,glassRepository,cocktailRepository);
    }
    @AfterMethod
    void tearDown() throws Exception {
        autoCloseable.close();
    }
///////////////////////////////////////GetAll///////////////////////////////////////////////////////
    @Test
    void testGetAllIngredients(){
        main.getAllIngredients();
        verify(ingredientRepository).findAll();
    }
    @Test
    void testGetAllGarnish(){
        main.getAllGarnish();
        verify(garnishRepository).findAll();
    }
    @Test
    void testGetAllEquipment(){
        main.getAllEquipment();
        verify(equipmentRepository).findAll();
    }
    @Test
    void testGetAllGlasses(){
        main.getAllGlasses();
        verify(glassRepository).findAll();
    }
    @Test
    void testGetAllInstructions(){
        main.getAllInstructions();
        verify(instructionRepository).findAll();
    }
    @Test
    void testGetAllCocktails(){
        main.getAllCocktails();
        verify(cocktailRepository).findAll();
    }
////////////////////////////////////////////GetOne///////////////////////////////////////////
    @Test
    void testGetIngredient(){
        Ingredients ingredients = new Ingredients(0, "name", "type", "description", "storage");
        Optional<Ingredients> optionalIngredients= Optional.of(ingredients);
        given(ingredientRepository.findById(ingredients.getIdingredientid())).willReturn(Optional.of(ingredients));
        Assertions.assertEquals(optionalIngredients,main.getIngredient(ingredients.getIdingredientid()) );
        verify(ingredientRepository).findById(ingredients.getIdingredientid());
    }
    @Test
    void testGetCocktail(){
        Cocktail cocktail=new Cocktail("name",10,0,3);
        Optional<Cocktail> optionalCocktail= Optional.of(cocktail);
        given(cocktailRepository.findById(cocktail.getIdcocktail())).willReturn(Optional.of(cocktail));
        Assertions.assertEquals(optionalCocktail,main.getCocktail(cocktail.getIdcocktail()));
        verify(cocktailRepository).findById(cocktail.getIdcocktail());
    }
    @Test
    void testGetInstruction(){
        Instruction instruction= new Instruction("description");
        Optional<Instruction> optionalInstruction= Optional.of(instruction);
        given(instructionRepository.findById(instruction.getIdinstruction())).willReturn(Optional.of(instruction));
        Assertions.assertEquals(optionalInstruction,main.getInstruction(instruction.getIdinstruction()));
        verify(instructionRepository).findById(instruction.getIdinstruction());
    }
    @Test
    void testGetEquipment(){
        Equipment equipment = new Equipment("name","type");
        Optional<Equipment> optionalEquipment = Optional.of(equipment);
        given(equipmentRepository.findById(equipment.getIdequipment())).willReturn(Optional.of(equipment));
        Assertions.assertEquals(optionalEquipment,main.getEquipment(equipment.getIdequipment()));
        verify(equipmentRepository).findById(equipment.getIdequipment());
    }
    @Test
    void testGetGarnish(){
        Garnish garnish= new Garnish("name","type","storage");
        Optional<Garnish> optionalGarnish= Optional.of(garnish);
        given(garnishRepository.findById(garnish.getIdgarnish())).willReturn(Optional.of(garnish));
        Assertions.assertEquals(optionalGarnish,main.getGarnish(garnish.getIdgarnish()));
        verify(garnishRepository).findById(garnish.getIdgarnish());
    }
    @Test
    void testGetGlass(){
        Glass glass= new Glass("type", 10);
        Optional<Glass> optionalGlass= Optional.of(glass);
        given(glassRepository.findById(glass.getIdglass())).willReturn(Optional.of(glass));
        Assertions.assertEquals(optionalGlass,main.getGlass(glass.getIdglass()));
        verify(glassRepository).findById(glass.getIdglass());
    }
///////////////////////////////////////////Add///////////////////////////////////////////////
    @Test
    void testAddIngredients(){
        Ingredients ingredients = new Ingredients(0,
                                                    "name",
                                                    "type",
                                                    "description",
                                                    "storage");
        main.addIngredient(ingredients);

        ArgumentCaptor<Ingredients> ingredientsArgumentCaptor =
                ArgumentCaptor.forClass(Ingredients.class);
        verify(ingredientRepository).save(ingredientsArgumentCaptor.capture());
        Ingredients capturedIngredients = ingredientsArgumentCaptor.getValue();
        assertThat(capturedIngredients).isEqualTo(ingredients);
    }

    @Test
    void testAddGarnish(){
        Garnish garnish = new Garnish("name","type","storage");
        main.addGarnish(garnish);

        ArgumentCaptor<Garnish> garnishArgumentCaptor =
                ArgumentCaptor.forClass(Garnish.class);
        verify(garnishRepository).save(garnishArgumentCaptor.capture());
        Garnish capturedGarnish = garnishArgumentCaptor.getValue();
        assertThat(capturedGarnish).isEqualTo(garnish);
    }

    @Test
    void testAddEquipment(){
        Equipment equipment = new Equipment("name","type");
        main.addEquipment(equipment);
        ArgumentCaptor<Equipment> equipmentArgumentCaptor =
                ArgumentCaptor.forClass(Equipment.class);
        verify(equipmentRepository).save(equipmentArgumentCaptor.capture());
        Equipment capturedEquipment = equipmentArgumentCaptor.getValue();
        assertThat(capturedEquipment).isEqualTo(equipment);
    }

    @Test
    void testAddCocktail(){
        Cocktail cocktail = new Cocktail("name",10,0,3);
        main.addCocktail(cocktail);
        ArgumentCaptor<Cocktail> cocktailArgumentCaptor =
                ArgumentCaptor.forClass(Cocktail.class);
        verify(cocktailRepository).save(cocktailArgumentCaptor.capture());
        Cocktail capturedCocktail = cocktailArgumentCaptor.getValue();
        assertThat(capturedCocktail).isEqualTo(cocktail);
    }

    @Test
    void testAddInstruction(){
        Instruction instruction = new Instruction("description");
        main.addInstruction(instruction);
        ArgumentCaptor<Instruction> instructionArgumentCaptor =
                ArgumentCaptor.forClass(Instruction.class);
        verify(instructionRepository).save(instructionArgumentCaptor.capture());
        Instruction capturedInstruction = instructionArgumentCaptor.getValue();
        assertThat(capturedInstruction).isEqualTo(instruction);
    }
    @Test
    void testAddGlass(){
        Glass glass = new Glass("type",10);
        main.addGlass(glass);
        ArgumentCaptor<Glass> glassArgumentCaptor =
                ArgumentCaptor.forClass(Glass.class);
        verify(glassRepository).save(glassArgumentCaptor.capture());
        Glass capturedGlass = glassArgumentCaptor.getValue();
        assertThat(capturedGlass).isEqualTo(glass);
    }


//////////////////////////////////////////////Update//////////////////////////////////////////
    @Test
    void testUpdateIngredients(){
        Ingredients ingredients = new Ingredients(0, "name", "type", "description", "storage");
        given(ingredientRepository.findById(ingredients.getIdingredientid())).willReturn(Optional.of(ingredients));
        ingredients.setName("Name");

        ArgumentCaptor<Ingredients> ingredientsArgumentCaptor = ArgumentCaptor.forClass(Ingredients.class);
        Optional<Ingredients> capturedIngredient= main.updateIngredient(ingredients,ingredients.getIdingredientid());
        Optional<Ingredients> ingredient = Optional.of(ingredients);
        verify(ingredientRepository).save(ingredients);
        Assertions.assertEquals(ingredient,capturedIngredient);
    }
    @Test
    void testUpdateCocktail(){
        Cocktail cocktail=new Cocktail("name",10,0,4);
        given(cocktailRepository.findById(cocktail.getIdcocktail())).willReturn(Optional.of(cocktail));
        cocktail.setName("Name");

        Cocktail capturedCocktail= main.updateCocktail(cocktail,cocktail.getIdcocktail());

        verify(cocktailRepository).save(cocktail);
        Assertions.assertEquals(cocktail,capturedCocktail);
    }
    @Test
    void testUpdateInstruction(){
        Instruction instruction=new Instruction("description");
        given(instructionRepository.findById(instruction.getIdinstruction())).willReturn(Optional.of(instruction));
        instruction.setDescription("Description");

        Instruction capturedInstruction= main.updateInstruction(instruction,instruction.getIdinstruction());

        verify(instructionRepository).save(instruction);
        Assertions.assertEquals(instruction,capturedInstruction);
    }
    @Test
    void testUpdateEquipment(){
        Equipment equipment=new Equipment("name","type");
        given(equipmentRepository.findById(equipment.getIdequipment())).willReturn(Optional.of(equipment));
        equipment.setName("Name");

        Equipment capturedEquipment= main.updateEquipment(equipment,equipment.getIdequipment());

        verify(equipmentRepository).save(equipment);
        Assertions.assertEquals(equipment,capturedEquipment);
    }
    @Test
    void testUpdateGarnish(){
        Garnish garnish = new Garnish("name","type", "storage");
        given(garnishRepository.findById(garnish.getIdgarnish())).willReturn(Optional.of(garnish));
        garnish.setName("Name");

        Garnish capturedGarnish= main.updateGarnish(garnish,garnish.getIdgarnish());

        verify(garnishRepository).save(garnish);
        Assertions.assertEquals(garnish,capturedGarnish);
    }
    @Test
    void testUpdateGlass(){
        Glass glass = new Glass("type",10);
        given(glassRepository.findById(glass.getIdglass())).willReturn(Optional.of(glass));
        glass.setType("Type");

        Glass capturedGlass= main.updateGlass(glass,glass.getIdglass());

        verify(glassRepository).save(glass);
        Assertions.assertEquals(glass,capturedGlass);
    }

//////////////////////////////////////////Delete/////////////////////////////////////////////
    @Test
    void testDeleteIngredient(){

        Ingredients ingredients = new Ingredients(0,
                "name",
                "type",
                "description",
                "storage");
        given(ingredientRepository.findById(ingredients.getIdingredientid())).willReturn(Optional.of(ingredients));
        Assertions.assertEquals("Deleted",main.deleteIngredient(ingredients.getIdingredientid()));
        verify(ingredientRepository).delete(ingredients);
    }
    @Test
    void testDeleteCocktail(){

        Cocktail cocktail = new Cocktail("name",10,0,3);
        given(cocktailRepository.findById(cocktail.getIdcocktail())).willReturn(Optional.of(cocktail));
        Assertions.assertEquals("Deleted",main.deleteCocktail(cocktail.getIdcocktail()));
        verify(cocktailRepository).delete(cocktail);
    }
    @Test
    void testDeleteInstruction(){
        Instruction instruction = new Instruction("description");
        given(instructionRepository.findById(instruction.getIdinstruction())).willReturn(Optional.of(instruction));
        Assertions.assertEquals("Deleted",main.deleteInstruction(instruction.getIdinstruction()));
        verify(instructionRepository).delete(instruction);
    }
    @Test
    void testDeleteEquipment(){
        Equipment equipment = new Equipment("name","type");
        given(equipmentRepository.findById(equipment.getIdequipment())).willReturn(Optional.of(equipment));
        Assertions.assertEquals("Deleted",main.deleteEquipment(equipment.getIdequipment()));
        verify(equipmentRepository).delete(equipment);
    }
    @Test
    void testDeleteGarnish(){
        Garnish garnish = new Garnish("name","type","storage");
        given(garnishRepository.findById(garnish.getIdgarnish())).willReturn(Optional.of(garnish));
        Assertions.assertEquals("Deleted",main.deleteGarnish(garnish.getIdgarnish()));
        verify(garnishRepository).delete(garnish);
    }
    @Test
    void testDeleteGlass(){
        Glass glass = new Glass("type",10);
        given(glassRepository.findById(glass.getIdglass())).willReturn(Optional.of(glass));
        Assertions.assertEquals("Deleted",main.deleteGlass(glass.getIdglass()));
        verify(glassRepository).delete(glass);
    }


}
