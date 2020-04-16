package me.shaposhnikandrii.chess.exception;

public class InvalidMoveSyntaxException extends ChessException {
  public InvalidMoveSyntaxException() {
  }

  public InvalidMoveSyntaxException(String message) {
    super(message);
  }

  public InvalidMoveSyntaxException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidMoveSyntaxException(Throwable cause) {
    super(cause);
  }

  public InvalidMoveSyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
