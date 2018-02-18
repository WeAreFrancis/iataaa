package com.wearefrancis.checkersmanager.service.impl;

import com.wearefrancis.checkersmanager.domain.AiPlayer;
import com.wearefrancis.checkersmanager.domain.CheckersGame;
import com.wearefrancis.checkersmanager.domain.Difficulty;
import com.wearefrancis.checkersmanager.domain.Player;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import com.wearefrancis.checkersmanager.repository.CheckersRepository;
import com.wearefrancis.checkersmanager.service.CheckersService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

public class CheckersServiceTest {

    private CheckersRepository checkersRepository;
    private CheckersService checkersService;

    @Before
    public void setUp() {
        checkersRepository = mock(CheckersRepository.class);
        checkersService = new CheckersServiceImpl(checkersRepository);
    }

    @Test
    public void createGameShouldReturnEntity() throws Exception {
        // GIVEN
        CheckersGameToWriteDTO checkersGameToWriteDTO = new CheckersGameToWriteDTO();
        checkersGameToWriteDTO.setDifficulty(Difficulty.EASY);
        checkersGameToWriteDTO.setGameName("game1");
        checkersGameToWriteDTO.setPlayerName("player1");

        Player player1 = new Player();
        player1.setName(checkersGameToWriteDTO.getPlayerName());
        AiPlayer player2 = new AiPlayer();
        player2.setName("Artificial Intelligence");
        player2.setDifficulty(checkersGameToWriteDTO.getDifficulty());

        CheckersGame game = new CheckersGame();
        game.setBoard("00000000000000000000000000000000000000000000000000");
        game.setName(checkersGameToWriteDTO.getGameName());
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setTurnPlayer(player1);

        // WHEN
        when(checkersRepository.save(any())).thenReturn(game);
        CreatedCheckersGameToReadDTO createdGameDTO = checkersService.create(checkersGameToWriteDTO);

        // THEN
        assertThat(createdGameDTO).isNotNull();
    }

    public void test() throws Exception {
        // GIVEN
        // WHEN
        // THEN
    }
}
