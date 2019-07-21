package utilities;

public class StringOperations
{
  /**
   * A method to check if a string is a palindrome
   * @param str the string to check
   * @return true if a palindrome, else false
   */
  public static boolean isPalindrome(String str)
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

  public static int[] stringToIntArray(String num)
  {
    int[] toReturn = new int[num.length()];

    for (int i = 0; i < num.length(); i++)
    {
      toReturn[num.length() - i - 1] = Integer.parseInt("" + num.charAt(i));
    }

    return toReturn;
  }
}
