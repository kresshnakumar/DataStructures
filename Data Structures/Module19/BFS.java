import java.util.*;
class MyArrayADT {
	int top;
	int size;
	int front;
	int rear;
	public MyArrayADT() {
		front = null;
		rear = null;
		size = 10;
		top = -1;
	}
	public void enQueue(int element) {
		Node node = new Node(element,null);
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
			return null;
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
class BFSImplement {
	Node root;
	MyArrayADT q;
	public BFSImplement() {
		root = null;
		q = MyArrayADT();
	}
	public void insert(int value) {
		if(root == null) {
			root.setData(value);
		}
		else {
			q.enQueue(root);
			while(!q.isEmpty()) {
				Node flag = q..deQueue();
			}
		}
	}
}
public class BFS {
	public static void main(String[] krishna) {
		Scanner input = new Scanner(System.in);
		int noOFVertices = Integer.parseInt(input.nextLine());
		int[][] array = new int[noOFVertices][noOFVertices];
		int type = Integer.parseInt(input.nextLine());
		int l = 0;
		BSTImplement bt = new BSTImplement(noOFVertices);
		if(type == 0) {
			while(l < noOFVertices) {
				String string = input.nextLine();
				String[] str = string.split("->");
				int root = Integer.parseInt(str[0]);
				for(int i = 0;i< str.length;i++) {
					bt.insert(root,Integer.parseInt(str[i]));
				}
				l++;
			}
		}
		if( type == 1) {
			for(int i = 0; i < noOFVertices; i++) {
				String string = input.nextLine();
				String[] str = string.split(" ");
				for(int j = 0 ; j < str.length ; j++) {
					array[i][j] = Integer.parseInt(str[j]);
				}
			}
		}
		bt.print();
	}
}