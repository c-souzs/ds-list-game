package com.souzs.ds_list_game.repositories;

import com.souzs.ds_list_game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// Responsavel por fazer consultas ao banco
public interface GameRepository  extends JpaRepository<Game, Long> {

}
