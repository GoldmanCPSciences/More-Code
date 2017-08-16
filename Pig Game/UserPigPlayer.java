
package pig;

import java.util.Scanner;


//@author Andrew
public class UserPigPlayer extends PigPlayer
{
    private int total;
    
    public UserPigPlayer(String name)
    {
        super(name);
    }
    
    public boolean isRolling(int turnTotal, int opponentScore)
    {
        Scanner keyboard = new Scanner(System.in);
        String u = "";
        int p = 0;
        int q = 0;
       
        System.out.println("it is " + this.getName() + "'s turn");
        p = Die.roll();
        
        if(p > 1)
        {
            q = q + p;
            System.out.println("Roll: "  + p);
            System.out.println("turn total so far: " + q +  " roll/hold?");
            u = keyboard.nextLine();
            
            while(u.length() < 1 && p > 1)
            {
                p = Die.roll();
                
                if(p > 1)
                {
                    q = q + p;
                    System.out.println("Roll: "  + p);
                    System.out.println("turn total so far: " + q +  " roll/hold?");
                    u = keyboard.nextLine();  
                }
            }
        }
        
        if(p == 1)
        {
            System.out.println("Roll: " + p);
            System.out.println("turn total: 0");
            System.out.println("");
        }
        else
        {
            this.addPoints(q);
            System.out.println("turn total: " + q);
            System.out.println("");
        }
        return false;   
    } 
}
