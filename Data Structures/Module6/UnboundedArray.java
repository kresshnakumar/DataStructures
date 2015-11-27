import java.util.*;

interface myListADT<E> {
	public void addElement(E element);
	public void removeElement();
	public void getSize();
	public void getCapacity();
	public void reallocateSize(int resize);
	public void printMyArray();
}

@SuppressWarnings("unchecked")

class SimpleGeneric<E> implements myListADT<E> {

	E[] myArray;
	int n;
	int w;
	int alpha;
	int beta;
	public int size() {
		return this.n + 1;
	}

	public SimpleGeneric() {
		myArray = (E[])new Object[1];
		this.w = 1;
		this.n = 0;
		alpha = 4;
		beta = 2;
	}

	public void addElement(E element) {
		if(n == w) {
			//int resize = myArray.length * 2;
			reallocateSize(beta * n);
		}
		myArray[n] = element;
		n++;
	}

	public void removeElement() {
		if(this.size() - 1 == 0) {
			System.out.println("Array is empty");
		}
		else {
			myArray[n - 1] = null;
			n--;
		}
		if((alpha * n) <= w && n >= 0) {
			//int resize = myArray.length/2;
			reallocateSize(w/beta);
		}
	}

	public void printMyArray() {
		int i;
		if(this.size() - 1 == 0) {
			System.out.println("Array is empty");
		}
		else
		{
			for(i = 0; i< this.size() - 2; i++) {
			System.out.print(myArray[i] + " ");
			}
			System.out.println(myArray[i]);
		}
	}
	public void getSize() {
		System.out.println(this.size() - 1);
	}

	public void getCapacity() {
		System.out.println(this.w);
	}

	public void reallocateSize(int resize) {
		this.w = resize;
		E[] newArray = Arrays.copyOf(myArray,resize);
		myArray = newArray;
	}
}

public class UnboundedArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char char1 = input.next().charAt(0);
		if(char1 == 'I') {
			SimpleGeneric<Integer> t = new SimpleGeneric<Integer>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					int value = Integer.parseInt(result[1]);
					t.addElement(value);
				}
				if(result[0].compareTo("pop") == 0) {
					t.removeElement();
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("size") == 0) {
					t.getSize();
				}
				if(result[0].compareTo("capacity") == 0) {
					t.getCapacity();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'C') {
			SimpleGeneric<Character> t = new SimpleGeneric<Character>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					char ch = result[1].charAt(0);
					t.addElement(ch);
				}
				if(result[0].compareTo("pop") == 0) {
					t.removeElement();
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("size") == 0) {
					t.getSize();
				}
				if(result[0].compareTo("capacity") == 0) {
					t.getCapacity();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'F') {
			SimpleGeneric<Float> t = new SimpleGeneric<Float>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					Float value = Float.parseFloat(result[1]);
					t.addElement(value);
				}
				if(result[0].compareTo("pop") == 0) {
					t.removeElement();
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("size") == 0) {
					t.getSize();
				}
				if(result[0].compareTo("capacity") == 0) {
					t.getCapacity();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
		else if(char1 == 'S') {
			SimpleGeneric<String> t = new SimpleGeneric<String>();
			int flag = 1;
			do {
				String string = input.nextLine();
				String[] result = string.split("\\s");
				if(result[0].compareTo("push") == 0) {
					String str = "";
					int i;
					for(i = 1; i < result.length -1 ; i++) {
						str = str + result[i] + " ";
					}
					str = str + result[i];
					t.addElement(str);
				}
				if(result[0].compareTo("pop") == 0) {
					t.removeElement();
				}
				if(result[0].compareTo("print") == 0) {
					t.printMyArray();
				}
				if(result[0].compareTo("size") == 0) {
					t.getSize();
				}
				if(result[0].compareTo("capacity") == 0) {
					t.getCapacity();
				}
				if(result[0].compareTo("end") == 0) {
					flag = 0;
				}
			}while(flag == 1);
		}
	}
}
