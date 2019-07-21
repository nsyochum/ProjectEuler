package utilities.math;

import java.math.BigInteger;

public class Operations {
 /**
   * uses Gauss' algorithm to add up all of the numbers less than a given number
   * @param max
   * @return
   */
  public static BigInteger gaussAdd(BigInteger max)
  {
    return max.multiply(max.add(BigInteger.ONE)).divide(BigInteger.TWO);
  }


  /**
   * returns the factorial of the given number
   * @param n
   * @return
   */
  public static BigInteger factorial(BigInteger n)
  {
    if(n.intValue() == 0)
      return BigInteger.ONE;

    return n.multiply(factorial(n.subtract(BigInteger.ONE)));
  }

  /**
   * returns
   * @param n
   * @param m
   * @return
   */
  public static int carryDigit(int n, int m)
  {
    return (n + m) / 10;
  }

  public static int resultDigit(int n, int m)
  {
    return (n + m) % 10;
  }

  public static int collatzLength(BigInteger n)
  {
    if(n.intValue() == 1)
    {
      return 1;
    }
    if(n.mod(BigInteger.TWO).intValue() == 0)
    {
      n = n.divide(BigInteger.TWO);
    }
    else
    {
      n = n.multiply(BigInteger.valueOf(3L)).add(BigInteger.ONE);
    }
    return collatzLength(n) + 1;
  }

  public static BigInteger choose(BigInteger n, BigInteger k)
  {
    BigInteger nFactorial = factorial(n);
    BigInteger kFactorial = factorial(k);
    BigInteger nMinusKFactorial = factorial(n.subtract(k));
    return nFactorial.divide(kFactorial.multiply(nMinusKFactorial));
  }
}
