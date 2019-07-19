public class Euler 
{
   public static void main(String[] args)
   {
      problem1(1000);
   }
   
   /**
   *  find the sum of all of teh even fibbonacci numbers below max
   */
   public static void problem2(int max)
   {
   
   }
   
   /**
   * find the sum of all multiples of 3 or 5 below max
   */
   public static void problem1(int max)
   {
      int sum = 0;
      for(int i = 0; i < max; i++)
      {
         if(i % 3 == 0 || i % 5 == 0)
         {
            sum += i;
         }
      }
      
      System.out.println(sum);
   }
}