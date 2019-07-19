package utilities.math;

import java.util.ArrayList;
import java.util.List;

public class Primes
{
  /**
   * A method to build a list of prime numbers less than a given max.
   * @param max the max number to check
   * @return a list of all primes below max
   */
  public static List<Long> buildPrimes(long max)
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
  public static boolean isPrime(long num, List<Long> primes)
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
