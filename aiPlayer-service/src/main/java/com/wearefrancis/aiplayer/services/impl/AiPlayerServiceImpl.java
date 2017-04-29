package com.wearefrancis.aiplayer.services.impl;

import com.wearefrancis.aiplayer.domain.AiPlayer;
import com.wearefrancis.aiplayer.domain.Player;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToRead;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToWrite;
import com.wearefrancis.aiplayer.dto.mapper.AiPlayerMapper;
import com.wearefrancis.aiplayer.exception.NotFoundException;
import com.wearefrancis.aiplayer.repository.AiPlayerRepository;
import com.wearefrancis.aiplayer.services.AiPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AiPlayerServiceImpl implements AiPlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AiPlayerServiceImpl.class);

    private AiPlayerRepository aiPlayerRepository;

    public AiPlayerServiceImpl(@Autowired AiPlayerRepository aiPlayerRepository) {
        this.aiPlayerRepository = aiPlayerRepository;
    }

    @Override
    public AiPlayerDTOToRead create(AiPlayerDTOToWrite aiPlayerDTOToWrite) {
        AiPlayer aiPlayer = AiPlayerMapper.writeDTOToModel(aiPlayerDTOToWrite);
        AiPlayer createdAiPlayer = aiPlayerRepository.save(aiPlayer);
        LOGGER.info("Player is created : {}", createdAiPlayer);
        return AiPlayerMapper.modelToReadDTO(createdAiPlayer);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        AiPlayer aiPlayer = Optional.ofNullable(aiPlayerRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException("id", id, "Player"));
        aiPlayerRepository.delete(id);
        LOGGER.info("Player is deleted : {}", aiPlayer);
    }

    @Override
    public Page<AiPlayerDTOToRead> getAll(Pageable pageable) {
        Page<AiPlayer> entitiesPage = aiPlayerRepository.findAll(pageable);
        LOGGER.info("Player is found all");
        List<AiPlayerDTOToRead> entitiesDTO = convertModelIterableToDTOList(entitiesPage.getContent());
        return new PageImpl<>(entitiesDTO, pageable, entitiesPage.getTotalElements());
    }

    @Override
    public AiPlayerDTOToRead getById(String playerId) throws NotFoundException {
        AiPlayer aiPlayer = Optional.ofNullable(aiPlayerRepository.findOne(playerId))
                .orElseThrow(() -> new NotFoundException("id", playerId, "Player"));
        LOGGER.info("Player is found : {}", aiPlayer);
        return AiPlayerMapper.modelToReadDTO(aiPlayer);
    }

    @Override
    public AiPlayerDTOToRead getByName(String name) throws NotFoundException {
        AiPlayerDTOToRead result;
        AiPlayer aiPlayer = Optional.ofNullable(aiPlayerRepository.findByName(name))
                .orElseThrow(() -> new NotFoundException("name", name, "Player"));
        LOGGER.info("Player is found : {}", aiPlayer);
        return AiPlayerMapper.modelToReadDTO(aiPlayer);
    }

    @Override
    public AiPlayerDTOToRead update(String playerId, AiPlayerDTOToWrite aiPlayerDTOToWrite) throws NotFoundException {
        AiPlayer player = aiPlayerRepository.findById(playerId)
                .orElseThrow(() -> new NotFoundException("id", playerId, "Player"));
        return save(player, aiPlayerDTOToWrite);
    }

    // PRIVATE

    private List<AiPlayerDTOToRead> convertModelIterableToDTOList(Iterable<AiPlayer> aiPlayers) {
        List<AiPlayerDTOToRead> dtos = new LinkedList<>();
        aiPlayers.forEach(aiPlayer -> {
            AiPlayerDTOToRead aiPlayerDTOToRead = AiPlayerMapper.modelToReadDTO(aiPlayer);
            dtos.add(aiPlayerDTOToRead);
        });
        return dtos;
    }

    private AiPlayerDTOToRead save(AiPlayer aiPlayer, AiPlayerDTOToWrite playerDTO) {
        aiPlayer.setDifficulty(playerDTO.getDifficulty());
        aiPlayer.setIp(playerDTO.getIp());
        aiPlayer.setName(playerDTO.getName());
        aiPlayer.setPath(playerDTO.getPath());
        aiPlayer.setPort(playerDTO.getPort());

        aiPlayerRepository.save(aiPlayer);
        LOGGER.info("Player is updated : {}", aiPlayer);
        return AiPlayerMapper.modelToReadDTO(aiPlayer);
    }
}