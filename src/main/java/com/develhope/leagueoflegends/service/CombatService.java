package com.develhope.leagueoflegends.service;

import com.develhope.leagueoflegends.entity.Champion;

import java.util.List;
import java.util.Optional;

public interface CombatService {

    List<Champion> simulateCombat(Long attacker_id, Long defender_id);
    Long calculateDamage(Champion attacker, Champion defender);
    Long calculateExperienceGain(Champion attacker, Champion defender);

}
