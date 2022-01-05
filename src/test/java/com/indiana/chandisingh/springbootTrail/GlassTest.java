package com.indiana.chandisingh.springbootTrail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlassTest {
    @Test
    public void testGlassGettersAndSetters(){
        Glass glass = new Glass();
        glass.setVolume(10);
        glass.setType("Type");
        assertEquals("Type",glass.getType(),"Type not set");
        assertEquals(10,glass.getVolume(),"Vol not set");


    }
}
