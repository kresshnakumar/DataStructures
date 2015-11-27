import java.util.*;
// interface stactADT<E> {
// 	public void push(E element);
// 	public void pop();
// 	public void top();
// 	public void isEmpty();
// }
class MyArrayADT {
	long[] arrayADT;
	int top;
	int size;
	public MyArrayADT() {
		size = 50;
		arrayADT = new long[size];
		top = -1;
	}
	public void push(long element) {
		if(top < size) {
			top = top + 1;
			arrayADT[top] = element;
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
	public void print() {
		while(top != -1) {
			System.out.print(arrayADT[top]);
			pop();
		}
	}
	public void top() {
		if(top == -1) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println(arrayADT[top]);
		}
	}
	public void isEmpty() {
		if(top == -1) {
			System.out.println("Stack is isEmpty");
		}
		else {
			System.out.println("Stack is notEmpty");
		}
	}
}
public class StackDecimalToBinary {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MyArrayADT obj = new MyArrayADT();
		long num = input.nextLong();
		long rem;
		while(num > 0) {
			rem = num % 2;
			obj.push(rem);
			num = num/2;
		}
		obj.print();
	}
}