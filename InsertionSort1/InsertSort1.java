import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari, 28sept2023
Sorting a list of String with Insertion Sort Algorithm
12oct2023: Profiling the number of comparisons done by Insertion Sort
*/
public class InsertSort1{
	static int counter = 0; //counts the number of comparisons that occur in the sorting algorithm
	static String[] getData(){ //returns an array of the input 
		Scanner sc = new Scanner(System.in);
      String[] array = new String[1000];
      int x = 0;
      while(sc.hasNextLine()){
         //reads input from a new line as long as the input has another line
         array[x] = sc.nextLine();
         x+=1;
      }
      String[] output = new String[x]; //new array has a more fixed size. 
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
			int i = j - 1; //element that precedes the new element
			while (j > 0 && a[i].compareTo(a[j]) > 0){
				counter++;
				/*does the exchange of elements if the preceding element is lexographically greater than 
				 * the current element */
				String temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j-=1;
				i-=1;
			}
			//DO ONLY ONE EXCHANGE OF ELEMENTS
			
			/**adds 1 to the number of comparisons ONLY IF the new element doesn't become the first element
			 * of the sorted array (if the new element becomes the first element of the sorted array, then there
			 * would be no need to correct for overcounting)
			*/
			if (j > 0 && a[i].compareTo(a[j]) <= 0){ 
				counter+=1;
			}
			boundary+=1;
		}
	}
	static void procedure(String[] a){ //prints all distinct values of the array
        System.out.println(a[0]); //first element will always be unique
        int j = 1;
        while (j < a.length){
            if (a[j].equals(a[j-1]) == false){ 
                //prints the next element if the current element is distinct from the preceding element 
                System.out.println(a[j]);
            }
            j+=1;
        }
		System.out.println("Total number of comparisons: " + counter);
    }

	public static void main(String[] args){
		String[] words = getData();
		insertionSort(words);
		procedure(words);
	}
}
