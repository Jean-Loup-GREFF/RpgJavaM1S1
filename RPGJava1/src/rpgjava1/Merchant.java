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
public class Merchant extends Character implements Looting{
    private double tariffSell;
    private double tariffBuy;
    
    /**
     * method to initialize a merchant class
     *
     */
    public Merchant(){
        super("Merchant", ' ');
        this.tariffBuy = 0.1;
        this.tariffSell = 1.2;
        super.setStats(new Statistic(999,999,1,1,1,1,100));
    }

    /**
     * method to initialize merchant class with all the different parameters
     *
     * @param name
     * @param level
     * @param health
     * @param healthM
     * @param stats
     * @param inventory
     * @param isAlive
     * @param display
     * @param tariffSell
     * @param tariffBuy
     */
    public Merchant(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display,
          double tariffSell, double tariffBuy){
        super(name,level,health,healthM,stats,inventory,isAlive,display);
        this.tariffBuy = tariffBuy;
        this.tariffSell = tariffSell;
        super.setStats(new Statistic(999,999,1,1,1,1,100));
    }
    @Override
    public void buy(Inventory seller, Inventory trade){
        trade.setGold((int)(this.tariffBuy * trade.getGold()));
        super.getInventory().setGold(
                super.getInventory().getGold() + trade.getGold());
        Looting.commerce(seller, trade, super.getInventory());
    }
    @Override
    public void sell(Inventory trade, Inventory buyer){
        trade.setGold((int)(this.tariffSell * trade.getGold()));
        Looting.commerce(super.getInventory(), trade, buyer);
    }

    /**
     * method to get the marge off of the sell to a merchant objet
     *
     * @return
     */
    public double getTariffSell() {
        return tariffSell;
    }

    /**
     * method to set the marge of the sell to a marchant objet
     *
     * @param tariffSell
     */
    public void setTariffSell(double tariffSell) {
        this.tariffSell = tariffSell;
    }

    /**
     * method to get the marge in of an item sold by a marchant object
     *
     * @return
     */
    public double getTariffBuy() {
        return tariffBuy;
    }

    /**
     * method set the marge in of an item sold by a marchant object
     *
     * @param tariffBuy
     */
    public void setTariffBuy(double tariffBuy) {
        this.tariffBuy = tariffBuy;
    }
    
    @Override
    public String getSaveText(){
        
        String save = "";
        save = super.getSaveText();
        save += this.tariffBuy;
        save += this.tariffSell;
        
        return save;
    }
    @Override
    public void InitFromSave(String[] save){
        super.InitFromSave(save[0]);
        this.tariffBuy = Double.parseDouble(save[1]);
        this.tariffSell = Double.parseDouble(save[2]);
        
    }

    @Override
    public void speak() {
        System.out.println(super.getName() + ":Hi! Welcome here~~!");
    }
    
}
