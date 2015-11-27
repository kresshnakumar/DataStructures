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
	public BTarrayList(){
		root = null;
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
  		printLevelorder(root);
 	} 
 	public void reverse() {
 		BTreeNode temp5 = root.getLeft();
 		root.setLeft(root.getRight());
 		root.setRight(temp5);
 	}
 	public void printLevelorder(BTreeNode root3) {
 		MyArrayADT q = new MyArrayADT();
	    ArrayList<String> current = new ArrayList<String>();
	    BTreeNode flag;
	    if(root3 == null){
	    	System.out.println("null");
	    	return ;
	    }
	    q.enQueue(root3);
	    q.enQueue(null);
	    while(!q.isEmpty()) {
	    	flag = q.deQueue();
	    	if(flag != null) {
	    		current.add(flag.getData());
    			if(flag.getLeft() != null)
    				if(flag.getLeft().getData().compareTo("#") != 0) {
	    				q.enQueue(flag.getLeft());
    				}
	       		if(flag.getRight() != null) {
	       			if(flag.getRight().getData().compareTo("#") != 0) {
	    				q.enQueue(flag.getRight());
    				}
	       		}
	    	}
	     	else {
		       	if(current.size() > 0){
		       		System.out.println(current);
		       	}
		      	current.clear();
		       	if(!q.isEmpty()) {
		       		q.enQueue(null);
		       	}
		    }
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
public class BinaryTree {
	public static void main(String[] args) {
		BTarrayList object = new BTarrayList();
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		// String[] string = str.split(" ");
		int j = 0;
		StringTokenizer st = new StringTokenizer(string,"[,] ");
		String[] str = new String[30];
		while(st.hasMoreTokens()) {
			str[j] = st.nextToken();
			//System.out.println(str[j]);
			j++;
		}
		int i = 0;
		while(i < j) {
			object.insert(str[i]);
			i++;
		}
		object.reverse();
		object.printBTree();

	}
}