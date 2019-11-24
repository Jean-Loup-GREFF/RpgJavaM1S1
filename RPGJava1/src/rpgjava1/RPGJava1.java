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
public class RPGJava1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game;
        game = new Game();
        game.mainMenu(sc);
        sc.close();
    }
}
