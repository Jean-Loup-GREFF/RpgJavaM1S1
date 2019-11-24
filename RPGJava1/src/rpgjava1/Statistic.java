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
public class Statistic {
    private int strenght;
    private int vitality;
    private int dexterity;
    private int agility;
    private int intelligence;
    private int wisdom;
    private int luck;

    /**
     * method to init a statistic object
     *
     */
    public Statistic(){
        this.strenght = 1;
        this.vitality = 1;
        this.dexterity = 1;
        this.agility = 1;
        this.intelligence = 1;
        this.wisdom = 1;
        this.luck = 100;
    }

    /**
     * method to init a statistic object with all parameters
     *
     * @param strenght
     * @param vitality
     * @param dexterity
     * @param agility
     * @param intelligence
     * @param wisdom
     * @param luck
     */
    public Statistic(int strenght, int vitality, int dexterity, int agility,
            int intelligence, int wisdom, int luck) {
        this.strenght = strenght;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.agility = agility;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.luck = luck;
    }

    /**
     * method to get the strenght stat
     *
     * @return
     */
    public int getStrenght() {
        return strenght;
    }

    /**
     * method to get the vitality stat
     *
     * @return
     */
    public int getVitality() {
        return vitality;
    }

    /**
     * method to get the dexterity stat
     *
     * @return
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * method to get the agility stat
     *
     * @return
     */
    public int getAgility() {
        return agility;
    }

    /**
     * method to get the intelligence stat
     *
     * @return
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * method to get the wisdom stat
     *
     * @return
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * method to get the luck stat
     *
     * @return
     */
    public int getLuck() {
        return luck;
    }
    
    /**
     * method to set the streght stat
     *
     * @param strenght
     */
    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    /**
     * method to set vitality
     *
     * @param vitality
     */
    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    /**
     * method to set the dexterity stat
     *
     * @param dexterity
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * method to set the agility stat
     *
     * @param agility
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * method to set the intelligence stat
     *
     * @param intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * method to set the wisdom stat
     *
     * @param wisdom
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * method to set the luck stat
     *
     * @param luck
     */
    public void setLuck(int luck) {
        this.luck = luck;
    }
    
    /**
     * method to multiply and add all stat for skill objects
     *
     * @param stats
     * @return
     */
    public int multiplicationAndAdd(Statistic stats){
        int calc = this.getAgility()*stats.getAgility() 
                + this.getDexterity()*stats.getDexterity() 
                + this.getIntelligence()*stats.getIntelligence() 
                + this.getLuck()*stats.getLuck() 
                + this.getStrenght()*stats.getStrenght() 
                + this.getVitality()*stats.getVitality() 
                + this.getWisdom()*stats.getWisdom();
        return calc;
    }
    
    /**
     * method to add statistics (mainly for lvl up)
     *
     * @param stats
     * @return
     */
    public Statistic add(Statistic stats){
        this.agility+=stats.getAgility();
        this.dexterity=stats.getDexterity(); 
        this.intelligence+=stats.getIntelligence(); 
        this.strenght+=stats.getStrenght(); 
        this.vitality+=stats.getVitality(); 
        this.wisdom+=stats.getWisdom();
        return this;
    }
    
    /**
     * method to init a statistic from a save
     *
     * @param save
     */
    public void InitFromSaveStat(String[] save){
        this.strenght = Integer.parseInt(save[0]);
        this.vitality = Integer.parseInt(save[1]);
        this.dexterity = Integer.parseInt(save[2]);
        this.agility = Integer.parseInt(save[3]);
        this.intelligence = Integer.parseInt(save[4]);
        this.wisdom = Integer.parseInt(save[5]);
        this.luck = Integer.parseInt(save[6]);
    }
    
    /**
     * method to get save text element from a stat object to save
     *
     * @return
     */
    public String getSaveTextStat (){
        String save = "";
        save += this.strenght + "/" + this.vitality + "/" + this.dexterity + "/"
                + this.agility + "/" + this.intelligence + "/" + this.wisdom
                + "/" + this.luck + "/";
        return save;
    }
    
    @Override
    public String toString(){
        String save = "";
        save += this.strenght + "\n" + this.vitality + "\n" + this.dexterity + 
                "\n" + this.agility + "\n" + this.intelligence + "\n" 
                + this.wisdom + "\n" + this.luck + "\n";
        return save;
    }
}
