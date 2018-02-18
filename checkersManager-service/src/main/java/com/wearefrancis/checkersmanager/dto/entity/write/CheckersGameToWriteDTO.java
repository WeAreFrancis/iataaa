package com.wearefrancis.checkersmanager.dto.entity.write;

import com.wearefrancis.checkersmanager.domain.Difficulty;
import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CheckersGameToWriteDTO implements DTO {
    @NotNull
    private Difficulty difficulty;
    @NotNull
    @Size(min = 1, max = 50)
    private String gameName;
    @NotNull
    @Size(min = 1, max = 50)
    private String playerName;
}
