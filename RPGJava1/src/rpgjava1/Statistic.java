/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Jean-Loup
 */
public class Statistic {
    private int strenght;
    private int vitality;
    private int dexterity;
    private int agility;
    private int intelligence;
    private int wisdom;
    private int luck;

    public Statistic(){
        this.strenght = 1;
        this.vitality = 1;
        this.dexterity = 1;
        this.agility = 1;
        this.intelligence = 1;
        this.wisdom = 1;
        this.luck = 100;
    }

    public Statistic(int strenght, int vitality, int dexterity, int agility, int intelligence, int wisdom, int luck) {
        this.strenght = strenght;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.agility = agility;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.luck = luck;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getVitality() {
        return vitality;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getLuck() {
        return luck;
    }
    
    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
    
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
    
    public Statistic add(Statistic stats){
        this.agility+=stats.getAgility();
        this.dexterity=stats.getDexterity(); 
        this.intelligence+=stats.getIntelligence(); 
        this.strenght+=stats.getStrenght(); 
        this.vitality+=stats.getVitality(); 
        this.wisdom+=stats.getWisdom();
        return this;
    }
    
    public void InitFromSaveStat(String[] save){
        this.strenght = Integer.parseInt(save[0]);
        this.vitality = Integer.parseInt(save[1]);
        this.dexterity = Integer.parseInt(save[2]);
        this.agility = Integer.parseInt(save[3]);
        this.intelligence = Integer.parseInt(save[4]);
        this.wisdom = Integer.parseInt(save[5]);
        this.luck = Integer.parseInt(save[6]);
        
    }
    
    public String getSaveTextStat (){
        String save = "";
        save += this.strenght + "/" + this.vitality + "/" + this.dexterity + "/"
                + this.agility + "/" + this.intelligence + "/" + this.wisdom
                + "/" + this.luck + "/";
        return save;
    
   
    
    
    }
}
