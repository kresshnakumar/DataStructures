import java.util.*;
interface myLinkedList {
	public void insertElement(int element);
	public void insertElementAfterElement(int afterElement, int newElement);
	public void insertElementBeforeElement(int prevElement, int newElement);
	public void removeElementAtIndex(int index);
	public void removeElement(int element);
	public void popFront();
	public void popBack();
	public void pushFront(int element);
	public void pushBack(int element);
	public void concat(MyLList obj2);
	public void concatAtIndex(int indexx , MyLList obj2);
}
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

class MyLList implements myLinkedList {
	Node start;
	Node end;
	int size;
	public MyLList() {
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

	public void insertElementAfterElement(int afterElement, int newElement){
		Node node = new Node(newElement,null);
		if(start == null) {
			System.out.println("List is empty");
		}
		else if(start.getData() == afterElement) {
			node.setAddress(start.getAddress());
			start.setAddress(node);
			if(size == 1) {
				end = node;
			}
			size++;
		}
		else {
			int count = 0;
			Node current = start.getAddress();
			if(current.getData() == (afterElement)) {
					node.setAddress(current.getAddress());
					current.setAddress(node);
					end = node;
					count++;
					size++;
			}
			else {
				while(current.getAddress() != null) {
					current = current.getAddress();
					if(current.getData() == (afterElement)) {
						node.setAddress(current.getAddress());
						current.setAddress(node);
						count++;
						size++;
						break;
					}
					end = current;
				}
				// if(count == 0) {
				// 	System.out.println("Element Not Found");
				// }
			}
		}
	}

	public void removeElement(int element){
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData() == (element)) {
			start = start.getAddress();
			size--;
		}
		else {
			int count = 0;
			Node prev = start;
			Node current = start.getAddress();
			if(current.getData() == (element)) {
					prev.setAddress(current.getAddress());
					current = null;
					count++;
					size--;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
					if(current.getData() == (element)) {
						prev.setAddress(current.getAddress());
						size--;
						count++;
						break;
					}
				}
				if(count == 0 ) {
					System.out.println("Element Not Found");
				}
			}
		}
	}

	public void insertElementBeforeElement(int prevElement, int newElement){
		Node node = new Node(newElement,null);
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData() == (prevElement)) {
			node.setAddress(start);
			start = node;
			size++;
		}
		else {
			int count = 0;
			Node prev = start;
			Node current = start.getAddress();
			if(current.getData() == (prevElement)) {
					node.setAddress(current);
					prev.setAddress(node);
					count++;
					size++;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
					if(current.getData() == (prevElement)) {
						node.setAddress(current);
						prev.setAddress(node);
						count++;
						size++;
						break;
					}
					end = current;
					prev = current;
				}
				if(count == 0 ) {
					System.out.println("Element Not Found");
				}
			}
		}
	}

	public void pushBack(int element) {
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

	public void pushFront(int element){
		Node node = new Node(element,null);
		if(start == null) {
			start = node;
			end = start;
			size++;
		}
		else {
			node.setAddress(start);
			start = node;
			size++;
		}
	}

		public void popFront() {
			Node next = start.getAddress();
			start = null;
			start = next;
			size--;
		}
		
		public void popBack() {
			Node prev = start;
			Node current = start.getAddress();
			if(start == end) {
				start = null;
				size--;
			}
			else if(current.getAddress() == null) {
				start.setAddress(null);
				current = null;
				end = start;
				size--;
			}
			else {
				while(current.getAddress() != null) {
					//System.out.println("hello..");
					prev = current;
					current = current.getAddress();
				}
				prev.setAddress(null);
				current = null;
				end = prev;
				size--;
			}
		}

	public void removeElementAtIndex(int index) {
		if(size == 0) {
			System.out.println("List is Empty");
		}
		if(index == 0) {
			popFront();
		}
		else if(index == (size - 1)) {
			popBack();
		}
		else {
			Node prev = start;
			Node current = start.getAddress();
			if(index < size) {
				int count = 1;
				while(count < index) {
					prev = current;
					current = current.getAddress();
					count++;
				}
				prev.setAddress(current.getAddress());
				current = null;
				size--;
			}
		}
	}

	public void concat(MyLList obj2) {
		Node list2 = obj2.start;
		if(start == null) {
			start = list2;
			while(list2.getAddress() != null) {
				list2 = list2.getAddress();
			}
			end = list2;
			size = obj2.size + size;
		}
		else {
			end.setAddress(list2);
			while(list2.getAddress() != null) {
				list2 = list2.getAddress();
			}
			end = list2;
			size = obj2.size + size;
		}
	}

	public void concatAtIndex(int indexx , MyLList obj2) {
		Node list2 = obj2.start;
		Node temp = obj2.start;
		System.out.println("concat index: " + indexx);
		if(indexx == 0) {
			Node list1next = start.getAddress();
			while(temp.getAddress() != null) {
				temp = temp.getAddress();
			}
			temp.setAddress(start.getAddress());
			start.setAddress(list2);
			size += obj2.size;
		}
		else if(indexx == (size-1)) {
			System.out.println("----------");
			concat(obj2);
		}
		else {
			if(indexx < size) {
				Node prev = start;
				Node current = start.getAddress();
				int count = 1;
				while(count < indexx) {
					prev = current;
					current = current.getAddress();
					count++;
				}
				while(temp.getAddress() != null) {
					temp = temp.getAddress();
				}
				temp.setAddress(current.getAddress());
				prev.setAddress(list2);
				size += obj2.size;
			}
		}
	}
	public void method(int value) {
		int val = 4;
		int count1 = 0;

		while(true) {
			Node node = start.getAddress();
			if(node.getData() == val) {
				continue;
			}
			else {
				insertElementAfterElement(val-2, val);
			}
			node = node.getAddress();
			val = val +2;
			count1++;
			if(count1 == 10) {
				break;
			}
		}
	}

	public void printLinkList() {
		if(start == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(start.getData());
			Node current = start;
			while(current.getData() != 20) {
				current = current.getAddress();
				System.out.print("," + current.getData());
			}
			System.out.println();
		}
		//System.out.println("size: "+size);
	}
}
public class LinkedList {
	public static void main(String[] args) {
		MyLList obj = new MyLList();
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		Scanner input1 = new Scanner(System.in);
		String str = input1.nextLine();
		String[] result = str.split(",");
		int arraysize = result.length;
		int i = 0;
		while(i < arraysize) {
			obj.pushBack(Integer.parseInt(result[i]));
			i++;
		}
		obj.method(value);
		obj.printLinkList();
	}
}