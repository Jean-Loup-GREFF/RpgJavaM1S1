/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Land {
    private String name;
    private ArrayList<AppOnMap> elemMap;
    private ArrayList<ArrayList<Integer>> map;

    public Land() {
        this.name = "";
        this.elemMap = new ArrayList();
        this.map = new ArrayList();
    }
   
    public Land(String name, ArrayList<AppOnMap> elemMap, ArrayList<ArrayList<Integer>> map) {
        this.name = name;
        this.elemMap = elemMap;
        this.map = map;
    }
    
    
    
    public void InitMap(){
        this.name = new String();
        this.name = "";
        this.elemMap = new ArrayList<>();
        this.map = new ArrayList<>();
    }
    
    public void InitMap(String name ,ArrayList<ArrayList<AppOnMap>> Save){
        
        // Save is an array list with first element name of the map
        // and then the other element is an array of array of all
        // the object in the map
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
        this.name = name;
        Integer pos = 0;
        for (ArrayList<AppOnMap> i : Save){
            ArrayList<Integer> line; 
            line = new ArrayList<>();
            for (AppOnMap j : i){
                if(this.elemMap.isEmpty()){
                    pos = 0;
                    line.add(pos);
                }
                else if(!this.elemMap.contains(j)){
                    pos = this.elemMap.size();
                    line.add(pos);
                    this.elemMap.add(j);
                    
                }
                else{
                    pos = this.elemMap.indexOf(j);
                    line.add(pos);
                }
             
            }
            this.map.add(line);
            
        }
        
    }
    
    public AppOnMap getEntity (int x,int y){
        return elemMap.get(map.get(y).get(x));
    }
    
    public AppOnMap getPlayer (){
        AppOnMap player;
        player = new AppOnMap();
        for (AppOnMap i : elemMap)
            if ("Player" == i.getClass().getSimpleName()){
                player = i;
                break;
            }
        return player;
    }
    
    public void InitMap(ArrayList<ArrayList<AppOnMap>> Save){
        
        // Save is an array list with first element name of the map
        // and then the other element is an array of array of all
        // the object in the map
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
        this.name = " ";
        Integer pos = 0;
        for (ArrayList<AppOnMap> i : Save){
            ArrayList<Integer> line; 
            line = new ArrayList<>();
            for (AppOnMap j : i){
                if(this.elemMap.isEmpty()){
                    pos = 0;
                    line.add(pos);
                }
                else if(!this.elemMap.contains(j)){
                    pos = this.elemMap.size();
                    line.add(pos);
                    this.elemMap.add(j);
                    
                }
                else{
                    pos = this.elemMap.indexOf(j);
                    line.add(pos);
                }
             
            }
            this.map.add(line);
            
        }
        
    }

    
    public Land(String name) {
        this.name = name;
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
    }
    
    
    public void displayMap() {
        
        for (ArrayList<Integer> i : this.map){
            for (Integer j : i){
                System.out.print(this.elemMap.get(j).getDisplay());
            }
            System.out.println();
            
        }
    }
    
    
    public String getName() {
        return name;
    }
    
    public void changeElem (Integer x, Integer y, AppOnMap news){
                if(!this.elemMap.contains(news)){
                    this.map.get(y).set(x,this.elemMap.size());
                    this.elemMap.add(news);
                }
                else{
                    this.map.get(y).set(x,this.elemMap.indexOf(news));
                }
    }
    
    public int moveTo (Integer x, Integer y, Integer Bouton){
        
        VoidCase voids = new VoidCase();
        int test = 1;
        AppOnMap temp = new AppOnMap();
        
        
        
        switch(Bouton){
            case (0):
                if (this.elemMap.get(this.map.get(y-1).get(x)) == voids){
                    temp = this.elemMap.get(this.map.get(y-1).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y-1, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(1):
                if (this.elemMap.get(this.map.get(y).get(x-1)) == voids){
                    temp = this.elemMap.get(this.map.get(y).get(x-1));
                    changeElem (x, y, voids);
                    changeElem (x-1, y, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(2):
                if (this.elemMap.get(this.map.get(y+1).get(x)) == voids){
                    temp = this.elemMap.get(this.map.get(y+1).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y+1, temp);
                }
                else{
                    test = 0;
                }
                break;
            case(3):
                if (this.elemMap.get(this.map.get(y).get(x+1)) == voids){
                    temp = this.elemMap.get(this.map.get(y).get(x+1));
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
    
    public ArrayList<ArrayList<AppOnMap>> getmap (){
        ArrayList<ArrayList<AppOnMap>> Save;
        Save = new ArrayList<>();
        for (ArrayList<Integer> i : this.map){
            ArrayList<AppOnMap> line; 
            line = new ArrayList<>();
            for (Integer j : i){
                line.add(this.elemMap.get(j));   
            }
            Save.add(line);
        
    }
        return Save;     
             
    }
    
    public void initMapFromSave(String nameProf, String namemap){
        this.name = namemap;
        try{
        InputStream flux=new FileInputStream("C:\\Game\\ANewDawn\\Save\\"+nameProf+"\\"+ this.name +".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        String[] objects;
        String[] type;
        ArrayList<ArrayList<AppOnMap>> map;
        ArrayList<AppOnMap> linemap;
        AppOnMap elem;
        int testNamemap = 0;
        int lenObjectLine;
        int i, j;
        map = new ArrayList<>();
        linemap = new ArrayList<>();
        elem = new AppOnMap();
        
        while ((line = buff.readLine())!=null){
            
                if (testNamemap == 0){
                    testNamemap = 1;
                }
                
                else{
                    objects = line.split(";");
                    lenObjectLine = objects.length;
                    for (i = 0; i < lenObjectLine; i++){
                        type = objects[i].split(",");
                        elem.InitFromSave(type);
                        linemap.add(elem);
                    }
                    map.add(linemap);
                }
        }
        InitMap(map);
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    }
        
    public void saveMap(String name){
        try{
        File ff; // définir l'arborescence
        String dirName = "C:\\Game\\ANewDawn\\Save\\"+name+"\\";
        File dir = new File(dirName);
        boolean isCreated = dir.mkdirs();
        ff = new File("C:\\Game\\ANewDawn\\Save\\"+name+"\\"+ this.name +".txt");
        ArrayList<ArrayList<AppOnMap>> Save;
        Save = new ArrayList<>();
        Save = getmap();
        int test = 1;
        int limitLine = 0;
        
        
        
        ff.createNewFile();
        FileWriter ffw = new FileWriter(ff);
        
        for (ArrayList<AppOnMap> y : Save){
            String SaveLine = "";
            ArrayList<Integer> line; 
            line = new ArrayList<>();
            limitLine = y.size();
            for (AppOnMap x : y){
                SaveLine += x.getSaveText();
                if (!(test == limitLine)){
                    SaveLine += ";";
                }
                else{
                    ffw.write(SaveLine);
                    ffw.write("\n");
                }
                test ++;
                }
            }
        
        ffw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e) {System.out.println("t'es une merde");}
    
}
    
    //public void initMapFromSave2(String nameProf, String namemap){
        // Gson gson = new Gson();

        //1. JSON to Java object, read it from a file.
        // Staff staff = gson.fromJson(new FileReader("D:\file.json"), Staff.class);

        //2. JSON to Java object, read it from a Json String.
        // String jsonInString = "{'name' : 'mkyong'}";
        // Staff staff = gson.fromJson(jsonInString, Staff.class);

        //JSON to JsonElement, convert to String later.
        // JsonElement json = gson.fromJson(new FileReader("D:\file.json"), JsonElement.class);
        // String result = gson.toJson(json);
    //}
        
    //public void saveMap2(String name){
        //Gson gson = new Gson();
        //Staff obj = new Staff();
        //try{
        //File ff; // définir l'arborescence
        //ff = new File("C:\\Game\\ANewDawn\\Save\\"+name+"\\"+ this.name +".txt");
       // ArrayList<ArrayList<AppOnMap>> Save;
        //Save = new ArrayList<>();
        //Save = getmap();
        //int test = 1;
        //int limitLine = 0;
        
        
        
        //ff.createNewFile();
        //FileWriter ffw = new FileWriter(ff);
        
        //for (ArrayList<AppOnMap> y : Save){
            //String SaveLine = "";
            //ArrayList<Integer> line; 
           // line = new ArrayList<>();
            //limitLine = y.size();
            //for (AppOnMap x : y){
               // SaveLine += x.getSaveText();
                //if (!(test == limitLine)){
               //     SaveLine += ";";
                //}
                //else{
                //    ffw.write(SaveLine);
                //    ffw.write("\n");
                //}
                //test ++;
                //}
            //}
        
        //ffw.close(); // fermer le fichier à la fin des traitements
        //} 
        //catch (Exception e) {}
    
//}
    
    public boolean elemHere (AppOnMap Elem){
       
        boolean test = false;
        try{
                    int i = 0;
                    for(AppOnMap j : this.elemMap){
                        if (j == Elem){
                            test = true;
                            break;
                        }
                        i++;
                    }
                }
                catch(Exception e){}
        return test;
    }
    
    public int placeElem(AppOnMap Elem){
        int i = -1;
        try{
                    i = 0;
                    for(AppOnMap j : this.elemMap){
                        if (j == Elem){
                            break;
                        }
                        i++;
                    }
                }//
                catch(Exception e){}
        return i;
    }
    
    public void addElemMap (AppOnMap Elem, int x, int y){
        
        int lenHeigh = this.map.size();
        if (y<lenHeigh){
            int lenLine = this.map.get(y).size();
            if (x<lenLine){
                changeElem(x,y,Elem);
            }
            else{
                int nX = this.map.get(y).size() - 1;
                ArrayList<Integer> line;
                line = new ArrayList<>();
                line = map.get(y);
                int pos = -1;
                if (pos < 0){
                    pos = elemMap.size();
                    elemMap.add(Elem);
                }
                while (nX<x){
                    nX++;
                    line.add(pos);
                }
            }
        }
        else{
            int nY = 0;
            int nX = 1;
            boolean test = elemHere(Elem);
            int pos = -1;
            if(test){
                pos = placeElem(Elem);
            }
            ArrayList<Integer> line;
            line = new ArrayList<>();
            if (pos < 0){
                    pos = elemMap.size();
                    elemMap.add(Elem);
                }
            line.add(pos);
            while (nY<y){
                    nY++;
                    map.add(line);
                }
            while (nX<x){
                nX++;
                line.add(pos);
            }
            map.add(line);
            
        }
    }
    
}