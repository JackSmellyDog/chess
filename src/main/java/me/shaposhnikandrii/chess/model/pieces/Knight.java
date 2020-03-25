package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Knight extends Piece {
  public static final String SHORT_NAME = "N";

  public static final String START_POSITION_B1 = "b1";
  public static final String START_POSITION_G1 = "g1";
  public static final String START_POSITION_B8 = "b8";
  public static final String START_POSITION_G8 = "g8";

  public Knight(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
