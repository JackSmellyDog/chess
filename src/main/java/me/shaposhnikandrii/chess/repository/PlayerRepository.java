package me.shaposhnikandrii.chess.repository;

import me.shaposhnikandrii.chess.model.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
  Player findTopByNick(String nick);
}