package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Queen extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2655';
  public static final char BLACK_UNICODE_SYMBOL = '\u265B';

  public static final String SHORT_NAME = "Q";

  public static final String START_POSITION_D1 = "d1";
  public static final String START_POSITION_D8 = "d8";

  public Queen(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
