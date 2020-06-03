package me.shaposhnikandrii.chess.model;

import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.exception.ImpossibleMoveException;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import me.shaposhnikandrii.chess.model.pieces.King;
import me.shaposhnikandrii.chess.model.pieces.Piece;
import me.shaposhnikandrii.chess.util.CustomCollectors;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Board {
  private final List<Piece> activePieces;
  private final List<Piece> capturedPieces;

  public Board(List<Piece> activePieces) {
    this.activePieces = activePieces;
    this.capturedPieces = new ArrayList<>();
  }

  public Board() {
    this(new ArrayList<>());
  }

  public Board addPiece(Piece newPiece) {
    final Square position = Optional.ofNullable(newPiece)
        .map(Piece::getPosition)
        .orElseThrow(RuntimeException::new);

    boolean isPositionTaken = activePieces.stream()
        .anyMatch(piece -> position == piece.getPosition());

    if (!isPositionTaken) {
      activePieces.add(newPiece);
      log.info("{} has been added on {}", newPiece.getClass().getSimpleName(), newPiece.getPosition());
    } else {
      log.warn("Position ({}) is already taken", position);
    }

    return this;
  }

  public Board addPieces(List<Piece> newPieces) {
    newPieces.forEach(this::addPiece);
    return this;
  }

  public char getPieceUnicodeOnPosition(Square position) {
    return getPieceOnPosition(position)
        .map(Piece::getUnicodeSymbol)
        .orElse('.');
  }


  public void updatePosition(Square newPosition, String pieceShortName, Color pieceColor, boolean isCapturing, String elaboration) {
    final Piece pieceToMove = getPieceWhichCanMoveTo(newPosition, pieceColor, pieceShortName, elaboration)
        .orElseThrow(() -> new ImpossibleMoveException("No or too many pieces on " + newPosition));

    // todo: en passant
    if (isCapturing) {
      final Piece pieceToBeTaken = getPieceOnPosition(newPosition)
          .orElseThrow(() -> new ImpossibleMoveException("No piece to be captured on " + newPosition));

      if (pieceToMove.hasSameColorAs(pieceToBeTaken))
        throw new ImpossibleMoveException("Your own piece can't be taken");

      if (pieceToBeTaken instanceof King)
        throw new ImpossibleMoveException("Kings can't be taken");

      removePiece(pieceToBeTaken);
    }

    pieceToMove.setPosition(newPosition);
  }

  public void shortCastling(Color forColor) {

  }

  public void longCastling(Color forColor) {

  }

  private Map<Square, Color> getTakenPosition() {
    return activePieces.stream().collect(Collectors.toMap(Piece::getPosition, Piece::getColor));
  }

  public Optional<Piece> getPieceWhichCanMoveTo(Square position, Color color, String shortName, String elaboration) {
    return activePieces.stream()
        .filter(piece -> piece.getColor() == color)
        .filter(piece -> piece.getShortName().equals(shortName))
        .filter(piece -> withElaboration(piece, elaboration))
        .filter(piece -> piece.isMoveToPositionPossible(position, getTakenPosition()))
        .collect(CustomCollectors.toSinglePieceOptional());
  }

  public Optional<Piece> getPieceWhichCanMoveTo(Square position, Color color, String shortName) {
    return getPieceWhichCanMoveTo(position, color, shortName, null);
  }

  public Optional<Piece> getKing(Color color) {
    return activePieces.stream()
        .filter(piece -> piece.getShortName().equals(King.SHORT_NAME))
        .filter(piece -> piece.getColor() == color)
        .collect(CustomCollectors.toSinglePieceOptional());
  }

  public Optional<Piece> getWhiteKing() {
    return getKing(Color.WHITE);
  }

  public Optional<Piece> getBlackKing() {
    return getKing(Color.BLACK);
  }

  private boolean withElaboration(Piece piece, String elaboration) {
    if (elaboration == null || elaboration.isEmpty())
      return true;

    final Square position = piece.getPosition();

    if (elaboration.length() == 1) {
      return elaboration.charAt(0) == position.getLetter() || elaboration.charAt(0) == position.getNumber();

    } else if (elaboration.length() == 2) {
      return elaboration.equalsIgnoreCase(position.name());

    } else {
      log.warn("Invalid elaboration ({})", elaboration);
      return false;
    }
  }

  public boolean removePiece(Piece piece) {
    if (activePieces.remove(piece)) {
      capturedPieces.add(piece);
      return true;
    }

    return false;
  }


  public Optional<Piece> getPieceOnPosition(Square position) {
    return activePieces.stream()
        .filter(piece -> position == piece.getPosition())
        .findFirst();
  }
}
