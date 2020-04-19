package me.shaposhnikandrii.chess.model.pieces;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PieceFactory {

  public Pawn createPawn(Color color, Square position) {
    return (Pawn) createPiece(color, position, Pawn.class);
  }

  public Bishop createBishop(Color color, Square position) {
    return (Bishop) createPiece(color, position, Bishop.class);
  }

  public Knight createKnight(Color color, Square position) {
    return (Knight) createPiece(color, position, Knight.class);
  }

  public Rook createRook(Color color, Square position) {
    return (Rook) createPiece(color, position, Rook.class);
  }

  public Queen createQueen(Color color, Square position) {
    return (Queen) createPiece(color, position, Queen.class);
  }

  public King createKing(Color color, Square position) {
    return (King) createPiece(color, position, King.class);
  }


  @SneakyThrows
  private Piece createPiece(Color color, Square position, Class<? extends Piece> pieceClass) {
    return pieceClass
        .getDeclaredConstructor(Color.class, Square.class)
        .newInstance(color, position);
  }

}




