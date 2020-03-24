package me.shaposhnikandrii.chess.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.entity.Game;
import me.shaposhnikandrii.chess.model.entity.Move;
import me.shaposhnikandrii.chess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {
  private final GameRepository gameRepository;
  private final ConcurrentHashMap<Long, Game> activeGames;


  public Long startGame() {

    // game id
    return 0L;
  }

  public void makeMove(Move move) {

  }

  private boolean isMoveValid(Move move) {
    return false;
  }

  public void endGame() {

  }


  public Game save(Game game) {
    return gameRepository.save(game);
  }



}