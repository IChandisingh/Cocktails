package com.indiana.chandisingh.springbootTrail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GlassTest {
    @Test
    void testGlassGettersAndSetters(){
        Glass glass = new Glass();
        glass.setVolume(10);
        glass.setType("Type");
        glass.setIdglass(1);
        assertEquals("Type",glass.getType(),"Type not set");
        assertEquals(10,glass.getVolume(),"Vol not set");
        assertEquals(1,glass.getIdglass(),"Id not set");
    }
    @Test
    void testGlassConstructor(){
        Glass glass= new Glass("Type",10);
        assertEquals("Type",glass.getType(),"Type not set");
        assertEquals(10,glass.getVolume(),"Vol not set");
    }
}
