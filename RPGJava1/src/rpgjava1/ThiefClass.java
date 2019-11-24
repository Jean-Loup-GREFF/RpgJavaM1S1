/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */
public class ThiefClass extends ClassArchetype{

    /**
     * method to init a thief class
     *
     */
    public ThiefClass(){
        super("Thief",new ArrayList<>(),new Statistic(1,0,2,2,0,1,50),new Statistic(0,0,0,5,0,0,0));
        super.setSkills(skills());
    }
    private ArrayList<Skill> skills(){
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Stab",new Statistic(1,0,0,1,0,0,0),10,0,0,5));
        skills.add(new Skill("Haemorrhage",new Statistic(1,0,1,1,0,0,0),15,0,0,10));
        skills.add(new Skill("Backstab",new Statistic(0,0,1,2,0,0,0),25,0,0,20));
        skills.add(new Skill("Sneaking",new Statistic(0,0,2,2,0,0,0),5,0,0,15));
        skills.add(new Skill("Bloodlust",new Statistic(0,0,2,2,0,2,0),30,0,0,30));
        return skills;
    }
    
    @Override
    public String getText(){
        return "thief";
    }
}
