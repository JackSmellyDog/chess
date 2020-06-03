package me.shaposhnikandrii.chess.model;

import lombok.Getter;
import me.shaposhnikandrii.chess.model.enums.Square;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public final class ParsedMove {
  private static final String VALID_MOVE_REGEX = "^([BNKQR]:?)?([a-h]?[1-8]?:?)(x:?)?([a-h][1-8]:?)$|^(O-O)$|^(O-O-O)$";

  private static final int SHORT_CASTLING_GROUP = 5;
  private static final int LONG_CASTLING_GROUP = 6;
  private static final int NEW_POSITION_GROUP = 4;
  private static final int PIECE_SHORT_NAME_GROUP = 1;
  private static final int ELABORATION_GROUP = 2;
  private static final int CAPTURING_GROUP = 3;

  private final String plainMove;
  private boolean isValid;

  // Make an enum with few statuses?
  private String error;

  private String pieceShortName;
  private Square newPosition;

  // Not sure it's a correct word. Example: N(a)xb6, R(1)h7, Q(c3)c4
  private String elaboration;

  private boolean isPawnMove;
  private boolean isCapturing;

  private boolean isCastling;
  private boolean isShortCastling;
  private boolean isLongCastling;


  public static ParsedMove parse(String plainMove) {
    return new ParsedMove(plainMove);
  }

  private ParsedMove(String plainMove) {
    this.plainMove = plainMove;
    //todo: avoid logic in constructor
    init();
  }

  private void init() {
    Pattern p = Pattern.compile(VALID_MOVE_REGEX);
    Matcher m = p.matcher(plainMove);

    if (m.find()) {
      isShortCastling = m.group(SHORT_CASTLING_GROUP) != null;
      isLongCastling = m.group(LONG_CASTLING_GROUP) != null;

      if (isShortCastling || isLongCastling) {
        isCastling = true;
        isValid = true;

        // Due to the rule that castling is a King's move
        pieceShortName = "K";

        return;
      }

      newPosition = Square.of(m.group(NEW_POSITION_GROUP));

      if (newPosition == Square.OUT_OF_BOARD) {
        error = String.format("After move position can't be null. Plain move: (%s)", plainMove);
        return;
      }

      pieceShortName = Optional.ofNullable(m.group(PIECE_SHORT_NAME_GROUP)).orElse("");
      elaboration = m.group(ELABORATION_GROUP);

      isPawnMove = pieceShortName.isEmpty();
      isCapturing = m.group(CAPTURING_GROUP) != null;

      if (isPawnMove && isCapturing && !isPawnNextToItsCapture()) {
        error = String.format("Invalid capturing by pawn, (%s)", plainMove);
        return;
      }

      isValid = true;

    } else {
      error = String.format("Move (%s) do not match the pattern", plainMove);
    }
  }

  private boolean isPawnNextToItsCapture() {
    // Move to Pawn's validation method?
    return elaboration != null && !elaboration.isEmpty() && Math.abs(newPosition.getLetter() - elaboration.charAt(0)) == 1;
  }

}
