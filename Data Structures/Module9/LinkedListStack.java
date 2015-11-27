import java.util.*;
interface stactADT<E> {
	public void push(E element);
	public void pop();
	public void top();
	public void isEmpty();
}
class Node<E> {
	private E data;
	private Node<E> address;
	public Node(E data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData() {
		return data;
	}
	public void setAddress(Node address) {
		this.address = address;
	}
	public Node getAddress() {
		return address;	
	}
}

class MyArrayADT<E> implements stactADT<E> {
	int top;
	int size;
	Node<E> start;
	Node<E> end;
	public MyArrayADT() {
		start = null;
		end = null;
		size = 10;
		top = -1;
	}
	public void push(E element) {
		if(top < size) {
			Node<E> node = new Node<E>(element,null);
			if(start == null) {
				start = node;
				end = start;
				top++;
				size++;
			}
			else {
				end.setAddress(node);
				end = node;
				top++;
				size++;
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
			Node<E> prev = start;
			Node<E> current = start.getAddress();
			if(start == end) {
				start = null;
				size--;
			}
			else if(current.getAddress() == null) {
				start.setAddress(null);
				current = null;
				end = start;
				size--;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
				}
				prev.setAddress(null);
				current = null;
				end = prev;
				size--;
			}
			top--;
		}
	}
	public void top() {
		if(top == -1) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println(end.getData());
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
public class LinkedListStack {
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