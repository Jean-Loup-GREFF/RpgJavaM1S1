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
        super.setStats(new Statistic(999,999,1,1,1,1,100));
    }
    public Merchant(String name, int level, int health, int healthM, 
          Statistic stats, Inventory inventory, boolean isAlive, char display,
          int tariffSell, int tariffBuy){
        super(name,level,health,healthM,stats,inventory,isAlive,display);
        this.tariffBuy = tariffBuy;
        this.tariffSell = tariffSell;
        super.setStats(new Statistic(999,999,1,1,1,1,100));
    }
    public void buy(Inventory seller, Inventory trade){
        trade.setGold((int)(this.tariffBuy * trade.getGold()));
        super.getInventory().setGold(super.getInventory().getGold() + trade.getGold());
        Looting.commerce(seller, trade, super.getInventory());
    }
    public void sell(Inventory trade, Inventory buyer){
        trade.setGold((int)(this.tariffSell * trade.getGold()));
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
    
    public String getSaveText(){
        
        String save = "";
        save = super.getSaveText();
        save += this.tariffBuy;
        save += this.tariffSell;
        
        return save;
    }
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
