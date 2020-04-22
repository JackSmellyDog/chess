package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;
import java.util.Map;

public class Pawn extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2659';
  public static final char BLACK_UNICODE_SYMBOL = '\u265F';

  public static final String SHORT_NAME = "";

  public Pawn(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition, Map<Square, Color> takenPositions) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    int onePoint = color == Color.WHITE ? 1 : -1;
    int twoPoints = color == Color.WHITE ? 2 : -2;
    char doubleJumpLine = color == Color.WHITE ? '2' : '7';
    char passantLine = color == Color.WHITE ? '5' : '4';

    final Square upOne = position.up(onePoint);
    final Square upTwo = position.up(twoPoints);
    final Square upAndLeft = upOne.left(1);
    final Square upAndRight = upOne.right(1);

    if (!takenPositions.containsKey(upOne)) {
      possiblePositions.add(upOne);
    }

    if (takenPositions.containsKey(upAndLeft) && takenPositions.get(upAndLeft) != color) {
      possiblePositions.add(upAndLeft);
    }

    final Square leftOne = position.left(1);

    if (position.getNumber() == passantLine && takenPositions.containsKey(leftOne) && takenPositions.get(leftOne) != color) {
      possiblePositions.add(upAndLeft);
    }

    if (takenPositions.containsKey(upAndRight) && takenPositions.get(upAndRight) != color) {
      possiblePositions.add(upAndRight);
    }

    final Square rightOne = position.right(1);

    if (position.getNumber() == passantLine && takenPositions.containsKey(rightOne) && takenPositions.get(rightOne) != color) {
      possiblePositions.add(rightOne);
    }

    if (position.getNumber() == doubleJumpLine && !takenPositions.containsKey(upTwo)) {
      possiblePositions.add(upTwo);
    }

    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }

}
