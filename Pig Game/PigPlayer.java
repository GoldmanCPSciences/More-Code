
package pig;

//@author Andrew
 
public abstract class PigPlayer
{
    private String name;
    private int score;
    private int gameswon;
    
    
    public PigPlayer(String name2)
    {
        name = name2;
        score = 0;
    }
    
    public void setName(String name2)
    {
        name = name2;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void reset()
    {
        score = 0;
    }
    
    public void addPoints(int turnTotal)
    {
        if(score < 100)
        {
            score = score + turnTotal;
            if(score >= PigGame.getGoal())
                gameswon = gameswon+1;
        }
    }
    
    public boolean won()
    {
        if(score < PigGame.getGoal())
            return false;
        else
            return true;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getWinRecord()
    {
        return gameswon;
    }
    
    public String toString()
    {
        return name + "\n" + score;
    }
    
    public abstract boolean isRolling(int turnTotal, int opponentScore);
}
