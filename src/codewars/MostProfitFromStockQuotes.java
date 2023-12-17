package src.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.codewars.MostProfitFromStockQuotes.solveWithLoop;
import static src.codewars.MostProfitFromStockQuotes.solveWithStream;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class MostProfitFromStockQuotes {
  public static int solveWithStream(int[] quotes) {
    int profit = 0;
    int[] reversed = Arrays.stream(quotes)
                           .boxed()
                           .collect(Collectors.collectingAndThen(Collectors.toList(),
                                                                 list -> {
                                                                   Collections.reverse(list);
                                                                   return list.stream()
                                                                              .mapToInt(
                                                                                  Integer::intValue)
                                                                              .toArray();
                                                                 }));
    // fill the business logic
    return profit;
  }

  public static int solveWithLoop(int[] quotes) {
    // loop from the END of the array
    // store the first value as current maximum value max
    // if value less then the max
    // buy if (add the difference between it and the max to a profit)
    // if greater than max
    // store as max
    int profit = 0;
    int max = 0;
    for (int i = quotes.length - 1; i >= 0; i--) {
      int quote = quotes[i];
      assert quote >= 0;
      if (quote < max) {
        profit += max - quote;
      } else {
        max = quote;
      }
    }
    return profit;
  }
}

class TestMostProfitFromStockQuotes {
  @Test
  void testSolveWithLoop() {
    assertEquals(15, solveWithLoop(new int[] {1, 2, 3, 4, 5, 6}));
    assertEquals(0, solveWithLoop(new int[] {6, 5, 4, 3, 2, 1}));
    assertEquals(18, solveWithLoop(new int[] {1, 6, 5, 10, 8, 7}));
    assertEquals(26, solveWithLoop(new int[] {1, 2, 10, 3, 2, 7, 3, 2}));
  }

  @Test
  void testSolveWithStream() {
    assertEquals(15, solveWithStream(new int[] {1, 2, 3, 4, 5, 6}));
    assertEquals(0, solveWithStream(new int[] {6, 5, 4, 3, 2, 1}));
    assertEquals(18, solveWithStream(new int[] {1, 6, 5, 10, 8, 7}));
    assertEquals(26, solveWithStream(new int[] {1, 2, 10, 3, 2, 7, 3, 2}));
  }
}
