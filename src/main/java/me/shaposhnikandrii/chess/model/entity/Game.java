package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.shaposhnikandrii.chess.model.Board;
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

  @Transient
  private Board board;

  @Column
  @Enumerated(EnumType.STRING)
  private GameStatus gameStatus;

  @NotNull
  @OneToOne
  @JoinColumn(name = "white_player_id")
  private Player white;

  @NotNull
  @OneToOne
  @JoinColumn(name = "black_player_id")
  private Player black;

  @OneToMany(mappedBy = "game")
  private List<Move> moves;
}