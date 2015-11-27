import java.util.*;
interface myDLinkedList<E> {
	public void deQueue();
	public void enQueue(E element);
	public void printLinkList();
	public void isEmpty();
	public void front();
}
class Node<E> {
	private E data;
	private Node<E> next;
	private Node<E> prev;
	public Node(Node prev, E data, Node next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData() {
		return data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getPrev() {
		return prev;
	}
}

@SuppressWarnings("unchecked")

class MyDLList<E> implements myDLinkedList<E> {
	E[] myDLLArray;
	Node<E> head;
	Node<E> front;
	Node<E> rear;
	int size;
	public MyDLList() {
		myDLLArray = (E[])new Object[10];
		front = null;
		rear = null;
		head = new Node<E>(front,null,rear);
		size = 0;
	}

	public void isEmpty() {
		if(front == rear) {
			//return true;
			System.out.println("Queue is isEmpty");
		}
		else {
			//return false;
			System.out.println("Queue is notEmpty");
		}
	}
	public void front() {
		if(front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			System.out.println(arrayADT[front]);
		}
	}
	public void enQueue(E element) {
		Node<E> node = new Node<E>(null,element,null);
		head = node;
		if(front == null) {
			head.getNext();
			front = node;
			rear = front;
			size++;
		}
		else {
			rear.setNext(node);
			node.setPrev(rear);
			rear = node;
			size++;
		}
	}
	
	public void deQueue(){
		if(size == 0) {
			System.out.println("List is Empty");
		}
		else if(size == 1) {
			front = null;
			rear = front;
			size--;
		}
		else {
			Node<E> next = front.getNext();
			front = null;
			next.setPrev(null);
			front = next;
			size--;
		}
	}

	public void printLinkList() {
		if(front == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(front.getData());
			Node<E> current = front;
			while(current.getNext() != null) {
				current = current.getNext();
				System.out.print("->" + current.getData());
			}
			System.out.println();
		}
		//System.out.println("size: "+size);
	}
}
public class CicularDoublyLinkedListQueue {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			MyDLList<Integer> obj = new MyDLList<Integer>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					int value = Integer.parseInt(result[1]);
					obj.enQueue(value);
				}
				if(result[0].compareTo("pop") == 0) {
					obj.deQueue();
				}
				if(result[0].compareTo("print") == 0) {
					obj.printLinkList();
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