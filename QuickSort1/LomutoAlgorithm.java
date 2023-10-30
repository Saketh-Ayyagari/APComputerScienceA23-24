import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari
Implementation of QuickSort using Lomuto's Partition
*/
public class LomutoAlgorithm{

	static void exchange(int arr[], int a, int b){ //swaps two elements in an array given their indecies
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void partition(int a[], int m){ 
		int pivot = a[m-1];
		int r = m + 1;
		while (r < a.length){
			
		}
	}
	static void sort(int arr[]){ //sorts the entire array
		partition(arr);
	}


	public static void main(String[] args) {
		
	}
}