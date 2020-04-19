package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

public class Queen extends Piece {
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
  public boolean isMoveToPositionPossible(Square newPosition) {
    return false;
  }


}
