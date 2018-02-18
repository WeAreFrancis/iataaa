package com.wearefrancis.checkersmanager.service;

import com.wearefrancis.checkersmanager.dto.entity.read.CreatedCheckersGameToReadDTO;
import com.wearefrancis.checkersmanager.dto.entity.write.CheckersGameToWriteDTO;

public interface CheckersService {
    CreatedCheckersGameToReadDTO create(
            CheckersGameToWriteDTO checkersGameToWriteDTO
    );
}
