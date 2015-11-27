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
	//Node<E> freeList;
	int size;
	public MyDLList() {
		start = null;
		end = null;
		size = 0;
	}
	// private void splice(Node<E> a, Node<E> b, Node<E> t) {

	// }
	// public void insert(E element) {
	// 	Node<E> node = new Node<E>(null,element,null);
	// 	if(start == null) {
	// 		start = element;
	// 		start.setPrev(head);
	// 		end = start;
	// 		end.setNext(head);
	// 	}
	// 	else {
	// 			end.setNext(node);
	// 			node.setPrev(end);
	// 			end = node;
	// 		}
	// }
	public void pushBack(E element) {
		Node<E> node = new Node<E>(null,element,null);
		if(start == null) {
			start = node;
			end = start;
			size++;
		}
		else {
			end.setNext(node);
			node.setPrev(end);
			end = node;
			size++;
		}
	}
	public void pushFront(E element) {
		Node<E> node = new Node<E>(null,element,null);
		if(start == null) {
			start = node;
			end = start;
			size++;
		}
		else {
			node.setNext(start);
			start.setPrev(node);
			start = node;
			size++;
		}
	}
	public void popFront(){
		if(size == 0) {
			System.out.println("List is Empty");
		}
		else if(size == 1) {
			start = null;
			end = start;
			size--;
		}
		else {
			Node<E> next = start.getNext();
			start = null;
			next.setPrev(null);
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
			if(start == end) {
				start = null;
				size--;
			}
			else if(current.getNext() == null) {
				start.setNext(null);
				current = null;
				end = start;
				size--;
			}
			else {
				while(current.getNext() != null) {
					//System.out.println("hello..");
					prev = current;
					current = current.getNext();
				}
				prev.setNext(null);
				current = null;
				end = prev;
				size--;
			}
		}
	}
	public void insertAfter(E afterElement, E newElement) {
		Node<E> node = new Node<E>(null,newElement,null);
		if(start == null) {
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
					if(node.getNext() == null) {
						end = node;
					}
					count++;
					size++;
			}
			else {
				while(current.getNext() != null) {
					current = current.getNext();
					if(current.getData().equals(afterElement)) {
						node.setNext(current.getNext());
						node.setPrev(current);
						current.setNext(node);
						if(node.getNext() == null) {
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
	public void insertBefore(E prevElement, E newElement) {
		Node<E> node = new Node<E>(null,newElement,null);
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData().equals(prevElement)) {
			node.setNext(start);
			start.setPrev(node);
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
				while(current.getNext() != null) {
					prev = current;
					current = current.getNext();
					if(current.getData().equals(prevElement)) {
						node.setNext(current);
						node.setPrev(prev);
						current.setPrev(node);
						prev.setNext(node);
						if(current.getNext() == null) {
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
		if(start == null) {
			System.out.println("No prevoius elements found");
		}
		else if(start.getData().equals(element)) {
			if(start.getNext() == null) {
				start = null;
				end = null;
			}
			else {
				start.getNext().setPrev(null);
				start = start.getNext();
			}
			size--;
		}
		else {
			int count = 0;
			if(start.getNext() == null) {
				System.out.println("Element Not Found");
				return;
			}
			Node<E> prev = start;
			Node<E> current = start.getNext();
			if(current.getData().equals(element)) {
				if(current.getNext() == null) {
					prev.setNext(null);
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
				while(current.getNext() != null) {
					prev = current;
					current = current.getNext();
					if(current.getData().equals(element)) {
						if(current.getNext() == null) {
							prev.setNext(null);
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
		if(start == null) {
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
	public void printLinkList() {
		if(start == null) {
			System.out.println("List is empty");
		}
		else {
			System.out.print(start.getData());
			Node<E> current = start;
			while(current.getNext() != null) {
				current = current.getNext();
				System.out.print("->" + current.getData());
			}
			System.out.println();
		}
		System.out.println("size: "+size);
	}
	public void makeEmpty(){

	}
}
public class DoublyLinkedList {
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
				// if(result[0].compareTo("removeIndex") == 0) {
				// 	obj.removeElementAtIndex(Integer.parseInt(result[1]));
				// }
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
				// if(result[0].compareTo("reverse") == 0) {
				// 	obj.reverse();
				// }
				if(result[0].compareTo("makeEmpty") == 0) {
					obj.makeEmpty();
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
			 //  if(result[0].compareTo("concatIndex") == 0) {
			 //  	MyLList<Integer> obj2 = new MyLList<Integer>();
				// 	obj2.insertElement(10);
				// 	obj2.insertElement(11);
				// 	obj2.insertElement(12);
				// 	obj2.insertElement(13);
				// 	obj2.insertElement(14);
				//  	obj.concatAtIndex(Integer.parseInt(result[1]),obj2);
				// }
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