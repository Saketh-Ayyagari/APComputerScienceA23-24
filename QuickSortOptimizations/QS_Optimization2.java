import java.io.*;
import java.util.Scanner;
import java.lang.Math;
/*
Saketh Ayyagari, 11nov2023
Optimizing QuickSort by selecting median of a subfile as a pivot
*/
public class QS_Optimization2{
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
    public static int choose_pivot (String a[], int l, int h){
        int pivot = 0;
		int x = (int)((h-l)/3); //separates the beginning, middle, and end elements
		int first_element = l;
		int second_element = l + x;
		int third_element = l + (2*x);
		if (first_element >= second_element && first_element >= third_element){
			pivot = first_element;
		}
		else if (first_element <= second_element && second_element <= third_element){
			pivot = second_element;
		}
		else{
			pivot = third_element;
		}
        return pivot;
    }
	public static void partition(String a[], int l, int h){
		if (h - l > 0){
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
