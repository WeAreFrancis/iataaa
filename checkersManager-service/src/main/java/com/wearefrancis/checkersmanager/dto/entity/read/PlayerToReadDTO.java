package com.wearefrancis.checkersmanager.dto.entity.read;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PlayerToReadDTO extends AbstractEntityToReadDTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
