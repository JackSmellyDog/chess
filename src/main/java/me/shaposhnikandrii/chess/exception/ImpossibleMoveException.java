package me.shaposhnikandrii.chess.exception;

public class ImpossibleMoveException extends ChessException {
  public ImpossibleMoveException() {
  }

  public ImpossibleMoveException(String message) {
    super(message);
  }

  public ImpossibleMoveException(String message, Throwable cause) {
    super(message, cause);
  }

  public ImpossibleMoveException(Throwable cause) {
    super(cause);
  }

  public ImpossibleMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
