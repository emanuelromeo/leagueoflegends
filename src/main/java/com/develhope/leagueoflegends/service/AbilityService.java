package com.develhope.leagueoflegends.service;

import com.develhope.leagueoflegends.entity.Ability;
import com.develhope.leagueoflegends.entity.Champion;
import com.develhope.leagueoflegends.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

    /**
     * Add new ability to db
     * @param ability
     * @return ability saved
     */
    public Ability addAbility(Ability ability) {
        return abilityRepository.save(ability);
    }

    /**
     * Get List of Abilities
     * @return List of abilities
     */
    public List<Ability> getAllAbilities() {
        List<Ability> abilities = abilityRepository.findAll();
        return abilities;
    }

    /**
     * Get Ability by Id
     * @param id
     * @return the Ability find by Id
     */
    public Optional<Ability> findAbilityById(Long id) {
        Optional<Ability> abilityOptional = abilityRepository.findById(id);
        return abilityOptional;
    }

    /**
     * Updates the Ability with the given id with values from the given ability.
     * @param id
     * @param updatedAbility
     * @return an optional containing the updated ability or Optional.empty() if none found.
     */
    public Optional<Ability> updateAbility(Long id, Ability updatedAbility) {
        Optional<Ability> ability = abilityRepository.findById(id);

        if (ability.isPresent()) {

            ability.get().setName(updatedAbility.getName());
            ability.get().setDamage(updatedAbility.getDamage());
            ability.get().setManaRequired(updatedAbility.getManaRequired());
            ability.get().setChampion(updatedAbility.getChampion());

            Ability savedAbility = abilityRepository.save(ability.get());

            return Optional.of(savedAbility);
        }

        return Optional.empty();
    }

    /**
     * Delete ability By Id
     * @param id
     * @return "Ability Deleted" if present
     */
    public String deleteAbility(Long id) {
        if (abilityRepository.existsById(id)) {
            abilityRepository.deleteById(id);
            return "Ability Deleted";
        } else {
            return "Ability Not Found";
        }
    }

}
