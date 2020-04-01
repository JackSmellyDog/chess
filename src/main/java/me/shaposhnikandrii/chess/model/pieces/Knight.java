package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Knight extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2658';
  public static final char BLACK_UNICODE_SYMBOL = '\u265E';

  public static final String SHORT_NAME = "N";

  public static final String START_POSITION_B1 = "b1";
  public static final String START_POSITION_G1 = "g1";
  public static final String START_POSITION_B8 = "b8";
  public static final String START_POSITION_G8 = "g8";

  public Knight(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveValid() {
    return false;
  }
}
