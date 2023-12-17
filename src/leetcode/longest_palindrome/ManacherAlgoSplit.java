package src.leetcode.longest_palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.leetcode.longest_palindrome.ManacherAlgoSplit.getLongestPalindrome;

import org.junit.jupiter.api.Test;

public class ManacherAlgoSplit {

  public static String getLongestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }
    char[] string = s.toCharArray();
    int length = string.length;

    int longestLeft = 0;
    int longestRight = 0;

    int[] oddRadius = new int[length];
    int[] evenRadius = new int[length];
    // even case
    int rightmostLeft = 0;
    int rightmostRight = -1;
    for (int mid = 0; mid < length; mid++) {
      if (mid < rightmostRight) {
        evenRadius[mid] = Math.min(evenRadius[rightmostLeft + rightmostRight - mid + 1], // - oddity
                                   rightmostRight - mid);
      }
      int left = mid - evenRadius[mid]; // - oddity
      int right = mid + evenRadius[mid] + 1;
      while (left >= 0 && right < length && string[left] == string[right]) {
        evenRadius[mid]++;
        left--;
        right++;
      }
      if (mid + evenRadius[mid] > rightmostRight) {
        rightmostLeft = mid - evenRadius[mid] + 1; // - oddity
        rightmostRight = mid + evenRadius[mid];
      }
      if (2 * evenRadius[mid] > longestRight - longestLeft + 1) { // - oddity
        longestLeft = mid - evenRadius[mid] + 1; // - oddity
        longestRight = mid + evenRadius[mid];
      }
    }
    // odd case
    rightmostLeft = 0;
    rightmostRight = -1;
    for (int mid = 0; mid < length; mid++) {
      if (mid < rightmostRight) {
        oddRadius[mid] = Math.min(oddRadius[rightmostLeft + rightmostRight - mid],
                                  rightmostRight - mid);
      }
      int left = mid - oddRadius[mid] - 1;
      int right = mid + oddRadius[mid] + 1;
      while (left >= 0 && right < length && string[left] == string[right]) {
        oddRadius[mid]++;
        left--;
        right++;
      }
      if (mid + oddRadius[mid] > rightmostRight) {
        rightmostLeft = mid - oddRadius[mid];
        rightmostRight = mid + oddRadius[mid];
      }
      if (2 * oddRadius[mid] > longestRight - longestLeft) {
        longestLeft = mid - oddRadius[mid];
        longestRight = mid + oddRadius[mid];
      }
    }
    return s.substring(longestLeft, longestRight + 1);
  }
}

class TestManacherAlgoSplit {

  @Test
  void testManacherAlgo() {
    assertEquals("", getLongestPalindrome(""));
    assertEquals("a", getLongestPalindrome("a"));
    assertEquals("aa", getLongestPalindrome("aa"));
    assertEquals("ccc", getLongestPalindrome("ccc"));
    assertEquals("bb", getLongestPalindrome("abbc"));
    assertEquals("abba", getLongestPalindrome("abba"));
    assertEquals("a", getLongestPalindrome("abcd"));
    assertEquals("bab", getLongestPalindrome("babad"));
    assertEquals("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123",
        getLongestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"));
  }
}
