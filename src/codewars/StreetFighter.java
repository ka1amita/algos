package src.codewars;

import java.util.Arrays;

public class StreetFighter {
  public static void main(String[] args) {
    String[][] fighters = new String[][] {
        new String[] {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
        new String[] {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"},
        };
    String[] moves = new String[] {"up", "left", "right", "left", "left"};
    System.out.println(Arrays.toString(solveWithSwitch(fighters, new int[] {0, 0}, moves)));
    System.out.println(Arrays.toString(streetFighterSelection(fighters, new int[] {0, 0}, moves)));

  }

  // TODO PRACTICE switch
  // Within a switch block, each statement group either terminates abruptly
  //  (with a break, continue, return or thrown exception),
  //  or is marked with a comment to indicate that execution will or
  //  might continue into the next statement group.
  //  Any comment that communicates the idea of fall-through is sufficient
  //  (typically // fall through).
  //  This special comment is not required in the last statement group of the switch block.
  //
  //  Each switch statement includes a default statement group, even if it contains no code.
  //
  //  switch (i) {
  //    case -1:
  //    case 0:
  //      System.out.println("0");
  //      // fall through
  //    case 1:
  //      System.out.println("1");
  //      break;
  //    default:
  //      System.out.println("default");
  //  }
  public static String[] solveWithSwitch(String[][] fighters,
                                         int[] position,
                                         String[] moves) {
    String[] solution = new String[moves.length];
    int i = 0;
    for (String move : moves) {
      switch (move) {
        case "up":
          position[0] = 0;
          break;
        case "down":
          position[0] = 1;
          break;
        case "left":
          position[1] = ( position[1] + 6 - 1 ) % 6;
          break;
        case "right":
          position[1] = ( position[1] + 1 ) % 6;
          break;
      }
      solution[i] = fighters[position[0]][position[1]];
      i++;
    }
    return solution;
  }

  // TODO PRACTICE array[] definition using {}: `String[] array = new String[] {"one", "two"};`
  public static String[] streetFighterSelection(String[][] fighters,
                                                int[] position,
                                                String[] moves) {
    String[] solution = new String[moves.length];
    int i = 0;
    for (String move : moves) {
      if (move.equals("up")) {
        position[0] = 0;
      } else if (move.equals("down")) {
        position[0] = 1;
      } else if (move.equals("left")) {
        position[1] = ( position[1] + 6 - 1 ) % 6;
      } else if (move.equals("right")) {
        position[1] = ( position[1] + 1 ) % 6;
      }
      solution[i] = fighters[position[0]][position[1]];
      i++;
    }
    return solution;
  }
}
