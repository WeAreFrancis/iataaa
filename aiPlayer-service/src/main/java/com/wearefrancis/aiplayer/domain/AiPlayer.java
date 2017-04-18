package com.wearefrancis.aiplayer.domain;

import com.wearefrancis.aiplayer.domain.util.Difficulty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@javax.persistence.Entity
public class AiPlayer extends Player {
    @NotNull
    private Difficulty difficulty;
}
