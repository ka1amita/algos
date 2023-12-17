package src.other;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.other.DotFollowedBySpaceAndCapitalLetter.solveWithRegex;

import org.junit.jupiter.api.*;

/**
 * Create a function that receives a string(text) and checks whether . is followed by an empty space and a capital letter.
 * You cannot use LINQ/Streams or similar functions that would solve this with single command.
 */
public class DotFollowedBySpaceAndCapitalLetter {

  public static boolean solveWithRegex(String text) {
    return !text.matches(".*\\. [a-z].*");
  }
}

class TestDotFollowedBySpaceAndCapitalLetter {
  @Test
  void testSolveWithRegex() {
    assertTrue(solveWithRegex("This is a good example. This is a good example."));
    assertTrue(solveWithRegex("this is still a good example. Second sentence starts with capital letter."));
    assertFalse(solveWithRegex("This is a bad example. no capital letter here."));
    assertFalse(solveWithRegex("This is a bad example. capital letter here. But no capital letter here!"));
  }
}
