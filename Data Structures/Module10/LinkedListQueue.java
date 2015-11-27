import java.util.*;
interface queueADT<E> {
	public void enQueue(E element);
	public void deQueue();
	public void front();
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

class MyArrayADT<E> implements queueADT<E> {
	int top;
	int size;
	Node<E> front;
	Node<E> rear;
	public MyArrayADT() {
		front = null;
		rear = null;
		size = 10;
		top = -1;
	}
	public void enQueue(E element) {
		Node<E> node = new Node<E>(element,null);
		if(front == null) {
			front = node;
			rear = front;
			top++;
			size++;
		}
		else {
			rear.setAddress(node);
			rear = node;
			top++;
			size++;
		}
	}
	public void deQueue() {
		if(top == -1) {
			System.out.println("Queue is Empty");
		}
		else {
			if(front.getAddress() == null) {
				front = null;
				size--;
				top--;
				rear = null;
			}
			else {
				front = front.getAddress();
				size--;
			}
		}
	}
	public void front() {
		if(top == -1) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println(front.getData());
		}
	}
	public void isEmpty() {
		if(top == -1) {
			System.out.println("Queue is isEmpty");
		}
		else {
			System.out.println("Queue is notEmpty");
		}
	}
}
public class LinkedListQueue {
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
					obj.enQueue(value);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.deQueue();
				}
				if(result[0].compareTo("front") == 0) {
					obj.front();
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
					obj.enQueue(value);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.deQueue();
				}
				if(result[0].compareTo("front") == 0) {
					obj.front();
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
					obj.enQueue(ch);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.deQueue();
				}
				if(result[0].compareTo("top") == 0) {
					obj.front();
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
					obj.enQueue(result[1]);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.deQueue();
				}
				if(result[0].compareTo("top") == 0) {
					obj.front();
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