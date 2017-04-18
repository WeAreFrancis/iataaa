package com.wearefrancis.aiplayer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception implements RestException {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

    public NotFoundException(String propertyName, String propertyValue, String entityName) {
        super(entityName + " entity with " + propertyValue + " " + propertyName + " is not found");
        LOGGER.info("{} entity with {} {} is not found", entityName, propertyValue, propertyName);
    }
}
