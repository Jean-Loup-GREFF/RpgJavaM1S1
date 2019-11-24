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
     * Init chest
     *
     */
    public Chest(){
        super('c');
        this.inventory = new Inventory();
    }
    
    /**
     * init chest with an inventory
     *
     * @param inventory
     * take in input the inventory you want to put in the chest
     */
    public Chest(Inventory inventory){
        super('c');
        this.inventory = inventory;
    }
    
    /**
     * function to loot the inventory of a chest
     *
     * @param getter
     * object which will get the loot
     */
    public void open(Character getter){
        Looting.loot(this.inventory, getter);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * set the inventry of an existing chest object
     *
     * @param inventory
     * the inventory you want to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public String getSaveText(){
        
        String save = "";
        save += this.inventory.getSaveTextInv()+ ",";
        return save+super.getDisplay();
    }

    /**
     * Initition of chest with a string initited by a text file
     *
     * @param save
     * the string table with all text to init a chest
     */
    public void InitFromSave(String[] save){
        
        this.inventory.InitFromSave(save[0].split("$"));
        super.InitFromSave(save[1]);
        
    }
}
