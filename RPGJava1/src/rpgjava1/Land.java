/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.util.ArrayList;

public class Land {
    private String name;
    private ArrayList<AppOnMap> ElemMap;
    private ArrayList<ArrayList<Integer>> Map;
    
    
    public void InitMap(){
        this.name = "";
        this.ElemMap = new ArrayList<>();
        this.Map = new ArrayList<>();
    }
    
    public void InitMap(ArrayList<ArrayList<AppOnMap>> Save){
        
        // Save is an array list with first element name of the map
        // and then the other element is an array of array of all
        // the object in the map
        Integer pos = 0;
        for (ArrayList<AppOnMap> i : Save){
            ArrayList<Integer> line; 
            line = new ArrayList<>();
            for (AppOnMap j : i){
                if(this.ElemMap.isEmpty()){
                    pos = 0;
                    line.add(pos);
                }
                else if(!this.ElemMap.contains(j)){
                    pos = this.ElemMap.size();
                    line.add(pos);
                    this.ElemMap.add(j);
                    
                }
                else{
                    pos = this.ElemMap.indexOf(j);
                    line.add(pos);
                }
             
            }
            this.Map.add(line);
            
        }
        
    }

    public Land(String name) {
        this.name = name;
    }
    
    
    public void displayMap() {
        
        for (ArrayList<Integer> i : this.Map){
            for (Integer j : i){
                this.ElemMap.get(j).getDisplay();
            }
            
        }
    }
    
    
    public String getName() {
        return name;
    }
    
    public void moveTo (Integer x, Integer y, Integer Bouton){
        
    }
}