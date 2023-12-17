package src.other;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.other.CheckStringLength.solve;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Create a function called checkStringsLengths(words, lengths), which accepts:
 * <p>
 * strings, which is an array of strings
 * lengths, which is an array of integers
 * This function is supposed to check whether there is at least one string of fitting length for each of the lengths in lengths array.
 * <p>
 * Return true or false depending on this.
 * <p>
 * Example 1
 * checkStringsLengths(
 * ["Word", "Sea", "Golden pearls", "Bookworm"],
 * [3, 4, 8]
 * )
 * returns true, as there is "Sea" for length 3, "Word" for length 4 and "Bookworm" for length 8.
 * <p>
 * Example 2
 * checkStringsLengths(
 * ["Word", "Sea", "Golden pearls", "Bookworm"],
 * [3, 8, 1]
 * )
 * returns false as there is no string of length 1.
 */
public class CheckStringLength {
  /**
   * <p>
   * strings, which is an array of strings
   * lengths, which is an array of integers
   * This function is supposed to check whether there is at least one string of fitting length for each of the lengths in lengths array.
   * <p>
   */

  public static boolean solve(String[] strings, int[] lengths) {
    // streams:
    // map strings s to String.lengths sl
    // sort sl
    // for each length l in lengths
    // if l not in sl
    // return false
    // else return true
    Set<Integer> stringLengths = Arrays.stream(strings)
                                       .mapToInt(string -> string.length())
                                       .distinct()
                                       .boxed()
                                       .collect(Collectors.toSet());

    boolean result = Arrays.stream(lengths)
                           .anyMatch(length -> !stringLengths.contains(length));

    // int result = (int) Arrays.stream(lengths)
    //                          .filter(length -> !stringLengths.contains(length))
    //                          .count();
    // return result != 0;

    // for (int length : lengths) {
    //   if (!stringLengths.contains(length)) {
    //     return false;
    //   }
    // }
    // return true;

    return !result;
  }
}

class TestCheckStringLength {
  @Test
  void returnsCorrectResultExample1() {
    String[] strings = new String[] {"Word", "Sea", "Golden pearls", "Bookworm"};
    int[] lengths = new int[] {3, 4, 8};
    assertTrue(solve(strings, lengths));
  }

  @Test
  void returnsCorrectResultExample2() {
    String[] strings = new String[] {"Word", "Sea", "Golden pearls", "Bookworm"};
    int[] lengths = new int[] {3, 8, 1};

    assertFalse(solve(strings, lengths));
  }
}
