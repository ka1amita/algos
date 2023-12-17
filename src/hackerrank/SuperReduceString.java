package src.hackerrank;

public class SuperReduceString {
  public static void main(String[] args) {
    System.out.println(solveWithSingleWhileLoop("aaabccddd"));
    System.out.println(solveWithRegex("aaabccddd"));
    System.out.println(solveWithOuterLoop("aaabccddd"));
    System.out.println(solveWithStringBuilderWhileLengthChangesRefactored("aaabccddd"));
    System.out.println(solveWithStringBuilderWhileLengthChanges("aaabccddd"));
  }

  public static String solveWithSingleWhileLoop(String input) {
    // TODO PRACTICE this particular solution is the best (single loop)!
    int i = 0;
    while (i < input.length() - 1) {
      if (input.charAt(i) == input.charAt(i + 1)) {
        input = input.substring(0, i) + input.substring(i + 2, input.length());
        i = 0;
      } else {
        i++;
      }
    }
    return input.isEmpty() ? "Empty String" : input;
  }

  public static String solveWithRegex(String input) {
    int length = 0;
    while (length != input.length()) {
      length = input.length();
        input = input.replaceAll("(\\w)\\1", "");
      }
    return input.isEmpty() ? "Empty String" : input;
  }

  public static String solveWithOuterLoop(String input) {
    // TODO PRACTICE labels: https://stackoverflow.com/questions/27696712/java-label-outer-middle-inner
    outer:
    while (true) {
      for (int x = 0; x < input.length() - 1; x++) {
        if (input.charAt(x) == input.charAt(x + 1)) {
          input = input.replaceAll("(\\w)\\1", "");
          // input = input.substring(0, x) + input.substring(x + 2, input.length());
          continue outer;
        }
      }
      break;
    }
    return input.isEmpty() ? "Empty String" : input;
  }

  public static String solveWithStringBuilderWhileLengthChangesRefactored(String s) {
    // while length changes
    StringBuilder builder = new StringBuilder(s);
    int length = 0;
    do {
      length = builder.length();
      // For each except last char (pair) in stringBuilder
      for (int i = 0; i < length - 1; i++) {
        // if equal with the next char
        if (builder.charAt(i) == builder.charAt(i + 1)) {
          // remove the pair
          builder.delete(i, i + 2);
          // break!
          break;
        }
      }
    } while (length != builder.length());
    return !builder.isEmpty() ? builder.toString() : "Empty String";
  }


  // TODO PRACTICE string builder methods like:
  //  `delete(int start, int end)` ,
  //  `deleteCharAt(int index)`,
  //  `append(*)`,
  //  `replace(int start, int end, String str)`,
  //  `insert(int offset, String str)`
  //  `reverse()`
  //   ...
  public static String solveWithStringBuilderWhileLengthChanges(String s) {
    StringBuilder builder = new StringBuilder(s);
    int length = -1;
    outer:
    while (length != builder.length()) {
      // System.out.println(builder);
      length = builder.length();
      for (int i = 0; i < length - 1; i++) {
        if (builder.charAt(i) == builder.charAt(i + 1)) {
          // System.out.println(builder.replace(i, i + 2, "  "));
          builder.delete(i, i + 2);
          break;
        }
      }
    }
    return !builder.isEmpty() ? builder.toString() : "Empty String";
  }
}
