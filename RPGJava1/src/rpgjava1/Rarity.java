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
public enum Rarity {
    COMMUN (0),
    UNCOMMUN (1),
    RARE (2),
    EPIC (3),
    LEGENDARY (4),
    MYTIC (5),
    GODLIKE (6);
    
    private Integer rarity;
    
    private Rarity(int rarity){
        this.rarity = rarity;
    }
    
    @Override
    public String toString() {
        return rarity.toString();
    }
}
