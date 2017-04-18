package com.wearefrancis.aiplayer.dto.mapper;

import com.wearefrancis.aiplayer.domain.AiPlayer;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToRead;
import com.wearefrancis.aiplayer.dto.entity.AiPlayerDTOToWrite;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class AiPlayerMapper {

    private AiPlayerMapper() {
    }

    public static AiPlayer writeDTOToModel(AiPlayerDTOToWrite aiPlayerDTOToWrite) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<AiPlayerDTOToWrite, AiPlayer> boundMapper =
                mapperFactory.getMapperFacade(AiPlayerDTOToWrite.class, AiPlayer.class);

        AiPlayer player = boundMapper.map(aiPlayerDTOToWrite);
        return player;
    }

    public static AiPlayer readDTOToModel(AiPlayerDTOToRead aiPlayerDTOToRead) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<AiPlayerDTOToRead, AiPlayer> boundMapper =
                mapperFactory.getMapperFacade(AiPlayerDTOToRead.class, AiPlayer.class);

        AiPlayer player = boundMapper.map(aiPlayerDTOToRead);
        return player;
    }

    public static AiPlayerDTOToRead modelToReadDTO(AiPlayer player) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<AiPlayer, AiPlayerDTOToRead> boundMapper =
                mapperFactory.getMapperFacade(AiPlayer.class, AiPlayerDTOToRead.class);

        AiPlayerDTOToRead aiPlayerDTOToRead = boundMapper.map(player);
        return aiPlayerDTOToRead;
    }
}
