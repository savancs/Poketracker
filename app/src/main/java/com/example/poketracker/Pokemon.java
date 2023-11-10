package com.example.poketracker;

public class Pokemon {
    String name;
    String gender;
    String species;
    int natnum;
    Float height;
    Float weight;
    int hp;
    int attack;
    int defense;

    public Pokemon(int natnum, String name, String species, String gender, Float height, Float weight, int hp, int attack, int defense){
        this.natnum = natnum;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.height = height;
        this.weight= weight;
        this.hp = hp;
        this.attack = attack;
        this.defense= defense;
    }
    public int getNum(){
        return natnum;
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public String getGender(){
        return gender;
    }
    public Float getHeight(){
        return height;
    }
    public Float getWeight(){
        return weight;
    }
    public int getHp(){
        return hp;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
}
