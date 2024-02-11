package dev.llw4h.games.service;

import dev.llw4h.games.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<Game> allGames();
    Optional<Game> singleGame(String appId);
}
