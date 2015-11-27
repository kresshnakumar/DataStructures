import java.util.*;
import java.lang.*;
interface stactADT {
	public void push(String element);
	public void pop();
	public String top();
	public boolean isEmpty();
}
class MyArrayADT implements stactADT {
	String[] arrayADT;
	int top;
	int size;
	public MyArrayADT() {
		size = 10;
		arrayADT = new String[10];
		top = -1;
	}
	public void push(String element) {
		if(top < size) {
			String ch1 = top();
			if(ch1.compareTo(element) == 0) {
				pop();
			}
			else {
				top = top + 1;
				arrayADT[top] = element;
			}
		}
		else {
			System.out.println("Stack OverFlow");
		}
	}
	public void pop() {
		if(top == -1) {
			System.out.println("Stack UnderFlow");
		}
		else {
			top = top - 1;			
		}
	}
	public String top() {
		if(top == -1) {
			//System.out.println("Stack is empty");
			return "x";
		}
		else {
			//System.out.println(arrayADT[top]);
			return arrayADT[top];
		}
	}
	public boolean isEmpty() {
		if(top == -1) {
			//System.out.println("Stack is isEmpty");
			return true;
		}
		else {
			//System.out.println("Stack is notEmpty");
			return false;
		}
	}
}
public class Stactprob {
	public static void main(String[] args) {
		boolean flag = true;
		MyArrayADT obj = new MyArrayADT();
		Scanner input = new Scanner(System.in);
		do {
			String str = input.nextLine();
			if(str.compareTo("end") == 0) {
				flag = false;
				break;
			}
			String[] result = str.split(" ");
			int x = 1;
			String temp = "";
			while(x < result.length) {
				temp = temp + result[x];
				x++;
			}
			obj.push(temp);
			//flag = obj.isEmpty();
		}while(flag);
		if(obj.isEmpty()) {
			System.out.println("Successfully matched function calls and returns");
		}
		else {
			System.out.println("Invalid function call or return");
		}
	}
}