package me.shaposhnikandrii.chess.exception;

public abstract class ChessException extends RuntimeException {

  public ChessException() {
  }

  public ChessException(String message) {
    super(message);
  }

  public ChessException(String message, Throwable cause) {
    super(message, cause);
  }

  public ChessException(Throwable cause) {
    super(cause);
  }

  public ChessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
