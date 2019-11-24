/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Matthieu
 */
public class Skill {
    private String name;
    private Statistic percent;
    private int damage;
    private int healthCost;
    private int magicPointCost;
    private int specialPointCost;
    
    public Skill(String name){
        this.name = name;
        this.percent = new Statistic(0,0,0,0,0,0,0);
        this.damage = 10;
        this.healthCost = 0;
        this.magicPointCost = 0;
        this.specialPointCost = 0;
    }
    
    public Skill(String name,Statistic percent, int damage, int healthCost, int magicPointCost, int specialPointCost){
        this.name = name;
        this.percent = percent;
        this.damage = damage;
        this.healthCost = healthCost;
        this.magicPointCost = magicPointCost;
        this.specialPointCost = specialPointCost;
    }
    
    public int calcDamage(Statistic stats){
        int calc = this.damage + this.percent.multiplicationAndAdd(stats);
        return calc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statistic getPercent() {
        return percent;
    }

    public void setPercent(Statistic percent) {
        this.percent = percent;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthCost() {
        return healthCost;
    }

    public void setHealthCost(int healthCost) {
        this.healthCost = healthCost;
    }

    public int getMagicPointCost() {
        return magicPointCost;
    }

    public void setMagicPointCost(int magicPointCost) {
        this.magicPointCost = magicPointCost;
    }

    public int getSpecialPointCost() {
        return specialPointCost;
    }

    public void setSpecialPointCost(int specialPointCost) {
        this.specialPointCost = specialPointCost;
    }
    
    public void display(){
        System.out.println(this.name);
    }
}
