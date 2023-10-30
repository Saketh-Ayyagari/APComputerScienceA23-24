import java.io.*;

public class Strtools{
	//S. Ayyagari 9/11/23
	//demonstration of different methods that can be acted on Strings
	public static void main(String[] args){
		int i = 0;
		while (i < args.length){
			System.out.println(args[i] + " " + args[i].substring(0, 6) + " " + args[i].substring(6));
			i+=1;
		}
		return;
	}
}