package com.wearefrancis.checkersmanager.dto.entity.write;

import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class HumanPlayerToWriteDTO implements DTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
