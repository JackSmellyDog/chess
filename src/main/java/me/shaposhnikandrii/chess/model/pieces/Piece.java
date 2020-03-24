package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;

public abstract class Piece {
  protected String shortName;
  protected Color color;
  protected String position;

  Piece(String shortName, Color color, String position) {
    this.shortName = shortName;
    this.color = color;
    this.position = position;
  }
}
