package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

public class Knight extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2658';
  public static final char BLACK_UNICODE_SYMBOL = '\u265E';

  public static final String SHORT_NAME = "N";

  public static final Square START_POSITION_B1 = Square.B1;
  public static final Square START_POSITION_G1 = Square.G1;
  public static final Square START_POSITION_B8 = Square.B8;
  public static final Square START_POSITION_G8 = Square.G8;

  public Knight(Color color, Square position) {
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
