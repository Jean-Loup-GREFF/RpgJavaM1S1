/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */
public class Land {
    private String name;
    private ArrayList<AppOnMap> elemMap;
    private ArrayList<ArrayList<Integer>> map;

    /**
     * method to initialize a land object
     *
     */
    public Land() {
        this.name = "1";
        this.elemMap = new ArrayList<>();
        this.map = new ArrayList<>();
    }
   
    /**
     * method to initialize a land object with all parameters
     *
     * @param name
     * @param elemMap
     * @param map
     */
    public Land(String name, ArrayList<AppOnMap> elemMap,
            ArrayList<ArrayList<Integer>> map) {
        this.name = name;
        this.elemMap = elemMap;
        this.map = map;
    }
 
    /**
     * method to init the map
     *
     */
    public void InitMap(){
        this.name = new String();
        this.name = "";
        this.elemMap = new ArrayList<>();
        this.map = new ArrayList<>();
    }
    
    /**
     * method to init a map from an ArrayListArrayListAppOnMap
     *
     * @param name
     * @param Save
     */
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
    
    /**
     * method to get an apponmap object from the land object
     *
     * @param x
     * @param y
     * @return
     */
    public AppOnMap getEntity (int x,int y){
        return elemMap.get(map.get(y).get(x));
    }
    
    /**
     * method to get player position on map
     *
     * @return
     */
    public int[] getPlayer (){

        Player p = new Player("");
        int n = 0, cx = 0 , cy = 0, x = -1, y = -1;
        for (int i= 0; i<this.elemMap.size(); i++){
            if ((""+this.elemMap.get(i).getDisplay()).equals(""+p.getDisplay())){
                break;
            }
            n++;
        }
        
        for (ArrayList<Integer> Y : this.map){
            cx = 0;
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
    
    /**
     * method to init a map from an ArrayList<ArrayList<AppOnMap>> with name
     * parameter
     *
     * @param Save
     * @param name
     */
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

    /**
     * method to init a land object with the name of the map
     *
     * @param name
     */
    public Land(String name) {
        this.name = name;
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
    }

    /**
     * method the display the map on screen
     *
     */
    public void displayMap() {
        
        for (ArrayList<Integer> i : this.map){
            for (Integer j : i){
                if ((""+this.elemMap.get(j).getDisplay()).equals("+")){
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

    /**
     * method to get the name of the map
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * method to change an element to one we want of the map throught coordonate
     * and apponmap parameters
     *
     * @param x
     * @param y
     * @param news
     */
    public void changeElem (Integer x, Integer y, AppOnMap news){
                if(!this.isElem(news)){
                    this.map.get(y).set(x,this.elemMap.size());
                    this.elemMap.add(news);
                }
                else{
                    this.map.get(y).set(x,this.posElem(news));
                }
    }
    
    /**
     * method to move an app on map on coordonate (x,y) to a position indicated
     * by buton
     *
     * @param x
     * @param y
     * @param buton
     * @param game
     * @return
     */
    public int moveTo (Integer x, Integer y, Integer buton, Game game){
        
        VoidCase voids = new VoidCase();
        int test = 1;
        AppOnMap temp = new AppOnMap();
        
        switch(buton){
            case (0)://up buton case
                if (game.getTrapCurrentPosition() == null){
                //test for trap gestion
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y-1, temp);
                }
                else{
                    //gestion when on trap
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x, y-1, temp);
                    String[] nprof = game.getProfileUse();
                    game.setProfiles(game.getCurrentProfile(), nprof);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(1)://left button case
                if (game.getTrapCurrentPosition() == null){
                    //test for trap gestion
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x-1, y, temp);
                }
                else{
                    //gestion when on trap
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x-1, y, temp);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(2)://down case buton
                if (game.getTrapCurrentPosition() == null){
                    //test for trap gestion
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x, y+1, temp);
                }
                else{
                    //gestion when on trap
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, game.getTrapCurrentPosition());
                    changeElem (x, y+1, temp);
                    game.setTrapCurrentPosition(null);
                }
                break;
            case(3)://rightc case buton 
                if (game.getTrapCurrentPosition() == null){
                    //test for trap gestion
                    temp = this.elemMap.get(this.map.get(y).get(x));
                    changeElem (x, y, voids);
                    changeElem (x+1, y, temp);
                }
                else{
                    //gestion when on trap
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
    
    /**
     * method to get the map as an ArrayListArrayListAppOnMap
     *
     * @return
     */
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
    
    /**
     * method to init a map for a new profile
     *
     * @param name
     * @return
     */
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
                    /*
                    all the slpits and cases are to manage all the 
                    initialisations possible for all objects possible
                    */
                    elem = new AppOnMap();
                    Character cha = new Character("",'.');
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
                            elem.InitFromSave(type[0]);
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
                        case 9:
                            mob.InitFromSave(type);
                            if (! isElem(mob)){
                                
                                n = this.elemMap.size();
                                this.elemMap.add(mob);
                                
                            }
                            else{
                                n = this.posElem(mob);
                            }
                            break;
                        case 10:
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
                    }
                    this.map.add(linemap);
                
        }
       
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
        return this.name;
    }
    
    /**
     * init a map from a save thanks to the path given by the profile name and
     * map
     *
     * @param nameProf
     * @param namemap
     */
    public void initMapFromSave(String nameProf, String namemap){
        this.name = namemap;
        this.map = new ArrayList<>();
        this.elemMap = new ArrayList<>();
        try{
        InputStream flux = new FileInputStream("save\\"+nameProf+"\\"+ this.name +".txt"); 
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
                    /*
                    all the slpits and cases are to manage all the 
                    initialisations possible for all objects possible
                    */
                    elem = new AppOnMap();
                    Character cha = new Character("", '.');
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
                        case 9:
                            mob.InitFromSave(type);
                            if (! isElem(mob)){
                                n = this.elemMap.size();
                                this.elemMap.add(mob);
                            }
                            else{
                                n = this.posElem(mob);
                            }
                            break;
                        case 10:
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
       
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    }
    
    /**
     * get the position of an elem on the elemMap array
     *
     * @param Elem
     * @return
     */
    public int posElem (AppOnMap Elem){
        int n = 0;
        for(AppOnMap j: this.elemMap){
            if ((""+Elem.getDisplay()).equals((""+j.getDisplay()))){
                break;
            }
            n++;
        }
        return n;
    }
    
    /**
     * method to test if the elem is already put at least once in the elem array 
     *
     * @param Elem
     * @return
     */
    public boolean isElem (AppOnMap Elem){
        boolean test = false;
        for(AppOnMap j: this.elemMap){
            if ((""+Elem.getDisplay()).equals((""+j.getDisplay()))){
                test = true;
                break;
            }
        }
        return test;
    }
    
    /**
     * method to save the map as a test file
     *
     * @param name
     */
    public void saveMap(String name){
        try{
        File ff; // définir l'arborescence
        String dirName = "save\\"+name+"\\";
        File dir = new File(dirName);
        boolean isCreated = dir.mkdirs();
        ff = new File("save\\"+name+"\\"+ this.name +".txt");
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
    
    /**
     * method which helped to initialize the first map there are still some
     * unresolded problems
     *
     * @param Elem
     * @param x
     * @param y
     */
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
            
            boolean test = isElem(Elem);
            int pos = -1;
            if(test){
                pos = posElem(Elem);
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