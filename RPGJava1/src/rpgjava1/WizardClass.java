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
public class WizardClass extends ClassArchetype {

    /**
     * method to init a wiard class
     *
     */
    public WizardClass(){
        super("Wizard",new ArrayList<>(),new Statistic(0,0,1,1,2,2,50),
                new Statistic(0,0,0,0,5,0,0));
        super.setSkills(skills());
    }
    
    private ArrayList<Skill> skills(){
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("FireBall",
                new Statistic(0,0,0,0,2,0,0),10,0,5,0));
        skills.add(new Skill("Electrocute",
                new Statistic(0,0,0,2,0,0,0),15,0,10,0));
        skills.add(new Skill("Beam of Light",
                new Statistic(0,0,0,2,1,0,0),25,0,20,0));
        skills.add(new Skill("Combinate Spell",
                new Statistic(0,0,0,3,0,0,0),40,0,45,0));
        skills.add(new Skill("Gather Storm's",
                new Statistic(0,0,0,2,2,0,0),30,0,30,0));
        return skills;
    }
    @Override
    public String getText(){
        return "wizard";
    }
}
