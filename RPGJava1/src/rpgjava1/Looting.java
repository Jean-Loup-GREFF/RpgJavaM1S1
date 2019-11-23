/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Matthieu
 */
public interface Looting {
    static void commerce(Character dealer, Inventory trade, Character getter){
        getter.getInventory().setGold(getter.getInventory().getGold()-trade.getGold());
        dealer.getInventory().setGold(dealer.getInventory().getGold() + trade.getGold());
        loopRemoveItems(trade,getter.getInventory());
    }
    static void loot(Inventory dealer,Character getter){
        getter.getInventory().setGold(dealer.getGold()+getter.getInventory().getGold());
        loopAddItems(dealer,getter.getInventory());
    }
    static void loopAddItems(Inventory dealer, Inventory getter){
        int len = dealer.getInventory().size();
        for(int i = 0;i<len;i++){
            getter.add(dealer.getInventory().get(i), dealer.getQuantity().get(i));
        }
    }
    static void loopRemoveItems(Inventory remover, Inventory target){
        int len = remover.getInventory().size();
        for(int i = 0;i<len;i++){
            target.remove(remover.getInventory().get(i), remover.getQuantity().get(i));
        }
    }
}
