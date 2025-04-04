package com.develhope.leagueoflegends.enumeration;

public enum ChampionRole {
    ASSASSIN("Assassin", 10L, 2L, true),
    TANK("Tank", 2L, 10L, true),
    MAGE("Mage", 6L, 5L, true),
    SUPPORT("Support", 3L, 4L, true),
    MARKSMAN("Marksman", 5L, 5L, true),
    FIGHTER("Fighter", 8L, 4L, false);

    private final String description;
    private final Long attack;
    private final Long defence;
    private final boolean active;

    ChampionRole(String description, Long attack, Long defence, boolean active) {
        this.description = description;
        this.attack = attack;
        this.defence = defence;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }
}