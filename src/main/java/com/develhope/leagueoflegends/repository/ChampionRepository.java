package com.develhope.leagueoflegends.repository;

import com.develhope.leagueoflegends.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {
}
