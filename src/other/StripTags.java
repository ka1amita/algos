package src.other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.other.StripTags.solveWithLoop;
import static src.other.StripTags.solveWithRegex;

import org.junit.jupiter.api.Test;

/**
 * Create a function called stripTags that takes a string as input and removes all HTML tags from it. A HTML tag starts with < and ends with >.
 * You <b>cannot</b> use regular expressions to solve this exercise.
 */
public class StripTags {
  public static String solveWithRegex(String input) {
    return input.replaceAll("(<[^<]*>)", "");
  }

  public static String solveWithLoop(String input) {
    /*
    + remove tags' content including the attributes etc.
    *   for each char c in input
    *     if '<' toggle isInTag to true; else if '>' toggle isInTag to false
    *     if not inside teg
    * append to filtered string
    */
    StringBuilder output = new StringBuilder();
    boolean isTag = false;
    for (char c : input.toCharArray()) {
      if (c == '<') {
        isTag = true;
      } else if (c == '>') {
        isTag = false;
      } else if (!isTag) {
        output.append(c);
      }
    }
    return output.toString();
  }
}

class TestStripTags {
  @Test
  public void testSolveWithLoop() {
    assertEquals("I'm a teapot.", solveWithLoop("<p class=\"lead\">I'm a <i>teapot</i>.</p>"));
    assertEquals("Nothing to strip", solveWithLoop("Nothing to strip"));
  }

  @Test
  public void testSolveWithRegex() {
    assertEquals("I'm a teapot.", solveWithRegex("<p class=\"lead\">I'm a <i>teapot</i>.</p>"));
    assertEquals("Nothing to strip", solveWithRegex("Nothing to strip"));
  }
}
