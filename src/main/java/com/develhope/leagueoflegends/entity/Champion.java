package com.develhope.leagueoflegends.entity;

import com.develhope.leagueoflegends.enumeration.ChampionRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "champions")
public class Champion {

    private final Long startingLevel = 1L;
    private final Long startingExperience = 0L;
    private final Long startingAbilityPower = 1L;

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
    private Long level = startingLevel;

    @Column(name = "experience")
    private Long experience = startingExperience;

    @Column(name = "health")
    private Long health;

    @Column(name = "mana")
    private Long mana;

    @Column(name = "base_damage")
    private Long baseDamage;

    @Column(name = "ability_power")
    private Long abilityPower = startingAbilityPower;

    public Champion() {
    }

    public Champion(Long id, String name, ChampionRole role, Integer difficulty, String region, LocalDate releaseDate, Long health, Long mana, Long baseDamage) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.difficulty = difficulty;
        this.region = region;
        this.releaseDate = releaseDate;
        this.health = health;
        this.mana = mana;
        this.baseDamage = baseDamage;
    }

    // Progression System

    public void gainExperience(int exp) {

        if (exp > 0) {
            experience += exp;
            System.out.println(name + " gained " + exp + " exp points!");
        }

        System.out.println("No exp points gained");
    }

    public void levelUp() {

        level += 1;
        System.out.println(name + " leveled up!");

    }

    public Long calculateExpToNextLevel() {

        Long requiredExp = (long) (10 * Math.pow(level, 2));
        System.out.println(name + " needs " + requiredExp + " exp points to level up");

        return requiredExp;

    }

    public void updateStats(Long health, Long mana, Long baseDamage, Long abilityPower) {

        this.health += health;
        this.mana += mana;
        this.baseDamage += baseDamage;
        this.abilityPower += abilityPower;

        System.out.println(name + " stats increased");

    }


    // Getter and Setter

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
}
