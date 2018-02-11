package com.wearefrancis.checkersmanager.dto.entity;

import com.wearefrancis.checkersmanager.dto.DTO;
import lombok.Getter;

@Getter
public enum CaseDTO implements DTO {
    EMPTY('0', " "),
    BLACK_PIECE('1', "o"),
    BLACK_QUEEN('2', "O"),
    WHITE_PIECE('3', "x"),
    WHITE_QUEEN('4', "X");


    // ATTRIBUTES

    private final char value;
    private final String abstraction;

    // CONSTRUCTOR

    CaseDTO(char value, String abstraction) {
        this.value = value;
        this.abstraction = abstraction;
    }

    // REQUESTS

    @Override
    public String toString() {
        return abstraction;
    }
}
