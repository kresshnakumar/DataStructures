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
	public MyLList() {
		myLLArray = new int[30];
		start = null;
		end = null;
		size = 0;
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

	public void rev(Node root) {
		Node temp1;
		Node tempPrev = null;
		temp1 = start;
		if(start.getData() == root.getData()) {
			temp1.setAddress(null);
			return;
		}
		while(temp1.getData() != root.getData()) {
			tempPrev = temp1;
			temp1 = temp1.getAddress();
		}
		temp1.setAddress(tempPrev);
		rev(tempPrev);
	}

	public void reverse() {
		rev(end);
	}
	public boolean isEmpty() {
		if(start == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void printAtIndex(int k) {
		int j = 0;
		if(k < 0) {
			System.out.println("List is empty");
		}
		else {
			Node current = end;
			while(current.getAddress() != null) {
				if(j == k) {
					System.out.print(current.getData());
				}
				current = current.getAddress();
				j++;
			}
			if(j == k) {
				System.out.print(current.getData());
			}
		}
	}
	public void printLinkList() {
		if(end == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(end.getData());
			Node current = end;
			while(current.getAddress() != null) {
				current = current.getAddress();
				System.out.print("," + current.getData());
			}
			System.out.println();
		}
	}
}
public class ReverseeSingleLinkedList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MyLList obj = new MyLList();
		int noOfElements = input.nextInt();
		input = new Scanner(System.in);
		String str = input.nextLine();
		input = new Scanner(System.in);
		int index = input.nextInt();
		String[] string = str.split(",");
		int i = 0;
		while(i < string.length) {
			obj.insertElement(Integer.parseInt(string[i]));
			i++;
		}
		obj.reverse();
		obj.printLinkList();
		obj.printAtIndex(index);
	}
}