import java.io.*;
import java.util.Scanner;
/*Saketh Ayyagari, 3oct2023
 * Sorting an array of strings using Selection Sort algorithm in descending order
 */
public class ReverseSelectSort{
    static String[] getData(String filename) throws FileNotFoundException{ //returns an array of the input 
        Scanner sc = new Scanner(new File(filename));
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
    static void SelectionSort(String[] a){ //runs selection sort algorithm
        int boundary = 0;
        while (boundary < a.length-1){
            int i = boundary; //index that goes the array
            String largest_lexographic_string = a[i+1];
            int index_of_largest_string = i+1;
            while (i < a.length){ //goes through array to find the smallest lexicographic string
                if (a[i].compareTo(largest_lexographic_string) > 0){
                    //if the current string is lexicographically larger than the largest lexicograhical string
                    largest_lexographic_string = a[i];
                    index_of_largest_string = i;
                }
                i+=1;
            }
            /*does an exchange of elements between the largest string and 
            the string at the boundary*/
            String temp = largest_lexographic_string;
            a[index_of_largest_string] = a[boundary];
            a[boundary] = temp;

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
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc2 = new Scanner(System.in);
        System.out.println("What is the name of your file: ");
        String filename = sc2.nextLine();
        String[] words = getData(filename);
        SelectionSort(words);
        procedure(words);
        return;
    }
}