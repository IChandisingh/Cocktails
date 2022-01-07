package com.indiana.chandisingh.springbootTrail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientsTest {

    @Test
    public void testIngredientsGettersAndSetters(){
    Ingredients ingredient = new Ingredients();
    ingredient.setAbv(0);
    ingredient.setName("Name");
    ingredient.setType("Type");
    ingredient.setDescription("Description");
    ingredient.setStorage("Storage");
    ingredient.setIdingredientid(1);
    assertEquals("Description",ingredient.getDescription(),"Description not set");
    assertEquals("Type",ingredient.getType(),"Type not set");
    assertEquals("Name",ingredient.getName(),"Name not set");
    assertEquals("Storage",ingredient.getStorage(),"Storage not set");
    assertEquals(0,ingredient.getAbv(),"ABV not set");
    assertEquals(1,ingredient.getIdingredientid(),"Id not set");
}
    @Test
    public void testIngredientConstructor(){
        Ingredients ingredient = new Ingredients(0,"Name","Type","Description","Storage");
        assertEquals("Description",ingredient.getDescription(),"Description not set");
        assertEquals("Type",ingredient.getType(),"Type not set");
        assertEquals("Name",ingredient.getName(),"Name not set");
        assertEquals("Storage",ingredient.getStorage(),"Storage not set");
        assertEquals(0,ingredient.getAbv(),"ABV not set");
    }

}
