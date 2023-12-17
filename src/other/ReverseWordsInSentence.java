package src.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class ReverseWordsInSentence {
  public static void main(String[] args) {

    String ecnetnes = "lleW ,enod taht saw ton taht .drah ?eeS";
    System.out.println(reverseWordsBuffer(ecnetnes));
  }

  public static String reverseWordsWithRegex(String ecnetnes) {
    return Pattern.compile("(?<drow>\\S+)")
                  .matcher(ecnetnes)
                  .replaceAll(match -> new StringBuilder(match.group()).reverse()
                                                                       .toString());
  }

  public static String reverseWordsWithReplaceAllCapturingGroup(String ecnetnes) {
    return ecnetnes.replaceAll("(\\S?)(\\S?)(\\S?)(\\S?)(\\S?)(\\S?)", "$6$5$4$3$2$1");
  }

  public static String reverseWordsBuffer(String ecnetnes) {
    List<String> sdrow = List.of(ecnetnes.split(" "));
    List<String> words = new ArrayList<>();
    for (String drow : sdrow) {
      words.add(new StringBuffer(drow).reverse()
                                      .toString());
    }
    return String.join(" ", words);
  }

  public static String reverseWordesManual(String ecnetnes) {
    List<Integer> spaceIndexes = new ArrayList<>();
    // spaceIndexes.add(-1);
    for (int i = 0; i < ecnetnes.length(); i++) {
      if (ecnetnes.charAt(i) == ' ') {
        spaceIndexes.add(i);
      }
    }
    // spaceIndexes.add(ecnetnes.length());

    String drow = ecnetnes.substring(0, spaceIndexes.get(0));
    String word = "";

    for (int j = drow.length() - 1; j >= 0; j--) {
      word += drow.charAt(j);
    }
    String sentence = word;
    for (int i = 0; i < spaceIndexes.size() - 1; i++) {
      // for (int spaceIndex : spaceIndexes) {
      drow = ecnetnes.substring(spaceIndexes.get(i) + 1, spaceIndexes.get(i + 1));
      word = "";

      for (int j = drow.length() - 1; j >= 0; j--) {
        word += drow.charAt(j);
      }
      sentence += " " + word;
    }

    drow = ecnetnes.substring(spaceIndexes.get(spaceIndexes.size() - 1) + 1, ecnetnes.length());
    word = "";
    for (int j = drow.length() - 1; j >= 0; j--) {
      word += drow.charAt(j);
    }
    sentence += " " + word;

    return sentence;
  }
}

class TestReverseWordsInSentence {
  @Test
  void testReverseWordsWithRegex() {
    assertEquals("Well done, that was not that hard. See?",
                 ReverseWordsInSentence.reverseWordsWithRegex(
                     "lleW ,enod taht saw ton taht .drah ?eeS"));
  }

  @Test
  void testReverseWordsBuffer() {
    assertEquals("Well done, that was not that hard. See?",
                 ReverseWordsInSentence.reverseWordsBuffer(
                     "lleW ,enod taht saw ton taht .drah ?eeS"));
  }

  @Test
  void testReverseWordesManual() {
    assertEquals("Well done, that was not that hard. See?",
                 ReverseWordsInSentence.reverseWordesManual(
                     "lleW ,enod taht saw ton taht .drah ?eeS"));
  }

  @Test
  void testReverseWordsWithReplaceAllCapturingGroup() {
    assertEquals("Well done, that was not that hard. See?",
                 ReverseWordsInSentence.reverseWordsWithReplaceAllCapturingGroup(
                     "lleW ,enod taht saw ton taht .drah ?eeS"));
  }
}

