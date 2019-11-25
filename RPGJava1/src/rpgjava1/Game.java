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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Principal Class of the Game
 * 
 * @author Matthieu
 */
public class Game {
    private Land currentMap;
    private ArrayList<String[]> profiles;
    private int currentProfile;
    private char up, down, left, right;
    private Trap trapCurrentPosition;

    /**
     * Create a simple instance of the game
     * You need to create one to play
     * Then call mainMenu
     */
    public Game(){
        this.currentMap = new Land();
        this.profiles = new ArrayList<>();
        up = 'z';
        down = 's';
        left = 'q';
        right = 'd';
        this.trapCurrentPosition = null;
    }
    
    /**
     * Create a complete instance of Game
     * 
     * @param currentMap
     * the map of the Land
     * @param profiles
     * the list of all the profiles saved on the computer
     * @param currentProfile
     * actual profile use to play
     */
    public Game(Land currentMap, ArrayList<String[]> profiles, 
            int currentProfile) {
        this.currentMap = currentMap;
        this.profiles = profiles;
        this.currentProfile = currentProfile;
        this.trapCurrentPosition = null;
    }

    /**
     * 
     * 
     * @return 
     * the actual Trap present on the same case as the player
     */
    public Trap getTrapCurrentPosition() {
        return trapCurrentPosition;
    }

    /**
     *
     * @param trapCurrentPosition
     * the actual Trap present on the same case as the player
     */
    public void setTrapCurrentPosition(Trap trapCurrentPosition) {
        this.trapCurrentPosition = trapCurrentPosition;
    }
    
    /**
     * collect all profiles save on the computer
     * 
     */
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
    
    /**
     * Allow to modify the link between a key and a action in the game
     * 
     */
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
    
    /**
     * Transform a char from a key press on the keybord in a instruction
     * 
     * @param move
     * the key pressed by the user
     * @return
     * the conversion of the key pressed by the user
     */
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
            else if (move == 'a'){
                ret = 5;
            }
            else if (move == 'l'){
                ret = 6;
            }
            else{
                this.profiles.get(this.profiles.size());
            }
            return ret;
            
        } 
        catch(Exception e){
            System.out.println("Try again to move but next time with a button "
                    + "to do it.");
                return ret;
                }
        
    }
    
    /**
     *
     * @return
     * All the profiles save on the computer
     */
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
    
    /**
     * clear the console on the Windows's console
     *
     */
    public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
    }
    
    /**
     * Initialize a New profile from the name of the player
     * and the player object
     *
     * @param name
     * the name of the new profile
     * @param p
     * the Object Player created
     * @return 
     * 0 if no problem else 1
     */
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
    
    /**
     * test if the name is already use
     *
     * @param name
     * the name we need to test to verify his unicity
     * @return 
     */
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
    
    /**
     * Initialize the profile from the save in the computer
     *
     * @param name
     * the name of the profile we want to load from the computer
     * @return
     * 0 if no problem else 1
     */
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
    
    /**
     * save the profile in the computer
     *
     */
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

    /**
     * save the map and the profile on the computer
     *
     */
    public void writeSave(){
        this.currentMap.saveMap(this.profiles.get(this.currentProfile)[0]);
        saveProfile();
}
    
    /**
     * give the position of the Player on the map
     *
     * @return the position of the player on the currentMap
     */
    public int[] getPlayer (){
        return this.currentMap.getPlayer();
    }
    
    /**
     * return the Entity(AppOnMap) presents on position (x,y)
     *
     * @param x
     * @param y
     * @return
     */
    public AppOnMap getEntity (int x,int y){
        return this.currentMap.getEntity(x,y);
    }
    
    /**
     *
     * @param newMap
     * the new Map on which we want to play
     */
    public void changeMap (String newMap){
        this.currentMap.saveMap(this.profiles.get(this.currentProfile)[0]);
        this.currentMap.initMapFromSave(
                this.profiles.get(this.currentProfile)[0], newMap);
        this.profiles.get(this.currentProfile)[1] = this.currentMap.getName();
    }
    
    /**
     *
     * @param Elem
     * the new AppOnMap we want to add on the Map
     * @param x
     * coordinate(colums) on which
     * @param y
     */
    public void addElemMap (AppOnMap Elem, int x, int y){
        this.currentMap.addElemMap(Elem, x, y);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param news
     */
    public void changeElem (Integer x, Integer y, AppOnMap news){
        this.currentMap.changeElem(x,y,news);
    }
    
    /**
     * display the map and the instruction to play
     *
     */
    public void displayMap (){
        this.currentMap.displayMap();
        System.out.println("What do you want to do?");
        System.out.println("(I)nventory\nS(A)ve\n(L)eave"
                + "\n(Z)Up/(Q)Left/(S)Down/(D)Right");
    }
    
    /**
     * gestion of the interaction between the player and the other AppOnMap
     *
     * @param st
     * @return
     */
    public boolean interaction(Scanner st){
        int[] positionPlayer = getPlayer();
        int x = positionPlayer[0];
        int y = positionPlayer[1];
        String str = "";
        int buton = -1;
        char move;
        do{
            str = st.nextLine();
            str = str.toLowerCase();
            if(str.length()==0){move = ' ';}
            else{move = str.charAt(0);}
            buton = butonToInt(move);
        }while(buton==-1);
        AppOnMap player = getEntity(x,y);
        String type;
        boolean next = true;
        char nextChoice = ' ';
        AppOnMap destination = new AppOnMap();
        if(buton == 4){type = "Inventory";}
        else {if(buton == 5){type = "Save";}
        else {if(buton == 6){type = "Quit";}
        else{
            destination = entityOnDirection(x,y,buton);
            type = destination.getClass().getSimpleName();
        }}}
        switch (type){
            case ("Mob"):
                fight(player, destination,st);
                clrscr();
                if(player.isIsAlive()){
                    System.out.println(destination.getInventory().getSaveTextInv());
                    destination.defeat(player);
                    player.levelUp();
                    this.currentMap.moveTo(x,y,buton, this);
                    return true;
                }
                else{String nextStr;
                    System.out.println("You die!\nDo you want to continue? "
                            + "(Y)es or (N)o");
                    do{
                        nextStr = st.nextLine().toUpperCase();
                        if(nextStr.length()==0){
                            nextChoice = ' ';
                        }
                        else{nextChoice = nextStr.charAt(0);}
                        clrscr();
                    }while((int)nextChoice!=89 && (int)nextChoice!=78);   
                    switch(nextChoice){
                        case('Y'):
                            initCurrentProfileFromSave(player.getName());
                            return true;
                        case('N'):
                            return false;
                    }}
            case ("Trap"):
                Trap tmp = createTrap(destination);
                destination.traps(player);
                this.trapCurrentPosition = null;
                this.currentMap.moveTo(x,y,buton, this);
                this.trapCurrentPosition = tmp;
                this.trapCurrentPosition.setHide(false);
                String[] profwithtrap = {
                    this.profiles.get(this.currentProfile)[0],
                        this.profiles.get(this.currentProfile)[1], 
                        this.trapCurrentPosition.getSaveText()}; 
                this.profiles.set(this.currentProfile,profwithtrap);
                if(!player.isIsAlive()){
                    String nextStr;
                    System.out.println("You die!\nDo you want to continue? "
                            + "(Y)es or (N)o");
                    do{
                        nextStr = st.nextLine().toUpperCase();
                        if(nextStr.length()==0){
                            nextChoice = ' ';
                        }
                        else{nextChoice = nextStr.charAt(0);}
                        clrscr();
                    }while((int)nextChoice!=89 && (int)nextChoice!=78);   
                    switch(nextChoice){
                        case('Y'):
                            initCurrentProfileFromSave(player.getName());
                            return true;
                        case('N'):
                            return false;
                    }
                }
                return true;
            case ("Chest"):
                System.out.println("You open a chest!");
                destination.open(player);
                this.currentMap.moveTo(x,y,buton, this);
                return true;
            case("Merchant"):
                clrscr();
                commerce(player,destination,st);
                return true;
            case("Inventory"):
                equip(player,st);
                return true;
            case("Save"):
                this.writeSave();
                return true;
            case("Quit"):
                return false;
            default:
                if(destination.getDisplay() == new VoidCase().getDisplay()){
                    this.currentMap.moveTo(x, y, buton, this);
                }
        }
        return true;
    }
    
    /**
     * return the Entity (AppOnMap) present
     * on the case next to the chosen position (x,y)
     * in the direction chose by buton
     *
     * @param x
     * @param y
     * @param buton
     * @return
     */
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
    
    /**
     * Display and realise the fight between two AppOnMaps
     *
     * @param c1
     * @param c2
     * @param sc
     */
    public void fight(AppOnMap c1, AppOnMap c2, Scanner sc){
        clrscr();
        c2.speak();
        System.out.println("[Press any touch to continue]");
        sc.nextLine();
        clrscr();
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
        System.out.println(c.get(0).getName() + " starts!");
        int i = 0;
        while (c.get(0).isIsAlive() && c.get(1).isIsAlive()){
            System.out.println(c.get(i%2).getName() + ":" 
                    + c.get(i%2).getHealth() + " HP");
            System.out.println(c.get((i+1)%2).getName() + ":" 
                    + c.get((i+1)%2).getHealth() + " HP");
            c.get(i%2).attack(c.get((i+1)%2), sc);
            System.out.println(c.get(i%2).getName() + ":" 
                    + c.get(i%2).getHealth() + " HP");
            System.out.println(c.get((i+1)%2).getName() + ":" 
                    + c.get((i+1)%2).getHealth() + " HP");
            System.out.println("");
            clrscr();
            i++;
        }
    }
    
    /**
     * Copy the pseudo-Trap give as parameters in a real Trap
     *
     * @param falseTrap
     * @return
     */
    public Trap createTrap(AppOnMap falseTrap){
        int damage = falseTrap.getDamage();
        boolean hide = falseTrap.isHide();
        return new Trap(damage,hide);
    }
    
    /**
     * display and realise the exchange between two AppOnMapss
     *
     * @param player
     * @param merchant
     * @param sc
     */
    public void commerce(AppOnMap player, AppOnMap merchant, Scanner sc){
        merchant.speak();
        System.out.println("I'm sorry, but I cab't sell or buy anything");
        sc.nextLine();
        /*char choice = ' ';
        do{
            System.out.println("What do you want to do?\n(B)uy\n(S)ell\n(Q)uit");
            String str = sc.nextLine().toUpperCase();
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
                    int lenB = merchant.getInventory().getInventory().size();
                    if(lenB == 0){
                        System.out.println(merchant.getName() 
                                + " don't have any item to sell!  "
                                        + "[PRESS any touch to continue]");
                        sc.nextLine();
                        return ;
                    }
                    int quantityMB = 0;
                    boolean validB1 = false;
                    boolean validB2 = false;
                    int choiceB1 = -1;
                    int choiceB2 = -1;
                    String strB = "";
                    do{
                        choice = ' ';
                        if(!validB1||!validB2){
                            System.out.println("Please enter a number");
                        }
                        merchant.getInventory().display();
                        System.out.println("What item do you want? "
                                + "(enter 1 for the first, "
                                + "2 for the second and so on...)"
                                + "\nPress (L) to leave.");
                        validB1 = !sc.hasNextInt();
                        if(!validB1){choiceB1 = sc.nextInt()-1;}
                        strB = sc.nextLine();
                        if(strB.length()!=0 && strB.toUpperCase()
                                .charAt(0)=='L'){
                            return ;
                        }
                        if(choiceB1<0 || choiceB1>=lenB){
                            validB1 = !validB1;
                        }
                        if(!validB1){
                            quantityMB = merchant.getInventory()
                                    .getQuantity().get(choiceB1);
                            System.out.println("In which quantity?");
                            validB2 = !sc.hasNextInt();
                            if(!validB2){choiceB2 = sc.nextInt()-1;}
                            if(choiceB2<0 || choiceB2>=quantityMB){
                                validB2 = !validB2;
                            }
                        }
                    }while(validB1 || validB2);
                    inventory.add(merchant.getInventory().getInventory()
                            .get(choiceB1));
                    quantity.add(choiceB2);
                    trade = new Inventory(inventory,quantity,(
                            choiceB2)*inventory.get(0).getPrice());
                    merchant.sell(trade, player.getInventory());
                    break;
                case('S'):
                    boolean validS1 = false;
                    boolean validS2 = false;
                    int choiceS1 = -1;
                    int choiceS2 = -1;
                    String strS = "";
                    int lenS = player.getInventory().getInventory().size();
                    if(lenS < 1){
                        System.out.println("You don't have any item to sell!  "
                                + "[PRESS any touch to continue]");
                        sc.nextLine();
                        return ;
                    }
                    int quantityMS = lenS;
                    do{
                        if(!validS1||!validS2){
                            System.out.println("Please enter a number");
                        }
                        player.getInventory().display();
                        System.out.println("What item do you want? ("
                                + "enter 1 for the first, "
                                + "2 for the second and so on...)"
                                + "\nPress (L) to leave.");
                        validS1 = !sc.hasNextInt();
                        if(!validS1){choiceS1 = sc.nextInt();}
                        strS = sc.nextLine();
                        if(strS.length()!=0 && strS.toUpperCase()
                                .charAt(0)=='L'){
                            return ;
                        }
                        if(choiceS1<0 || choiceS1>lenS){validS1 = !validS1;}
                        if(validS1){
                            quantityMS = player.getInventory()
                                    .getQuantity().get(choiceS1);
                            System.out.println("In which quantity?");
                            validS2 = sc.hasNextInt();
                            if(!validS2){choiceS2 = sc.nextInt();}
                            if(choiceS2<0 || choiceS2>=quantityMS){
                                validS2 = !validS2;
                            }
                        }
                    }while(!validS1 && !validS2);

                    inventory.add(
                            merchant.getInventory().getInventory().get(choiceS1));
                    quantity.add((int)choiceS2);
                    trade = new Inventory(inventory,quantity,
                            ((int)choiceS2)*inventory.get(0).getPrice());
                    merchant.buy(trade, player.getInventory());
            }
        }while(choice != 'Q');
        System.out.println(merchant.getName() + ":See You !");
        sc.nextLine();*/
    }
    
    /**
     * display and realise the inventory of the player
     * 
     * @param player
     * @param sc
     */
    public void equip(AppOnMap player, Scanner sc){
        int choice = -1;
        boolean valid = false;
        String str = "";
        int len = player.getInventory().getInventory().size();
        if(len == 0){
            System.out.println("Your inventory is empty! "
                    + "[PRESS any touch to continue]");
            sc.nextLine();
            return ;
        }
        do{
            player.getInventory().display();
            if((int)choice<49 && (int)choice>49-len){
                System.out.println("Please enter a number");
            }
            System.out.println("Which item do you want to equip? "
                    + "(Enter a number (1 for the first, "
                    + "2 for the second, and so on...)"
                    + "\nPress (L) to leave.");
            valid = !sc.hasNextInt();
            if(!valid){choice = sc.nextInt();}
            str = sc.nextLine();
            if(str.length()!=0 && str.toUpperCase()
                    .charAt(0)=='L'){
                return ;
            }
            if(choice<0 || choice>=len){valid = !valid;}
        }while(!valid);
        int item = choice-1;
        int[] equip = player.getEquipment();
        boolean can = true;
        for(int i = 0 ; i<equip.length; i++){
            if(equip[i] == item){
                can = false;
            }
        }
        if(!can){
            System.out.println("You have already equipped this item! "
                    + "[PRESS any touch to continue]");
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
    
    /**
     *
     * @return
     */
    public int getCurrentProfile(){
        return this.currentProfile;
    }
    
    /**
     *
     * @param i
     * @param nprofile
     */
    public void setProfiles(int i, String[] nprofile){
        this.profiles.set(i,nprofile);
    }
    
    /**
     *
     * @return
     */
    public String[] getProfileUse(){
        return this.profiles.get(currentProfile);
    }
    
    /**
     * display and realise the main menu of the game
     * such as new game, load game
     *
     * @param sc
     */
    public void mainMenu(Scanner sc){
        String strchoice = "";
        String str = "";
        String name = "";
        String str2 = "";
        Player player;
        boolean valid;
        char choice = (char)49;
        do{
            clrscr();
            System.out.println("A New Dawn");
            System.out.println("1) New Game\n2) Load Game\n3)Leave");
            System.out.println("What do you want to do?");
            if((int)choice<49 || (int)choice>51){
                System.out.println("Please enter a correct number!");
            }
            strchoice = sc.nextLine().toUpperCase();
            if(strchoice.length() != 0){choice = strchoice.charAt(0);}
            else{choice = ' ';}
        }while((int)choice<49 || (int)choice>51);
        clrscr();
        switch(choice){
            case('1'):
                char choiceC = ' ';
                valid = false;
                do{
                    do{
                        clrscr();
                        System.out.println("Create a new game!");
                        if(valid){
                            System.out.println(name 
                                    + ", is already use, "
                                            + "please choose another name");
                        }
                        System.out.println("What is your name?");
                        if(contains(str," /:*?\"<>|\\")){
                            System.out.println("/:*?\"<>|\\ "
                                    + "are illegals characters");
                        }
                        str = sc.nextLine();
                    }while(contains(str,"/:*?\"<>|\\"));
                    name = str;
                    do{
                        System.out.println("Which class do you want to play?");
                        System.out.println("1) Thief\n2) Warrior\n3) Wizard");
                        if((int)choiceC<49 || (int)choiceC>51){
                            System.out.println("Please enter "
                                    + "a correct number!");
                        }
                        str2 = sc.nextLine().toUpperCase();
                        if(str2.length() != 0){choiceC = str2.charAt(0);}
                        else{choiceC = ' ';}
                    }while((int)choice<49 || (int)choice>51);
                    player = new Player(name);
                    switch(choiceC){
                        case('1'):
                            player.setArchetype(new ThiefClass());
                            break;
                        case('2'):
                            player.setArchetype(new WarriorClass());
                            break;
                        case('3'):
                            player.setArchetype(new WizardClass());
                            break;
                    }
                    valid = initNewProfile(name, player) == 1;
                }while(valid);
                this.writeSave();
               break;
            case('2'):
                valid = true;
                int choiceP = -1;
                initProfiles();
                if(this.profiles.size()<=0){
                    System.out.println("You don't have saves!");
                    return ;
                }
                do{
                    System.out.println("Which game do you want to load?");
                    for (int i = 0; i<this.profiles.size();i++){
                        System.out.println(i + ") " 
                                + this.profiles.get(i)[0] + ":" 
                                + this.profiles.get(i)[1]);
                    }
                    if(!valid){System.out.println("Enter a correct number");}
                    valid = !sc.hasNextInt();
                    if(!valid){choiceP = sc.nextInt();}
                    sc.nextLine();
                    if(choiceP<0 || choiceP>=this.profiles.size() || choice==-1){
                        valid = true;
                    }
                }while(valid);
                initCurrentProfileFromSave(this.profiles.get(choiceP)[0]);
                break;
            case('3'):
            default:
                return ;
        }
        /*ArrayList<Item> in = new ArrayList<>();
        ArrayList<Integer> q = new ArrayList<>();
        in.add(new Item("Ring",Rarity.COMMUN,50,new Statistic(),"A_ring"));
        q.add(1);
        Inventory invent = new Inventory(in,q,1000);
        Chest chest = new Chest(invent);
        this.currentMap.changeElem(5, 12, chest);
        ArrayList<Item> inv = new ArrayList<>();
        ArrayList<Integer> qu = new ArrayList<>();
        inv.add(new Item("Excalibur",Rarity.EPIC,250,new Statistic(),"Saint_Sword"));
        qu.add(1);
        Inventory invento = new Inventory(inv,qu,500);
        Merchant merchant = new Merchant("merchant",1,999,999,new Statistic(),invento,true,'M',1.2,0.1);
        this.currentMap.changeElem(4, 4, merchant);
        ArrayList<Item> inve = new ArrayList<>();
        ArrayList<Integer> qua = new ArrayList<>();
        inve.add(new Item("Wooden_Hood",Rarity.GODLIKE,2500,new Statistic(5,5,10,10,50,10,0),"???"));
        qua.add(1);
        Inventory inventor = new Inventory(inve,qua,100);
        Mob mob = new Mob("monster",1,20,20,new Statistic(),inventor,true,'m',25);
        this.currentMap.changeElem(8,2,mob);*/
        
        do{
            clrscr();
            this.displayMap();
        }while(this.interaction(sc));
    }
    
    /**
     * test if several character are present individually in a String
     *
     * @param str
     * @param chars
     * @return
     */
    public boolean contains(String str, String chars){
        int len = chars.length();
        for(int i = 0; i<len; i++){
            if(str.contains(""+chars.charAt(i))){return true;}
        }
        return false;
    }
}
