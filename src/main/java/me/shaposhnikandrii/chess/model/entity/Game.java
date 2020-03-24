package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.shaposhnikandrii.chess.model.enums.GameStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity
public class Game {
  @Id
  private Long id;

  @Column
  @Enumerated(EnumType.STRING)
  private GameStatus gameStatus;

  @NotNull
  private Player white;

  @NotNull
  private Player black;

  private List<Move> moves;
}