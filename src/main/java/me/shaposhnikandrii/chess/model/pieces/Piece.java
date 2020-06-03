package me.shaposhnikandrii.chess.model.pieces;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import org.slf4j.Logger;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Getter
public abstract class Piece {
  protected String shortName;
  protected Color color;
  protected Square position;
  protected LinkedList<Square> previousPosition;

  protected Piece(String shortName, Color color, Square position) {
    this.shortName = shortName;
    this.color = color;
    this.position = position;
    this.previousPosition = new LinkedList<>();
  }

  protected Logger log() {
    return log;
  }

  public abstract char getUnicodeSymbol();

  public abstract boolean isMoveToPositionPossible(Square newPosition, Map<Square, Color> takenPositions);

  public void setPosition(Square position) {
    previousPosition.add(this.position);
    this.position = position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Piece piece = (Piece) o;
    return shortName.equals(piece.shortName) &&
        color == piece.color &&
        position == piece.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortName, color, position);
  }

  public boolean hasSameColorAs(Piece piece) {
    return piece.color == color;
  }
}
