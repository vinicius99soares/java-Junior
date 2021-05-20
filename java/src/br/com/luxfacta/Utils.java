package br.com.luxfacta;


public class Utils {

	
	public static String reverseWord(String word) {
		String reverseWord = "";
		
		for(int i = word.length()-1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}
		
		return reverseWord;
	}
	
}