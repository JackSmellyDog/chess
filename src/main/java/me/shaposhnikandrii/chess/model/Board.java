package me.shaposhnikandrii.chess.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Getter
public class Board {
  private final List<Piece> pieces;


  public Board(List<Piece> pieces) {
    this.pieces = pieces;
  }

  public Board() {
    this(new ArrayList<>());
  }

  public Board addPiece(Piece newPiece) {
    final String position = Optional.ofNullable(newPiece)
        .map(Piece::getPosition)
        .orElseThrow(RuntimeException::new);

    boolean isPositionTaken = pieces.stream()
        .anyMatch(piece -> position.equals(piece.getPosition()));

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

  public Board removePiece(String position) {
    Objects.requireNonNull(position);

    pieces.stream()
        .filter(piece -> position.equals(piece.getPosition()))
        .findFirst()
        .ifPresentOrElse(pieces::remove, () -> log.warn("No piece found on ({})", position));

    return this;
  }


  public void showBoard() {
    pieces.forEach(piece -> log.info("{} {}{}", piece.getColor().name(), piece.getShortName(), piece.getPosition()));
  }
}
