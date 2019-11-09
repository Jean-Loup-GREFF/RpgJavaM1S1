/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean-Loup
 */
import java.util.ArrayList;

public class Land {
    private String name;
    private ArrayList<Object> ElemMap;
    private ArrayList<ArrayList<Integer>> Map;
    
    

    public String getName() {
        return name;
    }
    
    public void initMap(){
        this.name = "";
        this.ElemMap = new ArrayList<Object>();
        this.Map = new ArrayList<ArrayList<Integer>>();
    }
    
    public void initMap(ArrayList<ArrayList<Object>> Save){
        // Save is an array list with first element name of the map
        // and then the other element is an array of array of all
        // the object in the map
        int x = 0;
        int y = 0;
        Integer pos = 0;
        for (ArrayList<Object> i : Save){
            ArrayList<Object> line = new ArrayList<Object>(); 
            for (Object j : i){
                if(this.ElemMap.isEmpty()){
                    pos = 0;
                    line.add(pos);
                }
                else if(this.ElemMap.contains(j)){
                    pos = this.ElemMap.indexOf(j);
                    line.add(pos);
                }
                else{
                    pos = this.ElemMap.size();
                    line.add(pos);
                    this.ElemMap.add(j);
                     
                }
             
            }
            
        }
        
    }

    public Land(String name) {
        this.name = name;
    }
    
    
    public void displayMap() {
        for (ArrayList<Integer> i : this.Map){
            ArrayList<Object> line = new ArrayList<Object>(); 
            for (Integer j : i){
                this.ElemMap(j).getchar();
            }
            
        }
    }
    
    
}
