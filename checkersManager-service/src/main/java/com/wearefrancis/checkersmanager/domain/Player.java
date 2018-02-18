package com.wearefrancis.checkersmanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Player extends AbstractEntity implements Entity {

    public Player() {
        this.token = UUID.randomUUID().toString();
    }

    @NotNull
    @Size(min=1)
    private String name;
    @NotNull
    @Size(min=1)
    private String token;
}
