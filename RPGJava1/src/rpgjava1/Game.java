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
    public Land currentMap;
    public ArrayList<String[]> profiles;
    public int currentProfile;
    
    public void initProfiles(String name) throws FileNotFoundException{
        
        try{
        InputStream flux=new FileInputStream("profiles\\"+name+".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        while ((line = buff.readLine())!=null){
            profiles.add(line.split(" "));
            
        }
        
        buff.close();
        
        }		
        catch (Exception e){
        System.out.println("Your save have been corrupted");
        }
    
}
    
    public void initCurrentProfile(String name){
        int n = 0;
        for (String[] i: profiles){
            if (i [0] == null ? name == null : i [0].equals(name)){
                currentProfile = n;
                n ++;
            }
        }
    }
    public void writeSave(String name){
        currentMap.saveMap(profiles.get(currentProfile)[0]);
}
    
}
