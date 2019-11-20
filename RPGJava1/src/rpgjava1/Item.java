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
public class Item {
    private String name;
    private Rarity rarity;
    private int price;
    private Statistic stats;
    private String description;

    public Item() {
        this.name = "";
        this.rarity = Rarity.COMMUN;
        this.price = 0;
        this.stats = new Statistic();
    }
    
    public Item(String name, Rarity rarity, int price, Statistic stats, String description) {
        this.name = name;
        this.rarity = rarity;
        this.price = price;
        this.stats = stats;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Statistic getStats() {
        return stats;
    }

    public void setStats(Statistic stats) {
        this.stats = stats;
    }
    
    public void InitFromSaveIt (String[] save){
        this.name = save[0];
        switch (Integer.parseInt(save[1])){
            case 0:
                this.rarity = Rarity.COMMUN;
                break;
            case 1:
                this.rarity = Rarity.UNCOMMUN;
                break;
            case 2:
                this.rarity = Rarity.RARE;
                break;
            case 3:
                this.rarity = Rarity.EPIC;
                break;
            case 4:
                this.rarity = Rarity.LEGENDARY;
                break;
            case 5:
                this.rarity = Rarity.MYTIC;
                break;
            case 6:
                this.rarity = Rarity.GODLIKE;
                break;
        }
        this.price = Integer.parseInt(save[2]);
        this.stats.InitFromSaveStat(save[3].split("/"));
    }
    
    public String getSaveTextIt (){
        String save = "";
        save += this.name + "%";
        save += this.rarity + "%";
        save += this.price + "%";
        save += this.stats.getSaveTextStat() + "%";
        save += this.description;
        
        return save;
        
    }
}
