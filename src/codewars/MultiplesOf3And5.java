package src.codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.codewars.MultiplesOf3And5.solveWithStream;
import static src.codewars.MultiplesOf3And5.solveWithoutLoop;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class MultiplesOf3And5 {

  public static int solveWithoutLoop(int n) {
    int count3 = ( n - 1 ) * 5 / 15;
    int count5 = count3 * 9 / 15;
    int count15 = count3 * 3 / 15;

    return (3 * (1 + count3) * count3 + 5 * (1+ count5) * count5  - 15 * (1 + count15) * count15 ) / 2;
}

  public static int solveWithStream(int n) {
    // TODO PRACTICE
    //  IntStream.range()
    return IntStream.range(3, n)
                    .reduce(0, (r, e) -> ( e % 5 == 0 || e % 3 == 0 ) ? r + e : r);
  }
}

class TestMultiplesOf3And5 {
  @Test
  void testSolveWithStream() {
    assertEquals(14, solveWithStream(9));
    assertEquals(23, solveWithStream(10));
    assertEquals(45, solveWithStream(15));
    assertEquals(60, solveWithStream(16));
  }


  @Test
  void testSolveWithoutLoop() {
    assertEquals(14, solveWithoutLoop(9));
    assertEquals(23, solveWithoutLoop(10));
    assertEquals(45, solveWithoutLoop(15));
    assertEquals(60, solveWithoutLoop(16));
  }
}
