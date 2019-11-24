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
public class Mob extends Character implements Looting{
    
    private int exp;

    /**
     * method toinitializa a mob
     *
     */
    public Mob(){
        super("Mob",'m');
        this.exp = 1;
    }
    
    /**
     * method to initialize a mob object with all parameters
     *
     * @param name
     * @param level
     * @param health
     * @param healthM
     * @param stats
     * @param inventory
     * @param isAlive
     * @param display
     * @param exp
     */
    public Mob(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display,
          int exp){
        super(name,level,health,healthM,stats,inventory,isAlive,display);
        this.exp = exp;
    }
    
    /**
     * method to give the rewards when you defeat an other object 
     *
     * @param winner
     */
    public void defeat(Player winner){
        winner.setExp(winner.getExp() + this.exp);
        Looting.loot(super.getInventory(), winner);
        System.out.println(winner.getName() + " wins " + this.exp + " Exp(s)");
    }
    
    public void speak(){
        System.out.println("Kill!");
    }

    @Override
    public int getExp() {
        return exp;
    }

    /**
     * method to set the exp won when you defeat an object
     *
     * @param exp
     */
    public void setExp(int exp) {
        this.exp = exp;
    }
    
    @Override
    public String getSaveText(){
        
        String save = "";
        save = super.getSaveText();
        save += this.exp;
        
        return save;
    }
    @Override
    public void InitFromSave(String[] save){
        super.InitFromSave(save[0]);
        this.exp = Integer.parseInt(save[1]);
        
    }
}
