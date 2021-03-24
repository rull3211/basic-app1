package no.bring.demo.hello;

import no.bring.demo.logic.Logic;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
public class LogicTest {
    Logic testLogic = new Logic();

    @Test
    public void ShouldBe65(){ // tester enkelpriskall
        int expected = 65;
        int got = testLogic.singlePrice(50,10,1,1,5);
        assertEquals(expected, got);
    }

    @Test
    public void testNestedLogic(){ // tester matriselogikken med en 3x3 matrise
        int[][] expected = {{65,80,95},{70,90,110},{75,100,125}};
        int[][] got = testLogic.multiplePrice(50,10,3,3,5);
        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(got) );
    }
}
