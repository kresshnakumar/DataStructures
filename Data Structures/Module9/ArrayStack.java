import java.util.*;
interface stactADT<E> {
	public void push(E element);
	public void pop();
	public void top();
	public void isEmpty();
}
class MyArrayADT<E> implements stactADT<E> {
	E[] arrayADT;
	int top;
	int size;
	public MyArrayADT() {
		size = 10;
		arrayADT = (E[])new Object[10];
		top = -1;
	}
	public void push(E element) {
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
public class ArrayStack {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			MyArrayADT<Integer> obj = new MyArrayADT<Integer>();
			int flag = 1;
			do{
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					int value = Integer.parseInt(result[1]);
					obj.push(value);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.pop();
				}
				if(result[0].compareTo("top") == 0) {
					obj.top();
				}
				if(result[0].compareTo("isEmpty") == 0) {
					obj.isEmpty();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'F') {
			MyArrayADT<Float> obj = new MyArrayADT<Float>();
			int flag = 1;
			do{
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					float value = Float.parseFloat(result[1]);
					obj.push(value);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.pop();
				}
				if(result[0].compareTo("top") == 0) {
					obj.top();
				}
				if(result[0].compareTo("isEmpty") == 0) {
					obj.isEmpty();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'C') {
			MyArrayADT<Character> obj = new MyArrayADT<Character>();
			int flag = 1;
			do{
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					char ch = result[1].charAt(0);
					obj.push(ch);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.pop();
				}
				if(result[0].compareTo("top") == 0) {
					obj.top();
				}
				if(result[0].compareTo("isEmpty") == 0) {
					obj.isEmpty();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'S') {
			MyArrayADT<String> obj = new MyArrayADT<String>();
			int flag = 1;
			do{
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					obj.push(result[1]);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.pop();
				}
				if(result[0].compareTo("top") == 0) {
					obj.top();
				}
				if(result[0].compareTo("isEmpty") == 0) {
					obj.isEmpty();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
	}
}