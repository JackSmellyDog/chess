package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity
public class Move {
  @Id
  private Long id;

  @Column(name = "move_number")
  private Integer moveNumber;

  @NotNull
  @Column(name = "to", length = 8)
  private String to;

  @NotNull
  @Column(name = "from", length = 8)
  private String from;

  @NotNull
  private Game game;

  @NotNull
  private Player player;

}