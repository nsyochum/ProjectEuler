import java.util.Map;
import utilities.math.*;
import utilities.StringOperations;

import java.util.List;

public class Euler
{
   public static List<Long> primes;

   public static void main(String[] args)
   {
      problem14(1000000);
   }

   /**
    * find the longest collatz sequence below n
    * @param n
    */
   public static void problem14(long n)
   {
      int max = 0;
      long maxNum = 0;
      for(long i = 1; i < n; i++)
      {
         int length = Operations.collatzLength(i);
         if(length > max)
         {
            max = length;
            maxNum = i;
         }
      }
      System.out.println(maxNum + " " + max);
   }

   /**
    * Find the first ten digits of the sum of the numbers
    * @param nums
    */
   public static void problem13(String[] nums)
   {
      int[] result = new int[nums[0].length() + (int) Math.round(Math.log(nums.length))];
      int[][] numbers = new int[nums.length][nums[0].length()];
      for(int i = 0; i < nums.length; i++)
      {
         numbers[i] = StringOperations.stringToIntArray(nums[i]);
      }
      for(int digit = 0; digit < numbers[0].length; digit++)
      {
         for(int[] number : numbers)
         {
            int subresult = number[digit] + result[digit];
            result[digit] = subresult;
         }

         int carry = result[digit];
         int tempDig = digit;
         while(carry > 0)
         {
            result[tempDig] = carry % 10;
            result[++tempDig] += carry / 10;
            carry = result[tempDig];
         }
      }

      String resultStr = "";
      for(int i = result.length - 1; i >= 0 && resultStr.length() != 10; i--)
      {
         if(result[i] != 0 || resultStr.length() > 0)
         {
            resultStr += result[i];
         }
      }

      System.out.println(resultStr);
   }

   /**
    * find the first triangle number with n factors.
    * @param n
    */
   public static void problem12(int n)
   {
      int count = 0;
      long number = 1;
      long tri = 0;
      while(count < 500)
      {
         count = 1;
         tri = Operations.gaussAdd(number);
         Map<Long, Integer> factors = Factors.primeFactorization(tri, primes);
         int i = 0;
         for(long prime : factors.keySet())
         {
            count *= (factors.get(prime) + 1);
         }
         number++;
      }

      System.out.println(tri);
   }

   /**
    * find the sum off all of the prime numbers less than max
    * @param max
    */
   public static void problem10(long max)
   {
      primes = Primes.buildPrimes(max);

      long sum = 0;
      for(long prime : primes)
      {
         sum += prime;
      }

      System.out.println(sum);
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
      primes = Primes.buildPrimes(newMax);
      System.out.println(primes.get(max));
   }

   /**
    * returns the difference between the sum of the squares and the square of the sums
    * of all of the numbers less than the given
    * @param max
    */
   public static void problem6(long max)
   {
      long sum = Operations.gaussAdd(max);
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
      primes = Primes.buildPrimes(max * max);

      long cur = 1;
      for(long i = 1; i < max; i++)
      {
         cur = Factors.leastCommonMultiple(i, cur, primes);
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
            if(toCheck > curMax && StringOperations.isPalindrome("" + toCheck))
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
      List<Long> primes = Primes.buildPrimes(Math.round(Math.ceil(Math.sqrt(max))));
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
}