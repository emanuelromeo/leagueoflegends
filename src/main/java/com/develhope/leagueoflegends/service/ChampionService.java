package com.develhope.leagueoflegends.service;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    /**
     * Saves the given champion in the database
     * @param champion
     * @return the saved champion
     */
    public Champion saveChampion(Champion champion) {
        Champion savedChampion = championRepository.save(champion);
        return savedChampion;
    }

    /**
     * Finds all champions
     * @return the list of found champions
     */
    public List<Champion> findAllChampions() {
        List<Champion> champions = championRepository.findAll();
        return champions;
    }
}
