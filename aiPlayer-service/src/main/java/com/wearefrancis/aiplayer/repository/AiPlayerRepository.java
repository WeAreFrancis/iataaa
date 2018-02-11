package com.wearefrancis.aiplayer.repository;

import com.wearefrancis.aiplayer.domain.AiPlayer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AiPlayerRepository extends PagingAndSortingRepository<AiPlayer, String> {
    AiPlayer findByName(String name);

    Optional<AiPlayer> findById(String id);
}
