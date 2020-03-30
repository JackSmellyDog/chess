package me.shaposhnikandrii.chess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class CLIChessApplication implements CommandLineRunner {

  public static void main(String[] args) {
    new SpringApplicationBuilder(CLIChessApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("It worked!");
  }
}
