package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;

public class Knight extends Piece {
  public static final char WHITE_UNICODE_SYMBOL = '\u2658';
  public static final char BLACK_UNICODE_SYMBOL = '\u265E';

  public static final String SHORT_NAME = "N";

  public static final Square START_POSITION_B1 = Square.B1;
  public static final Square START_POSITION_G1 = Square.G1;
  public static final Square START_POSITION_B8 = Square.B8;
  public static final Square START_POSITION_G8 = Square.G8;

  public Knight(Color color, Square position) {
    super(SHORT_NAME, color, position);
  }

  @Override
  public char getUnicodeSymbol() {
    return color == Color.WHITE ? WHITE_UNICODE_SYMBOL : BLACK_UNICODE_SYMBOL;
  }

  @Override
  public boolean isMoveToPositionPossible(Square newPosition) {
    final EnumSet<Square> possiblePositions = EnumSet.noneOf(Square.class);

    final Square upTwo = position.up(2);
    final Square downTwo = position.down(2);
    final Square leftTwo = position.left(2);
    final Square rightTwo = position.right(2);

    possiblePositions.add(upTwo.left(1));
    possiblePositions.add(upTwo.right(1));

    possiblePositions.add(downTwo.left(1));
    possiblePositions.add(downTwo.right(1));

    possiblePositions.add(leftTwo.up(1));
    possiblePositions.add(leftTwo.down(1));

    possiblePositions.add(rightTwo.up(1));
    possiblePositions.add(rightTwo.down(1));

    possiblePositions.remove(Square.OUT_OF_BOARD);

    return possiblePositions.contains(newPosition);
  }


}
