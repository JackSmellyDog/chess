package me.shaposhnikandrii.chess.model.pieces;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import org.slf4j.Logger;

@Slf4j
@Getter
public abstract class Piece {
  protected String shortName;
  protected Color color;
  protected String position;

  protected Piece(String shortName, Color color, String position) {
    this.shortName = shortName;
    this.color = color;
    this.position = position;
  }

  protected Logger log() {
    return log;
  }

  public void move(String position) {
    if (isMoveValid()) {
      this.position = position;
    }
  }

  protected abstract boolean isMoveValid();
}
