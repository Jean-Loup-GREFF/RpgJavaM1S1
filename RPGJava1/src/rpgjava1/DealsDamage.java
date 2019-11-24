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
public interface DealsDamage {
    static void dealsDamage(int damageDealt, AppOnMap target){
        int damage = damageDealt - target.getStats().getVitality();
        target.setHealth(target.getHealth()-damage);
        target.setIsAlive(target.getHealth()>0);
    }
}
