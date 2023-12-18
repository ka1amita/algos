package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_6.compress;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_6.compressAll;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_6.compressWithFixes;

import org.junit.jupiter.api.Test;

public class Q1_6 {

  static String compressAll(String s) {
    if (s.length() <= 2) {
      return s;
    }
    // TODO calculate upfront compressedLength
    char curr = s.charAt(0);
    char last = curr;
    int reps = 0;
    StringBuilder compressed = new StringBuilder(s.length());
    // StringBuilder compressed = new StringBuilder(compressedLength);
    compressed.append(curr);
    for (int i = 1; i < s.length(); i++) {
      curr = s.charAt(i);
      if (curr == last) {
        reps++;
      } else {
        compressed.append(reps + 1);
        reps = 0;
        last = curr;
        compressed.append(curr);
      }
    }
    compressed = compressed.append(reps + 1);

    return compressed.length() >= s.length() ? s : compressed.toString();
  }

  static String compressWithFixes(String s) {
    if (s.length() <= 2) {
      return s;
    }
    boolean isShorter = false;
    char last = 0;
    int reps = 0;
    StringBuilder compressed = new StringBuilder();
    s = '$' + s + '^';
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == last) {
        reps++;
        if (reps > 1) {
          isShorter = true;
        }
      } else {
        if (reps != 0) {
          compressed.append(reps + 1);
          reps = 0;
        }
        last = curr;
        compressed.append(curr);
      }
    }
    String result = isShorter ? compressed.toString() : s;
    return result.substring(1, result.length() - 1);
  }

  static String compress(String s) {
    /* for every position in s
     *   if the char is the same as previous one
     *     increase repetition counter
     *     if is > 1 toggle isShorter
     *   else
     *     if not zero,
     *       append the repetition value + 1, and
     *       zero it
     *       append the char
     *  if return the compression if isShorter else the original
     * */
    if (s.length() <= 2) {
      return s;
    }
    boolean isShorter = false;
    char last = 0;
    int reps = 0;
    StringBuilder compressed = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == last) {
        reps++;
        if (reps > 1) {
          isShorter = true;
        }
      } else {
        if (reps != 0) {
          compressed.append(reps + 1);
          reps = 0;
        }
        last = curr;
        compressed.append(curr);
      }
    }
    if (reps != 0) { // can be solved by suffixing the s with dummy character
      compressed.append(reps + 1);
    }
    return isShorter ? compressed.toString() : s;
  }
}

class TestQ1_6 {

  @Test
  void test_compress() {
    assertEquals("", compress(""));
    assertEquals(" ", compress(" "));
    assertEquals("a", compress("a"));
    assertEquals("ba", compress("ba"));
    assertEquals("Aa", compress("Aa"));
    assertEquals("AAaa", compress("AAaa"));
    assertEquals("A3a3", compress("AAAaaa"));
    assertEquals("a3", compress("aaa"));
  }

  @Test
  void test_compressWithFixes() {
    assertEquals("", compressWithFixes(""));
    assertEquals(" ", compressWithFixes(" "));
    assertEquals("a", compressWithFixes("a"));
    assertEquals("ba", compressWithFixes("ba"));
    assertEquals("Aa", compressWithFixes("Aa"));
    assertEquals("AAaa", compressWithFixes("AAaa"));
    assertEquals("A3a3", compressWithFixes("AAAaaa"));
    assertEquals("a3", compressWithFixes("aaa"));
  }

  @Test
  void test_compressAll() {
    assertEquals("", compressAll(""));
    assertEquals(" ", compressAll(" "));
    assertEquals("a", compressAll("a"));
    assertEquals("ba", compressAll("ba"));
    assertEquals("Aa", compressAll("Aa"));
    assertEquals("AAaa", compressAll("AAaa"));
    assertEquals("A3a3", compressAll("AAAaaa"));
    assertEquals("a3", compressAll("aaa"));
  }
}