package com.indiana.chandisingh.springbootTrail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @Disabled
    public void testGetIngredients(){}

    @Test
    @Disabled
    public void testAddIngredients(){}

    @Test
    @Disabled
    public void testUpdateIngredients(){}

    @Test
    @Disabled
    public void testDeleteIngredient(){}

}
