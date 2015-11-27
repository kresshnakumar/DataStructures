import java.util.*;
interface myDLinkedList<E> {
	public void insertAfter(E afterElement, E newElement);
	public void insertBefore(E prevElement, E newElement);
	public void removeElement(E element);
	public void popFront();
	public void popBack();
	public void pushFront(E element);
	public void pushBack(E element);
	public void concat(MyDLList<E> obj2);
	public void makeEmpty();
	public void reverse();
	public void search(E element);
}
class Node<E> {
	private E data;
	private Node<E> next;
	private Node<E> prev;
	public Node(Node prev, E data, Node next) {
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData() {
		return data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getPrev() {
		return prev;
	}
}

@SuppressWarnings("unchecked")

class MyDLList<E> implements myDLinkedList<E> {
	Node<E> start;
	Node<E> end;
	Node<E> dummy;
	int size;
	public MyDLList() {
		dummy = new Node(null,null,null);
		start = dummy;
		end = dummy;
		size = 0;
	}
	public void pushBack(E element) {
		Node<E> node = new Node<E>(dummy,element,dummy);
		if(start == dummy) {
			start = node;
			dummy.setNext(start);
			end = start;
			dummy.setPrev(end);
			size++;
		}
		else {
			end.setNext(node);
			node.setPrev(end);
			node.setNext(dummy);
			dummy.setPrev(node);
			end = node;
			size++;
		}
	}
	public void pushFront(E element) {
		Node<E> node = new Node<E>(dummy,element,dummy);
		if(start == dummy) {
			start = node;
			end = start;
			size++;
		}
		else {
			node.setNext(start);
			start.setPrev(node);
			dummy.setNext(node);
			start = node;
			size++;
		}
	}
	public void popFront(){
		if(size == 0) {
			System.out.println("List is Empty");
		}
		else if(size == 1) {
			start = dummy;
			end = start;
			size--;
		}
		else {
			Node<E> next = start.getNext();
			start = dummy;
			next.setPrev(dummy);
			dummy.setNext(next);
			start = next;
			size--;
		}
	}
	public void popBack(){
		if(size == 0) {
			System.out.println("List is Empty");
		}
		else {
			Node<E> prev = start;
			Node<E> current = start.getNext();
			if(size == 1) {
				start = dummy;
				end = dummy;
				size--;
			}
			else if(current.getNext() == dummy) {
				start.setNext(dummy);
				dummy.setPrev(start);
				current = null;
				end = start;
				size--;
			}
			else {
				while(current.getNext() != dummy) {
					prev = current;
					current = current.getNext();
				}
				prev.setNext(dummy);
				dummy.setPrev(prev);
				current = null;
				end = prev;
				size--;
			}
		}
	}
	public void insertAfter(E afterElement, E newElement) {
		Node<E> node = new Node<E>(dummy,newElement,dummy);
		if(start == dummy) {
			System.out.println("List is empty");
		}
		else if(start.getData().equals(afterElement)) {
			node.setNext(start.getNext());
			node.setPrev(start);
			start.setNext(node);
			if(size == 1) {
				end = node;
			}
			size++;
		}
		else {
			int count = 0;
			Node<E> current = start.getNext();
			if(current.getData().equals(afterElement)) {
					node.setNext(current.getNext());
					node.setPrev(current);
					current.setNext(node);
					if(node.getNext() == dummy) {
						end = node;
					}
					count++;
					size++;
			}
			else {
				while(current.getNext() != dummy) {
					current = current.getNext();
					if(current.getData().equals(afterElement)) {
						node.setNext(current.getNext());
						node.setPrev(current);
						current.setNext(node);
						if(node.getNext() == dummy) {
							end = node;
						}
						count++;
						size++;
						break;
					}
				}
				if(count == 0) {
					System.out.println("Element Not Found");
				}
			}
		}
	}
	public void search(E element) {
		dummy.setData(element);
		Node<E> temp = start;
		if(size == 0) {
			System.out.println("List is empty");
		}
		else {
			int count = 0;
			int won = 0;
			while(true) {
				if(element == dummy.getData()) {
					System.out.println("Element not found");
					break;
				}
				if(temp.getData().equals(element)) {
					System.out.println("Element Found at:" + count);
					break;
				}
				else {
					temp = temp.getNext();
					count++;
				}
			}
		}
	}
	public void insertBefore(E prevElement, E newElement) {
		Node<E> node = new Node<E>(dummy,newElement,dummy);
		if(start == dummy) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData().equals(prevElement)) {
			node.setNext(start);
			start.setPrev(node);
			dummy.setNext(node);
			start = node;
			size++;
		}
		else {
			int count = 0;
			Node<E> prev = start;
			Node<E> current = start.getNext();
			if(current.getData().equals(prevElement)) {
				node.setNext(current);
				node.setPrev(prev);
				current.setPrev(node);
				prev.setNext(node);
				count++;
				size++;
			}
			else {
				while(current.getNext() != dummy) {
					prev = current;
					current = current.getNext();
					if(current.getData().equals(prevElement)) {
						node.setNext(current);
						node.setPrev(prev);
						current.setPrev(node);
						prev.setNext(node);
						if(current.getNext() == dummy) {
							end = current;
						}
						count++;
						size++;
						break;
					}
				}
				if(count == 0 ) {
					System.out.println("Element Not Found");
				}
			}
		}
	}
	public void removeElement(E element) {
		if(start == dummy) {
			System.out.println("No elements found");
		}
		else if(start.getData().equals(element)) {
			popFront();
			// if(start.getNext() == dummy) {
			// 	start = dummy;
			// 	end = dummy;
			// }
			// else {
			// 	start.getNext().setPrev(dummy);
			// 	start = start.getNext();
			// }
			// size--;
		}
		else {
			int count = 0;
			if(start.getNext() == dummy) {
				System.out.println("Element Not Found");
				return;
			}
			Node<E> prev = start;
			Node<E> current = start.getNext();
			if(current.getData().equals(element)) {
				if(current.getNext() == dummy) {
					prev.setNext(dummy);
					end = prev;
				}
				else {
					current.getNext().setPrev(prev);
					prev.setNext(current.getNext());
					current = null;
				}
				count++;
				size--;
			}
			else {
				while(current.getNext() != dummy) {
					prev = current;
					current = current.getNext();
					if(current.getData().equals(element)) {
						if(current.getNext() == dummy) {
							prev.setNext(dummy);
							end = prev;
						}
						else {
							current.getNext().setPrev(prev);
							prev.setNext(current.getNext());
						}
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
	public void concat(MyDLList<E> obj2){
		Node<E> list2 = obj2.start;
		if(start == dummy) {
			start = list2;
			end = obj2.end;
			size = obj2.size + size;
		}
		else {
			end.setNext(list2);
			list2.setPrev(end);
			end = obj2.end;
			size = obj2.size + size;
		}
	}
	public void reverse() {
		rev(start);
		System.out.println();
	}

	public void rev(Node<E> temp) {
		if(temp == dummy) {
			return ;
		}
		else {
			rev(temp.getNext());
			if(temp.getNext() == dummy) {
				System.out.print(temp.getData());
			}
			else {
				System.out.print("->" + temp.getData());
			}
		}
	}
	public void printLinkList() {
		if(start == dummy) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(start.getData());
			Node<E> current = start;
			while(current.getNext() != dummy) {
				current = current.getNext();
				System.out.print("->" + current.getData());
			}
			System.out.println();
		}
		//System.out.println("size: "+size);
	}
	public void makeEmpty(){
		start = dummy;
		end = dummy;
		size = 0;
	}
}
public class CircularDoublyLinkedListDummy {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			MyDLList<Integer> obj = new MyDLList<Integer>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("insert") == 0) {
					int value = Integer.parseInt(result[1]);
					obj.pushBack(value);
				}
				if(result[0].compareTo("insertAfter") == 0) {
					obj.insertAfter(Integer.parseInt(result[1]),Integer.parseInt(result[2]));
				}
				if(result[0].compareTo("insertBefore") == 0) {
					obj.insertBefore(Integer.parseInt(result[1]),Integer.parseInt(result[2]));
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
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
				}
				if(result[0].compareTo("reverse") == 0) {
					obj.reverse();
				}
				if(result[0].compareTo("search") == 0) {
					obj.search(Integer.parseInt(result[1]));
				}
				if(result[0].compareTo("concat") == 0) {
					MyDLList<Integer> obj2 = new MyDLList<Integer>();
					obj2.pushBack(10);
					obj2.pushBack(11);
					obj2.pushBack(12);
					obj2.pushBack(13);
					obj2.pushBack(14);
				 	obj.concat(obj2);
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