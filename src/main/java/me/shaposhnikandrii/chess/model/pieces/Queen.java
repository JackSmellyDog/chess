package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;
import java.util.Map;

public class Queen extends LongRangePiece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2655';
  public static final char BLACK_UNICODE_SYMBOL = '\u265B';

  public static final String SHORT_NAME = "Q";

  public static final Square START_POSITION_D1 = Square.D1;
  public static final Square START_POSITION_D8 = Square.D8;

  public Queen(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition, Map<Square, Color> takenPositions) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    moveUntilPossible(possiblePositions, takenPositions, square -> square.up(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.up(1).right(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.up(1).left(1));

    moveUntilPossible(possiblePositions, takenPositions, square -> square.down(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.down(1).right(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.down(1).left(1));

    moveUntilPossible(possiblePositions, takenPositions, square -> square.left(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.right(1));


    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }

}
