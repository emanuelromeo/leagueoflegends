package com.develhope.leagueoflegends.entity;

import com.develhope.leagueoflegends.enumeration.ChampionRole;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    private LocalDate releaseDate;

    public Champion() {
    }

    public Champion(Long id, String name, ChampionRole role, Integer difficulty, String region, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.difficulty = difficulty;
        this.region = region;
        this.releaseDate = releaseDate;
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
}
