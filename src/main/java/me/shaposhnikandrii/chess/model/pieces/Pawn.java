package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;

public class Pawn extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2659';
  public static final char BLACK_UNICODE_SYMBOL = '\u265F';

  public static final String SHORT_NAME = "";

  public Pawn(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    if (color == Color.WHITE) {
      final Square upOne = position.up(1);

      possiblePositions.add(upOne);
      possiblePositions.add(upOne.left(1));
      possiblePositions.add(upOne.right(1));

      if (position.getNumber() == '2') {
        possiblePositions.add(position.up(2));
      }

    } else {
      final Square downOne = position.down(1);

      possiblePositions.add(downOne);
      possiblePositions.add(downOne.left(1));
      possiblePositions.add(downOne.right(1));

      if (position.getNumber() == '7') {
        possiblePositions.add(position.down(2));
      }
    }

    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }

}
