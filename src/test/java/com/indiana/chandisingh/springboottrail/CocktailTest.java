package com.indiana.chandisingh.springboottrail;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CocktailTest {

    @Test
    void testCocktailsGettersAndSetters(){
        Cocktail cocktail = new Cocktail();
        cocktail.setVolume(10);
        cocktail.setName("Name");
        cocktail.setAbv(0);
        cocktail.setIdcocktail(1);
        cocktail.setPrice(2);
        assertEquals(10,cocktail.getVolume(),"vol not set");
        assertEquals("Name",cocktail.getName(),"Name not set");
        assertEquals(0,cocktail.getAbv(),"ABV not set");
        assertEquals(1,cocktail.getIdcocktail(),"Id not set");
        assertEquals(2,cocktail.getPrice());
    }

    @Test
    void testCocktailConstructor(){
        Cocktail cocktail = new Cocktail("Name",10,0,2);
        assertEquals(10,cocktail.getVolume(),"vol not set");
        assertEquals("Name",cocktail.getName(),"Name not set");
        assertEquals(0,cocktail.getAbv(),"ABV not set");
        assertEquals(2,cocktail.getPrice());
    }
}
