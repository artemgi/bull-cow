package com.example.bullcow.repositories;

import com.example.bullcow.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    List<Games> findByUser_id(Long user_id);
}
