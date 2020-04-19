package me.shaposhnikandrii.chess.model.pieces;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import org.slf4j.Logger;

@Slf4j
@Getter
public abstract class Piece {
  protected String shortName;
  protected Color color;
  protected Square position;

  protected Piece(String shortName, Color color, Square position) {
    this.shortName = shortName;
    this.color = color;
    this.position = position;
  }

  protected Logger log() {
    return log;
  }

  public void move(Square position) {
    if (isMoveToPositionPossible(position)) {
      this.position = position;
    }
  }

  public abstract char getUnicodeSymbol();

  public abstract boolean isMoveToPositionPossible(Square newPosition);
}
