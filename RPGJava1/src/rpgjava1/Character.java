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
public class Character extends AppOnMap implements DealsDamage{
    private String name;
    private int level;
    private int health;
    private int healthM;
    private int strenght;
    private int vitality;
    private int dextirity;
    private int agility;
    private int intelligence;
    private Inventory inventory;
    private boolean isAlive;

    public Character(String name){
        super();
        this.name = name;
        this.level = 1;
        this.health = 10;
        this.healthM = 10;
        this.strenght = 2;
        this.vitality = 1;
        this.dextirity = 1;
        this.agility = 1;
        this.intelligence = 1;
        this.inventory = new Inventory();
        this.isAlive = true;
    }
    
    public Character(String name, int level, int health, int healthM, int strenght, int vitality, int dextirity, int agility, int intelligence, Inventory inventory, boolean isAlive, char display) {
        super(display);
        this.name = name;
        this.level = level;
        this.health = health;
        this.healthM = healthM;
        this.strenght = strenght;
        this.vitality = vitality;
        this.dextirity = dextirity;
        this.agility = agility;
        this.intelligence = intelligence;
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

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getDextirity() {
        return dextirity;
    }

    public void setDextirity(int dextirity) {
        this.dextirity = dextirity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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
    
    public void defence(int damage){
        this.health -= damage;
        this.isAlive = this.health <= 0;
    }
    
    public void speak(){
        System.out.println(this.name+":blabla");
    }
    
}
