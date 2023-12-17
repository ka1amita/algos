package src.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Complete the 'timeConversion' function below.
 * <p>
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
public class TimeConversion {
    public static void main(String[] args) {
        String input = "01:00:00PM";

        System.out.println(solveByIfPartAndIf12(input));
        System.out.println(solveBySimpleDateFormat(input));
    }

    /**
     * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/text/SimpleDateFormat.html
     */
    public static String solveBySimpleDateFormat(String input) {
      // TODO PRACTICE the use of SimpleDateFormat .parse() and .format()
      // Number:
      //   For formatting, the number of pattern letters is the minimum number of digits, and shorter numbers are zero-padded to this amount.
      //   For parsing, the number of pattern letters is ignored unless it'input needed to separate two adjacent fields.
      SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssaa");
      SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
      Date date;
      try {
        date = inputFormat.parse(input);
      } catch (ParseException e) {
        throw new RuntimeException(e);
      }
      return outputFormat.format(date);
    }

    public static String solveByIfPartAndIf12(String s) {
        String seconds = s.substring(6, 8);
        String minutes = s.substring(3, 5);
        Integer hours = Integer.valueOf(s.substring(0, 2));
        String part = s.substring(8, 10);
        if (part.equals("PM") && hours != 12) {
            hours += 12;
        }
        if (part.equals("AM") && hours == 12) {
            hours -= 12;
        }
        return ( hours < 10 ? "0" + hours : hours ) + ":" + minutes + ":" + seconds;
    }
}
