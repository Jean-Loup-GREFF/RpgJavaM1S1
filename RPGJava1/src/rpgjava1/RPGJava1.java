/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;
import java.util.Scanner;

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
        Trap trap = new Trap();
        Trap trap2 = new Trap();
        Mob mob = new Mob("merchant", 700, 9000, 9000,new Statistic(), new Inventory(), true, 'm',
          120);
        Merchant merchant = new Merchant("merchant", 700, 9000, 9000,new Statistic(), new Inventory(), true, 'M',
          120, 20);
        Chest chest = new Chest();
        Character c = new Character("Monster",1,5,5,new Statistic(),new Inventory(),true,'A');
        Game game,game2;
        
        game = new Game();
        game2 = new Game();
        Wall wall = new Wall();
        VoidCase voidc = new VoidCase();
        game.initCurrentProfileFromSave("Yourss");
        game.displayMap();
        game.writeSave();
        game.displayMap();
        
    }
    
}
