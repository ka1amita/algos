package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_1.hasOnlyUniqueCharsWithBitVector;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_1.hasOnlyUniqueCharsWithHashSet;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_1.sortStringAndCheckForIdenticalNeighboringChars;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class Q1_1 {

  /*
   * RESTRICTION: can't use another datastructures (and alphabet longer than string)
   * Time c.: O(n*log(n)) based on the sorting
   * Space c.: O(?) based on the sorting
   */
  public static boolean sortStringAndCheckForIdenticalNeighboringChars(String s) {
    char[] string = s.toCharArray();
    Arrays.sort(string); // TODO REMEMBER Arrays.sort(char[])
    for (int i = 0; i < string.length - 1; i++) {
      if (string[i] == string[i + 1]) {
        return false;
      }
    }
    return true;
  }

  /*
   * RESTRICTION: can't use another datastructures (and alphabet longer than string)
   * Time c.: * O(string^2)
   * Space c.: O(1) meaning no additional space req.
   */
  public static boolean compareEveryCharacterToEveryOtherCharacter(String string) {
    for (int i = 0; i < string.length() - 1; i++) {
      for (int j = i + 1; j < string.length(); j++) {
        if (string.charAt(i) == string.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

  /*
   * Time c.: O( min(string, alphabet) ) or O(alphabet) since string longer than alphabet is trivial
   * Space c.: O(alphabet)
   */
  public static boolean hasOnlyUniqueCharsWithBitVector(String string) {
    if (string.length() <= 1) {
      return true;
    }
    if (string.length() > 26) { // larger than alphabet
      return false;
    }
    int contains = 0;
    for (char c : string.toCharArray()) {
      int val = c - 'a';
      if ((contains & 1 << val) != 0) {
        return false;
      } else {
        contains |= 1 << val;
      }
    }
    return true;
  }

  public static boolean hasOnlyUniqueCharsWithBooleanArray(String string) {
    if (string.length() <= 1) {
      return true;
    }
    if (string.length() > 26) { // larger than alphabet
      return false;
    }
    boolean[] contained = new boolean[string.length()];
    for (char c : string.toCharArray()) {
      int val = c - 'a'; // assumes only a to z
      if (contained[val]) {
        return false;
      } else {
        contained[val] = true;
      }

    }
    return true;
  }

  public static boolean hasOnlyUniqueCharsWithHashSet(String string) {
    // what are the characters like (alphabet)? is it just an ASCII charset or more?

    /*
     * create an array of size / hash table / hash set of the alphabet  init with 0s
     * for each char in string
     *   if value == 1, return false
     *   if present, put 1
     *  return true
     */
    if (string.length() <= 1) {
      return true;
    }
    if (string.length() > 26) { // larger than alphabet
      return false;
    }
    HashSet<Character> contained = new HashSet<>(); // boolean[] || HashMap
    for (char c : string.toCharArray()) {
      if (!contained.add(c)) {
        return false;
      }
    }
    return true;
  }
}

class TestQ1_1 {

  @Test
  void test_hasOnlyUniqueCharsWithHashSet() {
    assertTrue(hasOnlyUniqueCharsWithHashSet(""));
    assertTrue(hasOnlyUniqueCharsWithHashSet("a"));
    assertTrue(hasOnlyUniqueCharsWithHashSet("ab"));
    assertFalse(hasOnlyUniqueCharsWithHashSet("aa"));
    assertFalse(hasOnlyUniqueCharsWithHashSet("aba"));
    assertFalse(hasOnlyUniqueCharsWithHashSet("aa"));
  }

  @Test
  void test_hasOnlyUniqueCharsWithBitVector() {
    assertTrue(hasOnlyUniqueCharsWithBitVector(""));
    assertTrue(hasOnlyUniqueCharsWithBitVector("a"));
    assertTrue(hasOnlyUniqueCharsWithBitVector("ab"));
    assertFalse(hasOnlyUniqueCharsWithBitVector("aa"));
    assertFalse(hasOnlyUniqueCharsWithBitVector("aba"));
    assertFalse(hasOnlyUniqueCharsWithBitVector("aa"));
  }

  @Test
  void test_sortStringAndCheckForIdenticalNeighboringChars() {
    assertTrue(sortStringAndCheckForIdenticalNeighboringChars(""));
    assertTrue(sortStringAndCheckForIdenticalNeighboringChars("a"));
    assertTrue(sortStringAndCheckForIdenticalNeighboringChars("ab"));
    assertFalse(sortStringAndCheckForIdenticalNeighboringChars("aa"));
    assertFalse(sortStringAndCheckForIdenticalNeighboringChars("aba"));
    assertFalse(sortStringAndCheckForIdenticalNeighboringChars("aa"));
  }
}
