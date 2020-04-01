package me.shaposhnikandrii.chess.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.entity.Player;
import me.shaposhnikandrii.chess.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {
  private final PlayerRepository playerRepository;

  public Player getPlayer(String nick, boolean isExists) {
    return isExists ? loadByNick(nick) : createPlayer(nick);
  }


  // todo: change random nick generation
  private Player createPlayer(String nick) {
    final String finalNickname = nick != null && !nick.isEmpty()
        ? nick
        : "Player" + UUID.randomUUID().toString().replaceAll("\\D", "");

    return new Player()
        .setNick(finalNickname);
  }


  private Player loadByNick(String nick) {
    return playerRepository.findTopByNick(nick);
  }

}