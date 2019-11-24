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

public abstract class ClassArchetype implements DealsDamage{
    private String name;
    private ArrayList<Skill> skills;
    private Statistic statsGrow;
    private Statistic basicAttack;

    /**
     * Init a class archetype
     *
     * @param name
     * @param skills
     * @param statsGrow
     * @param basicAttack
     */
    public ClassArchetype(String name, ArrayList<Skill> skills,
            Statistic statsGrow, Statistic basicAttack) {
        this.name = name;
        this.skills = skills;
        this.statsGrow = statsGrow;
        this.basicAttack = basicAttack;
    }
    
    /**
     * get the name of an object class archetype
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * get the skills of a get skills
     *
     * @return
     */
    public ArrayList<Skill> getSkills() {
        return skills;
    }

    /**
     * get the growth stats will be usefull for a player
     *
     * @return
     */
    public Statistic getStatsGrow()     {
        return statsGrow;
    }

    /**
     * Set the name of an object archetype
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the skills of an archetype
     *
     * @param skills
     */
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    /**
     * set the stat growth of an archetype to be used by player
     *
     * @param statsGrow
     */
    public void setStatsGrow(Statistic statsGrow) {
        this.statsGrow = statsGrow;
    }

    /**
     * get basic attack damage which help to create the basic attack of player
     *
     * @return
     */
    public Statistic getBasicAttack() {
        return basicAttack;
    }

    /**
     * set the basic attack which help to create the basic attack of player
     *
     * @param basicAttack
     */
    public void setBasicAttack(Statistic basicAttack) {
        this.basicAttack = basicAttack;
    }
    
    /**
     * get test for saving aspect
     *
     * @return
     */
    public String getText(){
        return "";
    }
    
    /**
     * display the skills on the screen
     *
     */
    public void displaySkill(){
        String[] touch = {"A","Z","E","R","T"};
        for(int i = 0;i<this.skills.size();i++){
            System.out.print(touch[i] + " ");
            skills.get(i).display();
        }
    }
}
