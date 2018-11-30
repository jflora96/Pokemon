/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author James
 */
public class Player extends Monster {
    private String playerName;
    private int maxHealth;
    private int potionCount;
    /**
     * @return the potionCount
     */
    public int getPotionCount() {
        return potionCount;
    }

    /**
     * @param potionCount the potionCount to set
     */
    public void setPotionCount(int potionCount) {
        this.potionCount = potionCount;
    }

    /**
     * @return the maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @param maxHealth the maxHealth to set
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    
    /**
     * @return the playerName
     */
     Player(int id, String name, int health, int level, int attack, int speed, int xp)
    {
        super(id, name, health, level, attack, speed);
    }
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
