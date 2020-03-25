package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Bishop extends Piece {
  public static final String SHORT_NAME = "B";

  public static final String START_POSITION_C1 = "c1";
  public static final String START_POSITION_F1 = "f1";
  public static final String START_POSITION_C8 = "c8";
  public static final String START_POSITION_F8 = "f8";

  public Bishop(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
