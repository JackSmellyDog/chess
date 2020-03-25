package me.shaposhnikandrii.chess.model.pieces;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PieceFactory {

  public Pawn createPawn(Color color, String position) {
    return (Pawn) createPiece(color, Pawn.SHORT_NAME, position, Pawn.class);
  }

  public Bishop createBishop(Color color, String position) {
    return (Bishop) createPiece(color, Bishop.SHORT_NAME, position, Bishop.class);
  }

  public Knight createKnight(Color color, String position) {
    return (Knight) createPiece(color, Knight.SHORT_NAME, position, Knight.class);
  }

  public Rook createRook(Color color, String position) {
    return (Rook) createPiece(color, Rook.SHORT_NAME, position, Rook.class);
  }

  public Queen createQueen(Color color, String position) {
    return (Queen) createPiece(color, Queen.SHORT_NAME, position, Queen.class);
  }

  public King createKing(Color color, String position) {
    return (King) createPiece(color, King.SHORT_NAME, position, King.class);
  }


  @SneakyThrows
  private Piece createPiece(Color color, String shortName, String position, Class<? extends Piece> pieceClass) {
    if (!isPositionValid(position)) {
      log.warn("Invalid position ({})", position);
      throw new RuntimeException("Invalid position" + position);
    }

    return pieceClass
        .getDeclaredConstructor(String.class, Color.class, String.class)
        .newInstance(shortName, color, position);
  }


  private boolean isPositionValid(String position) {
    return position != null && position.matches("[a-h][1-8]");
  }

}




