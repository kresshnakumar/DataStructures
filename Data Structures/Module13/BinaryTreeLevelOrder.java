import java.util.*;
class BTreeNode {
	BTreeNode left;
	BTreeNode right;
	int data;
	public BTreeNode(BTreeNode left,int data,BTreeNode right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
	public void setLeft(BTreeNode left) {
		this.left = left;
	}
	public BTreeNode getLeft() {
		return left;
	}
	public void setRight(BTreeNode right) {
		this.right = right;
	}
	public BTreeNode getRight() {
		return right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
}
class BTarrayList {
	BTreeNode root;
	public BTarrayList(){
		root = null;
	}
	public void insert(int value) {
		MyArrayADT q = new MyArrayADT();
		BTreeNode node = new BTreeNode(null,value,null);
		BTreeNode flag;
		if(root == null) {
			root = node;
			return;
		}
		q.enQueue(root);
		while(!q.isEmpty()) {

			flag = q.deQueue();
			if(flag.getLeft() != null) {
				q.enQueue(flag.getLeft());
			}
			else {
				flag.setLeft(node);
				q.makeEmpty();
				return;
			}
			if(flag.getRight() != null) {
				q.enQueue(flag.getRight());
			}
			else {
				flag.setRight(node);
				q.makeEmpty();
				return;
			}
		}
		q.makeEmpty();
	}
	public void printLevelorder(BTreeNode root2) {
		MyArrayADT q = new MyArrayADT();
		BTreeNode flag;
		if(root2 == null) {
			System.out.println("list is Empty");
			return;
		}
		q.enQueue(root);
		System.out.print(root.getData() + " ");
		while(!q.isEmpty()) {
			flag = q.deQueue();
			if(flag.getLeft() != null) {
				q.enQueue(flag.getLeft());
				System.out.print(flag.getLeft().getData() + " ");
			}
			else {
				return;
			}
			if(flag.getRight() != null) {
				q.enQueue(flag.getRight());
				System.out.print(flag.getRight().getData() + " ");
			}
			else {
				return;
			}
		}
		q.makeEmpty();
	}
	public void printPreorder(BTreeNode temp3) {
		if(temp3 != null) {
			System.out.print(temp3.getData() + " ");
			printPreorder(temp3.getLeft());
			printPreorder(temp3.getRight());
		}
	}
	public void printInorder(BTreeNode temp3) {
		if(temp3 != null) {
			printInorder(temp3.getLeft());
			System.out.print(temp3.getData() + " ");
			printInorder(temp3.getRight());
		}
	}
	public void printPostorder(BTreeNode temp3) {
		if(temp3 != null) {
			printPostorder(temp3.getLeft());
			printPostorder(temp3.getRight());
			System.out.print(temp3.getData() + " ");
		}
	}
	public void printBTree() {
		System.out.print("Inorder : ");
		printInorder(root);
		System.out.print("\nPreorder : ");
		printPreorder(root);
		System.out.print("\nPostorder : ");
		printPostorder(root);
		System.out.print("\nLevelorder : ");
		printLevelorder(root);
	}
}
class Node {
	private BTreeNode data;
	private Node address;
	public Node(BTreeNode data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(BTreeNode data) {
		this.data = data;
	}
	public BTreeNode getData() {
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
	public void enQueue(BTreeNode element) {
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
	public BTreeNode deQueue() {
		Node temp = front;
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
public class BinaryTreeLevelOrder {
	public static void main(String[] args) {
		BTarrayList object = new BTarrayList();
		object.insert(10);
		object.insert(20);
		object.insert(30);
		object.insert(40);
		object.insert(50);
		object.printBTree();

	}
}
