package examples;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CalculatorTest {
    Calculator calculator;

    private static final int FIRST_NUMBER = 4;
    private static final int SECOND_NUMBER = 6;

    private static final int EXPECTED_SUM_RESULT = 10;


    @BeforeMethod

    public void beforeTest() {
        calculator = new Calculator();
    }

    @Test
    public void caseOne() {
        assertTrue(calculator.add(FIRST_NUMBER, SECOND_NUMBER) == EXPECTED_SUM_RESULT);
    }

    @Test
    public void caseTwo() {
        assertFalse(calculator.add(FIRST_NUMBER, SECOND_NUMBER) != EXPECTED_SUM_RESULT);
    }

    @Test
    public void case3() {
        Assert.assertEquals(calculator.add(FIRST_NUMBER, SECOND_NUMBER), EXPECTED_SUM_RESULT);
    }
}


