/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.Set;

/**
 *
 * @author Matthieu
 */
public class Player extends Character implements DealsDamage{
    private int exp;
    private int expM;
    private ClassArchetype archetype;

    public Player(String name){
        super(name);
        this.exp = 0;
        this.expM = 0;
        this.archetype = new ClasslessClass();
    }
    
    public Player(int exp, int expM, ClassArchetype archetype, String name, int level, int health, int healthM, Statistic stats, Inventory inventory, boolean isAlive, char display) {
        super(name, level, health, healthM, stats, inventory, isAlive,display);
        this.exp = exp;
        this.expM = expM;
        this.archetype = archetype;
        super.setStats(this.archetype.getStatsGrow());
        
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpM() {
        return expM;
    }

    public void setExpM(int expM) {
        this.expM = expM;
    }

    public ClassArchetype getArchetype() {
        return archetype;
    }

    public void setArchetype(ClassArchetype archetype) {
        this.archetype = archetype;
    }

    public int levelUp(){
        int level = super.getLevel();
        if(this.exp >= level*10){
            this.setExp(this.exp - level*10);
            super.setLevel(level + 1);
            super.setStats(super.getStats().add(this.archetype.getStatsGrow()));
        }
        this.levelUp();
        return 0;
    }
    
}
