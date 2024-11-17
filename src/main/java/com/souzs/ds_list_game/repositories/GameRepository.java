package com.souzs.ds_list_game.repositories;

import com.souzs.ds_list_game.entities.Game;
import com.souzs.ds_list_game.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Responsavel por fazer consultas ao banco
public interface GameRepository  extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM tb_belonging WHERE game_id = :gameId")
	void deleteGameBelonging(Long gameId);
}
