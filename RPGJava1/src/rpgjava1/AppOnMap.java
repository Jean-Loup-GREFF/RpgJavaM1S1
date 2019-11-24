/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;

/**
 *
 * @author Matthieu
 */
public class AppOnMap {
    private char display;
    
    public AppOnMap(char display){
        this.display = display;
    }
    
    public AppOnMap(){
        this.display = ' ';
    }
    
    public char getDisplay(){
        return this.display;
    }

    public void setDisplay(char display) {
        this.display = display;
    }
    
    public ArrayList<String> getDataSave(){
        ArrayList<String> PartSave;
        PartSave = new ArrayList<>();
        return PartSave;
    }
    
    public void InitFromSave(String Save){
        this.display = Save.charAt(0);
    }
    
    public String getSaveText(){
        return ""+this.display;
    }
    
    public void attack(AppOnMap target){}
    
    public void speak(){}
    
    public int getExp() {return 0;}

    public void setExp() {}
    
    public int getExpM() {return 0;}

    public void setExpM() {}
    
    public int levelUp(){return 0;}
    
    public boolean isIsAlive() {return true;}
    
    public void defeat(AppOnMap winner){}
    
    public void buy(Inventory seller, Inventory trade){}
    
    public void sell(Inventory trade, Inventory buyer){}
    
    public Statistic getStats() {return null;}
    
    public int getHealth() {return 0;}
    
    public String getName() {return null;}
    
    public void traps(AppOnMap target){}

    public int getDamage() {return 0;}

    public void setDamage(int damage) {}

    public boolean isHide() {return true;}

    public void setHide(boolean hide) {}
    
    public void setHealth(int health) {}
    
    public void setIsAlive(boolean isAlive) {}
    
    public void open(AppOnMap getter){}
    
    public Inventory getInventory() {return null;}
    
    public void setOnePiece(int piece, int position){}
    
    public int[] getEquipment() {return null;}
    
}
