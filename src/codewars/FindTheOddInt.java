package src.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class FindTheOddInt {
  public static void main(String[] args) {
    // findWithXorToggle(new int[] {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5});
  }

  // TODO REMEMBER bitwise toggle
  public static int findWithStreamXorToggle(int[] input) {
    return Arrays.stream(input)
                 .reduce(0, (r, n) -> r ^ n);
  }

  // TODO REMEMBER bitwise toggle
  public static int findWithXorToggle(int[] input) {
    int toggle = 0;
    for (int n : input) {
      toggle ^= n;
    }
    return toggle;
  }

  // public static int findWithStream(int[] input) {
  //   Map<Integer, Integer> map = Arrays.stream(input)
  //                                          .collect(Collectors.toMap(,0));
  //                                          // .collect(Integer::intValue, Collectors.summingInt());
  //   return 0;
  // }

  public static int findIt(int[] input) {
    // new map of n : 0
    // for each n in numbers
    // in the map, update value v for key n: v++
    // for each key in keyset
    // if value odd
    // return value
    Map<Integer, Integer> count = new HashMap<>();
    for (int n : input) {
      if (!count.containsKey(n)) {
        count.put(n, 1);
      } else {
        count.put(n, count.get(n) + 1);
      }
    }
    for (Entry<Integer, Integer> e : count.entrySet()) {
      if (e.getValue() % 2 != 0) {
        return e.getKey();
      }
    }
    return 0;
  }
}

class FindTheOddIntTest {

  @Test
  public void testFindWithXorToggle() {
    // @formatter:off
    assertEquals(5, FindTheOddInt.findWithXorToggle(new int[] {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
    assertEquals(-1, FindTheOddInt.findWithXorToggle(new int[] {1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
    assertEquals(5, FindTheOddInt.findWithXorToggle(new int[] {20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
    assertEquals(10, FindTheOddInt.findWithXorToggle(new int[] {10}));
    assertEquals(10, FindTheOddInt.findWithXorToggle(new int[] {1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
    assertEquals(1, FindTheOddInt.findWithXorToggle(new int[] {5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    // @formatter:on
  }

  @Test
  public void testFindWithStreamXorToggle() {
    // @formatter:off
    assertEquals(5, FindTheOddInt.findWithStreamXorToggle(new int[] {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
    assertEquals(-1, FindTheOddInt.findWithStreamXorToggle(new int[] {1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
    assertEquals(5,FindTheOddInt.findWithStreamXorToggle(new int[] {20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
    assertEquals(10, FindTheOddInt.findWithStreamXorToggle(new int[] {10}));
    assertEquals(10, FindTheOddInt.findWithStreamXorToggle(new int[] {1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
    assertEquals(1, FindTheOddInt.findWithStreamXorToggle(new int[] {5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    // @formatter:on
  }
}