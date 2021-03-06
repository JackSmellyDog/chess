package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;
import java.util.Map;

public class Rook extends LongRangePiece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2656';
  public static final char BLACK_UNICODE_SYMBOL = '\u265C';

  public static final String SHORT_NAME = "R";

  public static final Square START_POSITION_A1 = Square.A1;
  public static final Square START_POSITION_H1 = Square.H1;
  public static final Square START_POSITION_A8 = Square.A8;
  public static final Square START_POSITION_H8 = Square.H8;

  public Rook(Color color, Square position) {
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
    moveUntilPossible(possiblePositions, takenPositions, square -> square.down(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.left(1));
    moveUntilPossible(possiblePositions, takenPositions, square -> square.right(1));

    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }

}
