import java.io.*;
import java.util.Scanner;
/**Saketh Ayyagari, 18oct2023
 * Sorting an array of Strings using Insertion Sort Algorithm (without profiling)
 */
public class InsertSort2 {
    static String[] getData(){ //returns an array of the input 
	Scanner sc = new Scanner(System.in);
        String[] array = new String[1000];
        int x = 0;
        while(sc.hasNextLine()){
             //reads input from a new line as long as the input has another line
            array[x] = sc.nextLine();
            x+=1;
        }
        String[] output = new String[x]; //new array has a fixed size. 
        int i = 0;
        while (i < x){
            output[i] = array[i];
            i+=1;
        }
        return output;
    }
	static void insertionSort(String[] a){ //sorts the array in lexographical order 
		int boundary = 1; //separates the sorted and unsorted subarrays
		while (boundary < a.length){ 
			int j = boundary; 
            String temp = a[boundary]; //new element from the unsorted subarray 
			while (j > 0 && a[j-1].compareTo(temp) > 0){ 
                int i = j - 1; //index of element that precedes the new element
                //if the preceding element is lexicographically greater than the element at the boundary line, 
                //then swap it 
                a[j] = a[i]; 
				j-=1;
			}
            /*assigns the string at the boundary index to the index where the preceding element is 
            lexicographially less*/
            a[j] = temp; 
			boundary+=1;
		}
	}
	static void procedure(String[] a){ //prints all distinct elements of the array
        System.out.println(a[0]); //first element will always be unique
        int j = 1;
        while (j < a.length){
            if (a[j].equals(a[j-1]) == false){ 
                //prints the next element if the current element is distinct from the preceding element 
                System.out.println(a[j]);
            }
            j+=1;
        }
    }
	public static void main(String[] args){
		String[] words = getData();
		insertionSort(words);
		procedure(words);
	}
}   
