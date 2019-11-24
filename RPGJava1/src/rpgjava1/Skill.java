/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */
public class Skill {
    private String name;
    private Statistic percent;
    private int damage;
    private int healthCost;
    private int magicPointCost;
    private int specialPointCost;
    
    /**
     * method to init a skill object with a name
     *
     * @param name
     */
    public Skill(String name){
        this.name = name;
        this.percent = new Statistic(0,0,0,0,0,0,0);
        this.damage = 10;
        this.healthCost = 0;
        this.magicPointCost = 0;
        this.specialPointCost = 0;
    }
    
    /**
     * method to init a skill with all the parameters
     *
     * @param name
     * @param percent
     * @param damage
     * @param healthCost
     * @param magicPointCost
     * @param specialPointCost
     */
    public Skill(String name,Statistic percent, int damage, int healthCost, int magicPointCost, int specialPointCost){
        this.name = name;
        this.percent = percent;
        this.damage = damage;
        this.healthCost = healthCost;
        this.magicPointCost = magicPointCost;
        this.specialPointCost = specialPointCost;
    }
    
    /**
     * method to calculate the damage of a skills object thanks to stats
     *
     * @param stats
     * @return
     */
    public int calcDamage(Statistic stats){
        int calc = this.damage + this.percent.multiplicationAndAdd(stats);
        return calc;
    }

    /**
     * method to get the name of a skill
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the name of a skill
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the percentage multiplicative (for a stat) of a skill
     *
     * @return
     */
    public Statistic getPercent() {
        return percent;
    }

    /**
     * method to set the the percentage multiplicative (for a stat) of a skill
     *
     * @param percent
     */
    public void setPercent(Statistic percent) {
        this.percent = percent;
    }

    /**
     * method to get the damage inflicted by the skill
     *
     * @return
     */
    public int getDamage() {
        return damage;
    }

    /**
     * method to set the damage inflicted by the skill
     *
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * method to get the health cost of a skill object
     *
     * @return
     */
    public int getHealthCost() {
        return healthCost;
    }

    /**
     * method to set the health cost of a skill object
     *
     * @param healthCost
     */
    public void setHealthCost(int healthCost) {
        this.healthCost = healthCost;
    }

    /**
     * method to get the magic point cost of an object skill
     *
     * @return
     */
    public int getMagicPointCost() {
        return magicPointCost;
    }

    /**
     * method to set the magic point cost of an object skill
     *
     * @param magicPointCost
     */
    public void setMagicPointCost(int magicPointCost) {
        this.magicPointCost = magicPointCost;
    }

    /**
     * method to get the special point cost of an object skill
     *
     * @return
     */
    public int getSpecialPointCost() {
        return specialPointCost;
    }

    /**
     * method to set the special point cost of an object skill
     *
     * @param specialPointCost
     */
    public void setSpecialPointCost(int specialPointCost) {
        this.specialPointCost = specialPointCost;
    }
    
    /**
     * method to display skill on the screen
     *
     */
    public void display(){
        System.out.println(this.name);
    }
}
