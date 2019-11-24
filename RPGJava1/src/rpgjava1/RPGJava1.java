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
        Player p = new Player(0,0,new WizardClass(),"M",1,10,10,new Statistic(),new Inventory(),true,'@',tmp);
        Character c = new Character("Monster",1,25,25,new Statistic(),new Inventory(),true,'A');
        System.out.println((int)'1');
        //ight(p,c);
        //Game game;
        //game = new Game();
        //Wall wall = new Wall();
        //game.addElemMap(wall, 90, 0);
        //game.addElemMap(wall, 0, 90);
        //game.displayMap();
        //game.initNewProfile("j'enaimarre");
        //game.writeSave();
        //game.initCurrentProfileFromSave("j'enaimarre");
        //game.displayMap();
    }
    
}
