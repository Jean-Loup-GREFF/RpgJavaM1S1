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
public class Chest extends AppOnMap implements Looting{
    private Inventory inventory;
    
    /**
     *
     */
    public Chest(){
        super('c');
        this.inventory = new Inventory();
    }
    
    /**
     *
     * @param inventory
     */
    public Chest(Inventory inventory){
        super('c');
        this.inventory = inventory;
    }
    
    /**
     *
     * @param getter
     */
    public void open(Character getter){
        Looting.loot(this.inventory, getter);
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @param inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getSaveText(){
        
        String save = "";
        save += this.inventory.getSaveTextInv()+ ",";
        return save+super.getDisplay();
    }

    /**
     *
     * @param save
     */
    public void InitFromSave(String[] save){
        
        this.inventory.InitFromSave(save[0].split("$"));
        super.InitFromSave(save[1]);
        
    }
}
