import java.util.*;
interface stactADT {
	public void push(char element);
	public void pop();
	public char top();
	public boolean isEmpty();
}
class MyArrayADT implements stactADT {
	char[] arrayADT;
	int top;
	int size;
	public MyArrayADT() {
		size = 10;
		arrayADT = new char[10];
		top = -1;
	}
	public void push(char element) {
		if(top < size) {
			char ch1 = top();
			//System.out.println(ch1 + "--" + element);
			if((ch1 == '(') && (element == ')')) {
				pop();
			}
			else if((ch1 == '{') && (element == '}')) {
				pop();
			}
			else if((ch1 == '[') && (element == ']')) {
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
	public char top() {
		if(top == -1) {
			//System.out.println("Stack is empty");
		}
		else {
			//System.out.println(arrayADT[top]);
			return arrayADT[top];
		}
		return 'x';
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
public class BalancedStack {
	public static void main(String[] args) {
		boolean flag = true;
		MyArrayADT obj = new MyArrayADT();
		Scanner input = new Scanner(System.in);
		do {
			char ch = input.next().charAt(0);
			if(ch == 'N' || ch == 'n') {
				flag = false;
				break;
			}
			obj.push(ch);
		}while(flag);
		if(obj.isEmpty()) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");
		}
	}
}