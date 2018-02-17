package com.wearefrancis.checkersmanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Getter
@Setter
@javax.persistence.Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
abstract class AbstractEntity implements Entity {
    @Id
    private String id;

    AbstractEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
