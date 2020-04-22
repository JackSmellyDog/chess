package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.shaposhnikandrii.chess.model.Board;
import me.shaposhnikandrii.chess.model.enums.Color;
import me.shaposhnikandrii.chess.model.enums.GameStatus;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity
@DynamicUpdate
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Transient
  private Board board;

  @Transient
  private Move lastMove;

  @Column
  @Enumerated(EnumType.STRING)
  private GameStatus gameStatus;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "white_player_id")
  private Player white;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "black_player_id")
  private Player black;

  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
  private List<Move> moves = new ArrayList<>();

  public Move getLastMove() {
    return lastMove;
  }

  public Move writeMoveDown(Move move) {
    lastMove = move;
    moves.add(move);

    return move;
  }

  public Color whoseTurn() {
    return moves.size() % 2 == 0 ? Color.WHITE : Color.BLACK;
  }

  public boolean isOver() {
    return gameStatus != GameStatus.ACTIVE;
  }
}