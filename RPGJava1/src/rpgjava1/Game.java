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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 *
 * @author Matthieu
 */
public class Game {
    private Land currentMap;
    private ArrayList<String[]> profiles;
    private int currentProfile;

    public Game(){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
    }
    
    public Game(Land currentMap, ArrayList<String[]> profiles, int currentProfile) {
        this.currentMap = currentMap;
        this.profiles = profiles;
        this.currentProfile = currentProfile;
    }
    
    public void initProfiles(String name) throws FileNotFoundException{
        
        try{
        InputStream flux=new FileInputStream("profiles\\"+"profiles"+".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        while ((line = buff.readLine())!=null){
            this.profiles.add(line.split(" "));
            
        }
        
        buff.close();
        
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    
}
    public ArrayList<String>  getProfiles (){
        ArrayList<String> listProfiles;
        listProfiles = new ArrayList<>();
        int len = this.profiles.size();
        int i;
        for (i = 0; i < len; i ++){
            listProfiles.add(this.profiles.get(i)[0]);
        }
        return listProfiles;
    }
    
    public void initNewProfile (String name){
        String[] profile;
        profile = new String[2];
        profile[0] = name;
        //this.currentMap.initMapFromSave("init", "Twilight's_Castle");
        //profile[1] = currentMap.getName();
        try{
            this.currentProfile = this.profiles.size();
            this.profiles.add(profile);
        }
        catch (Exception e){
            this.profiles = new ArrayList<>();
            currentProfile = 0;
            this.profiles.add(profile);
        }
    }
    
    public int initCurrentProfileFromSave(String name){
        int n = 0;
        int test = 1;
        for (String[] i: this.profiles){
            if (i [0] == null ? name == null : i [0].equals(name)){
                this.currentProfile = n;
                test = 0;
                currentMap.initMapFromSave(name, this.profiles.get(n)[1]);
            }
            n ++;
        }
        return test;
    }
    
    public void saveProfile(){
        String[] profile;
        profile = new String[2];
        profile[0] = this.profiles.get(this.currentProfile)[0]; 
        profile[1] = this.currentMap.getName();
        this.profiles.set(this.currentProfile, profile);
        try{
        String dirName = "profiles\\";
        File dir = new File(dirName);
        boolean isCreated = dir.mkdirs();
        File ff; // définir l'arborescence
        ff = new File("profiles\\"+"profiles"+".txt");
        
        ff.createNewFile();
        FileWriter ffw = new FileWriter(ff);
        
        for (String[] y : this.profiles){
            String SaveLine = "";
            SaveLine += y[0] + y[1] + " ";
            
            ffw.write(SaveLine);
            ffw.write("\n");
            }
        
        ffw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e) {}
    

    }
    
    public void writeSave(){
        this.currentMap.saveMap(this.profiles.get(this.currentProfile)[0]);
        saveProfile();
        
}
    public AppOnMap getPlayer (){
        return this.currentMap.getPlayer();
    }
    
    public AppOnMap getEntity (int x,int y){
        return this.currentMap.getEntity(x,y);
    }
    
    public void changeMap (String newMap){
        this.currentMap.saveMap(this.profiles.get(this.currentProfile)[0]);
        this.currentMap.initMapFromSave(this.profiles.get(this.currentProfile)[0], newMap);
        this.profiles.get(this.currentProfile)[1] = this.currentMap.getName();
    }
    
    public void addElemMap (AppOnMap Elem, int x, int y){
        this.currentMap.addElemMap(Elem, x, y);
    }
    
    public void displayMap (){
        this.currentMap.displayMap();
    }
    
}
