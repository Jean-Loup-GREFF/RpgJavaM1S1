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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Matthieu
 */
public class Game {
    private Land currentMap;
    private ArrayList<String[]> profiles;
    private int currentProfile;
    private char up, down, left, right;

    public Game(){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        up = 'z';
        down = 's';
        left = 'q';
        right = 'd';
    }
    
    public Game(Land currentMap, ArrayList<String[]> profiles, int currentProfile) {
        this.currentMap = currentMap;
        this.profiles = profiles;
        this.currentProfile = currentProfile;
    }
    
    public void initProfiles() {
        
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
    
    public void modifyButonsMov(){
        try{
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Entry the char you want to assign to the "
            + "movement go up");
            String str = sc.nextLine();
            if (str.length() > 1){
                char bug = str.charAt(str.length());//we provoc a bug to
                //go in the catch
            }
            this.up = str.charAt(0);
            System.out.println("You assigned " + this.up +" to go up");
            
            
            System.out.println("Entry the char you want to assign to the "
            + "movement go down");
            str = sc.nextLine();
            if (str.length() > 1){
                char bug = str.charAt(str.length());//we provoc a bug to
                //go in the catch
            }
            this.down = str.charAt(0);
            System.out.println("You assigned " + this.down +" to go down");
            
            System.out.println("Entry the char you want to assign to the "
            + "movement go left");
            str = sc.nextLine();
            if (str.length() > 1){
                char bug = str.charAt(str.length());//we provoc a bug to
                //go in the catch
            }
            this.left = str.charAt(0);
            System.out.println("You assigned " + this.left +" to go up");
            
            System.out.println("Entry the char you want to assign to the "
            + "movement go right");
            str = sc.nextLine();
            if (str.length() > 1){
                char bug = str.charAt(str.length());//we provoc a bug to
                //go in the catch
            }
            this.up = str.charAt(0);
            System.out.println("You assigned " + this.right +" to go up");
            
        }
        catch(Exception e){
            //Little error message which will only proc if u made a mystake up
            System.out.println("Try again with at least 1 or at most 1 char"
            + " or only one key of your keyboard seriously you thought we did"
                    + " not pay attention to that it may have been possible"
                    + "but sorry for you nope.");
            
        }
    }
    
    public int butonToInt (char move){
            int ret = -1;
        try{
            if (move == this.up ){
                ret = 0;
            }
            else if (move == this.left){
                ret = 1;
            }
            else if (move == this.down){
                ret = 2;
            }
            else if (move == this.right){
                ret = 3;
            }
            else{
                this.profiles.get(this.profiles.size());
            }
            return ret;
            
        } 
        catch(Exception e){
            System.out.println("Try again to move but next time with a button"
                    + "to do it.");
                return ret;
                }
        
    }
    
    public void moveOnMapTest (int x, int y, char move){
        int buton = butonToInt(move);
        this.currentMap.moveTo(x,y,buton);
        
    }
    
    
    
    public void moveOnMap(AppOnMap player,int x,int y){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        moveOnMapTest(x, y, str.charAt(0));
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
    
public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
}

    
    public void initNewProfile (String name){
        String[] profile;
        profile = new String[2];
        profile[0] = name;
        profile[1] = this.currentMap.getName();
        this.initProfiles();
        //this.currentMap.initMapFromSave("init", "Twilight's_Castle");
        //profile[1] = currentMap.getName();
        if (this.initCurrentProfileFromSave(name,"1")==1){
            this.profiles = new ArrayList<>();
            String[] test ={name, "1"};
            currentProfile = 0;
            this.currentMap.initMapFromSave(name, "1");
            profile[1] = "1";
            this.profiles.add(test);
            }
        System.out.println(this.currentProfile + " " + this.profiles.get(0)[0] + " " + this.profiles.get(0)[1]);
    }
    
    public int initCurrentProfileFromSave(String name, String name2){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        int n = 0;
        int test = 1;
        this.initProfiles();
        int aie = profiles.size();
        for (String[] i: this.profiles){
            if (i [0] == name){
                this.currentProfile = n;
                test = 0;
                
                currentMap.initMapFromSave(name, name2);
                break;
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
        int i = 0, l = this.profiles.size();
        
        ff.createNewFile();
        FileWriter ffw = new FileWriter(ff);
        
        for (String[] y : this.profiles){
            String SaveLine = "";
            SaveLine += y[0] + " " + y[1] ;
           
            ffw.write(SaveLine);
            i++;
            if (i!=l){
                ffw.write("\n");
            }
            
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
    public void changeElem (Integer x, Integer y, AppOnMap news){
        this.currentMap.changeElem(x,y,news);
    }
    
    public void displayMap (){
        this.currentMap.displayMap();
    }
    
}
