
package pig;

 //@author Andrew
 
public class SimpleHoldPlayer extends PigPlayer
{
    private int holdvalue;
    public SimpleHoldPlayer()
    {
        super("Default");
        holdvalue = 20;
    }
    
    public SimpleHoldPlayer(String m)
    {
        super(m);
    }
    
    public SimpleHoldPlayer(String m, int j)
    {
        super(m);
        holdvalue = j;
    }
    
    public boolean isRolling(int turnTotal, int opponentScore)
    {
        //Scanner keyboard = new Scanner(System.in);
       // String u = "";
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
            
            while(p > 1 && q < holdvalue)
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
           // System.out.println("turn total: " + q);
           // System.out.println("");
        }
        return false;  
    }
    
    public int getHoldValue()
    {
        return holdvalue;
    }
}
