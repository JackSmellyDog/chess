package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;
import java.util.function.UnaryOperator;

public class Bishop extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2657';
  public static final char BLACK_UNICODE_SYMBOL = '\u265D';

  public static final String SHORT_NAME = "B";

  public static final Square START_POSITION_C1 = Square.C1;
  public static final Square START_POSITION_F1 = Square.F1;
  public static final Square START_POSITION_C8 = Square.C8;
  public static final Square START_POSITION_F8 = Square.F8;

  public Bishop(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    moveUntilPossible(possiblePositions, square -> square.up(1).right(1));
    moveUntilPossible(possiblePositions, square -> square.up(1).left(1));
    moveUntilPossible(possiblePositions, square -> square.down(1).right(1));
    moveUntilPossible(possiblePositions, square -> square.down(1).left(1));

    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }

  private void moveUntilPossible(EnumSet<Square> possiblePositions, UnaryOperator<Square> unaryOperator) {
    Square candidate = unaryOperator.apply(position);

    while (candidate != Square.OUT_OF_BOARD) {
      possiblePositions.add(candidate);
      candidate = unaryOperator.apply(candidate);
    }
  }


}
