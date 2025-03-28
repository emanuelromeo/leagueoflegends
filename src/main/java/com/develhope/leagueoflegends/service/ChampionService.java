package com.develhope.leagueoflegends.service;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.enumeration.ChampionRole;
import com.develhope.leagueoflegends.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
     * Saves multiple champions in the database
     * @param champions
     * @return the list of champions
     */
    public List<Champion> saveMultipleChampions (List<Champion> champions) {
        List<Champion> championList = championRepository.saveAll(champions);
        return championList;
    }

    /**
     * Finds all champions
     * @return the list of found champions
     */
    public List<Champion> findAllChampions() {
        List<Champion> champions = championRepository.findAll();
        return champions;
    }

    public Optional<Champion> findChampionById(Long id) {
        Optional<Champion> optionalChampion = championRepository.findById(id);
        return optionalChampion;
    }


    /**
     * Updates the champion with the given id with values from the given champion.
     * @param id
     * @param updatedChampion
     * @return an optional containing the updated champion or Optional.empty() if none found.
     */
    public Optional<Champion> updateChampion(Long id, Champion updatedChampion) {
        Optional<Champion> champion = championRepository.findById(id);

        if (champion.isPresent()) {
            champion.get().setName(updatedChampion.getName());
            champion.get().setRole(updatedChampion.getRole());
            champion.get().setDifficulty(updatedChampion.getDifficulty());
            champion.get().setRegion(updatedChampion.getRegion());
            champion.get().setReleaseDate(updatedChampion.getReleaseDate());

            Champion savedChampion = championRepository.save(champion.get());
            return Optional.of(savedChampion);
        }

        return Optional.empty();
    }

    /**
     * Deletes a champion by its ID if it exists.
     * @param id
     * @return "Champion Deleted" if successful
     */
    public String deleteById(Long id) {
        if (championRepository.existsById(id)) {
            championRepository.deleteById(id);
            return "Champion Deleted";
        } else {
            return "Champion Not Found";
        }
    }

    /**
     * Finds all champions with the specified role.
     * @param role
     * @return a list of champions with the specified role, or an empty list if none are found
     */
    public List<Champion> findByRole (ChampionRole role) {
        List<Champion> championList = championRepository.findByRole(role);
        return championList;
    }

    /**
     * Finds all champions with the specified difficulty.
     * @param difficulty
     * @return a list of champions with the specified difficulty, or an empty list if none are found
     */
    public List<Champion> findByDifficulty (int difficulty) {
        List<Champion> championList = championRepository.findByDifficulty(difficulty);
        return championList;
    }

    /**
     * Finds all champions with the specified region.
     * @param region
     * @return a list of champions with the specified region, or an empty list if none are found
     */
    public List<Champion> findByRegion (String region) {
        List<Champion> championList = championRepository.findByRegion(region);
        return championList;
    }

    /**
     * Finds all champions with the specified releaseDate.
     * @param releaseDate
     * @return a list of champions with the specified releaseDate, or an empty list if none are found
     */
    public List<Champion> findByReleaseDate(LocalDate releaseDate) {
        List<Champion> championList = championRepository.findByReleaseDate(releaseDate);
        return championList;
    }
}
