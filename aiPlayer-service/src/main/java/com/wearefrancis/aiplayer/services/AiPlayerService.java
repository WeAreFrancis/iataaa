package com.wearefrancis.aiplayer.services;

import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToRead;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToWrite;
import com.wearefrancis.aiplayer.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AiPlayerService {

    AiPlayerDTOToRead create(AiPlayerDTOToWrite aiPlayerDTOToWrite);
    void delete(String id) throws NotFoundException;
    Page<AiPlayerDTOToRead> getAll(Pageable pageable);
    AiPlayerDTOToRead getById(String id) throws NotFoundException;
    AiPlayerDTOToRead getByName(String name) throws NotFoundException;
    AiPlayerDTOToRead update(String id, AiPlayerDTOToWrite aiPlayerDTOToWrite) throws NotFoundException;
}
