package com.wearefrancis.checkersmanager.domain;

import lombok.Data;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@javax.persistence.Entity
public class CheckersGame extends AbstractEntity implements Entity {
    @NotNull
    @Size(min=1)
    private String name;
    @NotNull
    @Size(min = 50, max = 50)
    private String board;
    @NotNull
    @ManyToOne
    private Player player1;
    @NotNull
    @ManyToOne
    private Player player2;
    @NotNull
    @ManyToOne
    private Player turnPlayer;
    @ManyToOne
    private Player winner;
}
