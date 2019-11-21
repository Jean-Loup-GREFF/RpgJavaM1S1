/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;

/**
 *
 * @author Matthieu
 */
public class WarriorClass extends ClassArchetype {
    public WarriorClass(){
        super("Warrior",new ArrayList<>(),new Statistic(5,5,2,2,1,1,50),new Statistic(5,0,0,0,0,0,0));
        super.setSkills(skills());
    }
    
    private ArrayList<Skill> skills(){
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Charge",new Statistic(2,0,0,0,0,0,0),10,0,5,0));
        skills.add(new Skill("Cyclone",new Statistic(2,0,1,0,0,0,0),10,0,5,0));
        skills.add(new Skill("Slash",new Statistic(2,0,0,1,0,0,0),10,0,5,0));
        skills.add(new Skill("Berserker",new Statistic(2,2,0,0,0,0,0),10,0,5,0));
        skills.add(new Skill("War Cry",new Statistic(1,2,0,0,0,2,0),10,0,5,0));
        return skills;
    }
}
