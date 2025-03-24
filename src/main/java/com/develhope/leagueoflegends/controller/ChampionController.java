package com.develhope.leagueoflegends.controller;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/champions")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @PostMapping
    public ResponseEntity<Champion> createChampion(@RequestBody Champion champion) {
        Champion savedChampion = championService.saveChampion(champion);
        return ResponseEntity.ok(savedChampion);
    }

    @GetMapping
    public ResponseEntity<List<Champion>> getAllChampions() {
        List<Champion> champions = championService.findAllChampions();
        return ResponseEntity.ok(champions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Champion> updateChampion(@PathVariable Long id, @RequestBody Champion updatedChampion) {
        Optional<Champion> champion = championService.updateChampion(id, updatedChampion);

        if (champion.isPresent()) {
            return ResponseEntity.ok(champion.get());
        }

        return ResponseEntity.notFound().build();
    }

}
