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
public class Fight {
    protected boolean alive;
    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
     
     public boolean checkAlive(int playerHealth, int monsterHealth)
     {
         if (playerHealth > 0)
         {
             if (monsterHealth > 0)
             {
                 return true;
             }
             else
             {
                 return false;
             }
         }
         else
         {
             return false;
         }
     }
     
     public int doAttack(int attack, int health)
     {
         health = health - attack;
                 return health;
     }
}


