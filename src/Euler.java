import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler
{
   public static List<Long> primes;

   public static void main(String[] args)
   {
      long max = factorial(20L);
      primes = buildPrimes(Math.round(Math.pow(20, 4)));
      problem5(20);
   }

   /**
    * Find the smallest number that is divisible by all of the numbers less than max
    * @param max
    */
   public static void problem5(long max)
   {
      long cur = 1;
      for(long i = 1; i < max; i++)
      {
         cur = leastCommonMultiple(i, cur);
      }

      System.out.println(cur);
   }

   /**
    * find the largest palindromic number that is a multiple of 2 numbers less than max
    * @param max the highest number to check
    */
   public static void problem4(long max)
   {
      long curMax = 0;
      for(long i = max; i > 0; i--)
      {
         for(long j = max; j > 0; j--)
         {
            long toCheck = i * j;
            if(toCheck > curMax && isPalindrome("" + toCheck))
            {
               curMax = toCheck;
            }
         }
      }

      System.out.println(curMax);
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
   *  find the sum of all of the even fibbonacci numbers below max
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

   /**
    * A method to check if a string is a palindrome
    * @param str the string to check
    * @return true if a palindrome, else false
    */
   private static boolean isPalindrome(String str)
   {
      for(int i = 0; i < str.length() / 2; i++)
      {
         if(str.charAt(i) != str.charAt(str.length() - i - 1))
         {
            return false;
         }
      }

      return true;
   }

   /**
    * returns the least common multiple of the two inputs
    * @param a
    * @param b
    * @return
    */
   private static long leastCommonMultiple(long a, long b)
   {
      long lcm = 1;
      for(long prime : primes)
      {
         long aCount = 0;
         while (a % prime == 0)
         {
            a /= prime;
            aCount++;
         }

         long bCount = 0;
         while (b % prime == 0)
         {
            b /= prime;
            bCount++;
         }

         long max = (aCount > bCount) ? aCount : bCount;
         for (long i = 0; i < max; i++)
         {
            lcm *= prime;
         }

         if(a == 1 || b == 1)
            break;
      }

      if(a != 1)
         lcm *= a;
      if( b != 1)
         lcm *= b;

      return lcm;
   }

   /**
    * returns the factorial of the given number
    * @param n
    * @return
    */
   private static long factorial(long n)
   {
      if(n == 0)
         return 1;

      return n * factorial(n - 1);
   }
}