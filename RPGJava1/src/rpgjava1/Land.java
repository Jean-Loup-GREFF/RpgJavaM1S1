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
    
    public void changeElem (Integer x, Integer y, AppOnMap news){
                if(!this.ElemMap.contains(news)){
                    this.Map.get(y).set(x,this.ElemMap.size());
                    this.ElemMap.add(news);
                }
                else{
                    this.Map.get(y).set(x,this.ElemMap.indexOf(news));
                }
    }
    
    public int moveTo (Integer x, Integer y, Integer Bouton){
        
        VoidCase voids = new VoidCase();
        int test = 1;
        AppOnMap temp = new AppOnMap();
        
        
        
        switch(Bouton){
            case (0):
                if (this.ElemMap.get(this.Map.get(y-1).get(x)) == voids){
                    temp = this.ElemMap.get(this.Map.get(y-1).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y-1, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(1):
                if (this.ElemMap.get(this.Map.get(y).get(x-1)) == voids){
                    temp = this.ElemMap.get(this.Map.get(y).get(x-1));
                    changeElem (x, y, voids);
                    changeElem (x-1, y, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(2):
                if (this.ElemMap.get(this.Map.get(y+1).get(x)) == voids){
                    temp = this.ElemMap.get(this.Map.get(y+1).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y+1, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(3):
                if (this.ElemMap.get(this.Map.get(y).get(x+1)) == voids){
                    temp = this.ElemMap.get(this.Map.get(y).get(x+1));
                    changeElem (x, y, voids);
                    changeElem (x+1, y, temp);
                }
                else{
                    test = 0;
                }
                break;
            
            
        }
                
        
        return test;
    }
    
    public ArrayList<ArrayList<AppOnMap>> getMap (){
        ArrayList<ArrayList<AppOnMap>> Save;
        Save = new ArrayList<>();
        for (ArrayList<Integer> i : this.Map){
            ArrayList<AppOnMap> line; 
            line = new ArrayList<>();
            for (Integer j : i){
                line.add(this.ElemMap.get(j));   
            }
            Save.add(line);
        
    }
        return Save;     
             
    }
}