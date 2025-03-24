package com.develhope.leagueoflegends.controller;

import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
