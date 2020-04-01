package me.shaposhnikandrii.chess.service;

import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.Board;
import me.shaposhnikandrii.chess.model.dto.GameSettings;
import me.shaposhnikandrii.chess.model.entity.Game;
import me.shaposhnikandrii.chess.model.entity.Move;
import me.shaposhnikandrii.chess.model.entity.Player;
import me.shaposhnikandrii.chess.model.enums.GameStatus;
import me.shaposhnikandrii.chess.repository.GameRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class GameService {
  private final GameRepository gameRepository;
  private final ConcurrentHashMap<Long, Game> activeGames;
  private final ObjectProvider<Board> startGameBoardProvider;

  public GameService(GameRepository gameRepository, ObjectProvider<Board> startGameBoardProvider) {
    this.gameRepository = gameRepository;
    this.activeGames = new ConcurrentHashMap<>();
    this.startGameBoardProvider = startGameBoardProvider;
  }


  public Game startGame(Player white, Player black, GameSettings gameSettings) {
    final Board board = startGameBoardProvider.getObject();

    final Game game = new Game()
        .setGameStatus(GameStatus.ACTIVE)
        .setBoard(board)
        .setWhite(white)
        .setBlack(black);

    save(game);
    activeGames.put(game.getId(), game);

    return game;
  }

  public void makeMove(Long gameId, Move move) {

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