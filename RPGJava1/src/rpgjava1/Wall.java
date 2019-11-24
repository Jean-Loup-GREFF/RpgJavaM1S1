/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Jean-Loup
 */
public class Wall extends AppOnMap{
    
    /**
     * method to init a wall object
     *
     */
    public Wall() {
        super('#');
    }

    public char getDisplay(){
        return super.getDisplay();
    }
}
