import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari, 3oct2023
Sorting a list of String with Insertion Sort Algorithm in Reverse Lexicographical Order
*/
public class ReverseInsertSort{
	static String[] getData(String filename) throws FileNotFoundException{ //returns an array of the input 
		Scanner sc = new Scanner(new File(filename));
		String[] array_temporary = new String[1000];
		int x = 0;
		while(sc.hasNextLine()){
			 //reads input from a new line as long as the input has another line
			array_temporary[x] = sc.nextLine();
			x+=1;
		}
		String[] output = new String[x];
		int i = 0;
		while (i < x){
			output[i] = array_temporary[i];
			i+=1;
		}
		return output;
	}
	static void insertionSort(String[] a){ //sorts the array in reverse lexicographical order 
		int boundary = 1; //separates the sorted and unsorted subarrays
		while (boundary < a.length){ 
			int j = boundary; 
			int i = j - 1; //element that precedes the new element
			while (j > 0 && a[i].compareTo(a[j]) < 0){
				/*does the exchange of elements if the preceding element is lexicographically less than 
				 * the current element */
				String temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j-=1;
				i-=1;
			}
			boundary+=1;
		}
	}
	static void procedure(String[] a){ //prints all distinct values of the array
        // System.out.println(a[0]); //first element will always be unique
        // int j = 1;
        // while (j < a.length){
        //     if (a[j].equals(a[j-1]) == false){ 
        //         //prints the next element if the current element is distinct from the preceding element 
        //         System.out.println(a[j]);
        //     }
        //     j+=1;
        // }
		for (int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
    }

	public static void main(String[] args) throws FileNotFoundException{
		String[] words = getData(args[0]);
		insertionSort(words);
		procedure(words);
	}
}