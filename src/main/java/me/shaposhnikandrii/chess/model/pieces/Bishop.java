package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

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
    return false;
  }


}
