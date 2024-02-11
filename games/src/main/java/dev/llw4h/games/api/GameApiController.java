package dev.llw4h.games.api;

import dev.llw4h.games.model.Game;
import dev.llw4h.games.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/games")
public class GameApiController {
    @Autowired
    private GameServiceImpl gameService;

    @GetMapping
//    REST API should return proper status codes
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<List<Game>>(gameService.allGames(), HttpStatus.OK);
    }

    @GetMapping("/{appId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable String appId){
        return new ResponseEntity<Optional<Game>>(gameService.singleGame(appId), HttpStatus.OK);
    }

}
