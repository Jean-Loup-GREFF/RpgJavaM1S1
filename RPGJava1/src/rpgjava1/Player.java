/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.Scanner;

/**
 *
 * @author Matthieu
 */
public class Player extends Character implements DealsDamage{
    private int exp;
    private int expM;
    private ClassArchetype archetype;
    //weapon, head, torso, pant, gauntlets, amulet, ri,g
    private int[] equipment;

    public Player(String name){
        super(name);
        this.exp = 0;
        this.expM = 0;
        this.archetype = new ClasslessClass();
        int[] tmp = {-1,-1,-1,-1,-1,-1,-1};
        this.equipment = tmp;
    }
    
    public Player(int exp, int expM, ClassArchetype archetype, String name, 
       int level, int health, int healthM, Statistic stats, Inventory inventory,
       boolean isAlive, char display, int[] equipment) {
        super(name, level, health, healthM, stats, inventory, isAlive, display);
        this.exp = exp;
        this.expM = expM;
        this.archetype = archetype;
        this.equipment = equipment;
        super.setStats(this.archetype.getStatsGrow());
        
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpM() {
        return expM;
    }

    public void setExpM(int expM) {
        this.expM = expM;
    }

    public ClassArchetype getArchetype() {
        return archetype;
    }

    public void setArchetype(ClassArchetype archetype) {
        this.archetype = archetype;
    }

    public int[] getEquipment() {
        return equipment;
    }

    public void setEquipment(int[] equipment) {
        this.equipment = equipment;
    }

    public int levelUp(){
        int level = super.getLevel();
        if(this.exp >= level*10){
            this.setExp(this.exp - level*10);
            super.setLevel(level + 1);
            super.setStats(super.getStats().add(this.archetype.getStatsGrow()));
        }
        this.levelUp();
        return 0;
    }
    
    public void setOnePiece(int piece, int position){
        this.equipment[piece] = position;
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void attack(Character target){
        Scanner keyboard = new Scanner(System.in);
        String choice = "";
        boolean use = false;
        //System.out.println("Press A");
        /*while(!use){
            /*if(KeyPressing.isAPress()){
                System.out.println("ça marche !!!!");
                use = true;
            } 
        }*/
        do{
            choice = "";
            choice = keyboard.nextLine();
            Skill skill = new Skill("");
            int damage = 0;
            if(choice.length() == 0){
                System.out.println("Please enter a letter");
                continue;
            }
            switch(choice.toUpperCase().charAt(0)){
                case 'A':
                    skill = this.archetype.getSkills().get(0);
                    System.out.println(skill.getName() + "!");
                    damage = skill.calcDamage(this.getStats());
                    DealsDamage.dealsDamage(damage, target);
                    System.out.println(super.getName() + " inflicts " + damage);
                    use = true;
                    break;
                case 'Z':
                    skill = this.archetype.getSkills().get(1);
                    System.out.println(skill.getName() + "!");
                    damage = skill.calcDamage(this.getStats());
                    DealsDamage.dealsDamage(damage, target);
                    System.out.println(super.getName() + " inflicts " + damage);
                    use = true;
                    break;
                case 'E':
                    skill = this.archetype.getSkills().get(2);
                    System.out.println(skill.getName() + "!");
                    damage = skill.calcDamage(this.getStats());
                    DealsDamage.dealsDamage(damage, target);
                    System.out.println(super.getName() + " inflicts " + damage);
                    use = true;
                    break;
                case 'R':
                    skill = this.archetype.getSkills().get(3);
                    System.out.println(skill.getName() + "!");
                    damage = skill.calcDamage(this.getStats());
                    DealsDamage.dealsDamage(damage, target);
                    System.out.println(super.getName() + " inflicts " + damage);
                    use = true;
                    break;
                case 'T':
                    skill = this.archetype.getSkills().get(4);
                    System.out.println(skill.getName() + "!");
                    damage = skill.calcDamage(this.getStats());
                    DealsDamage.dealsDamage(damage, target);
                    System.out.println(super.getName() + " inflicts " + damage);
                    use = true;
                    break;
            }
    }while(!use);
}
    public String getSaveText(){
        String save;
        save = super.getSaveText();
        save += ",";
        save += this.exp + ",";
        save += this.expM + ",";
        save += this.archetype;
        for (int i = 0; i < this.equipment.length; i++){
            save += this.equipment[0];
            if (i < this.equipment.length - 1){
                save += ":";
            }
        }
        
        return save;
    }
    
    @SuppressWarnings("empty-statement")
    public void InitFromSave(String[] save){
        String[] save1 = {save[0],save[1],save[2],save[3],save[4],save[5],
            save[6],save[7]};
        String[] save2 = {save[8],save[9],save[10],save[11]};
        String[] equipmentv2 = save[11].split(":");
        super.InitFromSave(save1);
        this.exp = Integer.parseInt(save2[0]);
        this.expM = Integer.parseInt(save2[1]);
        if (save2[2] == "warrior"){
            this.archetype = new WarriorClass();
        }
        else if (save2[2] == "wizard"){
            this.archetype = new WizardClass();
        }
        else if (save2[2] == "thief"){
            this.archetype = new ThiefClass();
        }
        else if (save2[2] == "classless"){
            this.archetype = new ClasslessClass();
        }
        int[] equi = {Integer.parseInt(equipmentv2[0]),
            Integer.parseInt(equipmentv2[1]),Integer.parseInt(equipmentv2[2]),
            Integer.parseInt(equipmentv2[3]),Integer.parseInt(equipmentv2[4]),
            Integer.parseInt(equipmentv2[5]),Integer.parseInt(equipmentv2[6])};
        this.equipment = equi;
    }
}
