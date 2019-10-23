/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean-Loup
 */
public class Statistic {
    private int hp;
    private int mp;
    private int sp;
    private int strenght;
    private int vitality;
    private int dexterity;
    private int agility;
    private int intelligence;
    private int wisdom;
    private int luck;
    

    public Statistic(int hp, int mp, int sp, int strenght, int vitality, int dexterity, int agility, int intelligence, int wisdom, int luck) {
        this.hp = hp;
        this.mp = mp;
        this.sp = sp;
        this.strenght = strenght;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.agility = agility;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.luck = luck;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getSp() {
        return sp;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getVitality() {
        return vitality;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getLuck() {
        return luck;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
    
}
