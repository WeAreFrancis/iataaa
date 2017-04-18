package com.wearefrancis.aiplayer.dto.entity;

import com.wearefrancis.aiplayer.dto.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class EntityDTO implements DTO {
    @NotNull
    private String id;
}
