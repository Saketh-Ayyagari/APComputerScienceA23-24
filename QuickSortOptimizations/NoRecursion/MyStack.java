import java.io.*;
/*Saketh Ayyagari
Creating a MyStack class for nonrecursive quicksort
*/
public class MyStack{
	private int[] st;
	private int top = 0; //first unused index of the stack 
	public MyStack(int size){ //Constructor for declaring Stack
		this.st = new int[size];
	}
	public void push(int n){ //pushes an element to the top index
		this.st[this.top] = n;
		this.top+=1;
	}
	public int pop(){ //returns element at the top
		this.top-=1;
		return this.st[this.top]; 
	}
	public boolean isEmpty(){ //is the stack empty?
		return (this.top==0);
	}
}
