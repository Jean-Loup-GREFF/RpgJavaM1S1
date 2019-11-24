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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/**
 *
 * @author Matthieu
 */
public class Game {
    private Land currentMap;
    private ArrayList<String[]> profiles;
    private int currentProfile;
    private char up, down, left, right;
    private Trap trapCurrentPosition;

    public Game(){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        up = 'z';
        down = 's';
        left = 'q';
        right = 'd';
        this.trapCurrentPosition = null;
    }
    
    public Game(Land currentMap, ArrayList<String[]> profiles, int currentProfile) {
        this.currentMap = currentMap;
        this.profiles = profiles;
        this.currentProfile = currentProfile;
        this.trapCurrentPosition = null;
    }
    
    public void initProfiles() {
        
        try{
        InputStream flux=new FileInputStream("profiles\\"+"profiles"+".txt"); 
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String line;
        int i = 0;
        while ((line = buff.readLine())!=null){
            
            this.profiles.add(line.split(" "));
            i++;
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
            else if (move == 'i'){
                ret = 4;
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
        this.currentMap.moveTo(x,y,buton,this);
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
    
    public int initNewProfile (String name,Player p){
        String[] profile;
        profile = new String[2];
        profile[0] = name;
        profile[1] = this.currentMap.getName();
        this.initProfiles();
        int test = 0;
        //this.currentMap.initMapFromSave("init", "Twilight's_Castle");
        //profile[1] = currentMap.getName();
        if (this.testNameNewProfile(name)==1){
            currentProfile = this.profiles.size();
            
            profile[0] = name;
            profile[1] = "Twilight'sCastle";
            this.profiles.add(profile);
            
            this.currentMap.initFirstMapFromSave(name);
            
            this.currentMap.changeElem(18,8,p);
            }
        else {
            test = 1;
        }
        return test;
    }
    
    public int testNameNewProfile (String name){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        int n = 0;
        int test = 1;
        this.initProfiles();
        for (String[] i: this.profiles){
            if (i[0].equals(name)){
                test = 0;
                break;
            }
            n ++;
        }
        return test;
    }
    
    public int initCurrentProfileFromSave(String name){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        int n = 0;
        int test = 1;
        this.initProfiles();
        for (String[] i: this.profiles){
            if (i[0].equals(name)){
                this.currentProfile = n;
                test = 0;
                
                currentMap.initMapFromSave(name, i[1]);
            try{
                this.trapCurrentPosition = new Trap();
                this.trapCurrentPosition.InitFromSave(i[2].split(","));
            }
            catch(Exception e){
            }
                break;
            }
            n ++;
        }
        return test;
    }
    
    public void saveProfile(){
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
            try {
                SaveLine += " " + y[2];
            }
            catch(Exception e){
            }
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
    
    public int[] getPlayer (){
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
    
    public boolean interaction(){
        int[] positionPlayer = getPlayer();
        int x = positionPlayer[0];
        int y = positionPlayer[1];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char move = str.charAt(0);
        int buton = butonToInt(move);
        AppOnMap player = getEntity(x,y);
        String type = "";
        AppOnMap destination = new AppOnMap();
        if(buton == 4){type = "Inventory";}
        else{
            destination = entityOnDirection(x,y,buton);
            type = destination.getClass().getSimpleName();
        }
        
        switch (type){
            case ("Mob"):
                fight(player, destination);
                if(player.isIsAlive()){
                    destination.defeat(player);
                    player.levelUp();
                    this.currentMap.moveTo(x,y,buton,this);
                    return true;
                }
                else{return false;}
            case ("Trap"):
                destination.setHide(false);
                Trap tmp = createTrap(destination);
                this.trapCurrentPosition = tmp;
                
                String[] profwithtrap = {
                    this.profiles.get(this.currentProfile)[0],
                        this.profiles.get(this.currentProfile)[1], 
                        this.trapCurrentPosition.getSaveText()}; 
                this.profiles.set(this.currentProfile,profwithtrap);
                destination.traps(player);
                this.currentMap.moveTo(x,y,buton,this);
                changeElem(x,y,trapCurrentPosition);
                this.trapCurrentPosition = tmp;
                return player.isIsAlive();
            case ("Chest"):
                destination.open(player);
                this.currentMap.moveTo(x,y,buton,this);
                return true;
            case("Merchant"):
                commerce(player,destination);
                return true;
            case("Inventory"):
                equip(player);
                return true;
            default:
                if(destination.getDisplay() == new VoidCase().getDisplay()){
                    this.currentMap.moveTo(x, y, buton,this);
                }
        }
        return true;
    }
    
    public AppOnMap entityOnDirection(int x, int y, Integer buton){
            switch(buton){
            case (0):
                return getEntity(x,y-1);
            case(1):
                return getEntity(x-1,y);
            case(2):
                return getEntity(x,y+1);
            case(3):
                return getEntity(x+1,y);
        }
        return null;
    }
    
    public static void fight(AppOnMap c1, AppOnMap c2){
        Scanner sc = new Scanner(System.in);
        c2.speak();
        System.out.println("[Press any touch to continue]");
        sc.nextLine();
        ArrayList<AppOnMap> c = new ArrayList<>();
        if(c1.getStats().getAgility() > c2.getStats().getAgility()){
            c.add(c1);
            c.add(c2);
        }
        if(c1.getStats().getAgility() > c2.getStats().getAgility()){
            c.add(c2);
            c.add(c1);
        }
        if(c1.getStats().getAgility() == c2.getStats().getAgility()){
            c.add(c1);
            c.add(c2);
        }
        System.out.println(c.get(0).getName() + "starts!");
        int i = 0;
        while (c.get(0).isIsAlive() && c.get(1).isIsAlive()){
            System.out.println(c.get(i%2).getName() + ":" + c.get(i%2).getHealth() + " HP");
            System.out.println(c.get((i+1)%2).getName() + ":" + c.get((i+1)%2).getHealth() + " HP");
            c.get(i%2).attack(c.get((i+1)%2));
            System.out.println(c.get(i%2).getName() + ":" + c.get(i%2).getHealth() + " HP");
            System.out.println(c.get((i+1)%2).getName() + ":" + c.get((i+1)%2).getHealth() + " HP");
            i++;
        }
    }
    
    public Trap createTrap(AppOnMap falseTrap){
        int damage = falseTrap.getDamage();
        boolean hide = falseTrap.isHide();
        return new Trap(damage,hide);
    }
    
    public void commerce(AppOnMap player, AppOnMap merchant){
        merchant.speak();
        Scanner sc = new Scanner(System.in);
        char choice = ' ';
        do{
            System.out.println("What do you want to do?\nb)Buy\nSell\nq)Quit");
            String str = sc.nextLine().toUpperCase();
            char choice1 = (char)50;
            char choice2 = (char)50;
            ArrayList<Item> inventory = new ArrayList<>();
            ArrayList<Integer> quantity = new ArrayList<>();
            Inventory trade = null;
            if(str.length() > 0){choice = str.charAt(0);}
            while(choice != 'B' && choice != 'S' && choice != 'Q'){
                str = sc.nextLine().toUpperCase();
                if(str.length() > 0){choice = str.charAt(0);}
            }
            switch(choice){
                case('B'):
                    int lenB = merchant.getInventory().getInventory().size()-1;
                    if(lenB == 0){
                        System.out.println(merchant.getName() + " don't have any item to sell!  [PRESS any touch to continue]");
                        sc.nextLine();
                        return ;
                    }
                    int quantityMB = lenB;
                    do{
                        if(((int)choice1<49 && (int)choice1>49-lenB)||((int)choice2<49 && (int)choice2>49-quantityMB)){
                            System.out.println("Please enter a number");
                        }
                        merchant.getInventory().display();
                        System.out.println("What item do you want? (enter 1 for the first, 2 for the second and so on...)");

                        str = sc.nextLine().toUpperCase();
                        if(str.length() > 0){choice1 = str.charAt(0);}
                        else{choice1 = ' ';}
                        if((int)choice1<49 && (int)choice1>49-lenB){
                            quantityMB = merchant.getInventory().getQuantity().get(choice1-49);
                            System.out.println("In which quantity?");
                            if(str.length() > 0){choice2 = str.charAt(0);}
                            else{choice2 = ' ';}
                        }
                    }while(!((int)choice1>=49 && (int)choice1<=49-lenB && (int)choice2>=49 && (int)choice2<=49-quantityMB));
                    inventory.add(merchant.getInventory().getInventory().get(choice1-49));
                    quantity.add((int)choice2);
                    trade = new Inventory(inventory,quantity,((int)choice2)*inventory.get(0).getPrice());
                    merchant.sell(trade, player.getInventory());
                case('S'):
                    int lenS = player.getInventory().getInventory().size()-1;
                    if(lenS == 0){
                        System.out.println("You don't have any item to sell!  [PRESS any touch to continue]");
                        sc.nextLine();
                        return ;
                    }
                    int quantityMS = lenS;
                    do{
                        if(((int)choice1<49 && (int)choice1>49-lenS)||((int)choice2<49 && (int)choice2>49-quantityMS)){
                            System.out.println("Please enter a number");
                        }
                        player.getInventory().display();
                        System.out.println("What item do you want? (enter 1 for the first, 2 for the second and so on...)");

                        str = sc.nextLine().toUpperCase();
                        if(str.length() > 0){choice1 = str.charAt(0);}
                        else{choice1 = ' ';}
                        if((int)choice1<49 && (int)choice1>49-lenS){
                            quantityMS = player.getInventory().getQuantity().get(choice1-49);
                            System.out.println("In which quantity?");
                            if(str.length() > 0){choice2 = str.charAt(0);}
                            else{choice2 = ' ';}
                        }
                    }while(!((int)choice1>=49 && (int)choice1<=49-lenS && (int)choice2>=49 && (int)choice2<=49-quantityMS));

                    inventory.add(merchant.getInventory().getInventory().get(choice1-49));
                    quantity.add((int)choice2);
                    trade = new Inventory(inventory,quantity,((int)choice2)*inventory.get(0).getPrice());
                    merchant.buy(trade, player.getInventory());
            }
        }while(choice != 'Q');
        System.out.println(merchant.getName() + ":See You !");
        sc.nextLine();
    }
    
    public void equip(AppOnMap player){
        Scanner sc = new Scanner(System.in);
        char choice = (char)50;
        String str = "";
        int len = player.getInventory().getInventory().size();
        if(len == 0){
            System.out.println("Your inventory is empty! [PRESS any touch to continue]");
            sc.nextLine();
            return ;
        }
        do{
            player.getInventory().display();
            if((int)choice<49 && (int)choice>49-len){
                System.out.println("Please enter a number");
            }
            System.out.println("Which item do you want to equip? (Enter a number (1 for the first, 2 for the second, and so on...)");
            str = sc.nextLine().toUpperCase();
            if(str.length() == 0){choice = ' ';}
        }while(!((int)choice>=49 && (int)choice<=49-len));
        int item = choice-49;
        int[] equip = player.getEquipment();
        boolean can = true;
        for(int i = 0 ; i<equip.length; i++){
            if(equip[i] == item){
                can = false;
            }
        }
        if(!can){
            System.out.println("You have already equipped this item! [PRESS any touch to continue]");
            sc.nextLine();
            return ;
        }
        for(int i = 0 ; i<equip.length; i++){
            if(equip[i] == -1){
                player.setOnePiece(item, i);
                break;
            }
        }
    }
    
    public int getCurrentProfile(){
        return this.currentProfile;
    }
    
    public void setProfiles(int i, String[] nprofile){
        this.profiles.set(i,nprofile);
        
    }
    
    public void mainMenu(){
        
    }
}
