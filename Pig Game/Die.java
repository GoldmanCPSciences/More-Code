
package pig;


 //@author Andrew
 
public class Die
{
    private int sides;
    public static int roll()
    {
        double random = Math.random();
        
        if(random < 1.0/6.0)
        {
            return 1;
        }
        else if (random >= 1.0/6.0 && random < 2.0/6.0)
        {
            return 2;
        }
        else if (random >= 2.0/6.0 && random < 3.0/6.0)
        {
            return 3;
        }
        else if (random >= 3.0/6.0 && random < 4.0/6.0)
        {
            return 4;
        }
        else if (random >= 4.0/6.0 && random < 5.0/6.0)
        {
            return 5;
        }
        else 
        {
            return 6;
        }
    }
    
    public void setSides(int numberOfSides)
    {
        sides = numberOfSides;
    }
    
    public int getSides()
    {
        return sides;
    }
    
    /*
    public int rollDie()
    {
        double a = Math.random();
        for(int x = 0; x < sides; x++)
        {
            if(a >= (x/sides) && a < ((x+1)/sides))
            {
                return x+1;
            }
        }
    }
    */
}
