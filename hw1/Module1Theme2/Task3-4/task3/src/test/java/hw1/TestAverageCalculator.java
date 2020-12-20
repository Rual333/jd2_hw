package hw1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestAverageCalculator {

    private final List<Integer> list;
    private final Double result;

    public TestAverageCalculator(List<Integer> list, Double result) {

        this.list = list;
        this.result = result;

    }
    @Parameterized.Parameters(name = "{index}:sumOf({0})={1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][] { { List.of(1,2), 3.0/2.0 }, { List.of(-1,1), 0.0 }, { List.of(Integer.MAX_VALUE, Integer.MAX_VALUE), 2.147483647E9 } });
    }

    @Test
    public void testAverage() {
        assertEquals(result, AverageCalculator.getAverage(list));

    }

}
