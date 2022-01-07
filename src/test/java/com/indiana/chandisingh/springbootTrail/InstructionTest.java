package com.indiana.chandisingh.springbootTrail;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionTest {
    @Test
    void testInstructionGetAndSet(){
        Instruction instruction = new Instruction();
        instruction.setDescription("Description");
        instruction.setIdinstruction(1);
        assertEquals("Description",instruction.getDescription(),"Description not set");
        assertEquals(1,instruction.getIdinstruction(),"Id not set");
    }
    @Test
    void testInstructionConstructor(){
        Instruction instruction = new Instruction("Description");
        assertEquals("Description",instruction.getDescription(),"Description not set");
    }
}
