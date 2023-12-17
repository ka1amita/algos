package src.codewars;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.codewars.PileOfTowels.solve;
import static src.codewars.PileOfTowels.solveRefactored;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PileOfTowels {
  public static String[] solveRefactored(String[] towels, int[] usages) {
    /*
     * find the greatest usage u
     * count the blue towels b among in the last u towels
     * set the last u towels to red
     * set the last b towels to blue
     */
    int usage = Arrays.stream(usages).max().orElse(0);
    int blueCount = 0;
    for (int i = 0; i < usage; i++) {
      blueCount += towels[towels.length - 1 - i].equals("blue") ? 1 : 0;
    }
    for (int i = 0; i < usage; i++) {
      if (i < blueCount) {
        towels[towels.length - 1 - i] = "blue";
      } else {
        towels[towels.length - 1 - i] = "red";
      }
    }
    return towels;
  }

  public static String[] solve(String[] towels, int[] usages) {
    /*
     * for every usage u in usages
     *   cut and sort subarray of last u towels t
     *     red < blue
     *   append to the end of original array
     *
     */
    for (int usage : usages) {
      String[] used = new String[usage];
      // TODO use
      //  Arrays.copyOfRange(arr, from ,to)
      //  Arrays.sort(arr, from, to);
      for (int i = 0; i < usage; i++) {
        used[i] = towels[towels.length - 1 - i];
      }
      String[] washed = Arrays.stream(used)
                              .sorted(
                                  (towel1, towel2) ->
                                      towel2.equals("red") && towel1.equals("blue") ? 1 : -1)
                              .toArray(String[]::new);
      for (int i = 0; i < washed.length; i++) {
        towels[towels.length - 1 - i] = washed[washed.length - 1 - i];
      }
    }
    return towels;
  }
}

class TestPileOfTowels {
  @Test
  void testSolve() {
    // TODO PRACTICE
    //  assertArrayEquals(expected, actual);
    //  assertTrue(arraysEquals(arr1, arr2));

    assertTrue(Arrays.equals(new String[] {"blue", "red", "red", "blue", "blue"},
                             solve(new String[] {"blue", "red", "blue", "red", "blue"},
                                   new int[] {3})));
    assertArrayEquals(new String[] {"blue", "red", "red", "blue", "blue"},
                      solve(new String[] {"blue", "red", "blue", "red", "blue"},
                            new int[] {2, 1, 4, 2}));
  }

  @Test
  void testSolveRefactored() {
    // TODO PRACTICE
    //  assertArrayEquals(expected, actual);
    //  assertTrue(arraysEquals(arr1, arr2));

    assertTrue(Arrays.equals(new String[] {"blue", "red", "red", "blue", "blue"},
                             solveRefactored(new String[] {"blue", "red", "blue", "red", "blue"},
                                             new int[] {3})));
    assertArrayEquals(new String[] {"blue", "red", "red", "blue", "blue"},
                      solveRefactored(new String[] {"blue", "red", "blue", "red", "blue"},
                                      new int[] {2, 1, 4, 2}));
  }
}