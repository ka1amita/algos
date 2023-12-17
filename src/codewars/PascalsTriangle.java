package src.codewars;

import java.util.Arrays;

public class PascalsTriangle {
  public static void main(String[] args) {
    // System.out.println(factorial(0));
    // System.out.println(factorial(1));
    // System.out.println(factorial(2));
    // System.out.println(factorial(3));
    // System.out.println(factorial(52));
    // System.out.println(calcElement(2, 2));

    System.out.println(Arrays.toString(generateRowByRow(10)));
    System.out.println(Arrays.toString(generateWithLookback(10)));
    // System.out.println(Arrays.toString(generateWithRecursion(5)));
    // System.out.println(Arrays.toString(generateWithFactorial(3)));
  }


  public static long[] generateRowByRow(int level) {
    // ref: https://en.wikipedia.org/wiki/Pascal's_triangle : Calculating a row or diagonal by itself
    // only note the (k + 1) that is necessary because of the instance when the expression is executed
    long[] result = new long[( 1 + level ) * level / 2];
    for (int i = 0, n = 0; n < level; n++) {
      for (long r = 1, k = 0; k <= n; r = r * ( n + 1 - ( k + 1 ) ) / ( k + 1 ), k++) {
        result[i++] = r;
      }
    }
    return result;
  }

  public static long[] generateWithLookback(int level) {
    long[] result = new long[( 1 + level ) * level / 2];
    for (int i = 0, n = 0; n < level; n++) {
      for (int k = 0; k <= n; k++) {
        result[i] = ( k == 0 || k == n ) ? 1 : result[i - n - 1] + result[i - n];
        i++;
      }
    }
    return result;
  }

  public static long[] generateWithRecursion(int level) {
    long[] result = new long[( 1 + level ) * level / 2];
    int i = 0;
    for (int n = 0; n < level; n++) {
      for (int k = 0; k <= n; k++) {
        result[i] = calcElement(n, k);
        i++;
      }
    }
    return result;
  }

  public static long calcElement(int n, int k) {
    if (n == 0 && k == 0) {
      return 1;
    } else if (k < 0 || k > n) {
      return 0;
    } else {
      return calcElement(n - 1, k - 1) + calcElement(n - 1, k);
    }
  }


  public static long[] generateWithFactorial(int level) {
    long[] result = new long[( 1 + level ) * level / 2];
    int i = 0;
    for (int n = 0; n < level; n++) {
      for (int k = 0; k <= n; k++) {
        result[i] = factorial(n) / ( factorial(k) * factorial(n - k) );
        i++;
      }
    }
    return result;
  }

  public static long factorial(long n) {
    if (n == 0) {
      return 1;
    } else {
      return n * ( factorial(n - 1) );
    }
  }
}