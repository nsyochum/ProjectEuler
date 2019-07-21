package utilities.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Primes
{
  /**
   * A method to build a list of prime numbers less than a given max.
   * @param max the max number to check
   * @return a list of all primes below max
   */
  public static List<BigInteger> buildPrimes(BigInteger max)
  {
    List<BigInteger> toReturn = new ArrayList<>();
    for(BigInteger i = BigInteger.TWO; i.compareTo(max) > 0; i = i.add(BigInteger.ONE))
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
  public static boolean isPrime(BigInteger num, List<BigInteger> primes)
  {
    for(BigInteger prime : primes)
    {
      // if we ever hit the square root of the number, then it is prime
      if(prime.pow(2).compareTo(num) > 0)
      {
        return true;
      }

      if(num.mod(prime).intValue() == 0)
      {
        return false;
      }
    }

    return true;
  }

}
