package utilities.math;

import java.math.BigInteger;
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
  public static BigInteger leastCommonMultiple(BigInteger a, BigInteger b, List<BigInteger> primes)
  {
    BigInteger lcm = BigInteger.ONE;
    for(BigInteger prime : primes)
    {
      BigInteger aCount = BigInteger.ZERO;
      while (a.mod(prime).intValue() == 0)
      {
        a = a.divide(prime);
        aCount = aCount.add(BigInteger.ONE);
      }

      BigInteger bCount = BigInteger.ZERO;
      while (b.mod(prime).intValue() == 0)
      {
        b = b.divide(prime);
        bCount = bCount.add(bCount);
      }

      BigInteger max = aCount.max(bCount);
      for (BigInteger i = BigInteger.ZERO; i.compareTo(max) < 0; i.add(BigInteger.ONE))
      {
        lcm.multiply(prime);
      }

      if(a.intValue() == 1 || b.intValue() == 1)
        break;
    }

    if(a.intValue() != 1)
      lcm = lcm.multiply(a);
    if(b.intValue() != 1)
      lcm = lcm.multiply(b);

    return lcm;
  }

  /**
   * Computes the prime factorization of a given number.
   * @param num
   * @param primes
   * @return
   */
  public static Map<BigInteger, Integer> primeFactorization(BigInteger num, List<BigInteger> primes)
  {
    Map<BigInteger, Integer> toReturn = new HashMap<>();
    for(BigInteger prime : primes)
    {

      while(num.mod(prime).intValue() == 0)
      {
        int count = toReturn.getOrDefault(prime, 0);
        count++;
        toReturn.put(prime, count);

        num = num.divide(prime);
      }

      if(num.intValue() == 1)
      {
        break;
      }
    }

    return toReturn;
  }

}
