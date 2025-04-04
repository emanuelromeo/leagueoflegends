package com.develhope.leagueoflegends.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "damage")
    private Long damage;

    @Column(name = "manaRequired")
    private Long manaRequired;

    @ManyToOne
    @JoinColumn(name = "champion_id")
    private Champion champion;


    //Constructors

    public Ability(){}

    public Ability(Long id, String name, Long damage, Long manaRequired, Champion champion) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.manaRequired = manaRequired;
        this.champion = champion;
    }

    //Getters and Setters

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

    public Long getDamage() {
        return damage;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
    }

    public Long getManaRequired() {
        return manaRequired;
    }

    public void setManaRequired(Long manaRequired) {
        this.manaRequired = manaRequired;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }
}
