package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Bishop extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2657';
  public static final char BLACK_UNICODE_SYMBOL = '\u265D';

  public static final String SHORT_NAME = "B";

  public static final String START_POSITION_C1 = "c1";
  public static final String START_POSITION_F1 = "f1";
  public static final String START_POSITION_C8 = "c8";
  public static final String START_POSITION_F8 = "f8";

  public Bishop(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMovePossible(String position) {
    return false;
  }


}
