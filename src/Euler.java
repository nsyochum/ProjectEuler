import java.util.ArrayList;
import java.util.List;

public class Euler
{
   public static void main(String[] args)
   {
      problem3(600851475143L);
   }

   /**
    * Find the largest prime factor of a given number.
    */
   public static void problem3(long max)
   {
      List<Long> primes = buildPrimes(Math.round(Math.ceil(Math.sqrt(max))));
      for(long prime : primes)
      {
         while(max % prime == 0 && max != prime)
         {
            max /= prime;
         }
      }

      System.out.println(max);
   }
   
   /**
   *  find the sum of all of teh even fibbonacci numbers below max
   */
   public static void problem2(int max)
   {
      int cur = 1;
      int prev = 1;
      int sum = 0;

      while(cur < max)
      {
         if(cur % 2 == 0)
         {
            sum += cur;
         }

         int temp = cur;
         cur += prev;
         prev = temp;
      }

      System.out.println(sum);
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

   /**
    * A method to build a list of prime numbers less than a given max.
    * @param max the max number to check
    * @return a list of all primes below max
    */
   private static List<Long> buildPrimes(long max)
   {
      List<Long> toReturn = new ArrayList<>();
      for(long i = 2; i < max; i++)
      {
         if(isPrime(i, toReturn))
         {
            toReturn.add(i);
         }
      }

      return toReturn;
   }

   /**
    * A helper method for build primes, checks if a number is prime
    * given the list contains all primes less than the given number.
    * @param num the number to check
    * @param primes a list of primes less than the given number
    * @return true if prime, else false
    */
   private static boolean isPrime(long num, List<Long> primes)
   {
      for(long prime : primes)
      {
         // if we ever hit the square root of the number, then it is prime
         if(prime > Math.sqrt(num))
         {
            return true;
         }

         if(num % prime == 0)
         {
            return false;
         }
      }

      return true;
   }
}