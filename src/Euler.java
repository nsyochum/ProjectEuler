import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler
{
   public static List<Long> primes;

   public static void main(String[] args)
   {
      String bigNum = "73167176531330624919225119674426574742355349194934"
          + "96983520312774506326239578318016984801869478851843"
          + "85861560789112949495459501737958331952853208805511"
          + "12540698747158523863050715693290963295227443043557"
          + "66896648950445244523161731856403098711121722383113"
          + "62229893423380308135336276614282806444486645238749"
          + "30358907296290491560440772390713810515859307960866"
          + "70172427121883998797908792274921901699720888093776"
          + "65727333001053367881220235421809751254540594752243"
          + "52584907711670556013604839586446706324415722155397"
          + "53697817977846174064955149290862569321978468622482"
          + "83972241375657056057490261407972968652414535100474"
          + "82166370484403199890008895243450658541227588666881"
          + "16427171479924442928230863465674813919123162824586"
          + "17866458359124566529476545682848912883142607690042"
          + "24219022671055626321111109370544217506941658960408"
          + "07198403850962455444362981230987879927244284909188"
          + "84580156166097919133875499200524063689912560717606"
          + "05886116467109405077541002256983155200055935729725"
          + "71636269561882670428252483600823257530420752963450";

      problem9(1000);
   }

   /**
    * Finds the product of pythagorean triples with a given sum.
    * @param sum
    */
   public static void problem9(int sum)
   {
      for(int i = 0; i < sum; i++)
      {
         for(int j = 0; j < sum; j++)
         {
            for(int k = 0; k < sum; k++)
            {
               if((i * i + j * j == k * k) && i + j + k == 1000)
               {
                  System.out.println("" + (i * j * k));
               }
            }
         }
      }
   }

   /**
    * Given a string that represents a number, find the max product of n consecutive numbers
    * @param number
    * @param subProduct
    */
   public static void problem8(String number, int subProduct)
   {
      long curMax = 0;
      for(int i = 0; i < number.length() - subProduct; i++)
      {
         long temp = 1;
         for(int j = 0; j < subProduct; j++)
         {
            temp *= Long.parseLong("" + number.charAt(i + j));
         }

         if(temp > curMax)
            curMax = temp;
      }

      System.out.println(curMax);
   }

   /**
    * Find the nth prime number.
    * @param max
    */
   public static void problem7(int max)
   {
      long newMax = 100L * (long) max;
      primes = buildPrimes(newMax);
      System.out.println(primes.get(max));
   }

   /**
    * returns the difference between the sum of the squares and the square of the sums
    * of all of the numbers less than the given
    * @param max
    */
   public static void problem6(long max)
   {
      long sum = gaussAdd(max);
      long sumSquares = 0;
      for(long i = 0; i <= max; i++)
      {
         sumSquares += (i * i);
      }

      System.out.println((sum * sum) - sumSquares);
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

   /**
    * uses Gauss' algorithm to add up all of the numbers less than a given number
    * @param max
    * @return
    */
   private static long gaussAdd(long max)
   {
      return (max * (max + 1)) / 2L;
   }
}