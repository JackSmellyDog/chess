package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

public class Rook extends Piece {
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
  public boolean isMoveToPositionPossible(Square newPosition) {
    return false;
  }


}
