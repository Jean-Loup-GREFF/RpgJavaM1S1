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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Land {
    private String name;
    private ArrayList<AppOnMap> elemMap;
    private ArrayList<ArrayList<Integer>> map;

    public Land() {
        this.name = "1";
        this.elemMap = new ArrayList<>();
        this.map = new ArrayList<>();
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
    
    public int[] getPlayer (){

        Player p = new Player("");
        int n = 0, cx = 0 , cy = 0, x = -1, y = -1;
        for (int i= 0; i<this.elemMap.size(); i++){
            if (this.elemMap.get(i).getDisplay() == p.getDisplay()){
                break;
            }
            n++;
        }
        for (ArrayList<Integer> Y : this.map){
            for (int X : Y){
                if (X == n){
                    x = cx;
                    y = cy;
                }
                cx ++;
            }
            cy ++;
        }
        int[] coord = {x,y};
        return coord;
    }
    
    public void InitMap(ArrayList<ArrayList<AppOnMap>> Save, String name){
        
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

    public Land(String name) {
        this.name = name;
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
    }

    public void displayMap() {
        
        for (ArrayList<Integer> i : this.map){
            for (Integer j : i){
                if (this.elemMap.get(j).getDisplay() == '+'){
                    if (this.elemMap.get(j).isHide()){
                        System.out.print(" ");
                    }
                    else{
                    System.out.print(this.elemMap.get(j).getDisplay());    
                    }
                }
                else{
                    System.out.print(this.elemMap.get(j).getDisplay());
                }
                
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
    
    public int moveTo (Integer x, Integer y, Integer buton, Game game){
        
        VoidCase voids = new VoidCase();
        int test = 1;
        AppOnMap temp = new AppOnMap();
        
        
        
        switch(buton){
            case (0):
                if (game.getTrapCurrentPosition() == null){
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y-1, temp);
                }
                else{
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x, y-1, temp);
                    String[] nprof = game.getProfileUse();
                    game.setProfiles(game.getCurrentProfile(), nprof);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(1):
                if (game.getTrapCurrentPosition() == null){
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x-1, y, temp);
                }
                else{
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x-1, y, temp);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(2):
                if (game.getTrapCurrentPosition() == null){
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y+1, temp);
                }
                else{
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x, y+1, temp);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(3):
                if (game.getTrapCurrentPosition() == null){
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x+1, y, temp);
                }
                else{
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x+1, y, temp);
                    game.setTrapCurrentPosition(null);
                }
                break;
            
            
        }
        boolean a = (this.elemMap.get(this.map.get(y-1).get(x)) == voids);        
        return test;
    }
    
    public ArrayList<ArrayList<AppOnMap>> getmap (){
        ArrayList<ArrayList<AppOnMap>> save;
        save = new ArrayList<>();
        for (ArrayList<Integer> i : this.map){
            ArrayList<AppOnMap> line; 
            line = new ArrayList<>();
            for (Integer j : i){
                line.add(this.elemMap.get(j));   
            }
            save.add(line);
        
    }
        return save;     
             
    }
    
    public String initFirstMapFromSave(String name){
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
        try{
        InputStream flux=new FileInputStream("maps\\Twilight'sCastle.txt"); 
        this.name = "Twilight'sCastle";
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        String[] objects;
        String[] type;
        ArrayList<ArrayList<Integer>> map;
        ArrayList<Integer> linemap;
        AppOnMap elem;
        
        int testNamemap = 0;
        int lenObjectLine;
        int i, j;
        map = new ArrayList<>();
        linemap = new ArrayList<>();
        
        
        
        int n = 0;
        
        while ((line = buff.readLine())!=null){
                
                objects = line.split(";");
                lenObjectLine = objects.length;
                linemap = new ArrayList<>();
                
                for (i = 0; i < lenObjectLine; i++){
                    
                    
                    elem = new AppOnMap();
                    Character cha = new Character("");
                    Player play = new Player(""); 
                    Trap trap = new Trap();
                    Mob mob = new Mob();
                    Merchant merchant = new Merchant();
                    Chest chest = new Chest();
                    
                    elem = new AppOnMap();
                    type = objects[i].split(",");
                    j = type.length;
                    switch(j){
                        case 1:
                            elem.InitFromSave(type[0]);//
                            if (! isElem(elem)){
                                n = this.elemMap.size();
                                this.elemMap.add(elem);
                            }
                            else{
                                n = this.posElem(elem);
                            }
                            break;
                        case 2:
                            chest.InitFromSave(type);
                            if (! isElem(chest)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(chest);
                                
                            }
                            else{
                                n = this.posElem(trap);
                            }
                            break;
                        case 3:
                            trap.InitFromSave(type);
                            if (! isElem(trap)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(trap);
                                
                            }
                            else{
                                n = this.posElem(trap);
                            }
                            break;
                        case 8:
                            cha.InitFromSave(type);
                            if (! isElem(cha)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(cha);
                                
                            }
                            else{
                                n = this.posElem(cha);
                            }
                            break;
                        case 12:
                            play.InitFromSave(type);
                            if (! isElem(play)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(play);
                                
                            }
                            else{
                                n = this.posElem(play);
                            }
                            break;
                        case 13:
                            mob.InitFromSave(type);
                            if (! isElem(mob)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(mob);
                                
                            }
                            else{
                                n = this.posElem(mob);
                            }
                            break;
                        case 14:
                            merchant.InitFromSave(type);
                            if (! isElem(merchant)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(merchant);
                                
                            }
                            else{
                                n = this.posElem(merchant);
                            }
                            break;           
                        
                    }
                    linemap.add(n);
                    //linemap.add(elem);
                    }
                    
                    this.map.add(linemap);
                
        }
        //this.InitMap(map,namemap);
       
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
        return this.name;
    }
    
    public void initMapFromSave(String nameProf, String namemap){
        this.name = namemap;
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
        try{
        InputStream flux=new FileInputStream("C:\\Game\\ANewDawn\\Save\\"+nameProf+"\\"+ this.name +".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        String[] objects;
        String[] type;
        ArrayList<ArrayList<Integer>> map;
        ArrayList<Integer> linemap;
        AppOnMap elem;
        
        int testNamemap = 0;
        int lenObjectLine;
        int i, j;
        
        map = new ArrayList<>();
        linemap = new ArrayList<>();
        
        
        int n = 0;
        
        while ((line = buff.readLine())!=null){
          
                objects = line.split(";");
                lenObjectLine = objects.length;
                linemap = new ArrayList<>();
                
                for (i = 0; i < lenObjectLine; i++){
                    elem = new AppOnMap();
                    Character cha = new Character("");
                    Player play = new Player(""); 
                    Trap trap = new Trap();
                    Mob mob = new Mob();
                    Merchant merchant = new Merchant();
                    Chest chest = new Chest();
                    type = objects[i].split(",");
                    j = type.length;
                    switch(j){
                        case 1:
                            elem.InitFromSave(type[0]);//
                            if (! isElem(elem)){
                                n = this.elemMap.size();
                                this.elemMap.add(elem);
                            }
                            else{
                                n = this.posElem(elem);
                            }
                            break;
                        case 2:
                            chest.InitFromSave(type);
                            if (! isElem(chest)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(chest);
                                
                            }
                            else{
                                n = this.posElem(trap);
                            }
                            break;
                        case 3:
                            trap.InitFromSave(type);
                            if (! isElem(trap)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(trap);
                                
                            }
                            else{
                                n = this.posElem(trap);
                            }
                            break;
                        case 8:
                            cha.InitFromSave(type);
                            if (! isElem(cha)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(cha);
                                
                            }
                            else{
                                n = this.posElem(cha);
                            }
                            break;
                        case 12:
                            play.InitFromSave(type);
                            if (! isElem(play)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(play);
                                
                            }
                            else{
                                n = this.posElem(play);
                            }
                            break;
                        case 13:
                            mob.InitFromSave(type);
                            if (! isElem(mob)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(mob);
                                
                            }
                            else{
                                n = this.posElem(mob);
                            }
                            break;
                        case 14:
                            merchant.InitFromSave(type);
                            if (! isElem(merchant)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(merchant);
                                
                            }
                            else{
                                n = this.posElem(merchant);
                            }
                            break;           
                        
                    }
                    linemap.add(n);
                    //linemap.add(elem);
                    }
                    
                    this.map.add(linemap);
                
        
        }
        //this.InitMap(map,namemap);
       
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    }
    
    public int posElem (AppOnMap Elem){
        int n = 0;
        for(AppOnMap j: this.elemMap){
            if (Elem == j){
                break;
            }
            n++;
        }
        return n;
    }
    
    public boolean isElem (AppOnMap Elem){
        boolean test = false;
        for(AppOnMap j: this.elemMap){
            if (Elem == j){
                test = true;
                break;
            }
        }
        return test;
    }
    
    public void saveMap(String name){
        try{
        File ff; // définir l'arborescence
        String dirName = "C:\\Game\\ANewDawn\\Save\\"+name+"\\";
        File dir = new File(dirName);
        boolean isCreated = dir.mkdirs();
        ff = new File("C:\\Game\\ANewDawn\\Save\\"+name+"\\"+ this.name +".txt");
        ArrayList<ArrayList<AppOnMap>> save;
        save = new ArrayList<>();
        save = this.getmap();
        int test = 1;
        int limitLine = 0;
        
        
        
        ff.createNewFile();
        FileWriter ffw = new FileWriter(ff);
        
        for (ArrayList<AppOnMap> y : save){
            String SaveLine = "";
            ArrayList<Integer> line; 
            line = new ArrayList<>();
            limitLine = y.size();
            test = 1;
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
        catch (Exception e) {}
    
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
                int nX = this.map.get(y).size() ;
                ArrayList<Integer> line;
                line = new ArrayList<>();
                line = this.map.get(y);
                int pos = -1;
                if (pos < 0){
                    pos = elemMap.size();
                    elemMap.add(Elem);
                }
                while (nX<x){
                    nX++;
                    line.add(pos);
                }
                this.map.set(y, line);
                
            }
        }
        else{
            int nY = 1;
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
            
            while (nY<y-1){
                    line = new ArrayList<>();
                    line.add(pos);
                    nY++;
                    map.add(line);
                }
            line = new ArrayList<>();
            while (nX<x){
                nX++;
                line.add(pos);
            }
            map.add(line);
            
        }
    }
}