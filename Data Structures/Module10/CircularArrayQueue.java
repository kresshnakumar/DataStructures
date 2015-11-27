import java.util.*;
interface QueueADT<E> {
	public void enQueue(E element);
	public void deQueue();
	public void front();
	public void isEmpty();
}
class MyArrayADT<E> implements QueueADT<E> {
	E[] arrayADT;
	int front;
	int size;
	int rear;
	public MyArrayADT() {
		size = 10;
		arrayADT = (E[])new Object[10];
		front = 0;
		rear = 0;
	}
	public int size() {
		return ((rear - front + size + 1) % (size + 1));
	}
	public void enQueue(E element) {
		if(size() >= size) {
			System.out.println("Queue is Full");
			return;
		}
		else {
			arrayADT[rear] = element;
			rear = (rear + 1) % size;
		}
	}
	public void deQueue() {
		if(front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			front = (front + 1) % size;
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
	public void printQueue() {
		int i;
		for(i = front; ;) {
			if(i == rear-1) {
				break;
			}
			System.out.print(arrayADT[i]+ "->");
			i = (i+1)%size;
		}
		System.out.println(arrayADT[i]);
	}
}
public class CircularArrayQueue {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char char1 = str.charAt(0);
		if(char1 == 'I') {
			MyArrayADT<Integer> obj = new MyArrayADT<Integer>();
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
				if(result[0].compareTo("front") == 0) {
					obj.front();
				}
				if(result[0].compareTo("isEmpty") == 0) {
					obj.isEmpty();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
				if(result[0].compareTo("print") == 0) {
					obj.printQueue();
				}
			}while(flag == 1);
		}
		else if(char1 =='C') {
			MyArrayADT<Character> obj = new MyArrayADT<Character>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					char ch = result[1].charAt(0);
					obj.enQueue(ch);
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
		else if(char1 =='S') {
			MyArrayADT<String> obj = new MyArrayADT<String>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					obj.enQueue(result[1]);
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
		else if(char1 =='F') {
			MyArrayADT<Float> obj = new MyArrayADT<Float>();
			int flag = 1;
			do {
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
	}
}

