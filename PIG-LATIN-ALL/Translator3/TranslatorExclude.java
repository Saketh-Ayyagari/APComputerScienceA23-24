import java.io.*;
/*
Saketh Ayyagari
9/19/23 
Translating English into Pig Latin with the exception of certain words
*/
public class TranslatorExclude{
	static boolean isVowelRegular(char c){ //determines whether or not a character is a vowel (aeiou)
		if ("aeiou".indexOf(c)>=0){ //does a character have an index in the string of vowels? 
			return true;
		}
		else{ //if the character does not contain an index in the string of vowels
			return false; 
		} 
	}
   	static boolean isYVowel(char c){ //determines if 'y' is a vowel or not
   		if ("aeiouy".indexOf(c)>=0){ //does character c have an index in this string of vowels?
   			return true;
   		}
   		else{
   			return false;
   		}
   	}
   	static boolean shouldTranslate(String a){ //should a word be translated into Pig Latin or not?
   		String[] excludedWords = {"a", "at", "in", "an", "or", "by", "the", "yet", "to", "so", "on"};
   		int x = 0; //counter that goes through the array
		while (x < excludedWords.length){
			if (excludedWords[x].equals(a)){ //the string should not be translated if it is in the array
				return false;
			}
			else{
				x+=1;
			}
		}
		return true;
   	}
	static String translate(String s){ //translates english word into Pig Latin
		String translated_word;
		if (shouldTranslate(s) == true){ //if the word is not in the array of excluded words
			if (isVowelRegular(s.charAt(0)) == true){ 
				//adds "yay" to the end of original word if word starts with a vowel
				translated_word = s + "yay";
			}
			else{ //if the word starts with a consonant or if 'y' is in the beginning 
				int first_vowel_index = 1; //index starts with 1 because it is guaranteed that the first letter (if it's a consonant or 'y') will be moved to the end.
				while (isYVowel(s.charAt(first_vowel_index))==false){ 
				//increments index as long as a letter is NOT a vowel (including 'y')
					first_vowel_index+=1;
				}
				//taking cluster of consonants that come before 'y' and adding it to the end along with "ay".
				translated_word = s.substring(first_vowel_index) + s.substring(0, first_vowel_index) + "ay"; 
			}
		}
		else{
			translated_word = s;
		}
		return translated_word;
	}
	public static void main(String[] args) {
		int i = 0;
		while (i < args.length){
			System.out.println(args[i] + "  " + translate(args[i]));
			i+=1;
		}	
	}
}

