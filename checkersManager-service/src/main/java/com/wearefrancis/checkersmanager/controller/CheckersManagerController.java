package com.wearefrancis.checkersmanager.controller;

import com.wearefrancis.checkersmanager.dto.entity.CheckersBoardDTO;
import com.wearefrancis.checkersmanager.dto.entity.Token;
import com.wearefrancis.checkersmanager.dto.entity.read.CheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.HumanPlayerToWriteDTO;
import com.wearefrancis.checkersmanager.dto.params.PageParams;
import com.wearefrancis.checkersmanager.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.wearefrancis.checkersmanager.Path.API_PATH;

@RestController
@RequestMapping(API_PATH + "/checkers")
public class CheckersManagerController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCheckersGameToReadDTO create(
            @Valid CheckersGameToWriteDTO checkersGameToWriteDTO,
            @Valid HumanPlayerToWriteDTO humanPlayerToWriteDTO
    ) {
        return new CreatedCheckersGameToReadDTO();
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
