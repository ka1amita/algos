package src.codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {
  public static void main(String[] args) {
    String a[] = new String[] {"arp", "live", "strong"};
    String b[] = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};

    System.out.println(Arrays.toString(solveWithStreams(a, b)));
    System.out.println(Arrays.toString(solveWithForLoopsAndSet(a, b)));
  }

  public static String[] solveWithStreams(String[] words, String[] superwords) {
    // words
    // filter'em
    // by any match in superwords
    // of kind superword contains word
    // sort
    // to array
    // TODO PRACTICE stream API; especially the pseudo code
    // e.g. use of filter any match, for each, find, map
    return Arrays.stream(words)
                 .distinct()
                 .filter(word -> Arrays.stream(superwords)
                                       .anyMatch(superword -> superword.contains(word)))
                 .sorted()
                 .toArray(String[]::new);
  }


  public static String[] solveWithForLoopsAndSet(String[] words, String[] superwords) {
    // for each word in words
    // check if is a substring of words in superwords
    // add it to Set<String> s
    // sort s to array
    // TODO PRACTICE I forgot the <String> in the Set definition
    Set<String> filtered = new HashSet<>();
    for (String word : words) {
      for (String superword : superwords) {
        if (superword.contains(word)) {
          filtered.add(word);
          break;
        }
      }
    }
    return filtered.stream()
                   .sorted()
                   .toArray(String[]::new);
  }
}
