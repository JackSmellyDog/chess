package me.shaposhnikandrii.chess;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.Board;
import me.shaposhnikandrii.chess.model.dto.GameSettings;
import me.shaposhnikandrii.chess.model.entity.Game;
import me.shaposhnikandrii.chess.model.entity.Player;
import me.shaposhnikandrii.chess.model.enums.GameStatus;
import me.shaposhnikandrii.chess.model.enums.Square;
import me.shaposhnikandrii.chess.service.GameService;
import me.shaposhnikandrii.chess.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumSet;

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

    int newColumnCounter = 0;

    for (Square square : EnumSet.range(Square.A8, Square.H1)) {
      if (newColumnCounter % 8 == 0) {
        builder.append(square.getNumber()).append(' ');
      }

      builder.append(board.getPieceUnicodeOnPosition(square)).append(' ');

      if (newColumnCounter % 8 == 7) {
        builder.append('\n');
      }

      newColumnCounter++;
    }

    builder.append("  a b c d e f g h").append("\n\n\n");
    System.out.println(builder.toString());
  }


}
