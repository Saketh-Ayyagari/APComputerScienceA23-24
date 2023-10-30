import java.io.*;
import java.util.Scanner;
/*
Saketh Ayyagari
Implementation of QuickSort using Hoare's Partitioning Scheme
Precondition: all elements are valid types
Postcondition: all elements in an array are sorted
*/
public class HoareAlgorithm{
	static int[] getData(){ //gets input of elements of the array
		Scanner sc = new Scanner(System.in);
		int temp[] = new int[1000];
		int x = 0;
		while (sc.hasNextLine()){
			temp[x] = sc.nextInt();
			x++;
		}
		int[] arr = new int[x]; //creates a new array with a more fixed size to store elements
		for (int i = 0; i < x; i+=1){
			arr[i] = temp[i];
		}
		return arr;
	}
	static void exchange(int arr[], int a, int b){ //exchanges two elements in an array given their indecies
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	static void partition(int a[], int l, int r){ //sorts the array between 
		int pivot = a[l];
		while (l+1 < r){ //moving left and right indecies inward until an inversion is reached
			if (pivot > a[l]){ //if the left index reaches an element greater than the pivot
				//moves the right index inward until an element less than the pivot is reached 
				while (a[r] < pivot){
					r--;
				}
				exchange(a, l, r);
			}
			l++;
		}
	}
	static void qs(int arr[]){ // 
		partition(arr, 0, arr.length-1);
	}
	public static void main(String[] args) {
		
	}
}