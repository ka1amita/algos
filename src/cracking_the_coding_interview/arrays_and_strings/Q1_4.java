package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_4.isPermutationOfPalindrome;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_4.isPermutationOfPalindromeRefactored;

import org.junit.jupiter.api.Test;

public class Q1_4 {

  /* BPR: O(string) - read every letter in string
   * Time c.: O(string) - one iteration over string + one iteration over alphabet
   * Space c.: O(alphabet)
   * */
  static boolean isPermutationOfPalindrome(String s) {
    /* because of symmetry
     * even-length palindrome has only even-count (that includes zero) characters
     * odd-length palindrome has exactly one odd-count character
     *
     * init oddityOfChars array / hash table / bit vector
     * for each (letter character) c in s
     *   change oddity
     * compare total number of odd chars against length of s
     *  return number of odd (or ?cardinality? of bit vector)== s.length() % 2;
     */
    int oddityOfChars = 0;
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        int val = Character.toLowerCase(c)-'a';
        oddityOfChars ^= 1 << val;
      }
    }
    // return Integer.bitCount(oddityOfChars) == letterCount % 2; TODO REALISE redundant
    return Integer.bitCount(oddityOfChars) <= 1;
  }

  // TODO REMEMBER use `phrase` as a good name for a String input like this (recall `passphrase`)
  static boolean isPermutationOfPalindromeRefactored(String phrase) {
    int oddityOfChars = getOddityOfChars(phrase);
    return countOddChars(oddityOfChars) <= 1;
  }

  private static int countOddChars(int oddityOfChars) {
//    return Integer.bitCount(oddityOfChars);
    return oddityOfChars & oddityOfChars - 1; // hack from the book
  }

  private static int getOddityOfChars(String s) {
    int oddityOfChars = 0;
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        int val = Character.toLowerCase(c) - 'a';
        oddityOfChars = toggle(oddityOfChars, val);
      }
    }
    return oddityOfChars;
  }

  private static int toggle(int oddityOfChars, int val) {
    int mask = 1 << val;
    oddityOfChars ^= mask;
    return oddityOfChars;
  }

}

class TestQ1_4 {

  @Test
  void test_isPermutationOfPalindrome() {
    assertTrue(isPermutationOfPalindrome(""));
    assertTrue(isPermutationOfPalindrome(" "));
    assertTrue(isPermutationOfPalindrome("a"));
    assertTrue(isPermutationOfPalindrome("a "));
    assertTrue(isPermutationOfPalindrome("aa"));
    assertTrue(isPermutationOfPalindrome("aaa"));
    assertTrue(isPermutationOfPalindrome("Aa"));
    assertTrue(isPermutationOfPalindrome("A a"));
    assertTrue(isPermutationOfPalindrome("bA a"));
    assertTrue(isPermutationOfPalindrome("bA aBC"));
    assertFalse(isPermutationOfPalindrome("ba"));
    assertFalse(isPermutationOfPalindrome("bAc a"));
  }

  @Test
  void test_isPermutationOfPalindromeRefactored() {
    assertTrue(isPermutationOfPalindromeRefactored(""));
    assertTrue(isPermutationOfPalindromeRefactored(" "));
    assertTrue(isPermutationOfPalindromeRefactored("a"));
    assertTrue(isPermutationOfPalindromeRefactored("a "));
    assertTrue(isPermutationOfPalindromeRefactored("aa"));
    assertTrue(isPermutationOfPalindromeRefactored("aaa"));
    assertTrue(isPermutationOfPalindromeRefactored("Aa"));
    assertTrue(isPermutationOfPalindromeRefactored("A a"));
    assertTrue(isPermutationOfPalindromeRefactored("bA a"));
    assertTrue(isPermutationOfPalindromeRefactored("bA aBC"));
    assertFalse(isPermutationOfPalindromeRefactored("ba"));
    assertFalse(isPermutationOfPalindromeRefactored("bAc a"));
  }
}