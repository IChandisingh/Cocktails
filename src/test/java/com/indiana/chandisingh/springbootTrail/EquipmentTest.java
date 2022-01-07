package com.indiana.chandisingh.springbootTrail;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentTest {

    @Test
    void testEquipmentGettersAndSetters(){
        Equipment equipment = new Equipment();
        equipment.setName("Name");
        equipment.setType("Type");
        equipment.setIdequipment(1);
        assertEquals("Type",equipment.getType(),"Type not set");
        assertEquals("Name",equipment.getName(),"Name not set");
        assertEquals(1,equipment.getIdequipment(),"Id not set");
    }
    @Test
    void testEquipmentConstructor(){
        Equipment equipment = new Equipment("Name","Type");
        assertEquals("Type",equipment.getType(),"Type not set");
        assertEquals("Name",equipment.getName(),"Name not set");
    }

}
