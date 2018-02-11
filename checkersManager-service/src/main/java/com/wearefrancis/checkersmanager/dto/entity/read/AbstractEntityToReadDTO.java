package com.wearefrancis.checkersmanager.dto.entity.read;

import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
abstract class AbstractEntityToReadDTO implements DTO {
    @NotNull
    private String id;
}
