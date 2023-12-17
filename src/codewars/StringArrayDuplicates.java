package src.codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringArrayDuplicates {
  public static void main(String[] args) {
    String[] arr = new String[] {"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"};

    System.out.println(Arrays.toString(solveSimpleWithStream(arr)));
    System.out.println(Arrays.toString(solveSimpleWithForLoop(arr)));
    System.out.println(Arrays.toString(solveWithStringBuilder(arr)));
    System.out.println(Arrays.toString(solveWithStringBuilderWhileLoop(arr)));
    System.out.println(Arrays.toString(solveWithForLoops(arr)));
    // System.out.println(solve(arr));
  }

  public static String[] solveSimpleWithStream(String[] input) {
    // TODO PRACTICE streams `.toArray()`
    return Arrays.stream(input)
                 .map(word -> word.replaceAll("(\\w)\\1+", "$1"))
                 .toArray(String[]::new);
  }

  public static String[] solveSimpleWithForLoop(String[] input) {
    String[] arr = input.clone();
    for (int i = 0; i < arr.length; i++) {
      // TODO PRACTICE the use of capturing group reference: `"$1"`
      arr[i] = arr[i].replaceAll("(\\w)\\1+", "$1");
    }
    return arr;
  }

  public static String[] solveWithStringBuilder(String[] arr) {
    String[] output = new String[arr.length];
    for (int i = 0; i < output.length; i++) {
      // TODO PRACTICE there replacements using both named and not named groups reference
      // output[i] = matcher.replaceAll(matchResult -> matchResult.group("duplicate"));
      output[i] = Pattern.compile("(?<duplicate>\\w)\\1+")
                         .matcher(arr[i])
                         .replaceAll(matchResult -> matchResult.group(1));
    }
    return output;
  }

  public static String[] solveWithStringBuilderWhileLoop(String[] arr) {
    String[] output = arr.clone();
    for (int i = 0; i < output.length; i++) {
      Pattern patter = Pattern.compile("(?<duplicate>\\w)\\1+");
      Matcher matcher = patter.matcher(output[i]);
      // TODO COMPARE more cumbersome
      while (matcher.find()) {
        output[i] = output[i].replaceFirst("(\\w)\\1+", matcher.group()
                                                               .charAt(0) + "");
      }
    }
    return output;
  }

  public static String[] solveWithForLoops(String[] arr) {
    String[] output = arr.clone();
    for (int w = 0; w < output.length; w++) {
      String wwoorrdd = output[w];
      String word = "" + wwoorrdd.charAt(0);
      for (int c = 1; c < wwoorrdd.length(); c++) {
        char letter = wwoorrdd.charAt(c);
        if (letter != word.charAt(word.length() - 1)) {
          word += "" + letter;
        }
      }
      output[w] = word;
    }
    return output;
  }

  public static String[] solve(String[] arr) {
    // for each word w in arr
    for (int j = 0; j < arr.length; j++) {
      // for each letter arr[i] but the last in w
      String wwoorrdd = arr[j];
      String word = "";
      if (wwoorrdd.charAt(0) != wwoorrdd.charAt(1)) {
        word += wwoorrdd.charAt(0);
      }
      for (int i = 1; i < wwoorrdd.length() - 1; i++) {
        if (wwoorrdd.charAt(i) != wwoorrdd.charAt(i - 1) &&
            wwoorrdd.charAt(i) != wwoorrdd.charAt(i + 1)) {
          word += wwoorrdd.charAt(i);
        }
      }
      if (wwoorrdd.charAt(wwoorrdd.length() - 1) != wwoorrdd.charAt(wwoorrdd.length() - 2)) {
        word += wwoorrdd.charAt(wwoorrdd.length() - 1);
      }
      arr[j] = word;
    }
    return arr;
  }
}