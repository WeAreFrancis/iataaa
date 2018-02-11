package com.wearefrancis.checkersmanager.dto.entity;

import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Token implements DTO {
    @NotNull
    @Size(min = 1, max = 200)
    private String token;
}
