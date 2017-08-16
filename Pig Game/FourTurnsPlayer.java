
package pig;


 // @author Andrew
 
public class FourTurnsPlayer extends PigPlayer
{
    private int scoringturns;
    public FourTurnsPlayer()
    {
        super("defaul");
    }
    
    public boolean isRolling(int turnTotal, int opponentScore)
    {
        int p = 0;
        int q = 0;
       
        // System.out.println("it is " + this.getName() + "'s turn");
        p = Die.roll();
          
        if(p > 1)
        {
            q = q + p;
           // System.out.println("Roll: "  + p);
            //System.out.println("turn total so far: " + q +  " roll/hold?");
           // u = keyboard.nextLine();
            
            while(p > 1 && q <= (PigGame.getGoal()-this.getScore())/(4-scoringturns))
            {
                p = Die.roll();
                
                if(p > 1)
                {
                    q = q + p;
                   // System.out.println("Roll: "  + p);
                   // System.out.println("turn total so far: " + q +  " roll/hold?");
                  //  u = keyboard.nextLine();  
                }
            }
        }
        
        if(p == 1)
        {
            //System.out.println("Roll: " + p);
           // System.out.println("turn total: 0");
           // System.out.println("");
        }
        else
        {
            this.addPoints(q);
            scoringturns++;
           // System.out.println("turn total: " + q);
           // System.out.println("");
        }
        return false;
    }
}
