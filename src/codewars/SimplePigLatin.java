package src.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.codewars.SimplePigLatin.solveWithForLoop;
import static src.codewars.SimplePigLatin.solveWithRegex;
import static src.codewars.SimplePigLatin.solveWithStream;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SimplePigLatin {

  // TODO PRACTICE
  //  String.replaceAll(regex,group_reference)
  public static String solveWithRegex(String input) {
    return input.replaceAll("(\\w)(\\w*)", "$2$1ay");
    // ~~`return input.replaceAll("\\b(\\w)(\\w*)\\b", "$2$1ay");`~~ // `\b` are not necessary since the regex always matches the whole (longest) out of all options
    // return input.replaceAll("(\\w)(\\w*)","$2"+"$1"+"ay"); // seems equivalent to above
  }

  // Not a valid solution because of some edge cases!
  public static String solveWithStream(String input) {
    return Arrays.stream(input.split(" "))
                 .map(
                     word -> word.matches("\\w+") ? word.substring(1) + word.charAt(0) + "ay" :
                             word)
                 .reduce("", (r, e) -> r.isEmpty() ? e : r + " " + e);
    // .reduce("", (r, e) -> r + " " + e);
    // .reduce("", (r,e) -> r + " " + e ).substring(1);
  }

  // Not a valid solution because of some edge cases!
  public static String solveWithForLoop(String input) {
    // split sentce into words on " "
    // for each word w in words
    // if word matches "\\w+" ???
    // repalce with new word nw: nw = w.substring(1, w.lengthh) + w.charAt(0) + "ay"
    // join words into resulting sentence r
    // return r
    String[] words = input.split(" ");
    String[] result = new String[words.length];
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      result[i] =
          words[i].matches("\\w+") ? word.substring(1) + word.charAt(0) + "ay" :
          word;
    }

    return String.join(" ", result);
  }
}

class PigLatinTests {
  @Test
  public void testWithForLoop() {
    assertEquals("igPay atinlay siay oolcay", solveWithForLoop("Pig latin is cool"));
    assertEquals("hisTay siay ymay tringsay", solveWithForLoop("This is my string"));
    assertEquals("elloHay orldway !", solveWithForLoop("Hello world !"));
    // assertEquals("elloHay orldway!", solveWithForLoop("Hello world!"));
  }

  @Test
  public void testWithStream() {
    assertEquals("igPay atinlay siay oolcay", solveWithStream("Pig latin is cool"));
    assertEquals("hisTay siay ymay tringsay", solveWithStream("This is my string"));
    assertEquals("elloHay orldway !", solveWithStream("Hello world !"));
    // assertEquals("elloHay orldway!", solveWithStream("Hello world!"));
  }

  @Test
  public void testWithRegex() {
    assertEquals("igPay atinlay siay oolcay", solveWithRegex("Pig latin is cool"));
    assertEquals("hisTay siay ymay tringsay", solveWithRegex("This is my string"));
    assertEquals("elloHay orldway !", solveWithRegex("Hello world !"));
    assertEquals("elloHay orldway!", solveWithRegex("Hello world!"));
  }
}