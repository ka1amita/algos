package src.codewars;

import java.util.Scanner;

public class TwentyThreeMatches {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Number of matches on the table: ");
    int matches = scanner.nextInt();
    int take = bot(matches, 3);
    System.out.println("I take " + take + " matches");
    System.out.println("Remain " + ( matches - take ) + " matches");
  }

  public static int bot(int matches, int maxPerTurn) {
    /**
     * To understand it, let's play together agings an opponent.
     * And for simplicity choose maxPerTurn = 3;
     * ...
     *
     * We can already see that if we are left with a single match, we have no choice but to take it and lose.
     * If we go one step further, or rather one turn back.
     * We can deduce, that if the opponent is faced with 2,3, or 4 matches,
     * he can make sure that he leaves us with the single match!
     *
     * If we go yet one turn back, to make it a full round.
     * We can calculate that if we are faced with 5 (maxPerTurn + 2), we are already guaranteed to lose
     * (given that the other players know how to play it as we are going understand shortly)!
     * Because no matter hom many matches we take at this point, we leave the opponent with 2,3, or 4 matches.
     * We have already seen where this leads to.
     *
     * Let's pause and think about it now a bit.
     * Is this outcome random? For sure not.
     * When is the game decide then? In the last move, the one before, or ony other?
     * We have already demonstrated above that the outcome is sealed before at least the last round!
     * If we induce further, given that any state could be the beginning of the game or,
     * seen from the other side,
     * any state could be only an intermediate result of already proceeding game,
     * (s well as the fact that the players are virtually indistinguishable)
     * We can't arrive to any other conclusion tha the game is determined at the very beginning
     * (given that both players know how to play it)!
     * This alone already gives us a lot of insight.
     *
     * Let's know express it more rigorously.
     * How to do that better than with math and code!
     * The number of matches to take is determined by this equation
     *
     * Explanation:
     * If we want to guarantee a win, our last move has to face our opponent with exactly one match
     * so he doesn't have any other choice then to take it and lose
     * therefore `numberOfMatches - 1`
     * We can guarantee this to happen given (almost, see later) any number of rounds before,
     * because we can ensure that every round (after both players played a turn) exactly
     * maxPerTurn + 1 is taken by both players in total
     * therefore `% (maxPerTurn + 1)`
     * Only a single round is necessary to ensure that this condition is met
     * `% maxPerTurn + 1` can only be as high as `maxPerTurn`
     * and therefore whoever starts,
     * have a good opportunity to insure ones win.
     * That said, there is an exception where we can't guarantee a win for us.
     * We have already said that the players are indistinguishable,
     * therefore we could be also faced with the same situation we just arranged for our opponent.
     * When? e.g. at the very first move!
     * We can actually derive this result from the last equation as well.
     * If we explore the other boundary, we come to this full conclusion:
     * `% maxPerTurn + 1` can only be as high as `maxPerTurn` and as small as `0`!
     * Now we can see where the problem comes from. It's right there, the `0`.
     * We are not allowed to take 0 matches!
     * In that cae we are in a position to lose already and there is nothing we can do about that,
     * unless our opponent does a mistake!
     *
     * Note:
     * when finished, film a video, explain how you came over it, what motivated you to talk about it etc
     */
    int move = ( matches - 1 ) % ( maxPerTurn + 1 );
    int randomMove = (int) ( 1 + Math.random() * maxPerTurn );
    return move == 0 ? randomMove : move;
  }

  public static int bot(int matches, int minPerTurn, int maxPerTurn) {
    int move = ( matches - minPerTurn ) % ( maxPerTurn + minPerTurn );
    int randomMove = (int) ( minPerTurn + Math.random() * ( maxPerTurn - minPerTurn + 1 ) );
    return move < minPerTurn ? randomMove : move;
  }
}


