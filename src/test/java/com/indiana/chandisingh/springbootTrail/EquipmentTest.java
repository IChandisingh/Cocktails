package com.indiana.chandisingh.springbootTrail;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipmentTest {

    @Test
    public void testEquipmentGettersAndSetters(){
        Equipment equipment = new Equipment();
        equipment.setName("Name");
        equipment.setType("Type");
        assertEquals("Type",equipment.getType(),"Type not set");
        assertEquals("Name",equipment.getName(),"Name not set");

    }

}
