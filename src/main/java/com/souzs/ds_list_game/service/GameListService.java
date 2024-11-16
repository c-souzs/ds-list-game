package com.souzs.ds_list_game.service;

import com.souzs.ds_list_game.dto.GameListDTO;
import com.souzs.ds_list_game.dto.GameMinDTO;
import com.souzs.ds_list_game.entities.GameList;
import com.souzs.ds_list_game.projections.GameMinProjection;
import com.souzs.ds_list_game.repositories.GameListRepository;
import com.souzs.ds_list_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public List<GameMinProjection> move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection sourceGame = list.remove(sourceIndex);
        list.add(destinationIndex, sourceGame);

        // Pega o intervalo da lista que vamos mover
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(
                    listId,
                    list.get(i).getId(), // Pega o id do game que vamos mover
                    i // A nova posicao do game que vamos mover
            );
        }

        return list;
    }

    @Transactional
    public List<GameMinDTO> insertGame(Long listId, Long gameId) {
        int position = gameRepository.searchByList(listId).size() - 1;

        gameListRepository.insertNewGameInPosition(listId, gameId, position);

        return gameRepository.searchByList(listId).stream().map(GameMinDTO::new).toList();
    }
}
