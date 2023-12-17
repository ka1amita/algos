package src.other;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.other.Isogram.solveWithArray;
import static src.other.Isogram.solveWithBitwise;

import org.junit.jupiter.api.Test;

public class Isogram {
  public static boolean solveWithBitwise(String input) {
    /*
     * for each letter in input l
     *  if letter among collection of seen letters
     *    return false
     *  else
     *   add l to collection of seen letters
     */
    int seen = 0;
    for (char letter : input.toCharArray()) {
      if (( seen & 1 << ( letter - 'a' ) ) != 0) {
        return false;
      } else {
        seen |= 1 << ( letter - 'a' );
      }
    }
    return true;
  }

  public static boolean solveWithArray(String input) {
    /*
     * for each letter in input l
     *  if letter among collection of seen letters
     *    return false
     *  else
     *   add l to collection of seen letters
     */
    int[] seen = new int['z' - 'a' + 1];
    for (char letter : input.toCharArray()) {
      if (seen[letter - 'a'] != 0) {
        return false;
      } else {
        seen[letter - 'a'] = 1;
      }
    }
    return true;
  }
}

class TestIsogram {
  @Test
  void testSolveWithArray() {
    assertTrue(solveWithArray("abc"));
    assertFalse(solveWithArray("aabc"));
    assertFalse(solveWithArray("abca"));
  }

  @Test
  void testSolveWithBitwise() {
    assertTrue(solveWithBitwise("abc"));
    assertFalse(solveWithBitwise("aabc"));
    assertFalse(solveWithBitwise("abca"));
  }
}