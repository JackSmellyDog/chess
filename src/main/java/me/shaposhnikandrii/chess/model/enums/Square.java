package me.shaposhnikandrii.chess.model.enums;

import java.util.Arrays;

public enum Square {
  OUT_OF_BOARD,

  A8, B8, C8, D8, E8, F8, G8, H8,
  A7, B7, C7, D7, E7, F7, G7, H7,
  A6, B6, C6, D6, E6, F6, G6, H6,
  A5, B5, C5, D5, E5, F5, G5, H5,
  A4, B4, C4, D4, E4, F4, G4, H4,
  A3, B3, C3, D3, E3, F3, G3, H3,
  A2, B2, C2, D2, E2, F2, G2, H2,
  A1, B1, C1, D1, E1, F1, G1, H1;


  private char letter;
  private char number;

  public char getLetter() {
    return letter;
  }

  public char getNumber() {
    return number;
  }

  public static Square of(String s) {
    if (s == null || !s.matches("[a-hA-H][1-8]"))
      return OUT_OF_BOARD;

    return Arrays.stream(Square.values())
        .filter(square -> square.letter == s.toLowerCase().charAt(0))
        .filter(square -> square.number == s.charAt(1))
        .findFirst()
        .orElse(OUT_OF_BOARD);
  }

  public Square up(int squares) {
    int newNumber = this.number + squares;

    return Arrays.stream(Square.values())
        .filter(square -> square != OUT_OF_BOARD)
        .filter(square -> square.letter == this.letter)
        .filter(square -> square.number == newNumber)
        .findFirst()
        .orElse(OUT_OF_BOARD);
  }

  public Square down(int squares) {
    return up(-squares);
  }

  public Square left(int squares) {
    return right(-squares);
  }

  public Square right(int squares) {
    int newLetter = this.letter + squares;

    return Arrays.stream(Square.values())
        .filter(square -> square != OUT_OF_BOARD)
        .filter(square -> square.letter == newLetter)
        .filter(square -> square.number == this.number)
        .findFirst()
        .orElse(OUT_OF_BOARD);
  }

  Square() {
    this.letter = this.name().toLowerCase().charAt(0);
    this.number = this.name().charAt(1);
  }
}
