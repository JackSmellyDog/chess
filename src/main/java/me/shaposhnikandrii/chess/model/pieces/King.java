package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

public class King extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2654';
  public static final char BLACK_UNICODE_SYMBOL = '\u265A';

  public static final String SHORT_NAME = "K";

  public static final Square START_POSITION_E1 = Square.E1;
  public static final Square START_POSITION_E8 = Square.E8;


  public King(Color color, Square position) {
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
