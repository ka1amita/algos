package src.codewars;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class LongestRepetition {
  public static Object[] longestRepetition(String s) {
    // for each character c in string s
    // if c == last c
    // increase count in Map<c,count> counts by 1
    // else or add (c,1)
    // find max value in counts
    // return corr. c
    Object[] result = new Object[] {"", 0};
    char lastCharacter = 0;
    int count = 0;
    for (char character : s.toCharArray()) {
      // equivalent to ternary statement below
      // if (lastCharacter == character) {
      //   count++;
      // } else {
      //   lastCharacter = character;
      //   count = 1;
      // }
      count = lastCharacter == character ? count + 1 : 1;
      if (count > (int) result[1]) {
        result[0] = "" + character;
        result[1] = count;
      }
      lastCharacter = character;
    }
    return result;
  }
}

class LongestRepetitionTest {
  @Test
  public void exampleTests() {
    assertArrayEquals(new Object[] {"a", 4}, LongestRepetition.longestRepetition("aaaabb"));
    assertArrayEquals(new Object[] {"a", 4}, LongestRepetition.longestRepetition("bbbaaabaaaa"));
    assertArrayEquals(new Object[] {"b", 4}, LongestRepetition.longestRepetition("bbbbaaabaaaa"));
    assertArrayEquals(new Object[] {"b", 5}, LongestRepetition.longestRepetition("bbbbbaaabbaaaa"));
    assertArrayEquals(new Object[] {"u", 3}, LongestRepetition.longestRepetition("cbdeuuu900"));
    assertArrayEquals(new Object[] {"b", 5}, LongestRepetition.longestRepetition("abbbbb"));
    assertArrayEquals(new Object[] {"a", 2}, LongestRepetition.longestRepetition("aabb"));
    assertArrayEquals(new Object[] {"", 0}, LongestRepetition.longestRepetition(""));
    assertArrayEquals(new Object[] {"a", 1}, LongestRepetition.longestRepetition("a"));
    assertArrayEquals(new Object[] {"a", 1}, LongestRepetition.longestRepetition("ab"));
  }
}