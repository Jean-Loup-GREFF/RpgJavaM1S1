/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgjava1;

/**
 *
 * @author Matthieu HUE and Jean-Loup GREFF
 */
public enum Rarity {

    /**
     * commun rarity
     *
     */
    COMMUN (0),

    /**
     * uncommun rarity
     *
     */
    UNCOMMUN (1),

    /**
     * rare rarity
     *
     */
    RARE (2),

    /**
     * epic rarity
     *
     */
    EPIC (3),

    /**
     * legendary rarity
     *
     */
    LEGENDARY (4),

    /**
     * mythic rarity
     *
     */
    MYTIC (5),

    /**
     * godlike rarity
     *
     */
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
