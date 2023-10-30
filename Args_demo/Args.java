//Saketh Ayyagari, 7sept2023
//Demonstration of the arguments array

//import java.io.*;

public class Args{
	public static void main(String[] args){ //Both String and Arrays are classes instead of types
		int i = 0;
		while (i < args.length){ //all basic types from C++ (such as ints) are the same in Java
			System.out.println(args[i] + "  " + args[i].length());
			i+=1;
		}
		return;
	}
}
