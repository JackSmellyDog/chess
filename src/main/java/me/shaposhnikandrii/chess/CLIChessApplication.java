package me.shaposhnikandrii.chess;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.Board;
import me.shaposhnikandrii.chess.model.dto.GameSettings;
import me.shaposhnikandrii.chess.model.entity.Game;
import me.shaposhnikandrii.chess.model.entity.Player;
import me.shaposhnikandrii.chess.model.enums.GameStatus;
import me.shaposhnikandrii.chess.service.GameService;
import me.shaposhnikandrii.chess.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class CLIChessApplication implements CommandLineRunner {
  private final GameService gameService;
  private final PlayerService playerService;


  public static void main(String[] args) {
    new SpringApplicationBuilder(CLIChessApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("**********************************************");
    log.info("***  Hello! This is a console chess game!  ***");
    log.info("**********************************************");

    Player white = playerService.getPlayer("Andrii", false);
    Player black = playerService.getPlayer("Ivan", false);


    Game game = gameService.startGame(white, black, new GameSettings());
    Board board = game.getBoard();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    while (!game.isOver()) {
      showScreen(board);

      System.out.println("Enter your move:");

      String move = reader.readLine();


      game.setGameStatus(GameStatus.DRAW);
    }

  }


  private void showScreen(Board board) {
    StringBuilder builder = new StringBuilder("\n\n\n");

    for (int i = 8; i >= 1; i--) {
      builder.append(i).append(' ');

      for (int j = 'a'; j <= 'h'; j++) {
        builder.append(board.getPieceUnicodeOnPosition(String.format("%s%s", (char) j, i))).append(' ');
      }

      builder.append('\n');
    }

    builder.append("  a b c d e f g h").append("\n\n\n");
    System.out.println(builder.toString());
  }


}
