package com.wearefrancis.checkersmanager.domain.mapper;

import com.wearefrancis.checkersmanager.domain.CheckersGame;
import com.wearefrancis.checkersmanager.domain.Difficulty;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckersGameMapperTest {

    @Test
    public void DTOToModelTest() {
        // GIVEN
        CheckersGameToWriteDTO checkersGameToWriteDTO = new CheckersGameToWriteDTO();
        checkersGameToWriteDTO.setPlayerName("player1");
        checkersGameToWriteDTO.setGameName("game1");
        checkersGameToWriteDTO.setDifficulty(Difficulty.EASY);
        // WHEN
        CheckersGame game = CheckersGameMapper.DTOToModel(checkersGameToWriteDTO);
        // THEN
        assertThat(game.getPlayer1().getName()).isEqualTo(checkersGameToWriteDTO.getPlayerName());
        assertThat(game.getPlayer1().getToken()).isNotEmpty();
        assertThat(game.getPlayer1().getId()).isNotEmpty();

        assertThat(game.getPlayer2().getName()).isNotEmpty();
        assertThat(game.getPlayer2().getToken()).isNotEmpty();
        assertThat(game.getPlayer2().getId()).isNotEmpty();
        assertThat(game.getPlayer2().getDifficulty()).isEqualTo(checkersGameToWriteDTO.getDifficulty());

//        assertThat(game.getBoard()).isEqualTo()
    }

    public void test() {
        // GIVEN
        // WHEN
        // THEN
    }
}
