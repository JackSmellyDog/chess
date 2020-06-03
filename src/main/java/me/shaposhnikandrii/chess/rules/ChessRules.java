package me.shaposhnikandrii.chess.rules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChessRules {

  @Bean
  public Rule kingsDontKiss() {
    return board -> {

    };
  }

}