package com.develhope.leagueoflegends.entity;

import com.develhope.leagueoflegends.enumeration.ChampionRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "champions")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private ChampionRole role;

    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "region")
    private String region;

    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(name = "level")
    private Long level;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "health")
    private Long health;

    @Column(name = "mana")
    private Long mana;

    @Column(name = "base_damage")
    private Long baseDamage;

    @Column(name = "ability_power")
    private Long abilityPower;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "champion_id")
    private List<Ability> abilities;

    public Champion() {
    }

    public Champion(Long id, String name, ChampionRole role, Integer difficulty, String region, LocalDate releaseDate, Long level, Long experience, Long health, Long mana, Long baseDamage, Long abilityPower) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.difficulty = difficulty;
        this.region = region;
        this.releaseDate = releaseDate;
        this.level = level;
        this.experience = experience;
        this.health = health;
        this.mana = mana;
        this.baseDamage = baseDamage;
        this.abilityPower = abilityPower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChampionRole getRole() {
        return role;
    }

    public void setRole(ChampionRole role) {
        this.role = role;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }

    public Long getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(Long baseDamage) {
        this.baseDamage = baseDamage;
    }

    public Long getAbilityPower() {
        return abilityPower;
    }

    public void setAbilityPower(Long abilityPower) {
        this.abilityPower = abilityPower;
    }

    public Long calculateBaseDamage() {
        return this.baseDamage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;

    }

    public boolean isAlive() {
        if (health> 0) {
            return true;
        }

        return false;
    }

    public void addAbility (Ability ability) {
        this.abilities.add(ability);
    }

    public void removeAbility (Ability ability) {
        this.abilities.remove(ability);
    }

}
