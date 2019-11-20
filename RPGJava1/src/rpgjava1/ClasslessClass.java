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
public class ClasslessClass extends ClassArchetype{
    public ClasslessClass(){
        super("None",new ArrayList<>(),new Statistic(1,1,1,1,1,1,50), new Statistic(2,2,2,2,2,0,0));
        super.setSkills(skills());
    }
    private ArrayList<Skill> skills(){
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Charge",new Statistic(2,0,0,0,0,0,0),10,0,5,0));
        skills.add(new Skill("Cyclone",new Statistic(2,0,1,0,0,0,0),10,0,5,0));
        skills.add(new Skill("Slash",new Statistic(2,0,0,1,0,0,0),10,0,5,0));
        skills.add(new Skill("Berserker",new Statistic(2,2,0,0,0,0,0),10,0,5,0));
        skills.add(new Skill("War Cry",new Statistic(1,2,0,0,0,2,0),10,0,5,0));
        skills.add(new Skill("Stab",new Statistic(1,0,0,1,0,0,0),10,0,0,5));
        skills.add(new Skill("Haemorrhage",new Statistic(1,0,1,1,0,0,0),15,0,0,10));
        skills.add(new Skill("Backstab",new Statistic(0,0,1,2,0,0,0),25,0,0,20));
        skills.add(new Skill("Sneaking",new Statistic(0,0,2,2,0,0,0),5,0,0,15));
        skills.add(new Skill("Bloodlust",new Statistic(0,0,2,2,0,2,0),30,0,0,30));
        skills.add(new Skill("FireBall",new Statistic(0,0,0,0,2,0,0),10,0,5,0));
        skills.add(new Skill("Electrocute",new Statistic(0,0,0,2,0,0,0),15,0,10,0));
        skills.add(new Skill("Beam of Light",new Statistic(0,0,0,2,1,0,0),25,0,20,0));
        skills.add(new Skill("Combinate Spell",new Statistic(0,0,0,3,0,0,0),40,0,45,0));
        skills.add(new Skill("Gather Storm's",new Statistic(0,0,0,2,2,0,0),30,0,30,0));
        return skills;
    }
}
