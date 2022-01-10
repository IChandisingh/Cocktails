package com.indiana.chandisingh.springboottrail;

import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
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
    @BeforeEach
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        main=new SpringbootTrailApplication(ingredientRepository,garnishRepository,equipmentRepository,instructionRepository,glassRepository,cocktailRepository);
    }
    @AfterEach
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
////////////////////////////////////////////GetOne///////////////////////////////////////////
    @Test
    @Disabled
    void testGetIngredients(){}
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
