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
public class Mob extends Character implements Looting{
    private int exp;
    public Mob(){
        super("Mob");
        this.exp = 1;
    }
    public Mob(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display, int exp){
        super(name,level,health,healthM,stats,inventory,isAlive,display);
        this.exp = exp;
    }
    public void defeat(Player winner){
        winner.setExp(winner.getExp() + this.exp);
        Looting.loot(super.getInventory(), winner);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
}
