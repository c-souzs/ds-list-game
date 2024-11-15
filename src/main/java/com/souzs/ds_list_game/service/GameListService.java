package com.souzs.ds_list_game.service;

import com.souzs.ds_list_game.dto.GameListDTO;
import com.souzs.ds_list_game.entities.GameList;
import com.souzs.ds_list_game.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(GameListDTO::new).toList();
    }
}
