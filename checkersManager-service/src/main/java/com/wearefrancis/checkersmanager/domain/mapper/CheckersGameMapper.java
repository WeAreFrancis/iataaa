package com.wearefrancis.checkersmanager.domain.mapper;

import com.wearefrancis.checkersmanager.domain.AiPlayer;
import com.wearefrancis.checkersmanager.domain.CheckersGame;
import com.wearefrancis.checkersmanager.domain.Player;
import com.wearefrancis.checkersmanager.dto.entity.CheckersBoardDTO;
import com.wearefrancis.checkersmanager.dto.entity.Token;
import com.wearefrancis.checkersmanager.dto.entity.read.CheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;

public class CheckersGameMapper {

    CheckersGameMapper() {
    }

    public static CheckersGame DTOToModel(CheckersGameToWriteDTO checkersGameToWriteDTO) {
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
        return game;
    }

    public static CreatedCheckersGameToReadDTO ModelToDTO(CheckersGame checkersGame) {
        CheckersGameToReadDTO checkersGameToReadDTO = new CheckersGameToReadDTO();
        CheckersBoardDTO checkersBoardDTO = new CheckersBoardDTO();
        checkersGameToReadDTO.setBoard(checkersBoardDTO);
        Token playerToken = new Token();
        playerToken.setToken(checkersGame.getPlayer1().getToken());

        CreatedCheckersGameToReadDTO createdGameDTO = new CreatedCheckersGameToReadDTO();
        createdGameDTO.setCheckersGame(checkersGameToReadDTO);
        createdGameDTO.setPlayerToken(playerToken);

        return createdGameDTO;
    }
}
