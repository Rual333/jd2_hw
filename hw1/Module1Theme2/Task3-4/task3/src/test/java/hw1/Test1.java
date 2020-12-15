package hw1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Test1 {
    Calculator calc;


    @Before
    public void init() {
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null;
    }
    private final int val1;
    private final int val2;
    private final int result;

    public Test1(int val1, int val2, int result) {

        this.val1 = val1;
        this.val2 = val2;
        this.result = result;

    }

    @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][] { { 0, 0, 0 }, { -0, -0, 0 }, { 9999999, 9999999, 19999998 } });
    }

    @Test
    public void testSum() {
        assertEquals(result, calc.getSum(val1, val2));

    }
}
