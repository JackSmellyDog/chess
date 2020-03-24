package me.shaposhnikandrii.chess.repository;

import me.shaposhnikandrii.chess.model.entity.Move;
import org.springframework.data.repository.CrudRepository;

public interface MoveRepository extends CrudRepository<Move, Long> {
}