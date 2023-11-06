import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari, 6nov2023
Implementation of QuickSort using Lomuto Partition
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
		String[] output = new String[x]; // input with a more fixed 
		for (int i = 0; i < output.length; i+=1){
			output[i] = temp[i];
		}
		return output;
	}
	public static void partition(String a[], int l, int h){ 
		//sorts the subarray from the lower bound l (which is also the pivot) and the upper bound h
		if (h - l > 0){
			//is the size of the subarray greater than 1?
			String temp = ""; 
			int m = l; //keeps track of element being exchanged when we get to one less than the pivot 
			int r = l + 1;
			while (r <= h){ //r index traverses up until the upper bound
				if (a[r].compareTo(a[l]) < 0){ 
				//if the current element is lexicographically less than the pivot
					m+=1;
					//exchange of elements
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
			partition(a, l, m-1); //partitions lower half
			partition(a, m+1, h); //partitions upper half
		}
	}
	public static void sort (String a[]){ //sorts the entire array
		partition(a, 0, a.length-1);
	}
	public static void printData(String[] a){
		int i = 0;
		while (i < a.length){
			System.out.println(a[i]);
			i+=1;
		}
	}
	public static void main(String[] args) {
		String[] array = getData();
		sort(array);
		printData(array);
	}
}