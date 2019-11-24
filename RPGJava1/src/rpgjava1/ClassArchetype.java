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
public abstract class ClassArchetype implements DealsDamage{
    private String name;
    private ArrayList<Skill> skills;
    private Statistic statsGrow;
    private Statistic basicAttack;

    public ClassArchetype(String name, ArrayList<Skill> skills, Statistic statsGrow, Statistic basicAttack) {
        this.name = name;
        this.skills = skills;
        this.statsGrow = statsGrow;
        this.basicAttack = basicAttack;
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public Statistic getStatsGrow()     {
        return statsGrow;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public void setStatsGrow(Statistic statsGrow) {
        this.statsGrow = statsGrow;
    }

    public Statistic getBasicAttack() {
        return basicAttack;
    }

    public void setBasicAttack(Statistic basicAttack) {
        this.basicAttack = basicAttack;
    }
    
    public String getText(){
        return "";
    }
    
    public void displaySkill(){
        char[] touch = {'A','Z','E','R','R'};
        for(int i = 0;i<this.skills.size();i++){
            System.out.print(touch[i] + ' ');
            skills.get(i).display();
        }
    }
}
