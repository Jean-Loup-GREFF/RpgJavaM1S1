/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Matthieu
 */
public class AppOnMap {
    private char display;
    
    public AppOnMap(char display){
        this.display = display;
    }
    
    public AppOnMap(){
        this.display = ' ';
    }
    
    public char getDisplay(){
        return this.display;
    }

    public void setDisplay(char display) {
        this.display = display;
    }
 
}
