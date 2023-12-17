package src.codewars;

import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {
  public static void main(String[] args) {
    System.out.println(withStream("man i need a taxi up to ubud"));
    System.out.println(high("man i need a taxi up to ubud"));

  }
  // best practice


  // clever
  // TODO PRACTICE stream without helping from IDE!
  // TODO PRACTICE imports (use `.*`)
  public static String withStream(String sentence) {
    return
        Arrays.stream(sentence.split(" "))
              .max(Comparator.comparingInt(word -> word.chars()
                                                       .map(letter -> letter - 'a' + 1)
                                                       .sum()))
              .orElse("");
  }

  public static String high(String sentence) {
    String[] words = sentence.split(" ");
    int maxScore = 0;
    String highestScoring = "";
    for (String word : words) {
      int score = 0;
      for (char letter : word.toCharArray()) {
        score += letter - 'a' + 1;
      }
      if (score > maxScore) {
        maxScore = score;
        highestScoring = word;
      }
      // System.out.println(word + " " + score);
    }
    return highestScoring;
  }
}
