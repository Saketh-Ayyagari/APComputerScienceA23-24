import java.io.*;
/*
Saketh Ayyagari
9/15/23 
Translating English into Pig Latin with String methods
*/
public class Translator{
	static boolean isVowel(char c){ //determines whether or not a character is a vowel
		if ("aeiou".indexOf(c)>=0){ //does a character have an index in the string of vowels? 
			return true;
		}
		else{ //if the character does not contain an index in the string of vowels
			return false; 
		} 
	}
	static int firstVowelIndex(String s){ //finds & returns the index of the first vowel in a word
		int first_vowel_index=0;
		while (isVowel(s.charAt(first_vowel_index)) == false){ 
			//increment index by 1 as long as the character is a consonant
			first_vowel_index+=1;
		}
		return first_vowel_index;
	}
	static String translate(String a){ //translates english into pig latin
		String translated_word;
		if (isVowel(a.charAt(0)) == true){ 
			//adds "yay" to the end of original word if word starts with a vowel
			translated_word = a + "yay";
		}
		else{ //if the word starts with a consonant
			int first_vowel_index = firstVowelIndex(a);
			//moves the cluster of consonants to the end and adds "ay".
			translated_word = a.substring(first_vowel_index) + a.substring(0, first_vowel_index) + "ay";
		}
		return translated_word;
	}
	public static void main(String[] args) {
		int i = 0;
		while (i < args.length){
			args[i].toLowerCase(); //makes all characters in a word lowercase
			System.out.println(args[i] + "  " + translate(args[i]));
			i+=1;
		}
		return;
	}
}

