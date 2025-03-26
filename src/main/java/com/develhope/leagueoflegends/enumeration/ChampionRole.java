package com.develhope.leagueoflegends.enumeration;

public enum ChampionRole {
    ASSASSIN("Assassin", 10L, 2L),
    TANK("Tank", 2L, 10L),
    MAGE("Mage", 6L, 5L),
    SUPPORT("Support", 3L, 4L),
    MARKSMAN("Marksman", 5L, 5L),
    FIGHTER("Fighter", 8L, 4L);

    private final String description;
    private final Long attack;
    private final Long defence;

    ChampionRole(String description, Long attack, Long defence) {
        this.description = description;
        this.attack = attack;
        this.defence = defence;
    }

    public String getDescription() {
        return description;
    }

    public Long getAttack() {
        return attack;
    }

    public Long getDefence() {
        return defence;
    }
}