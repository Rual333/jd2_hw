package hw1;

import java.util.List;

public class AverageCalculator {

    public static Double getAverage(List<Integer> list) {
        Double sum = 0.0;
        for(Integer l:list) {
           sum+=l;
        }
        return (sum/ list.size());
    }

}
