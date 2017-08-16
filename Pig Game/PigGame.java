
package pig;

// @author Andrew

import java.util.Scanner;


public class PigGame
{
    private static int GOAL = 100;
    private static PigPlayer a;
    private static PigPlayer b;
    
    public PigGame(UserPigPlayer player1, UserPigPlayer player2)
    {
        a = player1;
        b = player2;
    }
    
    public PigGame(String name1, String name2)
    {
        a = new UserPigPlayer(name1);
        b = new UserPigPlayer(name2);
    }
    
    public PigGame(PigPlayer player1, PigPlayer player2)
    {
        a = player1;
        b = player2;
    }
    
    public void reset()
    {
        a.reset();
        b.reset();
    }
    
    public void playGame()
    {
       int g = 0;
       int h = 0;
       int n = 0;
       do
       {
            if(n%2 < 1)
            {
                h = PigGame.playTurn(a, b);
            }
            else
            {
                g = PigGame.playTurnOffset(a, b);
            }
            
            n++;
       }
       while(g < 1 && h < 1);
    }
    
    public void playGameOtherAdvantage()
    {
        int g = 0;
       int h = 0;
       int n = 0;
       do
       {
            if(n%2 < 1)
            {
                h = PigGame.playTurnOffset(a, b);
            }
            else
            {
                g = PigGame.playTurn(a, b);
            }
            
            n++;
       }
       while(g < 1 && h < 1);
    }
    
    public static int playTurn(PigPlayer player, PigPlayer opponent)
    {
        if(player.won() == false && opponent.won() == false)
        {
            //System.out.println(player.getName() + "'s score: " + player.getScore());
            //System.out.println(opponent.getName() + "'s score: " + opponent.getScore());
            player.isRolling(0, 0);
            return 0;
        }
        else
            return 1;
        
    }
    
    public static int playTurnOffset(PigPlayer player, PigPlayer opponent)
    {
        if(player.won() == false && opponent.won() == false)
        {
            //System.out.println(player.getName() + "'s score: " + player.getScore());
            //System.out.println(opponent.getName() + "'s score: " + opponent.getScore());
            opponent.isRolling(0, 0);
            return 0;
        }
        else
            return 1;
    }
    
    public static void userVsUser()
    {
        Scanner keyboard = new Scanner(System.in);
        String o = "";
        String m = "";
       
        System.out.println("What is the first player's name?");
        o = keyboard.next();
        System.out.println("What is the second player's name?");
        m = keyboard.next();

        PigGame g = new PigGame(o,m);
        int n = 0;
        int v = 0;
        int h = 0;
        
        if(Die.roll() <= 3)
        {
            System.out.println(a.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurn(g.a, g.b);
                }
                else
                {
                    v = g.playTurnOffset(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        else
        {
            System.out.println(b.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurnOffset(g.a, g.b);
                }
                else
                {
                    v = g.playTurn(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        
        if(a.won()== true)
        {
            System.out.println(a.getName() + " wins!!");
            System.out.println(b.getName() + "'s score: " + b.getScore());
            System.out.println(a.getName() + "'s score: " + a.getScore());
        }
        else
        {
            System.out.println(b.getName() + " wins!!");
            System.out.println(b.getName() + "'s score: " + b.getScore());
            System.out.println(a.getName() + "'s score: " + a.getScore());
        }
    }
    
    public static void userVsComputer()
    {
        PigPlayer r = new FourTurnsPlayer();
        Scanner keyboard = new Scanner(System.in);
        String o = "";
        
        System.out.println("What is the first player's name?");
        o = keyboard.next();
        PigPlayer i = new UserPigPlayer(o);
        
        PigGame g = new PigGame(i,r);
        int n = 0;
        int v = 0;
        int h = 0;
        
        if(Die.roll() <= 3)
        {
            System.out.println(a.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurn(g.a, g.b);
                }
                else
                {
                    v = g.playTurnOffset(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        else
        {
            System.out.println(b.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurnOffset(g.a, g.b);
                }
                else
                {
                    v = g.playTurn(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        
        if(a.won()== true)
        {
            System.out.println(a.getName() + " wins!!");
            System.out.println(b.getName() + "'s score: " + b.getScore());
            System.out.println(a.getName() + "'s score: " + a.getScore());
        }
        else
        {
            System.out.println(b.getName() + " wins!!");
            System.out.println(b.getName() + "'s score: " + b.getScore());
            System.out.println(a.getName() + "'s score: " + a.getScore());
        }
    }
    
    public static void computerVsComputer()
    {
        PigPlayer r = new SimpleHoldPlayer("Default2", 20);
        PigPlayer i = new SimpleHoldPlayer("Defalut1", 20);
        
         PigGame g = new PigGame(i,r);
        int n = 0;
        int v = 0;
        int h = 0;
        
        if(Die.roll() <= 3)
        {
            System.out.println(a.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurn(g.a, g.b);
                }
                else
                {
                    v = g.playTurnOffset(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        else
        {
            System.out.println(b.getName() + " goes first");
            do
            {
                if(n%2 < 1)
                {
                    h = g.playTurnOffset(g.a, g.b);
                }
                else
                {
                    v = g.playTurn(g.a, g.b);
                }
            
                n++;
            }
            while(v < 1 && h < 1);
        }
        
        if(a.won()== true)
        {
            //System.out.println(a.getName() + " wins!!");
            //System.out.println(b.getName() + "'s score: " + b.getScore());
            //System.out.println(a.getName() + "'s score: " + a.getScore());
        }
        else
        {
            //System.out.println(b.getName() + " wins!!");
            //System.out.println(b.getName() + "'s score: " + b.getScore());
            //System.out.println(a.getName() + "'s score: " + a.getScore());
        }
    }
    
    public static int getGoal()
    {
        return GOAL;
    }
    
    public static void main(String[] args)
    {
        PigPlayer one = new SimpleHoldPlayer();
        PigPlayer two = new FourTurnsPlayer();
        // PigGame.computerVsComputer();
       System.out.println(Simulations.isFirstBetter(10000, two, one));
    }
}
