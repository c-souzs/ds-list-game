package com.souzs.ds_list_game.repositories;

import com.souzs.ds_list_game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
