package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public class Pawn extends Piece {
  public static final String SHORT_NAME = "";

  public Pawn(Color color, String position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  protected boolean isMoveValid() {
    return false;
  }
}
