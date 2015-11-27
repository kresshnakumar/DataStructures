import java.util.*;
class BinaryTreeNode {
	BinaryTreeNode left;
	BinaryTreeNode right;
	int height;
	int data;
	public BinaryTreeNode(BinaryTreeNode left,int data,BinaryTreeNode right) {
		height = 0;
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
	public void search(int eleSearch) {
		MyArrayADT q = new MyArrayADT();
		int largest = 0;
		int count = 0;
		BinaryTreeNode flag;
		if(root == null) {
			System.out.println("false,0");
			return;
		}
		q.enQueue(root);
		while(!q.isEmpty()) {
			count++;
			flag = q.deQueue();
			if(eleSearch < flag.getData()) {
				largest = flag.getData();
				if(flag.getLeft() != null) {
					q.enQueue(flag.getLeft());
				}
				else {
					System.out.println("false,"+largest);
					q.makeEmpty();
					return;
				}
			}
			else if(eleSearch > flag.getData()) {
				if(flag.getRight() != null) {
					q.enQueue(flag.getRight());
				}
				else {
					System.out.println("false,"+largest);
					q.makeEmpty();
					return;
				}
			}
			else {
				System.out.println("true,"+count);
			}
		}
		q.makeEmpty();
	}
	public void remove(int element) {
		root = removeElement(root,element);
	}
	public BinaryTreeNode removeElement(BinaryTreeNode root2,int element) {
		if(root2 == null) {

		}
		else if(element < root2.getData()) {
			root2.setLeft(removeElement(root2.getLeft(),element));
		}
		else if(element > root2.getData()) {
			root2.setRight(removeElement(root2.getRight(),element));
		}
		else {
			BinaryTreeNode temp;
			if(root2.getLeft() == null && root2.getRight() == null) {
				root2 = null;
			}
			else if(root2.getLeft() != null && root2.getRight() != null) {
				temp = getMax(root2.getLeft());
				root2.setData(temp.getData());
				root2.setLeft(removeElement(root2.getLeft(),root2.getData()));
			}
			else {
				temp = root2;
				if(root2.getLeft() == null) {
					root2 = root2.getRight();
				}
				if(root2.getRight() == null ) {
					temp = getMax(root2.getLeft());
					if(temp != null) {
						root2.setData(temp.getData());
						root2.setLeft(removeElement(root2.getLeft(),root2.getData()));
					}
				}
			}
		}
		return root2;
	}
	public BinaryTreeNode getMax(BinaryTreeNode root3) {
		if(root3 == null) {
			return null;
		}
		else {
			while(root3.getRight() != null) {
				root3 = root3.getRight();
			}
			return root3;
		}
	}
	public BinaryTreeNode singleRotationLeft(BinaryTreeNode root5) {
		BinaryTreeNode temp5 = root5.getLeft();
		root5.setLeft(temp5.getRight());
		temp5.setRight(root5);
		root5.height = max(FindHeight(root5.getLeft()),FindHeight(root5.getRight())) + 1;
		temp5.height = max(FindHeight(temp5.getLeft()),FindHeight(temp5.getRight())) + 1;
		return temp5;	
	}
	public BinaryTreeNode singleRotationRight(BinaryTreeNode root5) {
		BinaryTreeNode temp5 = root5.getRight();
		root5.setRight(temp5.getLeft());
		temp5.setLeft(root5);
		root5.height = max(FindHeight(root5.getLeft()),FindHeight(root5.getRight())) + 1;
		temp5.height = max(FindHeight(temp5.getLeft()),FindHeight(temp5.getRight())) + 1;
		return temp5;
	}
	public void isBalanced() {
		if((FindHeight(root.getRight()) - FindHeight(root.getLeft())) >= 2 || (FindHeight(root.getRight()) - FindHeight(root.getLeft())) <= -2) {
			System.out.println("Tree is not Balanced");
		}
		else {
			System.out.println("Tree is Balanced");
		}
	}
	public int max(int a, int b) {
		if(a < b) {
			return b;
		}
		else {
			return b;
		}
	}
	public int FindHeight(BinaryTreeNode root3) {
		if(root3 == null) {
			return 0;
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
	public void printBinarySearchTreeInorder() {
		printInorder(root);
		System.out.println();
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
	public void printInorder(BinaryTreeNode temp3) {
		if(temp3 != null) {
			printInorder(temp3.getLeft());
			System.out.print(temp3.getData() + ",");
			printInorder(temp3.getRight());
		}
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
public class Prob2 {
	public static void main(String[] args) {
		BinaryTreeArrayList object = new BinaryTreeArrayList();
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		String[] str = string.split(",");
		int i = 0;
		while(i < str.length) {
			String[] temp = str[i].split(" ");
			if(temp[0].compareTo("I") == 0) {
				object.insert(Integer.parseInt(temp[1]));
				object.printBinarySearchTreeInorder();
			}
			else if(temp[0].compareTo("S") == 0) {
				object.search(Integer.parseInt(temp[1]));
			}
			else if(temp[0].compareTo("R") == 0) {
				object.remove(Integer.parseInt(temp[1]));
				object.printBinarySearchTreePostorder();
			}
			else if(temp[0].compareTo("end") == 0) {
				break;
			}
			i++;
		}
		object.isBalanced();
	}
}