package com.wearefrancis.checkersmanager.dto.entity.read;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PlayerToReadDTO extends AbstractEntityToReadDTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
