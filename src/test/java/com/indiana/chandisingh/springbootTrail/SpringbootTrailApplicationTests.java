package com.indiana.chandisingh.springbootTrail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtensions.class)
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
    public void testGetAllIngredients(){
        main.getAllIngredients();
        verify(ingredientRepository).findAll();
    }
    @Test
    public void testGetAllGarnish(){
        main.getAllGarnish();
        verify(garnishRepository).findAll();
    }
    @Test
    public void testGetAllEquipment(){
        main.getAllEquipment();
        verify(equipmentRepository).findAll();
    }
    @Test
    public void testGetAllGlasses(){
        main.getAllGlasses();
        verify(glassRepository).findAll();
    }
    @Test
    public void testGetAllInstructions(){
        main.getAllInstructions();
        verify(instructionRepository).findAll();
    }
////////////////////////////////////////////GetOne///////////////////////////////////////////
    @Test
    @Disabled
    public void testGetIngredients(){}
///////////////////////////////////////////Add///////////////////////////////////////////////
    @Test
    public void testAddIngredients(){
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
    public void testAddGarnish(){
        Garnish garnish = new Garnish("name","type","storage");
        main.addGarnish(garnish);

        ArgumentCaptor<Garnish> garnishArgumentCaptor =
                ArgumentCaptor.forClass(Garnish.class);
        verify(garnishRepository).save(garnishArgumentCaptor.capture());
        Garnish capturedGarnish = garnishArgumentCaptor.getValue();
        assertThat(capturedGarnish).isEqualTo(garnish);
    }

    @Test
    public void testAddEquipment(){
        Equipment equipment = new Equipment("name","type");
        main.addEquipment(equipment);
        ArgumentCaptor<Equipment> equipmentArgumentCaptor =
                ArgumentCaptor.forClass(Equipment.class);
        verify(equipmentRepository).save(equipmentArgumentCaptor.capture());
        Equipment capturedEquipment = equipmentArgumentCaptor.getValue();
        assertThat(capturedEquipment).isEqualTo(equipment);
    }

    @Test
    public void testAddCocktail(){
        Cocktail cocktail = new Cocktail("name",10,0,3);
        main.addCocktail(cocktail);
        ArgumentCaptor<Cocktail> cocktailArgumentCaptor =
                ArgumentCaptor.forClass(Cocktail.class);
        verify(cocktailRepository).save(cocktailArgumentCaptor.capture());
        Cocktail capturedCocktail = cocktailArgumentCaptor.getValue();
        assertThat(capturedCocktail).isEqualTo(cocktail);
    }

    @Test
    public void testAddInstruction(){
        Instruction instruction = new Instruction("description");
        main.addInstruction(instruction);
        ArgumentCaptor<Instruction> instructionArgumentCaptor =
                ArgumentCaptor.forClass(Instruction.class);
        verify(instructionRepository).save(instructionArgumentCaptor.capture());
        Instruction capturedInstruction = instructionArgumentCaptor.getValue();
        assertThat(capturedInstruction).isEqualTo(instruction);
    }
    @Test
    public void testAddGlass(){
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
    @Disabled
    public void testUpdateIngredients(){}
//////////////////////////////////////////Delete/////////////////////////////////////////////
    @Test
    @Disabled
    public void testDeleteIngredient(){}

}
