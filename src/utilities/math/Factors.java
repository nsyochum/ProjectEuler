package utilities.math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factors {
  /**
   * returns the least common multiple of the two inputs
   * @param a
   * @param b
   * @return
   */
  public static long leastCommonMultiple(long a, long b, List<Long> primes)
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
   * Computes the prime factorization of a given number.
   * @param num
   * @param primes
   * @return
   */
  public static Map<Long, Integer> primeFactorization(long num, List<Long> primes)
  {
    Map<Long, Integer> toReturn = new HashMap<>();
    for(long prime : primes)
    {

      while(num % prime == 0)
      {
        int count = toReturn.getOrDefault(prime, 0);
        count++;
        toReturn.put(prime, count);

        num /= prime;
      }

      if(num == 1)
      {
        break;
      }
    }

    return toReturn;
  }

}
