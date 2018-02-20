package com.wearefrancis.checkersmanager.service.impl;

import com.wearefrancis.checkersmanager.domain.CheckersGame;
import com.wearefrancis.checkersmanager.domain.mapper.CheckersGameMapper;
import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;
import com.wearefrancis.checkersmanager.repository.CheckersRepository;
import com.wearefrancis.checkersmanager.service.CheckersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckersServiceImpl implements CheckersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckersServiceImpl.class);
    private CheckersRepository checkersRepository;

    public CheckersServiceImpl(@Autowired CheckersRepository checkersRepository) {
        this.checkersRepository = checkersRepository;
    }

    @Transactional
    public CreatedCheckersGameToReadDTO create(
            CheckersGameToWriteDTO checkersGameToWriteDTO
    ) {
        CheckersGame game = CheckersGameMapper.DTOToModel(checkersGameToWriteDTO);
        LOGGER.info("Checkers game is created : {}", game);
        CheckersGame savedGame = checkersRepository.save(game);
        return CheckersGameMapper.ModelToDTO(savedGame);
    }

}
