package pokemon;
import javax.swing.JOptionPane;
import java.util.Random;

public class Pokemon {
    public static void main(String[] args) {
    Monster bulbasaur = new Monster(1, "Bulbasaur", 0, 0, 0, 0);
    Monster squirtle = new Monster(2, "Squirtle", 0, 0, 0, 0);
    Monster charmander = new Monster(3, "Charmander", 0, 0, 0, 0);
    Monster pidgey = new Monster (4, "Pidgey", 0, 0, 0, 0);
    Monster rattata = new Monster (5, "Rattata", 0, 0, 0, 0);
    Monster caterpie = new Monster (6, "Caterpie", 0, 0, 0, 0);
    Monster weedle = new Monster (7, "Weedle", 0, 0, 0, 0);
    Monster kadabra = new Monster (8, "Kadabra", 0, 0, 0, 0);
    Monster machoke = new Monster (9, "Machoke", 0, 0, 0, 0);
    Monster graveler = new Monster (10, "Graveler", 0, 0, 0, 0);
    Monster slowpoke = new Monster (11, "Slowpoke", 0, 0, 0, 0);
    Monster gengar = new Monster (12, "Gengar", 0, 0, 0, 0);
    Monster kangaskhan = new Monster (13, "Kangaskhan", 0, 0, 0, 0);
    Monster lapras = new Monster (14, "Lapras", 0, 0, 0, 0);
    Monster gyarados = new Monster (15, "Gyarados", 0, 0, 0, 0);
    Monster mewtwo = new Monster (16, "Mewtwo", 0, 0, 0 ,0);
    Monster operational = new Monster(0, "x", 0, 0, 0, 0);
    Player player = new Player(100, "x", 20, 4, 5, 100, 0);
    
    String option = JOptionPane.showInputDialog("1. New Game \n2. Continue\n3. Quit");
    int choice = Integer.parseInt(option);
    
    if (choice == 1)
    {
        String playerName = JOptionPane.showInputDialog("Enter player name");    
        player.setPlayerName(playerName);    
        JOptionPane.showMessageDialog(null, "Player name is " + player.getPlayerName());
    
        String pokemonChoice = JOptionPane.showInputDialog("What pokemon do you want to start as?\n1. Bulbasaur\n2. Squirtle\n3. Charmander");
        int pokeChoice = Integer.parseInt(pokemonChoice);
        if (pokeChoice == 1)
        {
            player.setAttack(4);
            player.setHealth(20);
            player.setLevel(1);
            player.setSpeed(3);
            player.setMaxHealth(20);
            player.setName("Bulbasaur");
        }
        else if (pokeChoice == 2)
        {
            player.setAttack(3);
            player.setHealth(25);
            player.setLevel(1);
            player.setSpeed(4);
            player.setMaxHealth(25);
            player.setName("Squirtle");
        }
        else if (pokeChoice == 3)
        {
            player.setAttack(5);
            player.setHealth(17);
            player.setLevel(1);
            player.setSpeed(5);
            player.setMaxHealth(17);
            player.setName("Charmander");
        }
         player.setPotionCount(1);
         JOptionPane.showMessageDialog(null,"You picked " + player.getName() + "\nYour stats are:" + 
                 "\nHealth: " + player.getMaxHealth() + "\nAttack: " + player.getAttack() + 
                 "\nSpeed: " + player.getSpeed() + "\nLevel: " + player.getLevel());
         
         JOptionPane.showMessageDialog(null, "You will start the game with 1 potion,"
                 + " potions can be used at the end of a fight turn. Good luck!");
    
    }
    else if (choice == 2)
    {
        //load data
    }
    
    else
    {
        System.exit(0);
    }
    int choice2 = 0;
       
       do {
            if (player.getLevel() < 5)
            {
                Fight fight = new Fight(); 
                Random rand = new Random();
                Monster[] monsters = {pidgey, rattata, caterpie, weedle};
                int i = rand.nextInt(4);
                operational = monsters[i];
                int j = rand.nextInt((20-10) + 1) + 10;
                operational.setHealth(j);
                int k = rand.nextInt((5-2) + 1) + 2;
                operational.setSpeed(k);
                int l = rand.nextInt((5-2) + 1) + 2;
                operational.setAttack(l);
                player.setHealth(player.getMaxHealth());
                
                //story goes here
                
            JOptionPane.showMessageDialog(null, "you encounter a wild " + operational.getName());
            
                do {
              
                    if (player.getSpeed() >= operational.getSpeed())
                    {  
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack first. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() < operational.getSpeed())
                    {
                       int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "Your opponent attacks first. Your HP is: " + player.getHealth());
                    }
                    
                    
                    if (player.getSpeed() < operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack second. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() >= operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                         JOptionPane.showMessageDialog(null, "Your opponent attacks second. Your HP is: " + player.getHealth());
                    }
     
                    if (operational.getHealth() <= 0)
                    {    
                        player.setLevel(player.getLevel() + 1);
                        player.setMaxHealth(player.getMaxHealth() + 5);
                        player.setAttack(player.getAttack() + 2);
                        player.setSpeed(player.getSpeed() + 2);
                        JOptionPane.showMessageDialog(null, "you win and advanced to level: " + player.getLevel() + 
                         "\nyour new stats are:\nHealth: " + player.getMaxHealth() + "\nAttack: " + 
                         player.getAttack() + "\nSpeed: " + player.getSpeed());
                        int m = rand.nextInt(10 - 0 + 1) + 0;
                        if (m > 5)
                        {
                            JOptionPane.showMessageDialog(null, "You found a potion when you defeated"
                                    + " the enemy");
                            player.setPotionCount(player.getPotionCount()+1);
                        }
                    }
                    else if (player.getHealth() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "you lose");
                    }
                    else
                    {
                        String potionOption = JOptionPane.showInputDialog("The battle is still going. Do you want to use a potion? (1 for yes, 2 for no)");
                        int potionChoice = Integer.parseInt(potionOption);
                        
                        if (potionChoice == 1 && player.getPotionCount() > 0)
                        {
                            if (player.getHealth() + 20 > player.getMaxHealth())
                            {
                            player.setHealth(player.getMaxHealth());
                            JOptionPane.showMessageDialog(null, "You restore your health to max, your"
                                    + " new health is " + player.getHealth());
                            }
                            else if (player.getHealth() + 20 < player.getMaxHealth())
                            {
                                player.setHealth(player.getHealth() + 20);
                                JOptionPane.showMessageDialog(null, "You restore your health by 20, your new health"
                                    + " is " + player.getHealth());
                            }
                            player.setPotionCount(player.getPotionCount() - 1);
                        }
                        else if (potionChoice == 1 && player.getPotionCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "You don't have any potions");
                        }
                    }
                    
                } while (fight.checkAlive(player.getHealth(), operational.getHealth()) == true);
                
            }
           
            else if (player.getLevel() < 10 && player.getLevel() >= 5)
            {
                Fight fight = new Fight(); 
                Random rand = new Random();
                Monster[] monsters = {kadabra, machoke, graveler, slowpoke};
                int i = rand.nextInt(4);
                operational = monsters[i];
                int j = rand.nextInt((50-30) + 1) + 30;
                operational.setHealth(j);
                int k = rand.nextInt((12-8) + 1) + 8;
                operational.setSpeed(k);
                int l = rand.nextInt((12-8) + 1) + 8;
                operational.setAttack(l);
                player.setHealth(player.getMaxHealth());
                
                //story goes here
                
                JOptionPane.showMessageDialog(null, "you encounter a wild " + operational.getName());
            
                do {
              
                    if (player.getSpeed() >= operational.getSpeed())
                    {  
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack first. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() < operational.getSpeed())
                    {
                       int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "Your opponent attacks first. Your HP is: " + player.getHealth());
                    }
                    
                    
                    if (player.getSpeed() < operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack second. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() >= operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                         JOptionPane.showMessageDialog(null, "Your opponent attacks second. Your HP is: " + player.getHealth());
                    }
     
                    if (operational.getHealth() <= 0)
                    {    
                        player.setLevel(player.getLevel() + 1);
                        player.setMaxHealth(player.getMaxHealth() + 5);
                        player.setAttack(player.getAttack() + 2);
                        player.setSpeed(player.getSpeed() + 2);
                        JOptionPane.showMessageDialog(null, "you win and advanced to level: " + player.getLevel() + 
                         "\nyour new stats are:\nHealth: " + player.getMaxHealth() + "\nAttack: " + 
                         player.getAttack() + "\nSpeed: " + player.getSpeed());
                        int m = rand.nextInt(10 - 0 + 1) + 0;
                        if (m > 5)
                        {
                            JOptionPane.showMessageDialog(null, "You found a potion when you defeated"
                                    + " the enemy");
                            player.setPotionCount(player.getPotionCount()+1);
                        }
                    }
                    else if (player.getHealth() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "you lose");
                    }
                    else
                    {
                        String potionOption = JOptionPane.showInputDialog("The battle is still going. Do you want to use a potion? (1 for yes, 2 for no)");
                        int potionChoice = Integer.parseInt(potionOption);
                        
                        if (potionChoice == 1 && player.getPotionCount() > 0)
                        {
                            if (player.getHealth() + 20 > player.getMaxHealth())
                            {
                            player.setHealth(player.getMaxHealth());
                            JOptionPane.showMessageDialog(null, "You restore your health to max, your"
                                    + " new health is " + player.getHealth());
                            }
                            else if (player.getHealth() + 20 < player.getMaxHealth())
                            {
                                player.setHealth(player.getHealth() + 20);
                                JOptionPane.showMessageDialog(null, "You restore your health by 20, your new health"
                                    + " is " + player.getHealth());
                            }
                            player.setPotionCount(player.getPotionCount() - 1);
                        }
                        else if (potionChoice == 1 && player.getPotionCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "You don't have any potions");
                        }
                    }
                    
                } while (fight.checkAlive(player.getHealth(), operational.getHealth()) == true);
                
            }
        
        else if (player.getLevel() < 15 && player.getLevel() >= 10)
            {
                Fight fight = new Fight(); 
                Random rand = new Random();
                Monster[] monsters = {gengar, kangaskhan, lapras, gyarados};
                int i = rand.nextInt(4);
                operational = monsters[i];
                int j = rand.nextInt((70-50) + 1) + 50;
                operational.setHealth(j);
                int k = rand.nextInt((25-19) + 1) + 19;
                operational.setSpeed(k);
                int l = rand.nextInt((25-19) + 1) + 19;
                operational.setAttack(l);
                player.setHealth(player.getMaxHealth());
                
                //story goes here
                
                JOptionPane.showMessageDialog(null, "you encounter a wild " + operational.getName());
            
                do {
              
                    if (player.getSpeed() >= operational.getSpeed())
                    {  
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack first. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() < operational.getSpeed())
                    {
                       int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "Your opponent attacks first. Your HP is: " + player.getHealth());
                    }
                    
                    
                    if (player.getSpeed() < operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack second. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() >= operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                         JOptionPane.showMessageDialog(null, "Your opponent attacks second. Your HP is: " + player.getHealth());
                    }
     
                    if (operational.getHealth() <= 0)
                    {    
                        player.setLevel(player.getLevel() + 1);
                        player.setMaxHealth(player.getMaxHealth() + 5);
                        player.setAttack(player.getAttack() + 2);
                        player.setSpeed(player.getSpeed() + 2);
                        JOptionPane.showMessageDialog(null, "you win and advanced to level: " + player.getLevel() + 
                         "\nyour new stats are:\nHealth: " + player.getMaxHealth() + "\nAttack: " + 
                         player.getAttack() + "\nSpeed: " + player.getSpeed());
                        int m = rand.nextInt(10 - 0 + 1) + 0;
                        if (m > 5)
                        {
                            JOptionPane.showMessageDialog(null, "You found a potion when you defeated"
                                    + " the enemy");
                            player.setPotionCount(player.getPotionCount()+1);
                        }
                    }
                    else if (player.getHealth() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "you lose");
                    }
                    else
                    {
                        String potionOption = JOptionPane.showInputDialog("The battle is still going. Do you want to use a potion? (1 for yes, 2 for no)");
                        int potionChoice = Integer.parseInt(potionOption);
                        
                        if (potionChoice == 1 && player.getPotionCount() > 0)
                        {
                            if (player.getHealth() + 20 > player.getMaxHealth())
                            {
                            player.setHealth(player.getMaxHealth());
                            JOptionPane.showMessageDialog(null, "You restore your health to max, your"
                                    + " new health is " + player.getHealth());
                            }
                            else if (player.getHealth() + 20 < player.getMaxHealth())
                            {
                                player.setHealth(player.getHealth() + 20);
                                JOptionPane.showMessageDialog(null, "You restore your health by 20, your new health"
                                    + " is " + player.getHealth());
                            }
                            player.setPotionCount(player.getPotionCount() - 1);
                        }
                        else if (potionChoice == 1 && player.getPotionCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "You don't have any potions");
                        }
                    }
                    
                } while (fight.checkAlive(player.getHealth(), operational.getHealth()) == true);
                
            }
            
            else if (player.getLevel() >= 15)
            {
                Fight fight = new Fight(); 
                Random rand = new Random();
                operational = mewtwo;
                operational.setHealth(100);
                operational.setSpeed(30);
                operational.setAttack(30);
                player.setHealth(player.getMaxHealth());
                
                //story goes here
                
                JOptionPane.showMessageDialog(null, "you encounter the boss: Mewtwo!");
            
                do {
              
                    if (player.getSpeed() >= operational.getSpeed())
                    {  
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack first. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() < operational.getSpeed())
                    {
                       int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "Your opponent attacks first. Your HP is: " + player.getHealth());
                    }
                    
                    
                    if (player.getSpeed() < operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(player.getAttack(), operational.getHealth());
                        operational.setHealth(z);
                        if (operational.getHealth() < 0)
                        {
                            operational.setHealth(0);
                        }
                        JOptionPane.showMessageDialog(null, "You attack second. Your opponents HP is: " + operational.getHealth());
                    }
                    else if (player.getSpeed() >= operational.getSpeed())
                    {
                        int z = 0;
                        z = fight.doAttack(operational.getAttack(), player.getHealth());
                        player.setHealth(z);
                        if (player.getHealth() < 0)
                        {
                            player.setHealth(0);
                        }
                         JOptionPane.showMessageDialog(null, "Your opponent attacks second. Your HP is: " + player.getHealth());
                    }
     
                    if (operational.getHealth() <= 0)
                    {    
                        player.setLevel(player.getLevel() + 1);
                        player.setMaxHealth(player.getMaxHealth() + 5);
                        player.setAttack(player.getAttack() + 2);
                        player.setSpeed(player.getSpeed() + 2);
                        JOptionPane.showMessageDialog(null, "you win and advanced to level: " + player.getLevel() + 
                         "\nyour new stats are:\nHealth: " + player.getMaxHealth() + "\nAttack: " + 
                         player.getAttack() + "\nSpeed: " + player.getSpeed());
                        int m = rand.nextInt(10 - 0 + 1) + 0;
                        if (m > 5)
                        {
                            JOptionPane.showMessageDialog(null, "You found a potion when you defeated"
                                    + " the enemy");
                            player.setPotionCount(player.getPotionCount()+1);
                        }
                    }
                    else if (player.getHealth() <= 0)
                    {
                        JOptionPane.showMessageDialog(null, "you lose");
                    }
                    else
                    {
                        String potionOption = JOptionPane.showInputDialog("The battle is still going. Do you want to use a potion? (1 for yes, 2 for no)");
                        int potionChoice = Integer.parseInt(potionOption);
                        
                        if (potionChoice == 1 && player.getPotionCount() > 0)
                        {
                            if (player.getHealth() + 20 > player.getMaxHealth())
                            {
                            player.setHealth(player.getMaxHealth());
                            JOptionPane.showMessageDialog(null, "You restore your health to max, your"
                                    + " new health is " + player.getHealth());
                            }
                            else if (player.getHealth() + 20 < player.getMaxHealth())
                            {
                                player.setHealth(player.getHealth() + 20);
                                JOptionPane.showMessageDialog(null, "You restore your health by 20, your new health"
                                    + " is " + player.getHealth());
                            }
                            player.setPotionCount(player.getPotionCount() - 1);
                        }
                        else if (potionChoice == 1 && player.getPotionCount() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "You don't have any potions");
                        }
                    }
                    
                } while (fight.checkAlive(player.getHealth(), operational.getHealth()) == true);
                
            }
        
        String option2 = JOptionPane.showInputDialog("do you want to battle more? (1 for yes, 2 for no)");
        choice2 = Integer.parseInt(option2);
        
        
    } while (choice2 != 2);

       JOptionPane.showMessageDialog(null, "Saved your data");
       //save data
  }
    
}
