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

    @PostMapping("/create")
    public ResponseEntity<Champion> createChampion(@RequestBody Champion champion) {
        Champion savedChampion = championService.saveChampion(champion);
        return ResponseEntity.ok(savedChampion);
    }

    @GetMapping("/find-all")
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

}
