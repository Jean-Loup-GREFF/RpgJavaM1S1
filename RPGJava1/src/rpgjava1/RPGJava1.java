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
public class RPGJava1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] tmp ={-1,-1,-1,-1,-1,-1,-1};
        Player p = new Player(0,0,new ClasslessClass(),"Them",1,10,10,new Statistic(),new Inventory(),true,'@',tmp);
        Character c = new Character("Monster",1,5,5,new Statistic(),new Inventory(),true,'A');
        Game game,game2;
        
        game = new Game();
        game2 = new Game();
        Wall wall = new Wall();
        VoidCase voidc = new VoidCase();
        game.initNewProfile("Them",p);
        game.displayMap();
        game.writeSave();
        game.displayMap();
        
    }
    
    //public static void fight(Character c1, Character c2){
        //ArrayList<Character> c = new ArrayList<>();
        //if(c1.getStats().getAgility() > c2.getStats().getAgility()){
        //    c.add(c1);
        //    c.add(c2);
        //}
        //if(c1.getStats().getAgility() > c2.getStats().getAgility()){
        //    c.add(c2);
        //    c.add(c1);
        //}
        //if(c1.getStats().getAgility() == c2.getStats().getAgility()){
        //    c.add(c1);
        //    c.add(c2);
        //}
        //System.out.println(c.get(0).getName() + " attaque " + c.get(1).getName() + " en premier");
        //int i = 0;
        //while (c.get(0).isIsAlive() || c.get(1).isIsAlive()){
        //    c.get(i%2).attack(c.get((i+1)%2));
        //    System.out.println(c.get((i+1)%2).getHealth());
        //}
    //}
    
}
