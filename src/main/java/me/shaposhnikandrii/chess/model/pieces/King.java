package me.shaposhnikandrii.chess.model.pieces;

import lombok.Getter;
import lombok.Setter;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.*;

public class King extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2654';
  public static final char BLACK_UNICODE_SYMBOL = '\u265A';

  public static final String SHORT_NAME = "K";

  public static final Square START_POSITION_E1 = Square.E1;
  public static final Square START_POSITION_E8 = Square.E8;

  @Getter @Setter
  private boolean isUnderCheck;


  public King(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition, Map<Square, Color> takenPositions) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    final Square upOne = position.up(1);

    possiblePositions.add(upOne);
    possiblePositions.add(upOne.left(1));
    possiblePositions.add(upOne.right(1));

    possiblePositions.add(position.left(1));
    possiblePositions.add(position.right(1));


    final Square downOne = position.down(1);

    possiblePositions.add(downOne);
    possiblePositions.add(downOne.left(1));
    possiblePositions.add(downOne.right(1));

    possiblePositions.remove(Square.OUT_OF_BOARD);

    takenPositions.entrySet().stream()
        .filter(entry -> entry.getValue() == color)
        .map(Map.Entry::getKey)
        .forEach(possiblePositions::remove);

    return possiblePositions.contains(newPosition);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    King king = (King) o;
    return isUnderCheck == king.isUnderCheck;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isUnderCheck);
  }
}
