package com.wearefrancis.aiplayer.controller;

import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToRead;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToWrite;
import com.wearefrancis.aiplayer.dto.params.PageParams;
import com.wearefrancis.aiplayer.dto.util.PageableFactory;
import com.wearefrancis.aiplayer.exception.NotFoundException;
import com.wearefrancis.aiplayer.services.AiPlayerService;
import static com.wearefrancis.aiplayer.Path.API_PATH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(API_PATH + "/players")
public class AiPlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AiPlayerController.class);

    private AiPlayerService aiPlayerService;

    public AiPlayerController(@Autowired AiPlayerService aiPlayerService) {
        this.aiPlayerService = aiPlayerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AiPlayerDTOToRead create(@Validated @RequestBody AiPlayerDTOToWrite aiPlayerToReadDTO) {
        LOGGER.debug("REST request to create ai player : {}", aiPlayerToReadDTO);
        return aiPlayerService.create(aiPlayerToReadDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws NotFoundException {
        LOGGER.debug("REST request to delete ai player : {}", id);
        aiPlayerService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AiPlayerDTOToRead> getAll(@Valid PageParams pageParams) {
        LOGGER.debug("REST request to find all ai players");
        Pageable pageable = PageableFactory.getPage(pageParams);
        return aiPlayerService.getAll(pageable);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AiPlayerDTOToRead getById(@PathVariable("id") String id) throws NotFoundException {
        LOGGER.debug("REST request to find ai player by id : {}", id);
        return aiPlayerService.getById(id);
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AiPlayerDTOToRead getByName(@PathVariable("name") String name) throws NotFoundException {
        LOGGER.debug("REST request to find ai player by name : {}", name);
        return aiPlayerService.getByName(name);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AiPlayerDTOToRead update(
            @PathVariable("id") String id,
            @Validated @RequestBody AiPlayerDTOToWrite aiPlayerDTOToWrite
    ) throws NotFoundException {
        LOGGER.debug("REST request to update ai player : {}", aiPlayerDTOToWrite);
        return aiPlayerService.update(id, aiPlayerDTOToWrite);
    }
}