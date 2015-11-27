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
	String output = "";
	public int size() {
		return this.n + 1;
	}

	public SimpleGeneric(int a, int b) {
		myArray = (E[])new Object[1];
		this.w = 1;
		this.n = 0;
		alpha = b;
		beta = a;
	}

	public void addElement(E element) {
		if(n == w) {
			//int resize = myArray.length * 2;
			reallocateSize(beta * n);
			getCapacity();
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
		if((alpha * n) <= w && n > 0) {
			//int resize = myArray.length/2;
			reallocateSize(n*beta);
			getCapacity();
		}
	}

	public void printMyArray() {
		int i = 0;
		while(i < output.length()-2) {
			System.out.print(output.charAt(i));
			i++;
		}
		System.out.println(output.charAt(i));
	}
	public void getSize() {
		System.out.println(this.size() - 1);
	}

	public void getCapacity() {
		// System.out.print(this.w);
		output = output + this.w + ",";
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
		String str = input.nextLine();
		String[] result = str.split(",");
		int alpha = Integer.parseInt(result[0]);
		int beta = Integer.parseInt(result[1]);
		SimpleGeneric<Integer> t = new SimpleGeneric<Integer>(alpha,beta);
		
		int flag = 0;
		str = input.nextLine();
		//System.out.println("string:" + str);
		String[] result1 = str.split(",");
		int arraysize = result1.length;
		//System.out.println("size is:" + result1.length);
		t.getCapacity();
		while(flag < result1.length) {
			if(result1[flag].compareTo("push") == 0) {
				t.addElement(1);
			}
			if(result1[flag].compareTo("pop") == 0) {
				t.removeElement();
			}
			//System.out.println(result1[flag]);
			flag++;

		}
		t.printMyArray();
	}
}
