package me.shaposhnikandrii.chess.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity
public class Player {
  @Id
  private Long id;

  @Column(name = "nick")
  private String nick;




}