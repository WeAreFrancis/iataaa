package com.wearefrancis.aiplayer.repository;

import com.wearefrancis.aiplayer.domain.AiPlayer;
import com.wearefrancis.aiplayer.domain.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiPlayerRepository extends PagingAndSortingRepository<AiPlayer, String> {
    AiPlayer findByName(String name);
}
