package src.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        List<Integer> input = List.of(4, 4, 4, 3);

        System.out.println(solveWithIterationRefactored(input));
        System.out.println(solveWithIteration(input));
        System.out.println(solveWithMap(input));
    }

    public static int solveWithIterationRefactored(List<Integer> candles) {
        int highest = Integer.MIN_VALUE;
        int count = 0;
        for (int candle : candles) {
            if (candle > highest) {
                highest = candle;
                count = 1;
            } else if (candle == highest) {
                count++;
            }
        }
        return count;
    }

    public static int solveWithIteration(List<Integer> candles) {
        int highest = Integer.MIN_VALUE;
        int count = 0;
        for (int candle : candles) {
            if (candle > highest) {
                highest = candle;
                count = 0;
            }
            if (candle == highest) {
                count++;
            }
        }
        return count;
    }

    public static int solveWithMap(List<Integer> candles) {
        Map<Integer, Integer> countOfCandles = new HashMap<>();
        Integer longest = Integer.MIN_VALUE;
        for (Integer candle : candles) {
            if (candle > longest) {
                longest = candle;
            }
            if (countOfCandles.containsKey(candle)) {
                countOfCandles.replace(candle, countOfCandles.get(candle) + 1);
                // incorrect:
                // Integer count = countOfCandles.get(candle);
                // count = count + 1;
            } else {
                countOfCandles.put(candle, 1);
            }
            // countOfCandles.putIfAbsent(candle,1);
        }
        return countOfCandles.get(longest);
    }
}

