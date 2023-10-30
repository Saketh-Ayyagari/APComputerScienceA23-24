import java.io.*;
import java.util.Scanner;
/*Saketh Ayyagari, 1oct2023
 * Sorting an array of strings using Selection Sort algorithm
 12oct2023: Profiling the number of comparisons done by Selection Sort
 */
public class SelectionSort1{
    static int counter = 0; //counts the number of comparisons done throughout the sort

    public static String[] getData(){ //returns an array of the input 
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
    public static void SelectionSort(String[] a){ //runs selection sort algorithm
        int boundary = 0;
        while (boundary < a.length-1){
            int i = boundary + 1; //index that goes the unsorted array
            int index_of_smallest_string = boundary;
            while (i < a.length){ //goes through array to find the smallest lexographic string
                counter+=1; //increments the number of comparisons done
                if (a[i].compareTo(a[index_of_smallest_string]) < 0){
                    //if the current string is lexographically smaller than the smallest string
                    index_of_smallest_string = i;
                }
                i+=1;
            }
            /*does an exchange of elements between the smallest string and 
            the string at the boundary*/
            String temp = a[index_of_smallest_string];
            a[index_of_smallest_string] = a[boundary];
            a[boundary] = temp;
            boundary+=1;
        }
    }
    public static void procedure(String[] a){ //prints all distinct values of the array
        System.out.println(a[0]); //first element will always be unique, so it is always printed out
        int j = 1;
        while (j < a.length){
            if (a[j].equals(a[j-1]) == false){ 
                //prints the next element if the current element is distinct from the preceding element 
                System.out.println(a[j]);
            }
            j+=1;
        }
        System.out.println("Number of comparisons: " + counter);
    }

    public static void main(String[] args){
        String[] words = getData();
        SelectionSort(words);
        procedure(words);
        return;
    }
}