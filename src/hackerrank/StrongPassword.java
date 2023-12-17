package src.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class StrongPassword {

  public static void main(String[] args) {
    String input = "A98#+";
    System.out.println(solveWithDynamicListOfRequirements(input));
    System.out.println(solveWithLoop(input));
    System.out.println(solveWithStringMatchesRegex(input));
  }

  public static int solveWithDynamicListOfRequirements(String password) {
    int minLength = 6;
    List<String> requirements = new ArrayList<>();
    requirements.add("0123456789");
    requirements.add("abcdefghijklmnopqrstuvwxyz");
    requirements.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    requirements.add("!@#$%^&*()-+");
    for (char c : password.toCharArray()) {
      int i = 0;
      while (i < requirements.size()) {
        if (requirements.get(i)
                        .contains(c + "")) {
          requirements.remove(i);
        } else {
          i++;
        }
      }
      if (requirements.isEmpty()) {
        break;
      }
    }
    return Math.max(requirements.size(), minLength - password.length());
  }

  public static int solveWithLoop(String password) {
    String specialChar = "!@#$%^&*()-+";
    int totalRequirements = 4;
    int minLength = 6;
    int satisfied = 0;
    int missing = Integer.MAX_VALUE;
    for (char c : password.toCharArray()) {
      if (( satisfied & 1 ) == 0 && c > '0' &&
          c < '9') { // TODO PRACTICE bitwise AND coupled with `== 0` or `!=0`
        satisfied |=
            1; // TODO PRACTICE bitwise OR `|`, AND `&`, XOR `^`, and with assignment `|=`, `&=`, `^=`
      }
      if (( satisfied & 2 ) == 0 && c >= 'a' && c <= 'z') {
        satisfied |= 2;
      }
      if (( ( satisfied & 4 ) == 0 ) && ( c >= 'A' ) && ( c <= 'Z' )) {
        satisfied |= 4;
      }
      if (( satisfied & 8 ) == 0 && specialChar.contains("" + c)) {
        satisfied |= 8;
      }
      missing = totalRequirements - Integer.bitCount(satisfied); // TODO PRACTICE Integer.bitCount()
      if (missing == 0) {
        break;
      }
    }
    return Math.max(missing, minLength - password.length());
  }

  public static int solveWithStringMatchesRegex(String password) {
    String numbers = "0123456789";
    String lower_case = "abcdefghijklmnopqrstuvwxyz";
    String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String special_characters = "!@#$%^&*()\\-+"; // escape is necessary for regex!
    String prefix = ".*[";
    String suffix = "].*";

    int missing = 0;
    if (!password.matches(prefix + numbers + suffix)) {
      missing++;
    }
    if (!password.matches(prefix + lower_case + suffix)) {
      missing++;
    }
    if (!password.matches(prefix + upper_case + suffix)) {
      missing++;
    }
    if (!password.matches(prefix + special_characters + suffix)) {
      missing++;
    }
    return ( password.length() + missing >= 6 ) ? missing : ( 6 - password.length() );
  }
}
