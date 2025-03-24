package com.develhope.leagueoflegends.enumeration;

public enum ChampionRole {
    ASSASSIN("Assassin"),
    TANK("Tank"),
    MAGE("Mage"),
    SUPPORT("Support"),
    MARKSMAN("Marksman"),
    FIGHTER("Fighter");

    private final String description;

    ChampionRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}