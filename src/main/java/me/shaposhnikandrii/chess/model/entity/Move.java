package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity
public class Move {
  @Id
  private Long id;

  @Column(name = "game_move_number")
  private Integer gameMoveNumber;

  @NotNull
  @Column(name = "move_to", length = 8)
  private String moveTo;

  @NotNull
  @Column(name = "previous_position", length = 8)
  private String previousPosition;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  @NotNull
  @OneToOne
  @JoinColumn(name = "player_id")
  private Player player;

}