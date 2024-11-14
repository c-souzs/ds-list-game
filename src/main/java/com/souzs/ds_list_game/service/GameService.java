package com.souzs.ds_list_game.service;

// Implementa as regras de negocio ao realizar alguma acao

import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.entities.Game;
import com.souzs.ds_list_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Component tem a mesma funcao da annotation acima
public class GameService {
    // Injeta a dependencia de GameRepository na Game Service
    // pois a repository esta na camada abaixo.
    // Com isso podemos usar aqui na Service
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream().map(GameMinDTO::new).toList();
    }
}
