package me.shaposhnikandrii.chess.util;

import lombok.experimental.UtilityClass;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@UtilityClass
public class CustomCollectors {

  //todo: change to specific case
  public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(Collectors.toList(), list -> {
          if (list.size() != 1)
            throw new IllegalStateException();

          return list.get(0);
        }
    );
  }

}
