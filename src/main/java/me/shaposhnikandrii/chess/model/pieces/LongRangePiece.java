package me.shaposhnikandrii.chess.model.pieces;

import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.UnaryOperator;

public abstract class LongRangePiece extends Piece {
  protected LongRangePiece(String shortName, Color color, Square position) {
    super(shortName, color, position);
  }


  protected void moveUntilPossible(EnumSet<Square> possiblePositions,
                                   Map<Square, Color> takenPositions,
                                   UnaryOperator<Square> unaryOperator) {

    Square candidate = unaryOperator.apply(position);

    while (candidate != Square.OUT_OF_BOARD) {
      if (!takenPositions.containsKey(candidate)) {
        possiblePositions.add(candidate);
        candidate = unaryOperator.apply(candidate);

      } else if (takenPositions.get(candidate) == color) {
        return;

      } else {
        possiblePositions.add(candidate);
        return;
      }
    }
  }
}
