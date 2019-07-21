import java.math.BigInteger;
import java.util.Map;
import utilities.math.*;
import utilities.StringOperations;

import java.util.List;

public class Euler
{
   public static List<BigInteger> primes;

   public static void main(String[] args)
   {
      problem15(BigInteger.valueOf(20));
   }

   public static void problem15(BigInteger n)
   {
      // there are 2n options for n moves, so just perform 2n Choose n
      System.out.println(Operations.choose(n.multiply(BigInteger.TWO), n));
   }

   /**
    * find the longest collatz sequence below n
    * @param n
    */
   public static void problem14(BigInteger n)
   {
      int max = 0;
      BigInteger maxNum = BigInteger.ZERO;
      for(BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE))
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
      BigInteger number = BigInteger.ONE;
      BigInteger tri = BigInteger.ZERO;
      while(count < 500)
      {
         count = 1;
         tri = Operations.gaussAdd(number);
         Map<BigInteger, Integer> factors = Factors.primeFactorization(tri, primes);
         int i = 0;
         for(BigInteger prime : factors.keySet())
         {
            count *= (factors.get(prime) + 1);
         }
         number = number.add(BigInteger.ONE);
      }

      System.out.println(tri);
   }

   /**
    * find the sum off all of the prime numbers less than max
    * @param max
    */
   public static void problem10(BigInteger max)
   {
      primes = Primes.buildPrimes(max);

      BigInteger sum = BigInteger.ZERO;
      for(BigInteger prime : primes)
      {
         sum = sum.add(prime);
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
      BigInteger curMax = BigInteger.ZERO;
      for(int i = 0; i < number.length() - subProduct; i++)
      {
         BigInteger temp = BigInteger.ONE;
         for(int j = 0; j < subProduct; j++)
         {
            temp = temp .multiply(new BigInteger("" + number.charAt(i + j)));
         }

         if(temp.compareTo(curMax) > 0)
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
      BigInteger newMax = new BigInteger("" + (100 * max));
      primes = Primes.buildPrimes(newMax);
      System.out.println(primes.get(max));
   }

   /**
    * returns the difference between the sum of the squares and the square of the sums
    * of all of the numbers less than the given
    * @param max
    */
   public static void problem6(BigInteger max)
   {
      BigInteger sum = Operations.gaussAdd(max);
      BigInteger sumSquares = BigInteger.ZERO;
      for(BigInteger i = BigInteger.ZERO; i.compareTo(max) <= 0; i = i.add(BigInteger.ONE))
      {
         sumSquares = sumSquares.add(i.pow(2));
      }

      System.out.println(sum.pow(2).subtract(sumSquares));
   }

   /**
    * Find the smallest number that is divisible by all of the numbers less than max
    * @param max
    */
   public static void problem5(BigInteger max)
   {
      primes = Primes.buildPrimes(max.pow(2));

      BigInteger cur = BigInteger.ONE;
      for(BigInteger i = BigInteger.ONE; i.compareTo(max) < 0; i = i.add(BigInteger.ONE))
      {
         cur = Factors.leastCommonMultiple(i, cur, primes);
      }

      System.out.println(cur);
   }

   /**
    * find the largest palindromic number that is a multiple of 2 numbers less than max
    * @param max the highest number to check
    */
   public static void problem4(BigInteger max)
   {
      BigInteger curMax = BigInteger.ZERO;
      for(BigInteger i = max; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE))
      {
         for(BigInteger j = max; j.compareTo(BigInteger.ZERO) > 0; j = j.subtract(BigInteger.ONE))
         {
            BigInteger toCheck = i.multiply(j);
            if(toCheck.compareTo(curMax) > 0 && StringOperations.isPalindrome("" + toCheck))
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
   public static void problem3(BigInteger max)
   {
      List<BigInteger> primes = Primes.buildPrimes(max);
      for(BigInteger prime : primes)
      {
         while(max.mod(prime).intValue() == 0 && max != prime)
         {
            max = max.divide(prime);
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