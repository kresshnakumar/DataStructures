import java.util.*;
class Node {
	private char data;
	private Node address;
	public Node(char data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(char data) {
		this.data = data;
	}
	public char getData() {
		return data;
	}
	public void setAddress(Node address) {
		this.address = address;
	}
	public Node getAddress() {
		return address;	
	}
}
class MyLList {
	Node start;
	Node end;
	int size;
	public MyLList() {
		start = null;
		end = null;
		size = 0;
	}
	public void insertElement(char element) {
		Node node = new Node(element,null);
		if(start == null) {
			start = node;
			end = start;
			size++;
		}
		else {
			end.setAddress(node);
			end = node;
			size++;
		}
	}
	public void printLinkList() {
		if(start == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(start.getData());
			Node current = start;
			while(current.getAddress() != null) {
				current = current.getAddress();
				System.out.print("->" + current.getData());
			}
			System.out.println("->null");
		};
	}
}
class GraphMatrix {
	int[][] matrix;
	int size;
	public GraphMatrix(int size) {
		this.size = size;
		matrix = new int[size+1][size+1];
	}
	public void addElements(int i,int j) {
		if(i >= 1 && i <= size && j >= 1 && j <= size) {
			matrix[i][j] = 1;
		}
	}
	public void printMatrix() {
		int l = 97;
		for(int i = 0; i <= size; i++) {
			int k = 97;
			for(int j = 0 ; j <= size ; j++) {
				if(i == 0 && j == 0) {
					System.out.print(" ");
				}
				else if(i == 0 && j > 0) {
					System.out.print(" " +(char)k);
					k++;
				}
				else if(j == 0 && i > 0) {
					System.out.print((char)l + " ");
					l++;
				}
				else {
					System.out.print(matrix[i][j]+ " ");
				}
			}
			k = 97;
			System.out.println();
		}
	}
	public void printList() {
		int l = 97;
		int k = 97;
		for(int i = 1; i <= size; i++) {
			MyLList list = new MyLList();
			list.insertElement((char)k);
			k++;
			for(int j = 1 ; j <= size ; j++) {
				if(matrix[i][j] == 1) {
					list.insertElement((char)l);
				}
				l++;
			}
			l = 97;
			list.printLinkList();
		}
	}
}
public class Graphs_1 {
	public static void main(String[] args) {
		ArrayList<Character> ary = new ArrayList<Character>();
		Scanner input = new Scanner(System.in);
		int size = Integer.parseInt(input.nextLine());
		GraphMatrix gm = new GraphMatrix(size);
		int k = 97;
		for(int i = 0; i < size ; i++) {
			ary.add((char)k);
			k++;
		}
		String string = input.nextLine();
		string.trim();
		String[] str = new String[30];
		int j = 0;
		StringTokenizer st = new StringTokenizer(string,"(,) ");
		while(st.hasMoreTokens()) {
			str[j] = st.nextToken();
			j++;
		}
		int  i = 0;
		while(i < str.length) {
			if(str[i] != null && str[i+1] != null) {
				gm.addElements(ary.indexOf(str[i].charAt(0))+1,ary.indexOf(str[i+1].charAt(0))+1);
				i = i+2;
			}
			else {
				break;
			}
		}
		gm.printMatrix();
		gm.printList();
	}
}