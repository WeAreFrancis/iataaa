package com.wearefrancis.aiplayer.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Player extends Entity {

    public Player() {
        this.token = UUID.randomUUID().toString();
    }

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String token;
    @NotNull
    @NotEmpty
    private String ip;
    private int port;
    private String path;
}
