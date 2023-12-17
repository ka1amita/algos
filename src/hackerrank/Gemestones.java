package src.hackerrank;

import static java.lang.Integer.MIN_VALUE;

import java.util.List;

public class Gemestones {
  public static void main(String[] args) {
    List<String> rocks = List.of("aaabgzg", "baggz", "bgagz", "gabg");
    System.out.println(solveWithBitwiseComparisonsRefactored(rocks));
    System.out.println(solveWithArrayLoop(rocks));
    System.out.println(solveWithBitwiseComparisons(rocks));
    // BitSet bitSet = new BitSet(26);
    // System.out.println(bitSet);
    // System.out.println(bitSet.cardinality());
    // bitSet.flip(0, 26);
    // System.out.println(bitSet);
    // System.out.println(bitSet.cardinality());
    // int bits = 0;
    // System.out.println(bits);
    // bits |= 1;
    // System.out.println(bits);
    // bits <<= 'd' - 'a';
    // System.out.println(bits);
    // bits = 0;
    // System.out.println(Integer.bitCount(bits));
    // System.out.println(~bits);
    // System.out.println(Integer.bitCount(~bits));
    // System.out.println(Integer.bitCount(-1));
    // System.out.println(Integer.bitCount(MIN_VALUE));
  }

  public static int solveWithArrayLoopRefactored(List<String> rocks) {
    byte[] mineralCount = new byte[26];
    for (String rock : rocks) {
      byte[] mineralIsPresent = new byte[26];
      for (char mineral : rock.toCharArray()) {
        mineralIsPresent[mineral - 'a']++;
        if (mineralIsPresent[mineral - 'a'] == 1) {
          mineralCount[mineral - 'a']++;
        }
      }
    }
    int gems = 0;
    for (int i = 0; i < mineralCount.length; i++) {
      if (mineralCount[i] == rocks.size()) {
        gems++;
      }
    }
    return gems;
  }

  public static int solveWithArrayLoop(List<String> rocks) {
    // define count array
    byte[] mineralCount = new byte[26];
    // for each rock
    for (String rock : rocks) {
      // define consist array
      boolean[] mineralIsPresent = new boolean[26];
      // for each mineral
      for (char mineral : rock.toCharArray()) {
        // mark present minerals (set true in a consists bit array)
        mineralIsPresent[mineral - 'a'] = true;
      }
      // if a mineral was present in a rock, increase count (1 add it to the count bit array)
      for (int i = 0; i < mineralIsPresent.length; i++) {
        if (mineralIsPresent[i]) {
          mineralCount[i]++;
        }
      }
    }
    int gems = 0;
    for (int i = 0; i < mineralCount.length; i++) {
      if (mineralCount[i] == rocks.size()) {
        gems++;
      }
    }
    return gems;
  }

  public static int solveWithBitwiseComparisonsRefactored(List<String> rocks) {
    // TODO READ https://www.baeldung.com/java-bitset
    int gems = -1; // only `1`s in binary
    for (String rock : rocks) {
      int minerals = 0;
      for (char mineral : rock.toCharArray()) {
        minerals |= 1 << ( mineral - 'a' );
      }
      gems &= minerals;
      if (gems == 0) {
        break;
      }
    }
    return Integer.bitCount(gems);
  }

  // TODO PRACTICE using binary representation - try again
  // TODO PRACTICE Math.pow(base,exp)
  public static int solveWithBitwiseComparisons(List<String> rocks) {
    long fullhouse = (long) Math.pow(2, 'z' - ( 'a' - 1 ) + 1) - 1; // 2**27 - 1
    long gems = fullhouse;
    for (String rock : rocks) {
      long minerals = 0;
      for (char mineral : rock.toCharArray()) {
        minerals |= (long) Math.pow(2, mineral - 'a');
      }
      gems &= minerals;
    }
    return Long.bitCount(gems);
  }
}
