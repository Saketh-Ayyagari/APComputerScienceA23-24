import java.io.*;
import java.util.Scanner;
import java.lang.Math;
/*
Saketh Ayyagari, 3nov2023
Optimizing QuickSort by using Math.random to generate a pseudorandom pivot
*/
public class QS_Optimization1{
	static int comparisons = 0;
	static String[] getData(String filename) throws FileNotFoundException{ 
		Scanner sc = new Scanner(new File(filename));
		String[] temp = new String[1000];
		int x = 0;
		while (sc.hasNextLine()){
			temp[x] = sc.nextLine();
			x+=1;
		}
		String[] output = new String[x]; // input with a more fixed 
		for (int i = 0; i < output.length; i+=1){
			output[i] = temp[i];
		}
		return output;
	}
	public static void partition(String a[], int l, int h){ 
		//returns the index at which the pivot is moved to in the unsorted array
		if (h - l > 0){
			//creating a pivot using Math.random()
			int pivot = l + (int)(Math.random() * (h - l));
			String temp = ""; //temporary variable used for exchanging elements
			int m = l; //keeps track of the element being swapped when it is less than the pivot 
			int r = l;
			while (r <= h){ //r index traverses up until the upper bound
				if (a[r].compareTo(a[pivot]) < 0){
					m+=1;
					comparisons+=1;
					//does the exchange of elements
					temp = a[m];
					a[m] = a[r];
					a[r] = temp;	
				}
				r+=1;
			}
			//exchanges pivot with element at index m
			temp = a[pivot];
			a[pivot] = a[m];
			a[m] = temp;
			
			partition(a, l, pivot-1); //partitions lower half
			partition(a, pivot+1, h); //partitions upper half
		}
	}
	public static void sort (String a[]){ //partitions the array into two halves, then "sorts" each one individually
		partition(a, 0, a.length-1);
	}
	public static void printData(String[] a){
		for (int i = 0; i < a.length; i+=1){
			System.out.println(a[i]);
		}
		System.out.println("Number of comparisons: " + comparisons);
	}
	public static void main(String[] args) throws FileNotFoundException{
		String[] array = getData(args[0]);
		sort(array);
		printData(array);
	}
}
