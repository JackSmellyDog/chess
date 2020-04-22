package me.shaposhnikandrii.chess.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import me.shaposhnikandrii.chess.model.pieces.Piece;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class CustomCollectors {

  public static <T extends Piece> Collector<T, ?, Optional<T>> toSinglePieceOptional() {
    return Collectors.collectingAndThen(Collectors.toList(), list -> {
          if (list.size() != 1) {

            final String pieces = list.stream()
                .map(p -> String.format("Name: %s, position: %s", p.getShortName(), p.getPosition()))
                .collect(Collectors.joining(","));

            log.info("Too many or no pieces can move like that, size: {}. \n {}", list.size(), pieces);

            return Optional.empty();
          }

          return Optional.of(list.get(0));
        }
    );
  }

}
