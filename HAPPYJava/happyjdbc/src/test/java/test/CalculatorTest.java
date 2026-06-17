package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.*;

public class CalculatorTest {

    @Test
    public void testADD(){
        Calculator calc = new Calculator();
        int i = calc.add(1,2);

        assertEquals(3,i);

//        Assertions.assertEquals(3,i);
//
//        random();

//        assert
    }
}
