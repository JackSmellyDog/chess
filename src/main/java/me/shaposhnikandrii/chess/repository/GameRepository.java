package me.shaposhnikandrii.chess.repository;

import me.shaposhnikandrii.chess.model.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}