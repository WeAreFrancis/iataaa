package com.wearefrancis.checkersmanager.dto.entity;

import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BoardDTO<T> implements DTO {
    @NotNull
    private T cases[];
}
