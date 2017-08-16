
package pig;


// @author Andrew
 
public class Simulations
{
    public static void firstAdvantage(long simulations)
    {
        PigPlayer a = new SimpleHoldPlayer();
        PigPlayer b = new SimpleHoldPlayer();
        PigGame j = new PigGame(a, b);
        
        for(int i = 0; i < simulations; i++)
        {
            j.playGame();
            j.reset();
        }
        
        System.out.println("first ai: " + a.getWinRecord());
        System.out.println("second ai: " + b.getWinRecord());
    }
    
    public static boolean isFirstBetter(long simulations, PigPlayer first, PigPlayer second)
    {
        PigGame j = new PigGame(first, second);
        
        long x;
        long z;
        
        for(int i = 0; i < simulations/2; i++)
        {
            j.playGame();
            j.reset();
        }
        
        for(int i = 0; i < simulations/2; i++)
        {
            j.playGameOtherAdvantage();
            j.reset();
        }
        
        x = first.getWinRecord();
        z = second.getWinRecord();
        
        System.out.println("first ai: " + first.getWinRecord());
        System.out.println("second ai: " + second.getWinRecord());
        
        if(x>z)
            return true;
        else
            return false;
    }
    
    public static int bestHoldValue()
    {
        int x = 2;
        int z = 3;
        while(x < 101 && z < 101)
        {
            PigPlayer a = new SimpleHoldPlayer("default", x);
            PigPlayer b = new SimpleHoldPlayer("default1", z);
        
            PigGame j = new PigGame(a, b);
            
            if(Simulations.isFirstBetter(10000, a, b) == true)
                x++;
            else
                z++;
        }
        
        if(x<z)
          return x;
        else
          return z;
        
    }
}
