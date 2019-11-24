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
public interface DealsDamage {

    /**
     * function to deal damage to another object
     *
     * @param damageDealt
     * @param target
     */
    static void dealsDamage(int damageDealt, AppOnMap target){
        int damage = damageDealt - target.getStats().getVitality();
        target.setHealth(target.getHealth()-damage);
        target.setIsAlive(target.getHealth()>0);
    }
}
