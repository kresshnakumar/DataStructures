import java.util.*;
class Node {
	private int data;
	private Node address;
	public Node(int data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
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
	public int deQueue() {
		int temp = 0;
		if(top == -1 ) {
			System.out.println("Queue is Empty");
		}
		else {
			if(size == 1) {
				temp = front.getData();
				front = null;
				size--;
				top--;
				rear = null;
			}
			else {
				 //System.out.println("size:" + size);
					temp = front.getData();
					front = front.getAddress();
					size--;
					top--;
			}
		}
		return temp;
	}
	public int front() {
		if(top == -1) {
			//System.out.println("Queue is empty");
			return 0;
		}
		else {
			//System.out.println(front.getData());
			return front.getData();
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
class Vertex {
	public int label;
	public boolean visited;
	public Vertex(int lab) {
		label = lab;
		visited = false;
	}
}
class BFSGraph {
	private MyArrayADT theQ;
	private int vertexCount;
	private int adjMatrix[][];
	private Vertex vertexList[];
	private int maxVertices;
	int[] parent;
	public BFSGraph(int b) {
		maxVertices = b;
		parent = new int[b];
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		vertexCount = 0;
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j < maxVertices;j++) {
				adjMatrix[i][j] = 0;
			}
		}
		theQ = new MyArrayADT();
	}
	public void addVertex(int lab) {
		vertexList[vertexCount++] = new Vertex(lab);
	}
	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		//adjMatrix[end][start] = 1;
	}
	public void printVertex(int k) {
		System.out.print(vertexList[k].label + " ");
	}
	public void printParent() {
		for(int h=0;h< maxVertices; h++) {
			System.out.print("\nparent of "+(h+1)+" is : "+parent[h]);
		}
	}
	public void bfs() {
		vertexList[0].visited = true;
		theQ.enQueue(0);
		printVertex(0);
		int v2;
		while(!theQ.isEmpty()) {
			int v1 = theQ.deQueue();
			while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].visited = true;
				parent[v2] = v1+1;
				theQ.enQueue(v2);
				printVertex(v2);
			}
		}
	}
	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < vertexCount; j++) {
			if(adjMatrix[v][j] == 1 && vertexList[j].visited == false ) {
				return j;
			}
		}
		return -1;
	}
}
public class BFSNew {
	public static void main(String[] krishna) {
		Scanner input = new Scanner(System.in);
		int noOFVertices = Integer.parseInt(input.nextLine());
		int[][] array = new int[noOFVertices][noOFVertices];
		int type = Integer.parseInt(input.nextLine());
		int l = 0;
		BFSGraph bt = new BFSGraph(noOFVertices);
		for(int x=0;x < noOFVertices ; x++) {
			bt.addVertex(x+1);
		}
		if(type == 0) {
			while(l < noOFVertices) {
				String string = input.nextLine();
				String[] str = string.split("->");
				int root = Integer.parseInt(str[0]);
				for(int i = 1;i< str.length;i++) {
					bt.addEdge(root-1,Integer.parseInt(str[i])-1);
				}
				l++;
			}
		}
		if( type == 1) {
			for(int i = 0; i < noOFVertices; i++) {
				String string = input.nextLine();
				String[] str = string.split(" ");
				//int root = Integer.parseInt(str[0]);
				for(int j = 0 ; j < str.length ; j++) {
					if(Integer.parseInt(str[j]) == 1) {
						bt.addEdge(i,j);
					}
				}
			}
		}
		bt.bfs();
		bt.printParent();
	}
}