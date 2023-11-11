import java.io.*;
import java.util.Scanner;
import java.lang.Math;
/*
Saketh Ayyagari, 9nov2023
Optimizing QuickSort by switching to Insertion Sort when the subfile reaches a certain size
*/
public class QS_Optimization3{
	static int comparisons = 0;
	static String[] getData() { 
		Scanner sc = new Scanner(System.in);
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
	public static void insertionSort(String a[], int l, int r){ 
        //uses Insertion Sort algorithm between specific indecies
		int boundary = l+1; 
		while (boundary <= r){
			int j = boundary; //goes through preceding elements to check if they're lexicographically greater than new element
			String temp = a[boundary];
			while (j > l && a[j-1].compareTo(temp) > 0){ 
				//while j is greater than l and  preceding element is lexicographically smaller
				a[j] = a[j-1];
				j-=1;
			}
			a[j] = temp;
			boundary+=1;
		}	
    }
	public static void partition(String a[], int l, int h){
		int subfile_size = 3; 
		if (h - l > subfile_size){
			String temp = "";
			int m = l; //keeps track of the element being swapped when it is less than the pivot 
			int r = l+1;
			while (r <= h){ //r index traverses up until the upper bound
				if (a[r].compareTo(a[l]) < 0){
					m+=1;
					comparisons++;
					//does the exchange of elements
					temp = a[m];
					a[m] = a[r];
					a[r] = temp;	
				}
				r+=1;
			}
			//exchanges pivot with element at index m
			temp = a[l];
			a[l] = a[m];
			a[m] = temp;
			
			partition(a, l, m-1); //partitions lower half (from index l to the exchanged )
			partition(a, m+1, h); //partitions upper half
		}
		else{
			insertionSort(a, l, h);
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
	public static void main(String[] args){
		String[] array = getData();
		sort(array);
		printData(array);
	}
}
