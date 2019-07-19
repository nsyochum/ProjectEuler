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
}
