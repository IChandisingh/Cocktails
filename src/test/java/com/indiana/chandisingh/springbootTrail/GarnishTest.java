package com.indiana.chandisingh.springbootTrail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarnishTest {
    @Test
    public void testGarnishGetandSet(){
        Garnish garnish=new Garnish();
        garnish.setName("name");
        garnish.setType("type");
        garnish.setStorage("storage");
        garnish.setIdgarnish(1);
        assertEquals("name",garnish.getName(),"name not set");
        assertEquals("type",garnish.getType(),"type not set");
        assertEquals("storage",garnish.getStorage(),"storage not set");
        assertEquals(1,garnish.getIdgarnish(),"Id not set");
    }
    @Test
    public void testGarnishConstructor(){
        Garnish garnish=new Garnish("name","type","storage");
        assertEquals("name",garnish.getName(),"name not set");
        assertEquals("type",garnish.getType(),"type not set");
        assertEquals("storage",garnish.getStorage(),"storage not set");
    }
}
