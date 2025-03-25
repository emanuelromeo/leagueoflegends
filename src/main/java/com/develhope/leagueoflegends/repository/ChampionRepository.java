package com.develhope.leagueoflegends.repository;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.enumeration.ChampionRole;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {
    List<Champion> findByRole (ChampionRole role);


}
