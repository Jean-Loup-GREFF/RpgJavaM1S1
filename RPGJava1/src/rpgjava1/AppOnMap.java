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
    
    public ArrayList<String> getDataSave(){
        ArrayList<String> PartSave;
        PartSave = new ArrayList<>();
        return PartSave;
    }
    
    public void InitFromSave(String Save){
        this.display = Save.charAt(0);
    }
    
    public String getSaveText(){
        return ""+this.display;
    }
}
