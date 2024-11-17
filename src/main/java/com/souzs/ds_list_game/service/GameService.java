package com.souzs.ds_list_game.service;

import com.souzs.ds_list_game.dto.GameDTO;
import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.entities.Game;
import com.souzs.ds_list_game.projections.GameMinProjection;
import com.souzs.ds_list_game.repositories.GameListRepository;
import com.souzs.ds_list_game.repositories.GameRepository;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private GameListRepository gameListRepository;

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

    @Transactional
    public GameDTO createGame(GameDTO gameDTO) {
        Game createGame = new Game(gameDTO);
        gameRepository.save(createGame);

        return new GameDTO(createGame);
    }

    @Transactional
    public Long deleteGame(Long gameId) {
        List<Long> listsIds = gameListRepository.getListsIdsByGameId(gameId);

        listsIds.forEach(listId -> {
            List<GameMinProjection> list = gameRepository.searchByList(listId);
            int positionGameRemove = gameListRepository.getPositionGame(listId, gameId);
            list.remove(positionGameRemove);

            for (int i = positionGameRemove; i <= list.size() - 1; i++) {
                gameListRepository.updateBelongingPosition(
                        listId,
                        list.get(i).getId(),
                        i
                );
            }
        });

        gameRepository.deleteGameBelonging(gameId);
        gameRepository.deleteById(gameId);

        return gameId;
    }

    @Transactional
    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        Game updateGame = gameRepository.findById(id).get();

        updateGame.setTitle(gameDTO.getTitle());
        updateGame.setYear(gameDTO.getYear());
        updateGame.setGenre(gameDTO.getGenre());
        updateGame.setPlatforms(gameDTO.getPlatforms());
        updateGame.setScore(gameDTO.getScore());
        updateGame.setImgUrl(gameDTO.getImgUrl());
        updateGame.setShortDescription(gameDTO.getShortDescription());
        updateGame.setLongDescription(gameDTO.getLongDescription());


        return new GameDTO(updateGame);
    }
}
