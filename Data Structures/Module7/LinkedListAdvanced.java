import java.util.*;
interface myLinkedList<E> {
	public void insertElement(E element);
	public void insertElementAfterElement(E afterElement, E newElement);
	public void insertElementBeforeElement(E prevElement, E newElement);
	public void removeElementAtIndex(int index);
	public void removeElement(E element);
	public void popFront();
	public void popBack();
	public void pushFront(E element);
	public void pushBack(E element);
	public void concat(MyLList<E> obj2);
	public void concatAtIndex(int indexx , MyLList<E> obj2);
	public void reverse();
	public void makeEmpty();
}
class Node<E> {
	private E data;
	private Node<E> address;
	public Node(E data, Node address) {
		this.data = data;
		this.address = address;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData() {
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

class MyLList<E> implements myLinkedList<E> {
	E[] myLLArray;
	Node<E> start;
	Node<E> end;
	int size;
	int n;
	int w;
	int alpha;
	int beta;
	public MyLList() {
		w = 1;
		myLLArray = (E[])new Object[10];
		start = null;
		end = null;
		size = 0;
		alpha = 4;
		beta = 2;
		n = size;
	}
	public void insertElement(E element) {
		Node<E> node = new Node<E>(element,null);
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

	public void insertElementAfterElement(E afterElement, E newElement){
		Node<E> node = new Node<E>(newElement,null);
		if(start == null) {
			System.out.println("List is empty");
		}
		else if(start.getData().equals(afterElement)) {
			node.setAddress(start.getAddress());
			start.setAddress(node);
			if(size == 1) {
				end = node;
			}
			size++;
		}
		else {
			int count = 0;
			Node<E> current = start.getAddress();
			if(current.getData().equals(afterElement)) {
					node.setAddress(current.getAddress());
					current.setAddress(node);
					if(node.getNext() == null) {
						end = node;
					}
					count++;
					size++;
			}
			else {
				while(current.getAddress() != null) {
					current = current.getAddress();
					if(current.getData().equals(afterElement)) {
						node.setAddress(current.getAddress());
						current.setAddress(node);
						count++;
						size++;
						break;
					}
					end = current;
				}
				if(count == 0) {
					System.out.println("Element Not Found");
				}
			}
		}
	}

	public void removeElement(E element){
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData().equals(element)) {
			start = start.getAddress();
			size--;
		}
		else {
			int count = 0;
			if(start.getAddress() == null) {
				System.out.println("Element Not Found");
				return;
			}
			Node<E> prev = start;
			Node<E> current = start.getAddress();
			if(current.getData().equals(element)) {
					prev.setAddress(current.getAddress());
					current = null;
					count++;
					size--;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
					if(current.getData().equals(element)) {
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

	public void insertElementBeforeElement(E prevElement, E newElement){
		Node<E> node = new Node<E>(newElement,null);
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData().equals(prevElement)) {
			node.setAddress(start);
			start = node;
			size++;
		}
		else {
			int count = 0;
			Node<E> prev = start;
			Node<E> current = start.getAddress();
			if(current.getData().equals(prevElement)) {
				node.setAddress(current);
				prev.setAddress(node);
				count++;
				size++;
			}
			else {
				while(current.getAddress() != null) {
					prev = current;
					current = current.getAddress();
					if(current.getData().equals(prevElement)) {
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

	public void pushBack(E element) {
		Node<E> node = new Node<E>(element,null);
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

	public void pushFront(E element){
		Node<E> node = new Node<E>(element,null);
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
		Node<E> next = start.getAddress();
		start = null;
		start = next;
		size--;
	}
		
	public void popBack() {
		if(size == 0) {
			System.out.println("List is Empty");
			return ;
		}
		Node<E> prev = start;
		Node<E> current = start.getAddress();
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
			return;
		}
		if(index >= size) {
			System.out.println("No Index Found");
			return;
		}
		if(index == 0) {
			popFront();
		}
		else if(index == (size - 1)) {
			popBack();
		}
		else {
			Node<E> prev = start;
			Node<E> current = start.getAddress();
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

	public void concat(MyLList<E> obj2) {
		Node<E> list2 = obj2.start;
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

	public void concatAtIndex(int indexx , MyLList<E> obj2) {
		Node<E> list2 = obj2.start;
		Node<E> temp = obj2.start;
		if(indexx == 0) {
			Node<E> list1next = start.getAddress();
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
				Node<E> prev = start;
				Node<E> current = start.getAddress();
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

	public void reverse() {
		rev(start);
		System.out.println();
	}

	public void rev(Node<E> temp) {
		if(temp == null) {
			return ;
		}
		else {
			rev(temp.getAddress());
			if(temp.getAddress() == null) {
				System.out.print(temp.getData());
			}
			else {
				System.out.print("->" + temp.getData());
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
			Node<E> current = start;
			while(current.getAddress() != null) {
				current = current.getAddress();
				System.out.print("->" + current.getData());
			}
			System.out.println();
		}
		//System.out.println("size: "+size);
	}
}
public class LinkedListAdvanced {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			MyLList<Integer> obj = new MyLList<Integer>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("insert") == 0) {
					int value = Integer.parseInt(result[1]);
					obj.insertElement(value);
				}
				if(result[0].compareTo("insertAfter") == 0) {
					obj.insertElementAfterElement(Integer.parseInt(result[1]),Integer.parseInt(result[2]));
				}
				if(result[0].compareTo("insertBefore") == 0) {
					obj.insertElementBeforeElement(Integer.parseInt(result[1]),Integer.parseInt(result[2]));
				}
				if(result[0].compareTo("removeIndex") == 0) {
					obj.removeElementAtIndex(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("removeElement") == 0) {
					obj.removeElement(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("popFront") == 0) {
					obj.popFront();
				}
				if(result[0].compareTo("popBack") == 0) {
					obj.popBack();
				}
				if(result[0].compareTo("pushFront") == 0) {
					obj.pushFront(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("pushBack") == 0) {
					obj.pushBack(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("reverse") == 0) {
					obj.reverse();
				}
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
				}
				if(result[0].compareTo("concat") == 0) {
					MyLList<Integer> obj2 = new MyLList<Integer>();
					obj2.insertElement(10);
					obj2.insertElement(11);
					obj2.insertElement(12);
					obj2.insertElement(13);
					obj2.insertElement(14);
				 	obj.concat(obj2);
				}
			  if(result[0].compareTo("concatIndex") == 0) {
			  	MyLList<Integer> obj2 = new MyLList<Integer>();
					obj2.insertElement(10);
					obj2.insertElement(11);
					obj2.insertElement(12);
					obj2.insertElement(13);
					obj2.insertElement(14);
				 	obj.concatAtIndex(Integer.parseInt(result[1]),obj2);
				}
				if(result[0].compareTo("print") == 0) {
					obj.printLinkList();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'C') {
			MyLList<Character> obj = new MyLList<Character>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("insert") == 0) {
					char ch = result[1].charAt(0);
					obj.insertElement(ch);
				}
				if(result[0].compareTo("insertAfter") == 0) {
					obj.insertElementAfterElement(result[1].charAt(0),result[2].charAt(0));
				}
				if(result[0].compareTo("insertBefore") == 0) {
					obj.insertElementBeforeElement(result[1].charAt(0),result[2].charAt(0));
				}
				if(result[0].compareTo("removeIndex") == 0) {
					obj.removeElementAtIndex(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("removeElement") == 0) {
					obj.removeElement(result[1].charAt(0));
				}
				if(result[0].compareTo("popFront") == 0) {
					obj.popFront();
				}
				if(result[0].compareTo("popBack") == 0) {
					obj.popBack();
				}
				if(result[0].compareTo("pushFront") == 0) {
					obj.pushFront(result[1].charAt(0));
				}
				if(result[0].compareTo("pushBack") == 0) {
					obj.pushBack(result[1].charAt(0));
				}
				if(result[0].compareTo("reverse") == 0) {
					obj.reverse();
				}
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
				}
				if(result[0].compareTo("concat") == 0) {
					MyLList<Character> obj2 = new MyLList<Character>();
					obj2.insertElement('z');
					obj2.insertElement('y');
					obj2.insertElement('x');
					obj2.insertElement('w');
					obj2.insertElement('u');
				 	obj.concat(obj2);
				}
			  if(result[0].compareTo("concatIndex") == 0) {
			  	MyLList<Character> obj2 = new MyLList<Character>();
					obj2.insertElement('z');
					obj2.insertElement('y');
					obj2.insertElement('x');
					obj2.insertElement('w');
					obj2.insertElement('u');
				 	obj.concatAtIndex(Integer.parseInt(result[1]),obj2);
				}
				if(result[0].compareTo("print") == 0) {
					obj.printLinkList();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'S') {
			MyLList<String> obj = new MyLList<String>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split(" ");
				if(result[0].compareTo("insert") == 0) {
					obj.insertElement(result[1]);
				}
				if(result[0].compareTo("insertAfter") == 0) {
					System.out.println(result[1]+"=="+result[2]);
					obj.insertElementAfterElement(result[1],result[2]);
				}
				if(result[0].compareTo("insertBefore") == 0) {
					obj.insertElementBeforeElement(result[1],result[2]);
				}
				if(result[0].compareTo("removeIndex") == 0) {
					obj.removeElementAtIndex(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("removeElement") == 0) {
					obj.removeElement(result[1]);
				}
				if(result[0].compareTo("popFront") == 0) {
					obj.popFront();
				}
				if(result[0].compareTo("popBack") == 0) {
					obj.popBack();
				}
				if(result[0].compareTo("pushFront") == 0) {
					obj.pushFront(result[1]);
				}
				if(result[0].compareTo("pushBack") == 0) {
					obj.pushBack(result[1]);
				}
				if(result[0].compareTo("reverse") == 0) {
					obj.reverse();
				}
				if(result[0].compareTo("concat") == 0) {
					MyLList<String> obj2 = new MyLList<String>();
					obj2.insertElement("India");
					obj2.insertElement("US");
					obj2.insertElement("UK");
					obj2.insertElement("Australia");
					obj2.insertElement("Germany");
				 	obj.concat(obj2);
				}
			  if(result[0].compareTo("concatIndex") == 0) {
			  	MyLList<String> obj2 = new MyLList<String>();
					obj2.insertElement("India");
					obj2.insertElement("US");
					obj2.insertElement("UK");
					obj2.insertElement("Australia");
					obj2.insertElement("Germany");
				 	obj.concatAtIndex(Integer.parseInt(result[1]),obj2);
				}
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
				}
				if(result[0].compareTo("print") == 0) {
					obj.printLinkList();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'F') {
			MyLList<Float> obj = new MyLList<Float>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("insert") == 0) {
					float f = Float.parseFloat(result[1]);
					obj.insertElement(f);
				}
				if(result[0].compareTo("insertAfter") == 0) {
					obj.insertElementAfterElement(Float.parseFloat(result[1]),Float.parseFloat(result[1]));
				}
				if(result[0].compareTo("insertBefore") == 0) {
					obj.insertElementBeforeElement(Float.parseFloat(result[1]),Float.parseFloat(result[1]));
				}
				if(result[0].compareTo("removeIndex") == 0) {
					obj.removeElementAtIndex(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("removeElement") == 0) {
					obj.removeElement(Float.parseFloat(result[1]));
				}
				if(result[0].compareTo("popFront") == 0) {
					obj.popFront();
				}
				if(result[0].compareTo("popBack") == 0) {
					obj.popBack();
				}
				if(result[0].compareTo("pushFront") == 0) {
					obj.pushFront(Float.parseFloat(result[1]));
				}
				if(result[0].compareTo("pushBack") == 0) {
					obj.pushBack(Float.parseFloat(result[1]));
				}
				if(result[0].compareTo("reverse") == 0) {
					obj.reverse();
				}
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
				}
				if(result[0].compareTo("concat") == 0) {
					MyLList<Float> obj2 = new MyLList<Float>();
					obj2.insertElement((float)10.0);
					obj2.insertElement((float)11.0);
					obj2.insertElement((float)12.0);
					obj2.insertElement((float)13.0);
					obj2.insertElement((float)14.0);
				 	obj.concat(obj2);
				}
			  if(result[0].compareTo("concatIndex") == 0) {

			  	MyLList<Float> obj2 = new MyLList<Float>();
					obj2.insertElement((float)10.0);
					obj2.insertElement((float)11.0);
					obj2.insertElement((float)12.0);
					obj2.insertElement((float)13.0);
					obj2.insertElement((float)14.0);
				 	obj.concatAtIndex(Integer.parseInt(result[1]),obj2);
				}
				if(result[0].compareTo("print") == 0) {
					obj.printLinkList();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
	}
}