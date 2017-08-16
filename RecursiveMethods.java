/**
 * Created by Andrew Goldman and Megan Francis
 */
public class RecursiveMethods {
  public static int factorial (int n){
    if(n>=0)
    {
      if(n==0)
      {
        return 1;
      }
      else
      {
        return n*factorial(n-1);
      }
    }
    else
    {
      System.out.println("Invalid Value");
      return n;
    }
  }
  
  public static int handshakes(int n)
  { 
    if(n>=2)
    {
      if(n==2)
      {
        return 1;
      }
      return n-1 + handshakes(n-1);
    }
    else
    {
      System.out.println("THERE HAS TO BE MORE THAN TWO PEOPLE TO SHAKE HANDS WITH THEM O_O");
      System.out.print("Here's your filthy pathetic excuse for an input back: ");
      return n;
    }  
  }
  
  public static int fibonacci(int n){
   if(n>=0)
   {
     if(n==0)
       return 0;
     else if(n==1)
       return 1;
     else
     {
       return fibonacci(n-1) + fibonacci(n-2);
     }
   }
   else
   {
    System.out.println("baka dai yo...");
    return n;
   }
  }
  
  public static int countDigits (long n)
  {n = Math.abs(n);
     if(n < 10)
     {
       return 1;
     }
     else
     {
       return 1+ countDigits(n/10);
     }
       
  }
  
  private static boolean prime (int n, int d){
    int s;
    boolean answer = true;
    s=n%d;
    if(n>0 && s!=0 && d>1 && answer){
      answer = prime(n,d-1);
    }
    else if(d<1)
    {
      answer = true;     
    }
    else
      answer = false;
    
    return answer;
    
 
  }
  
  public static boolean prime (int n){
    return prime(n,n-1);
  }
  public static void main (String[] args){
//   System.out.println(handshakes(-5)); 
//   for (int i=0; i<10; i++)
//    System.out.println(fibonacci(i));
  //  System.out.println(countDigits(-1234567899999999999l));
    System.out.println(prime(1009));
  }
  
}
