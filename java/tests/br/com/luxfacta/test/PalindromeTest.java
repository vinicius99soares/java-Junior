package br.com.luxfacta.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import br.com.luxfacta.Palindrome;

public class PalindromeTest {
  @Test
  public void testExampleCase() {
    assertTrue(Palindrome.isPalindrome("omississimo"));
  }

  @Test
  public void testPalindromesCase() {
    assertTrue(Palindrome.isPalindrome("Ama"));

    assertTrue(Palindrome.isPalindrome("amA"));
  }

  @Test
  public void testOddAndEvenSizedPalindromes() {
    assertTrue(Palindrome.isPalindrome("amma"));

    assertTrue(Palindrome.isPalindrome("ana"));

    assertTrue(Palindrome.isPalindrome("romametemamor"));
  }

  @Test
  public void testNonPalindromes() {
    assertFalse(Palindrome.isPalindrome("not a palindrome"));
  }

  @Test
  public void testEmptyWord() {
    assertTrue(Palindrome.isPalindrome(""));
  }

  @Test
  public void testLongPalindromes() {
    assertTrue(Palindrome.isPalindrome("aaaaaaaaaababaaaaaaaaaa"));

    assertTrue(Palindrome.isPalindrome("aaaaaaaaaabbaaaaaaaaaa"));
  }
}
