import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String word = "";
		String cont;
		String translatedPhase;
		boolean flag = true;
		
		System.out.println("Welcome to the Pig Latin Translator");
		
		do {
			// confirms user has entered a value
			do {
				try {
					System.out.print("Enter a line to be translated: ");
					word = scnr.nextLine();
					if (word.equals(""))
	                {
	                    throw new IllegalArgumentException();
	                }
	                flag = false;
				} catch(IllegalArgumentException e) {
					System.out.println("Must enter a input");
				};
		} while(flag);
			
			translatedPhase = translatePhase(word);
			System.out.println(translatedPhase);
			
			System.out.print("Translate another line? (y/n): ");
			cont = scnr.nextLine();
		}while(!cont.equalsIgnoreCase("n"));
		System.out.println("Goodbye");
		scnr.close();
	}
	
	public static boolean isVowel(String word) {
		String startsWith = word.substring(0, 1);
		// checks first letter to see if it is a vowel Y not included
		switch(startsWith)
		{
			case "A":
			case "a":
			case "E":
			case "e":
			case "I":
			case "i":
			case "O":
			case "o":
			case "U":
			case "u":{
				return true;
			}
			default:
				return false;
		}
		
	}
	
	public static String transformVowel(String word) {
		String transformedVowel;
		
		transformedVowel = word + "way ";
		
		return transformedVowel;
	}
	
	public static String transformConsonant(String word) {
		String transformedConsonant = "";
		String firstLetter;
		String remainingLetters;
		
		for(int i = 0; i < word.length(); i++) {
			// updates first letter and remaining letters 
			firstLetter = word.substring(i, i+1);
			remainingLetters = word.substring(i+1);
			if(isVowel(firstLetter)) {
				transformedConsonant = firstLetter + remainingLetters + "ay ";
				break;
			}
			else {
				// adds first word to the end of word
				word += firstLetter;
			}
		}
		
		return transformedConsonant;
	}

	public static String translatePhase(String word) {
		// turns string into array of strings separated by " "
		String[] phase = word.split(" ");
		String transformedPhase = "";
		// loops through different words
		for(int i = 0; i < phase.length; i++) {
			if(containsSpecialOrNumber(phase[i])) {
				transformedPhase += phase[i] + " ";
			}
			else if(isVowel(phase[i])) {
				transformedPhase += transformVowel(phase[i]);
			}
			else {
				transformedPhase += transformConsonant(phase[i]);
			}
		}
		return transformedPhase;
	}
	
	public static boolean containsSpecialOrNumber(String word) {
		for(char c: word.toCharArray()) {
			if(Character.isDigit(c)) {
				return true;
			}
			else if(!Character.isLetterOrDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
