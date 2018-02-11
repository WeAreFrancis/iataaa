package com.wearefrancis.checkersmanager.dto.entity.read;

import com.wearefrancis.checkersmanager.dto.entity.CheckersBoardDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CheckersGameToReadDTO extends AbstractEntityToReadDTO {
    @NotNull
    private boolean beginGame;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    private CheckersBoardDTO board;
    @NotNull
    private PlayerToReadDTO player1;
    @NotNull
    private PlayerToReadDTO player2;
    @NotNull
    private PlayerToReadDTO turnPlayer;
    private PlayerToReadDTO winner;
}
