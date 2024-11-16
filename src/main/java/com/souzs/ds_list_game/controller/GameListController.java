package com.souzs.ds_list_game.controller;

import com.souzs.ds_list_game.dto.GameIdDTO;
import com.souzs.ds_list_game.dto.GameListDTO;
import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.dto.ReplacementDTO;
import com.souzs.ds_list_game.projections.GameMinProjection;
import com.souzs.ds_list_game.service.GameListService;
import com.souzs.ds_list_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/move")
    public List<GameMinProjection> move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        return gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

    @PostMapping(value = "/{listId}")
    public List<GameMinDTO> insertGame(@PathVariable Long listId, @RequestBody GameIdDTO body) {
        return gameListService.insertGame(listId, body.getGameId());
    }
}
