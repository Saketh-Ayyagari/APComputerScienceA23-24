import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari
Implementation of QuickSort using Lomuto's Partition
*/
public class LomutoAlgorithm{
	static String[] getData(){ 
		Scanner sc = new Scanner(System.in);
		String[] temp = new String[1000];
		int x = 0;
		while (sc.hasNextLine()){
			temp[x] = sc.nextLine();
			x+=1;
		}
		String[] output = new String[x];
		for (int i = 0; i < output.length; i+=1){
			output[i] = temp[i];
		}
		return output;
	}
	public static void partition(String a[], int l, int h){ 
		//sorts all elements between the lower bound m and upper bound h inclusive
		if (l < h){ // is the size of the subarray being partitioned at least 1?
			String temp = ""; //temporary variable used for exchanging elements
			int m = l; //counter that keeps track of the index being swapped
			int pivot = l; 
			int r = l + 1;
		
			while (r <= h){ //r index traverses up until the upper bound
				if (a[r].compareTo(a[pivot]) < 0){
					m+=1;
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
			
			partition(a, l, pivot-1); //partition for lower half
			partition(a, pivot+1, h); //partition for upper half
		}
	}
	public static void sort(String arr[]){ //sorts the entire array
		partition(arr, 0, arr.length-1);
	}
	public static void printData(String[] a){
		for (int i = 0; i < a.length; i+=1){
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		String[] array = getData();
		sort(array);
		printData(array);
	}
}
