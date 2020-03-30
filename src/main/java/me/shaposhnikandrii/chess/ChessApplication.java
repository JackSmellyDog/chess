package me.shaposhnikandrii.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"me.shaposhnikandrii.chess"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CLIChessApplication.class)
})
public class ChessApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChessApplication.class, args);
  }

}
