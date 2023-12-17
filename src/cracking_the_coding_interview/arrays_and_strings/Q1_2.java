package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_2.arePermutationsByCountingCharacters;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_2.arePermutationsBySortingAndComparing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Q1_2 {

  static boolean arePermutationsByCountingCharacters(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int[] count = new int[128]; // whole ASCII
    for (int c : s1.toCharArray()) {
      count[c]++;
    }
    for (int c : s2.toCharArray()) {
      count[c]--;
      if (count[c] < 0) {
        return false;
      }
    }
    // TODO REALISE redundant!
    // int sum = 0;
    // for (int i : count) {
    //   sum += i;
    // }
    // return sum == 0;
    return true;
  }

  static boolean arePermutationsBychreatingHasMaps(String s1, String s2) {
    Map<Integer, List<Integer>> chars1 = s1.chars().boxed().collect(Collectors.groupingBy(e -> e));
    Map<Integer, List<Integer>> chars2 = s2.chars().boxed().collect(Collectors.groupingBy(e -> e));
    return chars1.equals(chars2);
  }

  /*
   * Time c.: depends on sorting, likely O(n*log(n))
   * Space c.: depends on sorting
   */
  static boolean arePermutationsBySortingAndComparing(String s1, String s2) {
    s1 = sortString(s1);
    s2 = sortString(s2);
    return s1.equals(s2);
  }

  private static String sortString(String s1) {
    char[] chars = s1.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}

class TestQ1_2 {

  @Test
  void test_arePermutationsBySorting() {
    assertTrue(arePermutationsBySortingAndComparing("", ""));
    assertTrue(arePermutationsBySortingAndComparing("a", "a"));
    assertTrue(arePermutationsBySortingAndComparing("abc", "acb"));
    assertFalse(arePermutationsBySortingAndComparing("abc", ""));
    assertFalse(arePermutationsBySortingAndComparing("abc", "a"));
    assertFalse(arePermutationsBySortingAndComparing("abc", "aaa"));
  }

  @Test
  void test_arePermutationsByCountingCharacters() {
    assertTrue(arePermutationsByCountingCharacters("", ""));
    assertTrue(arePermutationsByCountingCharacters("a", "a"));
    assertTrue(arePermutationsByCountingCharacters("abc", "acb"));
    assertFalse(arePermutationsByCountingCharacters("abc", ""));
    assertFalse(arePermutationsByCountingCharacters("abc", "a"));
    assertFalse(arePermutationsByCountingCharacters("abc", "aaa"));
  }
}
