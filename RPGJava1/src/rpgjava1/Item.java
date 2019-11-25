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
public class Item {
    private String name;
    private Rarity rarity;
    private int price;
    private Statistic stats;
    private String description;

    /**
     * method to initialize an item object
     *
     */
    public Item() {
        this.name = "";
        this.rarity = Rarity.COMMUN;
        this.price = 0;
        this.stats = new Statistic();
    }
    
    /**
     * method to initialize an item object with all the parameters
     *
     * @param name
     * @param rarity
     * @param price
     * @param stats
     * @param description
     */
    public Item(String name, Rarity rarity, int price, Statistic stats,
            String description) {
        this.name = name;
        this.rarity = rarity;
        this.price = price;
        this.stats = stats;
        this.description = description;
    }

    /**
     * method to get the name of an item object
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the name of an item object
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get the rarity of an item object
     *
     * @return
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * method to set the rarity of an item object
     *
     * @param rarity
     */
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    /**
     * method to get the price of an item object
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * method to set the price of an item object
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * method to get the stats of an item object
     *
     * @return
     */
    public Statistic getStats() {
        return stats;
    }

    /**
     * method to set the stats of an item object
     *
     * @param stats
     */
    public void setStats(Statistic stats) {
        this.stats = stats;
    }

    /**
     * method to get the description of an item object
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * method to set the description of an item object
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * method to init an item object from the string given by the init save land
     *
     * @param save
     */
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
        this.description = save[4];
    }
    
    /**
     * method to get the string in order to create the strings to
     * save of an item object
     *
     * @return
     */
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
