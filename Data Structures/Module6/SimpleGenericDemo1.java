import java.util.*;

interface myListADT<E> {
	public void addElement(E element);
	public void removeElement(E element);
	public void removeElementAtIndex(int index);
	public void modifyByIndex(int index, E element);
	public void modifyByElement(E oldElement, E newElement);
	public void read(int index);
	public void reallocateSize();
	public void removeSize();
	public void printMyArray();
}

@SuppressWarnings("unchecked")

class SimpleGeneric<E> implements myListADT<E> {
	E[] myArray;
	int index;
	public int size() {
		return this.index + 1;
	}

	public SimpleGeneric() {
		myArray = (E[])new Object[1];
		int index = 0;
	}

	public void addElement(E element) {
		if(index == myArray.length) {
			reallocateSize();
		}
		myArray[index] = element;
		index++;
	}

	public void removeElement(E element) {
		int i;
		int count = 0;
		for(i = 0 ; i < this.size() - 1; i++) {
			//System.out.println(element + "--" + myArray[i]);
			if(element.equals(myArray[i])) {
				int j;
				for(j = i ; j < this.size() - 2 ; j++) {
					myArray[j] = myArray[j+1];
				}
				myArray[j] = null;
				index--;
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("Element is not found");
		}
		if((myArray.length/4) == index) {
			removeSize();
		}
	}

	public void removeElementAtIndex(int index) {
		if(myArray.length == 0) {
			System.out.println("List is empty");
		}
		if(index <= this.size() - 1) {
			int i;
			for(i = index ; i < this.size() - 1; i++) {
				myArray[i] = myArray[i+1];
			}
		myArray[i] = null;
		this.index--;
		}
		else {
			System.out.println("No Index Found");
		}
		if((myArray.length/4) == index) {
			removeSize();
		}
	}

	public void modifyByIndex(int index, E element) {
		if(index <= this.size() - 1) {
			myArray[index] = element;
		}
		else {
			System.out.println("No Index Found");
		}
	}

	public void printMyArray() {
		int i;
		if(myArray.length == 0) {
			System.out.println("List is empty");
		}
		for(i = 0; i < this.size() - 1 ; i++) {
			System.out.println(myArray[i]);
		}
	}

	public void modifyByElement(E oldElement, E newElement) {
		for(int i = 0; i < this.size() - 1 ; i++) {
			if(myArray[i].equals(oldElement)) {
				myArray[i] = newElement;
			}
		}
	}

	public void reallocateSize() {
		int shrinkvalue = 2 * myArray.length;
		E[] newArray = Arrays.copyOf(myArray,shrinkvalue);
		myArray = newArray;
	}

	public void removeSize() {
		int shrinkvalue = myArray.length/2;
		E[] newArray = Arrays.copyOf(myArray,shrinkvalue);
		myArray = newArray;
	}

	public void read(int index) {
		if(index <= this.size() - 1) {
			System.out.println(myArray[index]);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int i;
		for(i = 0 ; i < this.size() - 2 ; i++) {
			sb.append(myArray[i]);
			sb.append(", ");
		}
		sb.append(myArray[i]);
		sb.append("]");
		return sb.toString();
	}
}

public class SimpleGenericDemo1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if(str.compareTo("I") == 0) {
			SimpleGeneric<Integer> t = new SimpleGeneric<Integer>();
			int flag = 1;
			do {
				Scanner input1 = new Scanner(System.in);
				String string = input1.nextLine();
				if(string.compareTo("add") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					t.addElement(value);
				}
				if(string.compareTo("removeElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					//System.out.println(value);
					t.removeElement(value);
				}
				if(string.compareTo("read") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					//System.out.println(value);
					t.read(value);
				}
				if(string.compareTo("modifyIndex") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value1 = input2.nextInt();
					int value2 = input2.nextInt();
					//System.out.println(value1);
					t.modifyByIndex(value1,value2);
				}
				if(string.compareTo("modifyElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value1 = input2.nextInt();
					int value2 = input2.nextInt();
					//System.out.println(value1);
					t.modifyByElement(value1,value2);
				}
				if(string.compareTo("print") == 0) {
					t.printMyArray();
				}
				if(string.compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(str.compareTo("C") == 0) {

			SimpleGeneric<Character> t = new SimpleGeneric<Character>();
			int flag = 1;
			do {
				Scanner input1 = new Scanner(System.in);
				String string = input1.nextLine();
				if(string.compareTo("add") == 0) {
					Scanner input2 = new Scanner(System.in);
					char ch = input2.next().charAt(0);
					t.addElement(ch);
				}
				if(string.compareTo("removeElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					char ch = input2.next().charAt(0);
					t.removeElement(ch);
				}
				if(string.compareTo("read") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					t.read(value);
				}
				if(string.compareTo("modifyIndex") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					Scanner input3 = new Scanner(System.in);
					char ch = input3.next().charAt(0);;
					t.modifyByIndex(value,ch);
				}
				if(string.compareTo("modifyElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					char ch1 = input2.next().charAt(0);
					char ch2 = input2.next().charAt(0);
					t.modifyByElement(ch1, ch2);
				}
				if(string.compareTo("print") == 0) {
					t.printMyArray();
				}
				if(string.compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);

		}
		else if(str.compareTo("S") == 0) {
			SimpleGeneric<String> st = new SimpleGeneric<String>();
			int flag = 1;
			do {
				Scanner input1 = new Scanner(System.in);
				String string = input1.nextLine();
				if(string.compareTo("add") == 0) {
					Scanner input2 = new Scanner(System.in);
					String str1 = input2.nextLine();
					st.addElement(str1);
				}
				if(string.compareTo("removeElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					String str1 = input2.nextLine();
					st.removeElement(str1);
				}
				if(string.compareTo("read") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					st.read(value);
				}
				if(string.compareTo("modifyIndex") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					Scanner input3 = new Scanner(System.in);
					String str1 = input3.nextLine();
					st.modifyByIndex(value,str1);
				}
				if(string.compareTo("modifyElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					String str1 = input2.nextLine();
					String str2 = input2.nextLine();
					st.modifyByElement(str1, str2);
				}
				if(string.compareTo("print") == 0) {
					st.printMyArray();
				}
				if(string.compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(str.compareTo("F") == 0) {

			SimpleGeneric<Float> t = new SimpleGeneric<Float>();
			int flag = 1;
			do {
				Scanner input1 = new Scanner(System.in);
				String string = input1.nextLine();
				if(string.compareTo("add") == 0) {
					Scanner input2 = new Scanner(System.in);
					float value = input2.nextFloat();
					t.addElement(value);
				}
				if(string.compareTo("removeElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					float value = input2.nextFloat();
					t.removeElement(value);
				}
				if(string.compareTo("read") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value = input2.nextInt();
					t.read(value);
				}
				if(string.compareTo("modifyIndex") == 0) {
					Scanner input2 = new Scanner(System.in);
					int value1 = input2.nextInt();
					float value2 = input2.nextFloat();
					t.modifyByIndex(value1,value2);
				}
				if(string.compareTo("modifyElement") == 0) {
					Scanner input2 = new Scanner(System.in);
					float value1 = input2.nextFloat();
					float value2 = input2.nextFloat();
					t.modifyByElement(value1,value2);
				}
				if(string.compareTo("print") == 0) {
					t.printMyArray();
				}
				if(string.compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);

		}
	}
}