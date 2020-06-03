package me.shaposhnikandrii.chess.rules;

import me.shaposhnikandrii.chess.model.Board;

@FunctionalInterface
public interface Rule {
  void check(Board board);
}
