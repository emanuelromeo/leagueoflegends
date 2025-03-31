package com.develhope.leagueoflegends.controller;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.enumeration.ChampionRole;
import com.develhope.leagueoflegends.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/champions")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @PostMapping("create")
    public ResponseEntity<Champion> createChampion(@RequestBody Champion champion) {
        Champion savedChampion = championService.saveChampion(champion);
        return ResponseEntity.ok(savedChampion);
    }

    @PostMapping("create-multiple")
    public ResponseEntity<List<Champion>> createMultipleChampions(@RequestBody List<Champion> champions) {
        List<Champion> championList = championService.saveMultipleChampions(champions);
        return ResponseEntity.ok(championList);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Champion>> getAllChampions() {
        List<Champion> champions = championService.findAllChampions();
        return ResponseEntity.ok(champions);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Champion> findChampionById(@PathVariable Long id) {
        Optional<Champion> optionalChampion = championService.findChampionById(id);

        if (optionalChampion.isPresent()) {
            return ResponseEntity.ok(optionalChampion.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Champion> updateChampion(@PathVariable Long id, @RequestBody Champion updatedChampion) {
        Optional<Champion> champion = championService.updateChampion(id, updatedChampion);

        if (champion.isPresent()) {
            return ResponseEntity.ok(champion.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity<String> deleteChampionById(@PathVariable Long id) {
        championService.deleteById(id);
        return ResponseEntity.ok("Champion Deleted");
    }

    @GetMapping("find-by-role")
    public ResponseEntity<List<Champion>> getChampionsByRole(@RequestParam ChampionRole role) {
        List<Champion> championList = championService.findByRole(role);
        return ResponseEntity.ok(championList);
    }

    /*
    List<Champion> findByDifficulty (int difficulty);

    List<Champion> findByRegion (String region);

    (LocalDate releaseDate);
     */

    @GetMapping("find-by-difficulty")
    public ResponseEntity<List<Champion>> findByDifficulty(@RequestParam int difficulty) {
        List<Champion> championList = championService.findByDifficulty(difficulty);
        return ResponseEntity.ok(championList);
    }

    @GetMapping("find-by-region")
    public ResponseEntity<List<Champion>> findByRegion(@RequestParam String region) {
        List<Champion> championList = championService.findByRegion(region);
        return ResponseEntity.ok(championList);
    }

    @GetMapping("find-by-releaseDate")
    public ResponseEntity<List<Champion>> findByReleaseDate(@RequestParam LocalDate releaseDate) {
        List<Champion> championList = championService.findByReleaseDate(releaseDate);
        return ResponseEntity.ok(championList);
    }

    /**
     * Simulates an attack from the attacker to the defender and updates champions
     * letting defender take damage and attacker gain experience.
     *
     * @param attacker_id
     * @param defender_id
     * @return the list of updated champions, or an empty list if champions not found.
     */
    @PutMapping("/simulate-combat")
    public ResponseEntity<List<Champion>> simulateCombat(
            @RequestParam Long attacker_id,
            @RequestParam Long defender_id) {

        List<Champion> champions = championService.simulateCombat(attacker_id, defender_id);

        if (champions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(champions);

    }

}