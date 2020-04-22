package me.shaposhnikandrii.chess.model;

import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.Square;
import me.shaposhnikandrii.chess.model.pieces.King;
import me.shaposhnikandrii.chess.model.pieces.Piece;
import me.shaposhnikandrii.chess.util.CustomCollectors;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Board {
  private final List<Piece> pieces;

  public Board(List<Piece> pieces) {
    this.pieces = pieces;
  }

  public Board() {
    this(new ArrayList<>());
  }

  public Board addPiece(Piece newPiece) {
    final Square position = Optional.ofNullable(newPiece)
        .map(Piece::getPosition)
        .orElseThrow(RuntimeException::new);

    boolean isPositionTaken = pieces.stream()
        .anyMatch(piece -> position == piece.getPosition());

    if (!isPositionTaken) {
      pieces.add(newPiece);
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
    return pieces.stream()
        .filter(piece -> position == piece.getPosition())
        .findFirst()
        .map(Piece::getUnicodeSymbol)
        .orElse('.');
  }

  private Map<Square, Color> getTakenPosition() {
    return pieces.stream().collect(Collectors.toMap(Piece::getPosition, Piece::getColor));
  }

  public Optional<Piece> getPieceWhichCanMoveTo(Square position, Color color, String shortName, String elaboration) {
    return pieces.stream()
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
    return pieces.stream()
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

  public Optional<Piece> removePiece(Square position) {
    Objects.requireNonNull(position);

    return pieces.stream()
        .filter(piece -> position == piece.getPosition())
        .findFirst();
  }


}
