package com.indiana.chandisingh.springbootTrail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientsTest {

@Test
    public void testIngredientsGettersAndSetters(){
    Ingredients ingredient = new Ingredients();
    ingredient.setAbv(0);
    ingredient.setName("Name");
    ingredient.setType("Type");
    ingredient.setDescription("Description");
    assertEquals("Description",ingredient.getDescription(),"Description not set");
    assertEquals("Type",ingredient.getType(),"Type not set");
    assertEquals("Name",ingredient.getName(),"Name not set");
    assertEquals(0,ingredient.getAbv(),"ABV not set");
}

}
