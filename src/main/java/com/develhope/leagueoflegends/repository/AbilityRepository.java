package com.develhope.leagueoflegends.repository;

import com.develhope.leagueoflegends.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability,Long> {
}
