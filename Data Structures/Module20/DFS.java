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
	Node start;
	Node end;
	public MyArrayADT() {
		start = null;
		end = null;
		size = 0;
		top = -1;
	}
	public void push(int element) {
		if(top < size) {
			Node node = new Node(element,null);
			if(start == null) {
				start = node;
				end = start;
				top++;
				size++;
			}
			else {
				end.setAddress(node);
				end = node;
				top++;
				size++;
			}
		}
		else {
			System.out.println("Stack OverFlow");
		}
	}
	public int pop() {
		int temp = 0;
		if(top == -1) {
			System.out.println("Stack UnderFlow");
		}
		else {
			Node prev = start;
			Node current = start.getAddress();
			if(start == end) {
				temp = start.getData(); 
				start = null;
				size--;
			}
			else if(current.getAddress() == null) {
				temp = current.getData();
				start.setAddress(null);
				current = null;
				end = start;
				size--;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
				}
				temp = current.getData();
				prev.setAddress(null);
				current = null;
				end = prev;
				size--;
			}
			top--;
		}
		return temp;
	}
	public int top() {
		if(top == -1) {
			//System.out.println("Stack is empty");
			return 0;
		}
		else {
			//System.out.println(end.getData());
			return end.getData();
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
	private MyArrayADT theStack;
	private int vertexCount;
	private int adjMatrix[][];
	private Vertex vertexList[];
	private int maxVertices;
	int[] parent;
	public BFSGraph(int b) {
		maxVertices = b;
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		parent = new int[maxVertices];
		vertexCount = 0;
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j < maxVertices;j++) {
				adjMatrix[i][j] = 0;
			}
		}
		theStack = new MyArrayADT();
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
		theStack.push(0);
		printVertex(0);
		int v2;
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.top());
			if(v == -1) {
				theStack.pop();
			}
			else {
				vertexList[v].visited = true;
				printVertex(v);
				parent[v] = theStack.top()+1; 
				theStack.push(v);
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
public class DFS {
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
		//System.out.println("parent");
		bt.printParent();
		//bt.print();
	}
}