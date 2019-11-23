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
public class Merchant extends Character implements Looting{
    private double tariffSell;
    private double tariffBuy;
    public Merchant(){
        super("Merchant");
        this.tariffBuy = 0.1;
        this.tariffSell = 1.2;
    }
    public Merchant(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display,
          int tariffSell, int tariffBuy){
        super(name,level,health,healthM,stats,inventory,isAlive,display);
        this.tariffBuy = tariffBuy;
        this.tariffSell = tariffSell;
    }
    public void buy(Inventory seller, Inventory trade){
        super.getInventory().setGold(super.getInventory().getGold() + trade.getGold());
        Looting.commerce(seller, trade, super.getInventory());
    }
    public void sell(Inventory trade, Inventory buyer){
        Looting.commerce(super.getInventory(), trade, buyer);
    }

    public double getTariffSell() {
        return tariffSell;
    }

    public void setTariffSell(double tariffSell) {
        this.tariffSell = tariffSell;
    }

    public double getTariffBuy() {
        return tariffBuy;
    }

    public void setTariffBuy(double tariffBuy) {
        this.tariffBuy = tariffBuy;
    }
    
}
