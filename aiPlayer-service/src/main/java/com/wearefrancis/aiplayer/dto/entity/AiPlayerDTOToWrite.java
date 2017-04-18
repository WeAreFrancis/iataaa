package com.wearefrancis.aiplayer.dto.entity;

import com.wearefrancis.aiplayer.domain.util.Difficulty;
import com.wearefrancis.aiplayer.dto.DTO;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class AiPlayerDTOToWrite implements DTO {

    @NotNull
    private Difficulty difficulty;
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    @Pattern(
            regexp="^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$",
            message = "Invalid ip"
    )
    private String ip;
    @Min(1)
    @Max(65536)
    private int port;
    @Size(min = 1, max = 200)
    private String path;
}
