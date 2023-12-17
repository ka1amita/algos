package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_3.urlfy;

import org.junit.jupiter.api.Test;

public class Q1_3 {

  /* BCR: O(n)
   * Time: O(n)
   * Space: O(1)
   */
  static String urlfy(String input, int trueLength) {
    int spaces = (input.length() - trueLength) / 2; // assumes the number of spaces is correct
    char[] chars = input.toCharArray();
    int i = chars.length - 1;
    while (i >= 0) {
      int endOfString = i - spaces * 2;
      char lastStringChar = chars[endOfString];
      if (lastStringChar != ' ') {
        chars[i] = lastStringChar;
      } else {
        chars[i] = '0';
        chars[--i] = '2';
        chars[--i] = '%';
        spaces--;
      }
      i--;
    }
    return new String(chars);
  }
}

class TestQ1_3 {

  @Test
  void test_arePermutationsBySorting() {
    assertEquals("%20", urlfy("   ", 1));
    assertEquals("a%20", urlfy("a   ", 2));
    assertEquals("a%20%20", urlfy("a      ", 3));
    assertEquals("a%20%20a", urlfy("a  a    ", 4));
    assertEquals("a", urlfy("a", 1));
    assertEquals("", urlfy("", 0));
  }
}