package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class King extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2654';
  public static final char BLACK_UNICODE_SYMBOL = '\u265A';

  public static final String SHORT_NAME = "K";

  public static final String START_POSITION_E1 = "e1";
  public static final String START_POSITION_E8 = "e8";


  public King(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
