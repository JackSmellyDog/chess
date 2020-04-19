package me.shaposhnikandrii.chess.config;

import lombok.RequiredArgsConstructor;
import me.shaposhnikandrii.chess.model.Board;
import me.shaposhnikandrii.chess.model.enums.Square;
import me.shaposhnikandrii.chess.model.pieces.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static me.shaposhnikandrii.chess.model.enums.Color.BLACK;
import static me.shaposhnikandrii.chess.model.enums.Color.WHITE;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
  private final PieceFactory pieceFactory;



  @Bean
  @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
  public Board startGameBoard() {

    List<Piece> whitePawns = Arrays.stream(Square.values())
        .filter(square -> square.getNumber() == '2')
        .map(square -> pieceFactory.createPawn(WHITE, square))
        .collect(Collectors.toList());

    List<Piece> blackPawns = Arrays.stream(Square.values())
        .filter(square -> square.getNumber() == '7')
        .map(square -> pieceFactory.createPawn(WHITE, square))
        .collect(Collectors.toList());


    return new Board()
        .addPiece(pieceFactory.createKing(WHITE, King.START_POSITION_E1))
        .addPiece(pieceFactory.createQueen(WHITE, Queen.START_POSITION_D1))
        // white rooks
        .addPiece(pieceFactory.createRook(WHITE, Rook.START_POSITION_A1))
        .addPiece(pieceFactory.createRook(WHITE, Rook.START_POSITION_H1))
        // white knights
        .addPiece(pieceFactory.createKnight(WHITE, Knight.START_POSITION_B1))
        .addPiece(pieceFactory.createKnight(WHITE, Knight.START_POSITION_G1))
        // white bishops
        .addPiece(pieceFactory.createBishop(WHITE, Bishop.START_POSITION_C1))
        .addPiece(pieceFactory.createBishop(WHITE, Bishop.START_POSITION_F1))
        // white pawns
        .addPieces(whitePawns)
        // Black Pieces

        .addPiece(pieceFactory.createKing(BLACK, King.START_POSITION_E8))
        .addPiece(pieceFactory.createQueen(BLACK, Queen.START_POSITION_D8))
        // black rooks
        .addPiece(pieceFactory.createRook(BLACK, Rook.START_POSITION_A8))
        .addPiece(pieceFactory.createRook(BLACK, Rook.START_POSITION_H8))
        // black knights
        .addPiece(pieceFactory.createKnight(BLACK, Knight.START_POSITION_B8))
        .addPiece(pieceFactory.createKnight(BLACK, Knight.START_POSITION_G8))
        // black bishops
        .addPiece(pieceFactory.createBishop(BLACK, Bishop.START_POSITION_C8))
        .addPiece(pieceFactory.createBishop(BLACK, Bishop.START_POSITION_F8))
        // black pawns
        .addPieces(blackPawns);


  }

}