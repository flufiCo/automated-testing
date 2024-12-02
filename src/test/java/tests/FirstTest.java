package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "EMC";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 100 == 0) {
            return "T";
        } else {
            return "FAIL";
        }
    }

    @Test
    public void tmcTest() {
        String actualResult = trialCode(4);
        assertEquals("FAIL", actualResult);
    }

    @Test
    public void tmc2Test() {
        String actualResult = trialCode(5);
        assertEquals("M", actualResult);
    }

    @Test
    public void tmc3Test() {
        String actualResult = trialCode(15);
        assertEquals("EMC", actualResult);
    }
}