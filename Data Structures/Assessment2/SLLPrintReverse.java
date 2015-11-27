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

@SuppressWarnings("unchecked")

class MyLList {
	int[] myLLArray;
	Node start;
	Node end;
	int size;
	int n;
	int w;
	int alpha;
	int beta;
	public MyLList() {
		w = 1;
		myLLArray = new int[10];
		start = null;
		end = null;
		size = 0;
		alpha = 4;
		beta = 2;
		n = size;
	}
	public void insertElement(int element) {
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

	public void reverse() {
		rev(start);
	}

	public void rev(Node temp) {
		if(temp == null) {
			return ;
		}
		else {
			rev(temp.getAddress());
			if(temp.getAddress() == null) {
				System.out.print(temp.getData());
			}
			else {
				System.out.print("," + temp.getData());
			}
		}
	}

	public void makeEmpty() {
		start = null;
		size = 0;
		end = null;
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
			System.out.println();
		}
	}
}
public class SLLPrintReverse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MyLList obj = new MyLList();
		int noOfElements = input.nextInt();
		input = new Scanner(System.in);
		String str = input.nextLine();
		str.trim();
		String[] string = str.split(",");
		int i = 0;
		while(i < string.length) {
			obj.insertElement(Integer.parseInt(string[i]));
			i++;
		}
		obj.reverse();
	}
}