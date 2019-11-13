/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 *
 * @author Matthieu
 */
public class Game {
    public Land currentMap;
    
    public void initASave(String name){
        try{
        InputStream flux=new FileInputStream(name+".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        String[] objects;
        String[] type;
        ArrayList<ArrayList<AppOnMap>> map;
        ArrayList<AppOnMap> lineMap;
        String nameMap= new String();
        AppOnMap elem;
        int testNameMap = 0;
        int lenObjectLine;
        int i, j;
        map = new ArrayList<>();
        lineMap = new ArrayList<>();
        elem = new AppOnMap();
        
        while ((line = buff.readLine())!=null){
            
                if (testNameMap == 0){
                    nameMap = line;
                    testNameMap = 1;
                }
                
                else{
                    objects = line.split(";");
                    lenObjectLine = objects.length;
                    for (i = 0; i < lenObjectLine; i++){
                        type = objects[i].split(",");
                        elem.InitFromSave(type);
                        lineMap.add(elem);
                    }
                    map.add(lineMap);
                }
        }
        currentMap.InitMap(nameMap, map);
        buff.close(); 
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    
}
    public void writeSave(String name){
        try{
        File ff; // définir l'arborescence
        ff = new File("C:\\Game\\Save\\ANewDawn\\"+name+".txt");
        ArrayList<ArrayList<AppOnMap>> Save;
        Save = new ArrayList<>();
        Save = currentMap.getMap();
        int test = 1;
        int limitLine = 0;
        
        
        
        ff.createNewFile();
        FileWriter ffw = new FileWriter(ff);
        ffw.write(currentMap.getName());  // écrire une ligne dans le fichier resultat.txt
        ffw.write("\n"); // forcer le passage à la ligne
        
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
                }
            }
        
        ffw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e) {}
    
}
}
