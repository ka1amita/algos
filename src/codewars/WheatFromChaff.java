package src.codewars;

import java.util.Arrays;

public class WheatFromChaff {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(
        solveClever(new long[] {-15, -45, -23, -2, -35, -37, -24, -13, -19, -6, -26, -11, -34})));
  }

  public static long[] solveClever(long[] values) {
    values = Arrays.copyOf(values, values.length);
    for (int l = 0, r = values.length - 1; l < r; l++) {
      while (values[l] > 0 && l < r) { // 1st condition is for entering and the 2nd is for leaving the loop!
        if (values[r] < 0) {
          long tmp = values[l];
          values[l] = values[r];
          values[r] = tmp;
        }
        r--;
      }
    }
    return values;
  }

  public static long[] solveAgain(long[] values) {
    long[] result = values.clone();
    int i = 0;
    int j = values.length - 1;
    while (true) {
      while (result[i] < 0) {
        i++;
        if (j <= i) {
          return result;
        }
      }
      while (result[j] > 0) {
        j--;
        if (j <= i) {
          return result;
        }
      }
      long tmp = result[i];
      result[i] = result[j];
      result[j] = tmp;
    }
  }

  public static long[] wheatFromChaff(long[] values) {
    long[] result = values.clone();
    int i = 0;
    int j = values.length - 1;

    while (i < j) {
      if (result[i] > 0) {
        while (result[j] > 0) {
          if (j <= i) {
            return result;
          }
          j--;
        }
        long tmp = result[i];
        result[i] = result[j];
        result[j] = tmp;
      }
      i++;
    }
    return result;
  }
}
