package src.codewars;

import java.util.*;

public class FindUniqueNumber {
  public static void main(String[] args) {
    double[] input = new double[] {1, 1, 2, 1, 1, 1};
    System.out.println(solveWithSolved(input));
    System.out.println(solveElegantly(input));
    System.out.println(solve(input));
  }

  public static double solveElegantly(double[] arr) {
  // TODO PRACTICE good thinking
    final double major = arr[arr[0] == arr[1] ? 0 : 2];
    for (double n : arr) {
      if (n != major) {
        return n;
      }
    }
    return 0;
  }

  public static double solve(double[] input) {
    Map<Double, Boolean> buffer = new HashMap();

    for (int i = 0; i < input.length; i++) {
      double n = input[i];
      if (!buffer.containsKey(n)) {
        buffer.put(n, true);
      } else {
        buffer.put(n, false);
      }
      if (buffer.size() == 2 && i >= 2) {
        for (Map.Entry<Double, Boolean> e : buffer.entrySet()) {
          if (e.getValue()) {
            return e.getKey();
          }
        }
      }
    }
    throw new IllegalArgumentException("No unique number");
  }

  public static double solveWithSolved(double[] arr) {
    // TODO REMEMBER no reassignment!
    Arrays.sort(arr);
    return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
  }
}
