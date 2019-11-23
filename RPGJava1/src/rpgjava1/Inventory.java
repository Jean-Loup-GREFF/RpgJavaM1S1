/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;
import java.util.ArrayList; // import the ArrayList class
/**
 *
 * @author Matthieu
 */
public class Inventory {
    private ArrayList<Item> inventory;
    private ArrayList<Integer> quantity;
    private int gold;

    public Inventory() {
        this.inventory = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.gold = 0;
    }
    
    public Inventory(ArrayList<Item> inventory, ArrayList<Integer> quantity, int gold) {
        this.inventory = inventory;
        this.quantity = quantity;
        this.gold = gold;
    }
    
    public void InitInventory (int golf){
        this.inventory = new ArrayList<>();
        this.quantity = new ArrayList<>();
        this.gold = golf;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public void display(){
        for(int i = 0;i < this.inventory.size(); i++){
            System.out.print(this.quantity.get(i));
            System.out.print("x \t");
            System.out.println(this.inventory.get(i).getName());
        }
        System.out.print("Gold(s): ");
        System.out.println(this.gold);
    }
    
    public int remove(Item item, int number){
        int index = this.inventory.indexOf(item);
        if(0 < this.inventory.size() || this.inventory.size() < index){
            System.out.println("You give a wrong index");
            return 1;
        }
        if(number < 0){
            System.out.println("You can't take a negative amount of " + this.inventory.get(index));
            return 1;
        }
        if(this.quantity.get(index) < number){
            System.out.println("You don't have enough " + this.inventory.get(index));
            return 1;
        }
        
       this.quantity.set(index,this.quantity.get(index)-number);
       if(this.quantity.get(index) == 0){
           this.quantity.remove(index);
           this.inventory.remove(index);
       }
       return 0; 
    }
    
    public int add(Item item, int number){
        if(number < 0){
            System.out.println("You can't obtain a negative amount of " + item.getName());
            return 1;
        }
        if(this.inventory.contains(item)){
            int index = this.inventory.indexOf(item);
            this.quantity.set(index,this.quantity.get(index) + number);
        }
        else{
            this.inventory.add(item);
            this.quantity.add(number);
        }
        return 0;
    }
    
    public void InitFromSave (String [] save){
        if (save.length == 1){
            this.InitInventory(Integer.parseInt(save[0]));
        }
        else{
            String[] itemQuant;
            String[] itemsQuant;
            itemsQuant = save[0].split("^");
            int i, l = itemsQuant.length;
            Item tempitem;
            int tempquant;
            tempitem = new Item();
            this.inventory = new ArrayList<>();
            this.quantity = new ArrayList<>();
            this.gold = Integer.parseInt(save[1]);
            for (i = 0; i < l; i++){
                itemQuant = itemsQuant[i].split(":");
                tempitem.InitFromSaveIt(itemQuant[0].split("%"));
                this.inventory.add(tempitem);
                this.quantity.add(Integer.parseInt(itemQuant[1]));
            }
        }
    }
    
    public String getSaveTextInv(){
        
        int i;
        int l;
        String save = "";
        l = this.inventory.size();
        for (i = 0; i < l; i++){
            save += this.inventory.get(i).getSaveTextIt() + ":" 
                    + this.quantity.get(i);
            if (i < l-1 ){
                save += "^";
            }
        }
        if (this.inventory.size() > 0){
            save += "$";
        }
        return save += this.gold;
    }
    
}
