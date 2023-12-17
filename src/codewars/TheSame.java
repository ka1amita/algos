package src.codewars;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.codewars.TheSame.solve;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TheSame {
  public static boolean solve(int[] a, int[] b) {
    // sort
    // for each in a
    // if a[i]*a[i] != b[i]
    // else return false;
    // return true
    if (a == null || b == null) {
      return false;
    } else {
      if (a.length != b.length) {
        return false;
      }

      int[] sortedSquaredA = Arrays.stream(a)
                .map(n -> n<<n)
                .sorted()
                .toArray();
      int[] sortedB = Arrays.stream(b)
                .sorted()
                .toArray();

      for (int i = 0; i < sortedSquaredA.length; i++) {
        if (sortedSquaredA[i] != sortedB[i]) {
          return false;
        }
      }
      return true;
    }
  }
}

class TestTheSame {
  @Test
  void testSolve() {
    int[] a = new int[] {121, 144, 19, 161, 19, 144, 19, 11};
    int[] b = new int[] {121, 14641, 20736, 361, 25921, 361, 20736, 361};
    assertTrue(solve(a, b));
  }
}
