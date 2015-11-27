import java.util.*;

interface myListADT<E> {
	public void addElement(E element);
	public void removeElement(E element);
	public void removeElementAtIndex(int index);
	public void modifyByIndex(int index, E element);
	public void modifyByElement(E oldElement, E newElement);
	public void read(int index);
	public void reallocateSize(int resize);
	public void printMyArray();
}

@SuppressWarnings("unchecked")

class SimpleGeneric<E> implements myListADT<E> {
	E[] myArray;
	int index;
	public int size() {
		return this.index;
	}

	public SimpleGeneric() {
		myArray = (E[])new Object[1];
		this.index = 0;
	}

	public void addElement(E element) {
		if(index == myArray.length) {
			int resize = myArray.length * 2;
			reallocateSize(resize);
		}
		myArray[index] = element;
		index++;
	}

	public void removeElement(E element) {
		int i;
		int count = 0;
		for(i = 0 ; i < this.size(); i++) {
			if(element.equals(myArray[i])) {
				int j;
				for(j = i ; j < this.size() - 1 ; j++) {
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
			int resize = myArray.length/2;
			reallocateSize(resize);
		}
	}

	public void removeElementAtIndex(int index) {
		if(this.size() == 0) {
			System.out.println("List is empty");
		}
		else {
			if(index <= this.size() - 1) {
			int i;
				for(i = index ; i < this.size() - 1; i++) {
					myArray[i] = myArray[i+1];
				}
			myArray[i] = null;
			this.index--;
			}
			if((myArray.length/4) == index) {
				int resize = myArray.length/2;
				reallocateSize(resize);
			}
		}
	}

	public void modifyByIndex(int index, E element) {
		if(index <= this.size() - 1) {
			myArray[index] = element;
		}
	}

	public void printMyArray() {
		int i;
		if(this.size() == 0) {
			System.out.println("List is empty");
		}
		else {
			for(i = 0; i < this.size() - 1 ; i++) {
			System.out.print(myArray[i] + ",");
			}
			System.out.println(myArray[i]);
		}
	}

	public void modifyByElement(E oldElement, E newElement) {
		for(int i = 0; i < this.size(); i++) {
			if(myArray[i].equals(oldElement)) {
				myArray[i] = newElement;
			}
		}
	}

	public void reallocateSize(int resize) {
		E[] newArray = Arrays.copyOf(myArray,resize);
		myArray = newArray;
	}

	public void removeSize() {
		int shrinkvalue = myArray.length/2;
		E[] newArray = Arrays.copyOf(myArray,shrinkvalue);
		myArray = newArray;
	}

	public void read(int index) {
		if(index <= this.size()) {
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

public class SimpleGenericDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			SimpleGeneric<Integer> t = new SimpleGeneric<Integer>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("add") == 0) {
					int value = Integer.parseInt(result[1]);
					t.addElement(value);
				}
				if(result[0].compareTo("removeElement") == 0) {
					int value = Integer.parseInt(result[1]);
					t.removeElement(value);
				}
				if(result[0].compareTo("removeIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					t.removeElementAtIndex(value);
				}
				if(result[0].compareTo("read") == 0) {
					int value = Integer.parseInt(result[1]);
					t.read(value);
				}
				if(result[0].compareTo("modifyIndex") == 0) {
					int value1 = Integer.parseInt(result[1]);
					int value2 = Integer.parseInt(result[2]);
					t.modifyByIndex(value1,value2);
				}
				if(result[0].compareTo("modifyElement") == 0) {
					int value1 = Integer.parseInt(result[1]);
					int value2 = Integer.parseInt(result[2]);
					t.modifyByElement(value1,value2);
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 =='C') {
			SimpleGeneric<Character> t = new SimpleGeneric<Character>();
			int flag = 1;
			do {
				Scanner input1 = new Scanner(System.in);
				String string = input1.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("add") == 0) {
					char ch = result[1].charAt(0);
					t.addElement(ch);
				}
				if(result[0].compareTo("removeIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					t.removeElementAtIndex(value);
				}
				if(result[0].compareTo("removeElement") == 0) {
					char ch = result[1].charAt(0);
					t.removeElement(ch);
				}
				if(result[0].compareTo("read") == 0) {
					int value = Integer.parseInt(result[1]);
					t.read(value);
				}
				if(result[0].compareTo("modifyIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					char ch = result[2].charAt(0);
					t.modifyByIndex(value,ch);
				}
				if(result[0].compareTo("modifyElement") == 0) {
					char ch1 = result[1].charAt(0);
					char ch2 = result[2].charAt(0);
					t.modifyByElement(ch1, ch2);
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);

		}
		else if(char1 =='S') {
			SimpleGeneric<String> st = new SimpleGeneric<String>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("add") == 0) {
					st.addElement(result[1]);
				}
				if(result[0].compareTo("removeIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					st.removeElementAtIndex(value);
				}
				if(result[0].compareTo("removeElement") == 0) {
					st.removeElement(result[1]);
				}
				if(result[0].compareTo("read") == 0) {
					int value = Integer.parseInt(result[1]);
					st.read(value);
				}
				if(result[0].compareTo("modifyIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					st.modifyByIndex(value,result[2]);
				}
				if(result[0].compareTo("modifyElement") == 0) {
					st.modifyByElement(result[1],result[2]);
				}
				if(result[0].compareTo("print") == 0) {
					st.printMyArray();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 =='F') {

			SimpleGeneric<Float> t = new SimpleGeneric<Float>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("add") == 0) {
					float value = Float.parseFloat(result[1]);
					t.addElement(value);
				}
				if(result[0].compareTo("removeIndex") == 0) {
					int value = Integer.parseInt(result[1]);
					t.removeElementAtIndex(value);
				}
				if(result[0].compareTo("removeElement") == 0) {
					float value = Float.parseFloat(result[1]);
					t.removeElement(value);
				}
				if(result[0].compareTo("read") == 0) {
					int value = Integer.parseInt(result[1]);
					t.read(value);
				}
				if(result[0].compareTo("modifyIndex") == 0) {
					int value1 = Integer.parseInt(result[1]);
					float value2 = Float.parseFloat(result[2]);
					t.modifyByIndex(value1,value2);
				}
				if(result[0].compareTo("modifyElement") == 0) {
					float value1 = Float.parseFloat(result[1]);
					float value2 = Float.parseFloat(result[2]);
					t.modifyByElement(value1,value2);
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);

		}
	}
}