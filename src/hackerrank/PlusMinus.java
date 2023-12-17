package src.hackerrank;

import java.util.List;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
 */
public class PlusMinus {
    public static void main(String[] args) {
        List<Integer> arr = List.of(-4, 3, -9, 0, 4, 1);
        plusMinus(arr);
    }

    /**
     * TODO PRACTICE System.out.printf/format formatting:
     * The ***format specifiers*** for general, character, and numeric types have the following syntax:
     * `%[argument_index$][flags][width][.precision]conversion`
     * [oracle.com](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/Formatter.html)
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int zero = 0;
        int positive = 0;
        int negative = 0;
        int size = arr.size();
        for (Integer n : arr) {
            if (n > 0) {
                positive++;
            } else if (n < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        // TODO PRACTICE System.out.printf/format formatting:
        // System.err.printf(...) // Writes formatted output to stderr.
        // System.out.format(...) // Writes a formatted string to stdout. (the same as below)

        // 'f'	floating point	The result is formatted as a decimal number
        // '%'	percent	The result is a literal '%' ('\u0025')
        // 'n'	line separator	The result is the platform-specific line separator
        System.out.printf("%4$5.4s\n%1$.9f%%%n%3$+.2a\n%2$f\n",
                          (float) positive / size,
                          (float) zero / size,
                          (float) negative / size,
                          "Result:\n");

        // StringBuilder sb = new StringBuilder();
        // Send all output to the Appendable object sb
        // Formatter formatter = new Formatter(sb, Locale.US);
        // formatter.format()
    }
}