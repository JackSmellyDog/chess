package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Pawn extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2659';
  public static final char BLACK_UNICODE_SYMBOL = '\u265F';

  public static final String SHORT_NAME = "";

  public Pawn(Color color, String position) {
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
