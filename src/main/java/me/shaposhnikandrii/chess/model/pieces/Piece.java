package me.shaposhnikandrii.chess.model.pieces;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import org.slf4j.Logger;

import java.util.Map;

@Slf4j
@Getter
public abstract class Piece {
  protected String shortName;
  protected Color color;

  @Setter
  protected Square position;

  protected Piece(String shortName, Color color, Square position) {
    this.shortName = shortName;
    this.color = color;
    this.position = position;
  }

  protected Logger log() {
    return log;
  }

  public abstract char getUnicodeSymbol();

  public abstract boolean isMoveToPositionPossible(Square newPosition, Map<Square, Color> takenPositions);
}
