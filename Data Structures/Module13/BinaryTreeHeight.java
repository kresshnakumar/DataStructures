import java.util.*;
class BTreeNode {
	BTreeNode left;
	BTreeNode right;
	String data;
	public BTreeNode(BTreeNode left,String data,BTreeNode right) {
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
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
}
class BTarrayList {
	BTreeNode root;
	int count;
	public BTarrayList(){
		root = null;
		count = -1;
	}
	public void insert(String value) {
		MyArrayADT q = new MyArrayADT();
		BTreeNode node = new BTreeNode(null,value,null);
		BTreeNode flag;
		if(root == null) {
			if(node.getData().compareTo("#") == 0) {
				return;
			}
			root = node;
			return;
		}
		q.enQueue(root);
	go:	while(!q.isEmpty()) {
			flag = q.deQueue();
		    if(flag.getLeft() != null) {
				q.enQueue(flag.getLeft());
			}
			else {
				if(flag.getData().compareTo("#") == 0) {
					//flag = q.deQueue();
					continue go;
				}
				else {
					flag.setLeft(node);
					q.makeEmpty();
					return;
				}
			}
			if(flag.getRight() != null) {
				q.enQueue(flag.getRight());
			}
			else {
				if(flag.getData().compareTo("#") == 0) {
					//flag = q.deQueue();
					break go;
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
	
	public void printBTree() {
		System.out.println(FindHeight(root));
		// FindHeight(root);
	}
	public int FindHeight(BTreeNode root3) {
		if(root3 == null) {
			return -1;
		}
		if(root3.getData().compareTo("#") == 0) {
			return -1;
		}
		int leftHeight = FindHeight(root3.getLeft());
		int rightHeight = FindHeight(root3.getRight());
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
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
				top--;
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
public class BinaryTreeHeight {
	public static void main(String[] args) {
		BTarrayList object = new BTarrayList();
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		//String str = "1 2 # # # 4 5 6";
		String[] string = str.split(" ");
		int i = 0;
		while(i<string.length) {
			object.insert(string[i]);
			i++;
		}
		object.printBTree();
	}
}