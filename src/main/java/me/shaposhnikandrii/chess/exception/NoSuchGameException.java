package me.shaposhnikandrii.chess.exception;

public class NoSuchGameException extends ChessException {
  public NoSuchGameException() {
  }

  public NoSuchGameException(String message) {
    super(message);
  }

  public NoSuchGameException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoSuchGameException(Throwable cause) {
    super(cause);
  }

  public NoSuchGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
