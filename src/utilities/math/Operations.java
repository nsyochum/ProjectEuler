package utilities.math;

public class Operations {
 /**
   * uses Gauss' algorithm to add up all of the numbers less than a given number
   * @param max
   * @return
   */
  public static long gaussAdd(long max)
  {
    return (max * (max + 1)) / 2L;
  }


  /**
   * returns the factorial of the given number
   * @param n
   * @return
   */
  public static long factorial(long n)
  {
    if(n == 0)
      return 1;

    return n * factorial(n - 1);
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

  public static int collatzLength(long n)
  {
    if(n == 1)
    {
      return 1;
    }
    if(n % 2 == 0)
    {
      n = n / 2;
    }
    else
    {
      n = 3*n + 1;
    }
    return collatzLength(n) + 1;
  }
}
