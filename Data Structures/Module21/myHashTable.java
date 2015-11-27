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
class BinaryTreeArrayList {
	BinaryTreeNode root;
	ArrayList<Integer> array = new ArrayList<Integer>();
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
	public ArrayList<Integer> printBinarySearchTreePreorder() {
		return printPreorder(root);
	}
	public ArrayList<Integer> printPreorder(BinaryTreeNode temp3) {
		if(temp3 != null) {
			array.add(temp3.getData());
			printPreorder(temp3.getLeft());
			//System.out.print(temp3.getData() + ",");
			printPreorder(temp3.getRight());
		}
		return array;
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
class hashNode {
	private String word;
	private int frequency;
	public hashNode(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWord() {
		return word;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getFrequeny() {
		return frequency;
	}
}
class hashTableOperations {
	BinaryTreeArrayList bst;
	int size;
	String[] key;
	int[] freq;
	public hashTableOperations() {
		bst = new BinaryTreeArrayList();
		size = 100;
		key = new String[size];
		freq = new int[size];
	}
	public void insertIntoHashTable(String iKey) {
		int genKey = generateKey(iKey);
		if(contains(iKey)) {
			//key[genKey] = iKey;
			freq[genKey] = freq[genKey] + 1;
		}
		else {
			key[genKey] = iKey;
			//bst.insert(genKey);
			freq[genKey] = 1;
		}
	}
	public boolean contains(String temp) {
		for(int h = 0; h < size ; h++) {
			//System.out.println(key[h] +"--" + temp);
			if(key[h] != null) {
				if(key[h].equals(temp)) {
					return true;
				}
			}
		}
		return false;
	}
	public int generateKey(String string) {
		int sum = 0;
		for(int z = 0; z < string.length() ; z++) {
			sum = sum + (int)(string.charAt(z));
		}
		//System.out.println("sum: "+ (sum % size));
		return (sum % size);
	}
	public void print() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array = bst.printBinarySearchTreePreorder();
		for(int y = 0; y < array.size(); y++) {
			System.out.println(key[array.get(y)] + "->" + freq[array.get(y)]);
		}
	}
}
public class myHashTableNew {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// int size = Integer.parseInt(input.nextLine());
		hashTableOperations hash = new hashTableOperations();
		String str = input.nextLine();
		String s[] = str.split(" ");
		int q= 0;
		while(q < s.length) {
			hash.insertIntoHashTable(s[q]);
			q++;
		}
		hash.print();
	}
}