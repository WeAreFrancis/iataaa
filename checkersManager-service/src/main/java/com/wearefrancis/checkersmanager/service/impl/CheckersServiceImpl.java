package com.wearefrancis.checkersmanager.service.impl;

import com.wearefrancis.checkersmanager.domain.AiPlayer;
import com.wearefrancis.checkersmanager.domain.CheckersGame;
import com.wearefrancis.checkersmanager.domain.Player;
import com.wearefrancis.checkersmanager.dto.entity.CheckersBoardDTO;
import com.wearefrancis.checkersmanager.dto.entity.Token;
import com.wearefrancis.checkersmanager.dto.entity.read.CheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import com.wearefrancis.checkersmanager.repository.CheckersRepository;
import com.wearefrancis.checkersmanager.service.CheckersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckersServiceImpl implements CheckersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckersServiceImpl.class);
    private CheckersRepository checkersRepository;

    public CheckersServiceImpl(@Autowired CheckersRepository checkersRepository) {
        this.checkersRepository = checkersRepository;
    }

    @Transactional
    public CreatedCheckersGameToReadDTO create(
            CheckersGameToWriteDTO checkersGameToWriteDTO
    ) {
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

        LOGGER.info("Checkers game is created : {}", game);

        CheckersGame savedGame = checkersRepository.save(game);

        CheckersGameToReadDTO checkersGameToReadDTO = new CheckersGameToReadDTO();
        CheckersBoardDTO checkersBoardDTO = new CheckersBoardDTO();
        checkersGameToReadDTO.setBoard(checkersBoardDTO);
        Token playerToken = new Token();
        playerToken.setToken(savedGame.getPlayer1().getToken());

        CreatedCheckersGameToReadDTO createdGameDTO = new CreatedCheckersGameToReadDTO();
        createdGameDTO.setCheckersGame(checkersGameToReadDTO);
        createdGameDTO.setPlayerToken(playerToken);

        return createdGameDTO;
    }

}
