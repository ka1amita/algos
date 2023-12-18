package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_5.isOneEditAwayWithHashTable;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_5.isOneEditAwayWithSinglePass;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_5.isOneEditAwayWithSinglePassCombined;

import org.junit.jupiter.api.Test;

public class Q1_5 {

  static boolean isOneEditAwayWithSinglePassCombined(String s1, String s2) {
    if (s2.length() > s1.length()) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    if (s1.length() - s2.length() > 1) {
      return false;
    }

    int i1 = 0;
    int i2 = 0;
    boolean diff = false;
    while (i1 < s1.length()) {
      if (s1.charAt(i1++) != s2.charAt(i2++)) {
        if (diff) {
          return false;
        }
        diff = true;
        i2 -= s1.length() - s2.length(); // if lengths differ, compare to the char from s2 again
      }
    }
    return true;
  }


  static boolean isOneEditAwayWithSinglePass(String s1, String s2) {
    /* if the same length
     *    diff = 0
     *    for each char in s1 compare to char s2 at the same position
     *      if differs,
     *        if diff = 1, then return false
     *        diff++
     *
     * if s1 length > s2 length
     *    for each char in s1 compare to s2 at the same position
     *      if differs
     *        if diff = 1, then return false
     *        diff++
     *        try the next in s1 but the same in s2!
     *
     * else swap s1 and s2
     */

    if (s1.length() == s2.length()) {
      return isMaxOneCharReplaced(s1, s2);
    } else if (s1.length() - s2.length() == 1) {
      return isMaxOneCharShifted(s1, s2);
    } else if (s2.length() - s1.length() == 1) {
      return isMaxOneCharShifted(s2, s1);
    } else {
      return false;
    }
  }

  private static boolean isMaxOneCharShifted(String s1, String s2) {
    assert s2.length() != s1.length();
    if (s2.length() > s1.length()) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    int i1 = 0;
    int i2 = 0;
    boolean diff = false;
    while (i1 < s1.length()) {
      if (s1.charAt(i1) != s2.charAt(i2)) {
        if (diff) {
          return false;
        }
        diff = true;
        i1++;
      } else {
        i1++;
        i2++;
      }
    }
    return true;
  }

  private static boolean isMaxOneCharReplaced(String s1, String s2) {
    int i1 = 0;
    int i2 = 0;
    boolean diff = false;
    while (i1 < s1.length()) {
      if (s1.charAt(i1) != s2.charAt(i2)) {
        if (diff) {
          return false;
        }
        diff = true;
      }
      i1++;
      i2++;
    }
    return true;
  }

  static boolean isOneEditAwayWithHashTable(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1) {
      return false;
    }
    int[] counts = new int[26];
    for (char c : s1.toCharArray()) {
      int val = c - 'a';
      counts[val]++;
    }
    for (char c : s2.toCharArray()) {
      int val = c - 'a';
      counts[val]--;
    }
    int differences = 0;
    for (int count : counts) {
      differences += Math.abs(count);
    }
    return differences <= 2;
  }
}

class TestQ1_5 {

  @Test
  void test_isOneEditAwayWithHashTable() {
    assertTrue(isOneEditAwayWithHashTable("pale", "ple"));
    assertTrue(isOneEditAwayWithHashTable("pale", "pale"));
    assertTrue(isOneEditAwayWithHashTable("pale", "bale"));
    assertFalse(isOneEditAwayWithHashTable("pale", "bake"));
    assertFalse(isOneEditAwayWithHashTable("pale", "palepale"));
  }

  @Test
  void test_isOneEditAwayWithSinglePassCombined() {
    assertTrue(isOneEditAwayWithSinglePassCombined("pale", "ple"));
    assertTrue(isOneEditAwayWithSinglePassCombined("pale", "pale"));
    assertTrue(isOneEditAwayWithSinglePassCombined("pale", "bale"));
    assertFalse(isOneEditAwayWithSinglePassCombined("pale", "bake"));
    assertFalse(isOneEditAwayWithSinglePassCombined("pale", "palepale"));
  }

  @Test
  void test_isOneEditAwayWithSinglePass() {
    assertTrue(isOneEditAwayWithSinglePass("pale", "ple"));
    assertTrue(isOneEditAwayWithSinglePass("pale", "pale"));
    assertTrue(isOneEditAwayWithSinglePass("pale", "bale"));
    assertFalse(isOneEditAwayWithSinglePass("pale", "bake"));
    assertFalse(isOneEditAwayWithSinglePass("pale", "palepale"));
  }
}
