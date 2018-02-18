package com.wearefrancis.checkersmanager.controller;

import com.wearefrancis.checkersmanager.dto.entity.CheckersBoardDTO;
import com.wearefrancis.checkersmanager.dto.entity.Token;
import com.wearefrancis.checkersmanager.dto.entity.read.CheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import com.wearefrancis.checkersmanager.dto.params.PageParams;
import com.wearefrancis.checkersmanager.exception.NotFoundException;
import com.wearefrancis.checkersmanager.service.CheckersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.wearefrancis.checkersmanager.Path.API_PATH;

@RestController
@RequestMapping(API_PATH + "/checkers")
public class CheckersManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckersManagerController.class);

    private CheckersService checkersService;

    public CheckersManagerController(@Autowired CheckersService checkersService) {
        this.checkersService = checkersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCheckersGameToReadDTO create(
            @RequestBody @Valid CheckersGameToWriteDTO checkersGameToWriteDTO
    ) {
        LOGGER.debug("REST request to create checkers game with : {}", checkersGameToWriteDTO);
        return checkersService.create(checkersGameToWriteDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CheckersGameToReadDTO> getAll(
            @Valid PageParams pageParams
    ) {
        return null;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckersGameToReadDTO getById(
            @PathVariable("id") String id
    ) throws NotFoundException {
        return new CheckersGameToReadDTO();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckersGameToReadDTO play(
            @PathVariable("id") String id,
            @Valid Token token,
            @Valid CheckersBoardDTO board
    ) throws NotFoundException {
        return null;
    }

    @PutMapping(value = "/surrender/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckersGameToReadDTO surrender(
            @PathVariable("id") String id,
            @Valid Token token
    ) throws NotFoundException {
        return null;
    }
}
