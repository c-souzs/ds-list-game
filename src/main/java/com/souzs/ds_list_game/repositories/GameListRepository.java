package com.souzs.ds_list_game.repositories;

import com.souzs.ds_list_game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying // Metodos diferente do GET deve ter essa annotation
    @Query(nativeQuery = true, value = "" +
            "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
