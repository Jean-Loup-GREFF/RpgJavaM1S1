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
public class Trap extends AppOnMap implements DealsDamage{
    private int damage;
    private boolean hide;
    
    public Trap(){
        super('+');
        this.damage = 10;
        this.hide = true;
    }
    public Trap(int damage, boolean hide){
        super('+');
        this.damage = damage;
        this.hide = hide;
    }
    public void traps(Character target){
        DealsDamage.dealsDamage(this.damage, target);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }
    
}
