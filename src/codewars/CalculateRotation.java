package src.codewars;

public class CalculateRotation {
  public static void main(String[] args) {
    System.out.println(shiftedClever("coff","coffee"));
    System.out.println(shiftedClever("coffee","coffee"));
    System.out.println(shiftedClever("hoop","pooh"));
    System.out.println(shiftedClever("coffee","eecoff"));
    System.out.println(shiftedClever("eecoff","coffee"));
    // System.out.println(shiftedDiff("coffee","eecoff"));
  }
  static int shiftedClever(String first, String second) {
    // TODO PRACTICE clever solution;
    return second.length() == first.length() ? (second + second).indexOf(first) : -1;
  }
  static int shiftedDiff(String first, String second) {
    if (first.equals(second)) {
      return 0;
    } else {
      for (int i = 1; i < first.length(); i++) {
        String shifted = first.substring(first.length() - i, first.length()) +
                         first.substring(0, first.length() - i);
        if (shifted.equals(second)) {
          return i;
        }
      }
      return -1;
    }
  }
}