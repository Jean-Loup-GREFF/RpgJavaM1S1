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
public class Trap extends AppOnMap implements DealsDamage{
    private int damage;
    private boolean hide;
    
    /**
     * method to init a trap object
     *
     */
    public Trap(){
        super('+');
        this.damage = 10;
        this.hide = true;
    }

    /**
     * init a trap element with all parameters
     *
     * @param damage
     * @param hide
     */
    public Trap(int damage, boolean hide){
        super('+');
        this.damage = damage;
        this.hide = hide;
    }
    
    /**
     * method to deal damage of a trap object
     *
     * @param target
     */
    @Override
    public void traps(AppOnMap target){
        System.out.println("You take " + this.damage + " damages.");
        DealsDamage.dealsDamage(this.damage, target);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    @Override
    public boolean isHide() {
        return hide;
    }

    @Override
    public void setHide(boolean hide) {
        this.hide = hide;
    }
    
    @Override
    public String getSaveText(){
        
        String save = "";
        save += this.hide + ",";
        save += this.damage + ",";
        
        return save + super.getSaveText();
    }
    
    /**
     * method to init a trap object from a save text
     *
     * @param save
     */
    public void InitFromSave(String[] save){
        super.InitFromSave(save[2]);
        this.hide = Boolean.parseBoolean(save[0]);
        this.damage = Integer.parseInt(save[1]);
        
    }
}
