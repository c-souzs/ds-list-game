package com.souzs.ds_list_game.repositories;

import com.souzs.ds_list_game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying // Metodos diferente do GET deve ter essa annotation
    @Query(nativeQuery = true, value = "" +
            "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

    @Modifying
    @Query(nativeQuery = true, value = "" +
            "INSERT INTO tb_belonging (list_id, game_id, position) VALUES (:listId, :gameId, :position);")
    void insertNewGameInPosition(Long listId, Long gameId, Integer position);

    @Modifying
    @Query(nativeQuery = true, value = "" +
            "DELETE tb_belonging WHERE game_id = :gameId AND list_id = :listId")
    void removeGame(Long listId, Long gameId);

    @Query(nativeQuery = true, value = "SELECT position FROM tb_belonging WHERE list_id = :listId AND game_id = :gameId")
    Integer getPositionGame(Long listId, Long gameId);

    @Query(nativeQuery = true, value = "SELECT list_id FROM tb_belonging WHERE game_id = :gameId")
    List<Long> getListsIdsByGameId(Long gameId);
}
