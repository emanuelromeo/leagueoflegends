package com.develhope.leagueoflegends.controller;

import com.develhope.leagueoflegends.entity.Ability;
import com.develhope.leagueoflegends.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abilities")
@CrossOrigin
public class AbilityController {

    @Autowired
    private AbilityService abilityService;

    @PostMapping("/create-ability")
    public ResponseEntity<Ability> createAbility(@RequestBody Ability ability) {
        Ability abilitySaved = abilityService.createAbility(ability);
        return ResponseEntity.ok(abilitySaved);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Ability>> findAll() {
        List<Ability> abilities = abilityService.findAllAbilities();
        return ResponseEntity.ok(abilities);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Ability> findAbilityById(@PathVariable Long id) {
        Optional<Ability> abilityOptional = abilityService.findAbilityById(id);

        if (abilityOptional.isPresent()) {
            return ResponseEntity.ok(abilityOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ability> updateChampion(@PathVariable Long id, @RequestBody Ability updatedAbility) {
        Optional<Ability> ability = abilityService.updateAbility(id, updatedAbility);

        if (ability.isPresent()) {
            return ResponseEntity.ok(ability.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-ability/{id}")
    public ResponseEntity<String> deleteteAbility(@PathVariable Long id) {
        abilityService.deleteAbility(id);
        return ResponseEntity.ok("Ability Deleted");
    }
}
