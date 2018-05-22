package org.home.bowling.utils;

import java.util.List;

public class ScoreCalculatorHelper {

    public static Integer calculateTotalSum(List<Integer> scores) {
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        return total;
    }
}
