package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Rook extends Piece {
  public static final String SHORT_NAME = "R";

  public static final String START_POSITION_A1 = "a1";
  public static final String START_POSITION_H1 = "h1";
  public static final String START_POSITION_A8 = "a8";
  public static final String START_POSITION_H8 = "h8";

  public Rook(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
