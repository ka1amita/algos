package src.codewars;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidParentheses {
  public static void main(String[] args) {
    // System.out.println(solveWithStream("({(0))"));
    // System.out.println(solve("({(0))"));
    int num = 0;
    boolean res;
    switch (num) {
      case 1:
        res = false;
      default:
        res = true;
    }
  }

  // TODO PRACTICE using stream API
  //   .map(two nested ternary statements) or .map(switch)
  //   .reduce()
  public static boolean solveWithStream(String input) {
    int count = IntStream.range(0, input.length())
                         .map(input::charAt)
                         // .map(c -> c == '(' ? 1 : ( c == ')' ? -1 : 0 ))
                         .map(c -> {
                           int i;
                           switch (c) {
                             case '(':
                               i = 1;
                               break;
                             case ')':
                               i = -1;
                               break;
                             default:
                               i = 0;
                           }
                           return i;
                         })
                         .reduce(0, (result, element) -> {
                           if (result < 0) {
                             // memory of failure: once toggles, can't be restored
                             return result;
                           } else {
                             return result += element;
                           }
                         });
    return count == 0;
  }

  public static boolean solve(String input) {
    assert input.length() <= 100;
    assert !input.isEmpty();

    int count = 0;
    for (char letter : input.toCharArray()) {
      if (letter == '(') {
        count++;
      } else if (letter == ')') {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }

  // "()"              =>  true
  // ")(()))"          =>  false
  // "("               =>  false
  // "(())((()())())"  =>  true

  @Nested
  class TestValidParentheses {
    @Test
      // TODO PRACTICE parsing with shell
      //  `echo $input | awk '{print"assert"$3" "$1}' | sed 's/ "/(solve("/' | sed 's/"$/"));/' | sed 's/true/True/' | sed 's/false/False/'`

    void returnsTheCorrectResultWithAValidInput() {
      assertTrue(solveWithStream("()"));
      assertFalse(solveWithStream(")(()))"));
      assertFalse(solveWithStream("("));
      assertTrue(solveWithStream("(())((()())())"));
    }
  }
}

// TODO PRACTICE write and run test like this (note the missing public modifier)
//   select to `Run SolutionTest` class by clicking the run button on the left
//   contrary the e.g. `My_Algo.main()`
//   `import org.junit.jupiter.api.*;`
//   `import static org.junit.jupiter.api.Assertions.*;`
//   `src.my_package.MyAlgo.solve`
//    or use @Nested annotation of the Test nested class as above
// class SolutionTest {
//   @Test
//   public void sampleTest() {
//     assertTrue(solve("()"));
//     assertFalse(solve("())"));
//     assertTrue(solve("32423(sgsdg)"));
//     assertFalse(solve("(dsgdsg))2432"));
//     assertTrue(solve("adasdasfa"));
//   }
// }
