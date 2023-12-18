package src.cracking_the_coding_interview.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static src.cracking_the_coding_interview.arrays_and_strings.Q1_7.rotate90;

import org.junit.jupiter.api.Test;

public class Q1_7 {

  static int[][] rotate90(int[][] input) {
    if (input == null || input.length == 0 || input.length != input[0].length) {
      return null;
    }
    int temp;
    int size = input.length;
    for (int row = 0; row <= size / 2; row++) {
      for (int col = 0; col < size / 2; col++) {
        int r = row;
        int c = col;
        temp = input[r][c];
        for (int i = 0; i < 3; i++) {
          int nextR = size - 1 - c;
          int nextC = r;
          input[r][c] = input[nextR][nextC];
          // t = c no longer necessary
          r = nextR;
          c = nextC;
        }
        input[r][c] = temp;
      }
    }
    return input;
  }
}

class TestQ1_7 {

  @Test
  void test_empty() {
    int[][] input = new int[0][0];
    int[][] output = new int[0][0];
    assertArrayEquals(output, rotate90(input));
  }

  @Test
  void test_not_square() {
    int[][] input = new int[1][2];
    assertArrayEquals(null, rotate90(input));
  }

  @Test
  void test_not_square_and_zero_times_nonzero() {
    int[][] input = new int[0][2];
    assertArrayEquals(null, rotate90(input));
  }

  @Test
  void test_not_square_and_nonzero_times_zero() {
    int[][] input = new int[2][0];
    assertArrayEquals(null, rotate90(input));
  }

  @Test
  void test_size_one() {
    int[][] input = new int[1][1];
    int[][] output = new int[1][1];
    assertArrayEquals(output, rotate90(input));
  }

  @Test
  void test_sanity() {
    int[][] input = new int[][] {
        {1, 1},
        {1, 1}
    };
    int[][] output = new int[][] {
        {1, 1},
        {1, 1}
    };
    assertArrayEquals(output, rotate90(input));
  }

  @Test
  void test_rotation() {
    int[][] input = new int[][] {
        {1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}
    };
    int[][] output = new int[][] {
        {1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}
    };
    assertArrayEquals(output, rotate90(input));
  }

  @Test
  void test_complex_rotation() {
    int[][] input = new int[][] {
        {1, 0, 8},
        {2, 7, 6},
        {3, 4, 5}
    };
    int[][] output = new int[][] {
        {3, 2, 1},
        {4, 7, 0},
        {5, 6, 8}
    };
    assertArrayEquals(output, rotate90(input));
  }
}