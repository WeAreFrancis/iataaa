package com.wearefrancis.checkersmanager.domain;

import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class AiPlayer extends Player implements Entity {

    @NotNull
    private Difficulty difficulty;
}
