import java.util.*;
class BinaryTreeNode {
	BinaryTreeNode left;
	BinaryTreeNode right;
	int data;
	public BinaryTreeNode(BinaryTreeNode left,int data,BinaryTreeNode right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
}
class Node {
	private BinaryTreeNode data;
	private Node address;
	public Node(BinaryTreeNode data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(BinaryTreeNode data) {
		this.data = data;
	}
	public BinaryTreeNode getData() {
		return data;
	}
	public void setAddress(Node address) {
		this.address = address;
	}
	public Node getAddress() {
		return address;	
	}
}

class MyArrayADT {
	int top;
	int size;
	Node front;
	Node rear;
	public MyArrayADT() {
		front = null;
		rear = null;
		size = 0;
		top = -1;
	}
	public void makeEmpty() {
		front = rear = null;
		top = -1;
	}
	public void enQueue(BinaryTreeNode element) {
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
	public BinaryTreeNode deQueue() {
		Node temp = front;
		if(top == -1) {
			System.out.println("Queue is Empty");
		}
		else {
			if(front.getAddress() == null) {
				front = null;
				size--;
				top = -1;
				rear = null;
			}
			else {
				front = front.getAddress();
				size--;
			}
		}
		return temp.getData();
	}
	public void front() {
		if(top == -1) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println(front.getData());
		}
	}
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
}
class BinaryTreeArrayList {
	BinaryTreeNode root;
	public BinaryTreeArrayList(){
		root = null;
	}
	public void insert(int value) {
		MyArrayADT q = new MyArrayADT();
		BinaryTreeNode node = new BinaryTreeNode(null,value,null);
		BinaryTreeNode flag;
		if(root == null) {
			root = node;
			return;
		}
		q.enQueue(root);
		while(!q.isEmpty()) {
			flag = q.deQueue();
			if(node.getData() <= flag.getData()) {
				if(flag.getLeft() != null) {
					q.enQueue(flag.getLeft());
				}
				else {
					flag.setLeft(node);
					q.makeEmpty();
					return;
				}
			}
			else if(node.getData() > flag.getData()) {
				if(flag.getRight() != null) {
					q.enQueue(flag.getRight());
				}
				else {
					flag.setRight(node);
					q.makeEmpty();
					return;
				}
			}
		}
		q.makeEmpty();
	}
	public void printBinarySearchTreePostorder() {
		if(root == null) {
			System.out.println("0");
		}
		else {
			printPostorder(root);
			System.out.println();	
		}
	}
	public void printPostorder(BinaryTreeNode temp3) {
		if(temp3 != null) {
			printPostorder(temp3.getLeft());
			printPostorder(temp3.getRight());
			System.out.print(temp3.getData() + ",");
		}
	}
}
public class BalancedBinarySearchTree {
	public static void main(String[] arg) {
		BinaryTreeArrayList object = new BinaryTreeArrayList();
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		String[] str = string.split(" ");
		int i = 0;
		int[] arr = new int[str.length];
		while(i < str.length) {
			arr[i] = Integer.parseInt(str[i]);
			i++;
		}
		
		object.printBinarySearchTreePostorder();
	}
}