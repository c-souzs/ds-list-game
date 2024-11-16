package com.souzs.ds_list_game.controller;

// Implementa a API e a deixa disponivel para o externo
// Front chama a controller -> Service -> Repository -> BD

import com.souzs.ds_list_game.dto.GameDTO;
import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.entities.Game;
import com.souzs.ds_list_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    // Tambem injenta uma dependencia
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return  gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO body) {
        return gameService.createGame(body);
    }
}
