import java.io.*;
//Saketh Ayyagari, 20oct2023
//Using recursion to generate the nth number of the Fibonnaci Sequence
public class Fibonacci{
	static int count = 0; //counts the number of times the algorithm recurses through different values.
	static int nthFibNum(int n){ //finds the nth fibonacci number of fibonacci sequence
		count++;
		if (n <= 1){ //returns the value itself if n is at most 1
			return n;
		}
		return nthFibNum(n - 1) + nthFibNum(n - 2); //next fibonacci number is the sum of the previous two elements
	}
	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		System.out.println("Fibonnaci Number: " + nthFibNum(input));
		
		System.out.println("Number of times method recurses: " + count);
		return;
	}
}
