package dev.llw4h.games.service;

import dev.llw4h.games.model.Game;
import dev.llw4h.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> allGames(){
        return gameRepository.findAll();
    }

//    Optional<Game> - might return null if no id found
    @Override
    public Optional<Game> singleGame(String appId){
        return gameRepository.findGameByAppId(appId);
    }
}
