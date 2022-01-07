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
        main.addIngredient(
                "name",
                "type",
                0,
                "description",
                "storage");

        ArgumentCaptor<Ingredients> ingredientsArgumentCaptor =
                ArgumentCaptor.forClass(Ingredients.class);
        verify(ingredientRepository).save(ingredientsArgumentCaptor.capture());
        Ingredients capturedIngredients = ingredientsArgumentCaptor.getValue();
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
