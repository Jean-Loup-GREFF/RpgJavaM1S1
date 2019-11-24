/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */
public class Character extends AppOnMap implements DealsDamage{
    private String name;
    private int level;
    private int health;
    private int healthM;
    private Statistic stats;
    private Inventory inventory;
    private boolean isAlive;

    /**
     * Init a character object with the name you want to give to it
     *
     * @param name
     * name you want to give to your character object
     */
    public Character(String name){
        super();
        this.name = name;
        this.level = 1;
        this.health = 10;
        this.healthM = 10;
        this.stats = new Statistic();
        this.inventory = new Inventory();
        this.isAlive = true;
    }
    
    /**
     * Init a character object with all the stats possible
     *
     * @param name
     * name of your character
     * @param level
     * level of your character
     * @param health
     * current health of your character
     * @param healthM
     * health max of your character
     * @param stats
     * stats of your character
     * @param inventory
     * inventory of your character
     * @param isAlive
     * if your character is alive or no
     * @param display
     * the kind of char you want to show on map for this character
     */
    public Character(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display) {
        super(display);
        this.name = name;
        this.level = level;
        this.health = health;
        this.healthM = healthM;
        this.stats = stats;
        this.inventory = inventory;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    /**
     * Set the name of a character
     *
     * @param name
     * name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the level of the character
     *
     * @return
     * the level as an int
     */
    public int getLevel() {
        return level;
    }

    /**
     * set the level of the character
     *
     * @param level
     * the level you want
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * function to get the health max
     *
     * @return
     * return the health in int form
     */
    public int getHealthM() {
        return healthM;
    }

    /**
     * set healthM of a character
     *
     * @param healthM
     * input int
     */
    public void setHealthM(int healthM) {
        this.healthM = healthM;
    }

    public Statistic getStats() {
        return stats;
    }

    /**
     * Set the stats of a character
     *
     * @param stats
     */
    public void setStats(Statistic stats) {
        this.stats = stats;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Set inventory of a character
     *
     * @param inventory
     * we put in parameter the inventory we want
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    /**
     * Method to define the attack and show something on the sreen
     *
     * @param target
     * the object you want to deal damage
     */
    public void attack(Character target){
        System.out.println(super.getName() + " attacks !");
        DealsDamage.dealsDamage(stats.getStrenght(),target);
    }
    
    public void speak(){
        System.out.println(this.name+":blabla");
    }
    
    public String getSaveText(){
        
        String save = "";
        save = save + this.name + ",";
        save += this.level + ",";
        save += this.health + ",";
        save += this.healthM + ",";
        save += this.stats.getSaveTextStat() + ",";
        save += this.inventory.getSaveTextInv()+ ",";
        save += this.isAlive + ",";
        return save+super.getDisplay();
    }

    /**
     * Init a character with the string table given in the init 
     *
     * @param save
     * elem in a string way which allow to init a character
     */
    public void InitFromSave(String[] save){
        
        this.name = save[0];
        
        this.level = Integer.parseInt(save[1]);
        
        this.health = Integer.parseInt(save[2]);
        
        this.healthM = Integer.parseInt(save[3]);
        
        this.stats.InitFromSaveStat(save[4].split("/"));
        
        this.inventory.InitFromSave(save[5].split("$"));
        
        this.isAlive = Boolean.parseBoolean(save[6]);
        
        super.InitFromSave(save[7]);
        
    }
}
