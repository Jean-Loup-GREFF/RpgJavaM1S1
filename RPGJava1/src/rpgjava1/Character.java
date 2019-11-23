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
 * @author Matthieu
 */
public class Character extends AppOnMap implements DealsDamage{
    private String name;
    private int level;
    private int health;
    private int healthM;
    private Statistic stats;
    private Inventory inventory;
    private boolean isAlive;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthM() {
        return healthM;
    }

    public void setHealthM(int healthM) {
        this.healthM = healthM;
    }

    public Statistic getStats() {
        return stats;
    }

    public void setStats(Statistic stats) {
        this.stats = stats;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public void attack(Character target){
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
    public void InitFromSave(String[] save){
        this.name = save[0];
        this.level = Integer.parseInt(save[1]);
        this.health = Integer.parseInt(save[2]);
        this.healthM = Integer.parseInt(save[3]);
        this.stats.InitFromSaveStat(save[4].split("/"));
        
        //int len = save[5].split("$").length;
        //if (len == 1){
        //    this.inventory.InitInventory(Integer.parseInt(""+save[5].charAt(1)));
        //}
        //else{
        this.inventory.InitFromSave(save[5].split("$"));
        //}
        
        this.isAlive = Boolean.parseBoolean(save[6]);
        super.InitFromSave(save[7]);
        
    }
}
