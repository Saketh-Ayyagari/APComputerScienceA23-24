import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari
Implementation of QuickSort using Lomuto's Partition
*/
public class LomutoAlgorithm{
	static int[] getData(){
		Scanner sc = new Scanner(System.in);
		int[] temp = new int[1000];
		int x = 0;
		while (sc.hasNextLine()){
			temp[x] = sc.nextInt();
		}
		int[] output = new int[x];
		for (int i = 0; i < output.length; i+=1){
			output[i] = temp[i];
		}
		return output;
	}
	public static void exchange(int arr[], int a, int b){ //swaps two elements in an array given their indecies
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	static void partition(int a[], int m, int h){ //sorts all elements between the lower bound m and upper bound h
		int pivot = m; //index of pivot element
		int r = m + 1;
		if (h - m + 1 < 2){
			return;
		}
		else{
			while (r < h){
				if (a[r] < a[pivot]){
					m+=1;
					exchange(a, m, r);
				}
				r+=1;
			}
		}
		exchange(a, pivot, m);
		partition(a, 0, pivot);
		partition(a, pivot + 1, h);
	}
	static void sort(int arr[]){ //sorts the entire array
		partition(arr, 0, arr.length);
	}
	public static void main(String[] args) {
		int[] array = getData();
		sort(array);
		for (int i = 0; i < array.length; i+=1){
			System.out.println(array[i]);
		}
	}
}