/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */

public class AppOnMap {
    // This class is a mother class which help to get the display aspect
    // for the display map and also give acces to the method (by override)
    // for the gestion of interraction
    
    private char display;
    
    /**
     *
     * @param display
     */
    public AppOnMap(char display){
        this.display = display;
    }
    
    /**
     *
     */
    public AppOnMap(){
        this.display = ' ';
    }
    
    /**
     * method to display on map
     *
     * @return
     */
    public char getDisplay(){
        return this.display;
    }

    /**
     *
     * @param display
     */
    public void setDisplay(char display) {
        this.display = display;
    }
    
    /**
     * As it name imply init AppOnMap element from a text format String
     *
     * @param Save
     */
    public void InitFromSave(String Save){
        this.display = Save.charAt(0);
    }
    
    /**
     * As it name imply get Save element in a text format String
     *
     * @return
     */
    public String getSaveText(){
        return ""+this.display;
    }

    /**
     * method to override for speaking aspect
     *
     * @param target
     * @param keyboard
     */
    public void attack(AppOnMap target, Scanner keyboard){}

    /**
     * method to override for getting Exp aspect
     */
    public void speak(){}

    /**
     * method to override for setting aspect
     *
     * @return
     */
    public int getExp() {return 0;}

    /**
     * method to override for setting exp aspect
     */
    public void setExp() {}

    /**
     * method to override for getting expMax (exp nexessary for lvl up) aspect
     *
     * @return
     */
    public int getExpM() {return 0;}

    /**
     * method to override for setting exp Max aspect
     */
    public void setExpM() {}

    /**
     * method to override for leveling up aspect
     *
     * @return
     */
    public int levelUp(){return 0;}

    /**
     *  method to override for checking if the object is alive
     *
     * @return
     */
    public boolean isIsAlive() {return true;}
    
    /**
     *  method to override for defeating aspect
     *
     * @param winner
     */
    public void defeat(AppOnMap winner){}
    
    /**
     * method to override for buying aspect
     *
     * @param seller
     * @param trade
     */
    public void buy(Inventory seller, Inventory trade){}
    
    /**
     * method to override for selling aspect
     *
     * @param trade
     * @param buyer
     */
    public void sell(Inventory trade, Inventory buyer){}
    
    /**
     * method to override for getting status aspect
     *
     * @return
     */
    public Statistic getStats() {return null;}
    
    /**
     * method to override for getting Health
     *
     * @return
     */
    public int getHealth() {return 0;}
    
    /**
     * method to override for getting Name aspect
     *
     * @return
     */
    public String getName() {return "";}

    /**
     * method to override for dealing damage by traps aspect
     *
     * @param target
     */
    public void traps(AppOnMap target){}

    /**
     * method to override for getting the damage to dealt aspect
     *
     * @return
     */
    public int getDamage() {return 0;}

    /**
     * method to override for setting damage aspect
     *
     * @param damage
     */
    public void setDamage(int damage) {}

    /**
     * method to override for the hidding aspect of a trap
     *
     * @return
     */
    public boolean isHide() {return true;}

    /**
     * method to override for the hidding aspect of a trap
     *
     * @param hide
     */
    public void setHide(boolean hide) {}
    
    /**
     * method to override for setting Health aspect
     *
     * @param health
     */
    public void setHealth(int health) {}
    
    /**
     * method to override for setting the alive aspect
     *
     * @param isAlive
     */
    public void setIsAlive(boolean isAlive) {}
    
    /**
     * method to override for the opening chest aspect
     *
     * @param getter
     */
    public void open(AppOnMap getter){}
    
    /**
     * method to override for getting inventory aspect
     *
     * @return
     */
    public Inventory getInventory() {return null;}
    
    /**
     * method to override for setting one peice of equipment aspect
     *
     * @param piece
     * @param position
     */
    public void setOnePiece(int piece, int position){}
    
    /**
     * method to override for getting the equipment aspect
     *
     * @return
     */
    public int[] getEquipment() {return null;}
   
    /**
     * method to set exp
     *
     * @param exp
     */
    public void setExp(int exp){}
    
    
}
