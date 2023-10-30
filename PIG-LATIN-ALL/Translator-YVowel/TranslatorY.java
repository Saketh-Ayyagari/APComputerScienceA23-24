import java.io.*;
/*
Saketh Ayyagari
9/18/23 
Translating English into Pig Latin with String methods while considering if 'Y' is a consonant or a vowel. 
*/
public class TranslatorY{
	static boolean isVowelRegular(char c){ //determines whether or not a character is a vowel (aeiou)
		if ("aeiou".indexOf(c)>=0){ //does a character have an index in the string of vowels? 
			return true;
		}
		else{ //if the character does not contain an index in the string of vowels
			return false; 
		} 
	}
   	static boolean isYVowel(char c){ //determines if 'y' is a vowel or not
   		if ("aeiouy".indexOf(c)>=0){ //does c have an index in this string of vowels?
   			return true;
   		}
   		else{
   			return false;
   		}
   	}
	static String translate(String s){ //translates english word into Pig Latin
		String translated_word;
		if (isVowelRegular(s.charAt(0)) == true){ 
			//adds "yay" to the end of original word if word starts with a vowel
			translated_word = s + "yay";
		}
		else{ //if the word starts with a consonant or if 'y' is in the beginning 
			int first_vowel_index = 1; 
			//index starts with 1 because it is guaranteed that the first letter (if it's a consonant or 'y') will be moved to the end.
			while (isYVowel(s.charAt(first_vowel_index))==false){ 
			//increments index as long as a letter is NOT a vowel (including 'y')
				first_vowel_index+=1;
			}
			//taking cluster of consonants that come before 'y' and adding it to the end along with "ay".
			translated_word = s.substring(first_vowel_index) + s.substring(0, first_vowel_index) + "ay"; 
		}
		return translated_word;
	}
	public static void main(String[] args) {
		int i = 0;
		while (i < args.length){
			System.out.println(args[i] + "  " + translate(args[i]));
			i+=1;
		}
		return;
	}
}

