package br.com.luxfacta;

import br.com.luxfacta.Utils;

/*******************************************************************************
  Uma palíndroma é uma palavra que se lê da mesma forma de trás para frente.

  Escreva o corpo do método isPalindrome que verifica se uma palavra é
  palíndroma. A validação deve desconsiderar diferença entre maiúsculas e
  minúsculas (case insensitive).

  Por exemplo, isPalindrome(“Deleveled”) deve retornar true.
*******************************************************************************/

public boolean isPalindrome(String word) {
  String wordLowerCase = word.toLowerCase();
  String reverseWord = Utils.reverseWord(wordLowerCase);
  int wordLength = wordLowerCase.length();
  boolean result = true;	
  
  for (int i = 0; i < wordLength; i++) {
    if (wordLowerCase.charAt(i) != reverseWord.charAt(i)) {
      result = false;
      break;
    }
  }
  
  return result;
}

}