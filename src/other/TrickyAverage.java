package src.other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.other.TrickyAverage.solve;
import static src.other.TrickyAverage.solveWithStream;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * Create a function called trickyAverage that takes an array of integers as an input
 * and returns the average of the smallest odd and the largest even number in it.
 * <p>
 * You cannot use LINQ/Streams or similar functions that would solve this with single command.
 * You are not allowed to use .sort().
 * <p>
 * Example cases:
 * <p>
 * trickyAverage([1, 2, 3]);
 * Should return 1.5, because the average of 1 and 2 is 1.5.
 * <p>
 * trickyAverage([3, 4, 5, 6]);
 * Should return 4.5, because the average of 3 and 6 is 4.5.
 * <p>
 * trickyAverage([5, 2, 8, -1]);
 * Should return 3.5, because the average of -1 and 8 is 3.5.
 */
public class TrickyAverage {
  // public static double solveWithStreamAndSort(int[] input) {
  //   return Arrays.stream(input).sorted().
  // }

  public static double solveWithStream(int[] input) {
    return Arrays.stream(Arrays.stream(input)
                               .collect(() -> new int[] {Integer.MAX_VALUE, -Integer.MAX_VALUE},
                                        (arr, element) -> {
                                          arr[0] =
                                              ( element % 2 != 0 && element < arr[0] ) ? element :
                                              arr[0];
                                          arr[1] =
                                              ( element % 2 == 0 && element > arr[1] ) ? element :
                                              arr[1];
                                        }, (arr1, arr2) -> {
                                     arr1[0] = Math.min(arr1[0], arr2[0]);
                                     arr1[1] = Math.max(arr1[1], arr2[1]);
                                   }))
                 .average()
                 .getAsDouble();
  }

  public static double solve(int[] input) {
    int min = Integer.MAX_VALUE;
    int max = -Integer.MAX_VALUE - 1; // because there is no need for -0

    // TODO MISTAKE
    //   n % 2 == 1 is bad (it doesn't cover negative numbers)
    //   n % 2 != 0 is OK
    for (int n : input) {
      if (n % 2 != 0 && n < min) {
        min = n;
      } else if (n % 2 == 0 && n > max) {
        max = n;
      }
    }
    return ( 0.0 + min + max ) / 2;
  }
}

class TestTrickyAverage {
  @Test
  void returnsCorrectOutput0() {
    int[] input = new int[] {3, 4, 5, 6};
    double result = 4.5;
    assertEquals(result, solve(input));
    assertEquals(result, solveWithStream(input));
  }

  @Test
  void returnsCorrectOutput1() {
    int[] input = new int[] {5, 2, 8, -1};
    double result = 3.5;
    assertEquals(result, solve(input));
    assertEquals(result, solveWithStream(input));
  }

  @Test
  void returnsCorrectOutput2() {
    int[] input = new int[] {1, 2, 3};
    double result = 1.5;
    assertEquals(result, solve(input));
    assertEquals(result, solveWithStream(input));
  }

}
