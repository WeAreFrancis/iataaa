package com.wearefrancis.checkersmanager.repository;

import com.wearefrancis.checkersmanager.domain.CheckersGame;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckersRepository extends PagingAndSortingRepository<CheckersGame, String> {
    Optional<CheckersGame> findById(String id);
}
