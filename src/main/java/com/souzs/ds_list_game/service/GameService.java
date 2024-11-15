package com.souzs.ds_list_game.service;

import com.souzs.ds_list_game.dto.GameDTO;
import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.entities.Game;
import com.souzs.ds_list_game.projections.GameMinProjection;
import com.souzs.ds_list_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// Implementa as regras de negocio ao realizar alguma acao

@Service
// @Component tem a mesma funcao da annotation acima
public class GameService {
    // Injeta a dependencia de GameRepository na Game Service
    // pois a repository esta na camada abaixo.
    // Com isso podemos usar aqui na Service
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Nenhuma operacao de escrita
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        return result.stream().map(GameMinDTO::new).toList();
    }
}
