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
public class Chest extends AppOnMap implements Looting{
    private Inventory inventory;
    
    public Chest(){
        super('c');
        this.inventory = new Inventory();
    }
    
    public Chest(Inventory inventory){
        super('c');
        this.inventory = inventory;
    }
    
    public void open(Character getter){
        Looting.loot(this.inventory, getter);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
}
