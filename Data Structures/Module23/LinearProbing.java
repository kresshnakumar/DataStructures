import java.util.*;
class probingOperations {
	private int[] array; 
	private int size;
	public probingOperations(int size) {
		this.size = size;
		array = new int[size];
	}
	public void insert(int number) {
		int genKey = generateKey(number);
		if(array[genKey] == 0) {
			array[genKey] = number;
		}
		else {
			int i = genKey + 1;
			int xxx = 0;
			while( i != genKey) {
				if(array[i] == 0) {
					array[i] = number;
					xxx = 1;
					break;
				}
				else {
					i = generateKey(++i);
				}
			}
			if(xxx == 0) {
				System.out.println("Array is Full");
			}
			//System.out.println("Array is full ");
		}
	}
	public void search(int element) {
		int key = generateKey(element);
		if(array[key] == element) {
			System.out.println("Element Found");
		}
		else {
			int h = key + 1;
			int l = 0;
			while(h != key && array[h] != 0) {
				if(array[h] == element) {
					System.out.println("Element Found");
					l = 1;
					break;
				}
				h = generateKey(++h);
			}
			if(l == 0) {
				System.out.println("Element Not found");
			}
		}
	}
	public void remove(int value) {
		int key = generateKey(value);
		if(array[key] == value) {
			array[key] = 0;
			reHashArray(key);
		}
		else {
			int h = key + 1;
			int l = 0;
			while(h != key && array[h] != 0) {
				if(array[h] == value) {
					array[h] = 0;
					reHashArray(h);
					l = 1;
					break;
				}
				h = generateKey(++h);
			}
			if(l == 0) {
				System.out.println("Element Not found");
			}
		}
	}
	public void reHashArray(int key) {
		int g= key + 1;
		while(array[g] != 0) {
			int temp = array[g];
			array[g] = 0;
			insert(temp);
			g = generateKey(++g);
		}
	}
	public int generateKey(int number) {
		return (number % size);
	}
	public void print() {
		for(int v = 0; v < size; v++) {
			//if(array[v] != 0) {
				System.out.print(array[v] + " ");
			//}
		}
		System.out.println();
	}
}
public class LinearProbing {
	public static void main(String[] krishna) {
		Scanner input = new Scanner(System.in);
		int size = Integer.parseInt(input.nextLine());
		probingOperations po = new probingOperations(size);
		int z = 0;
		while(z < size) {
			po.insert(Integer.parseInt(input.nextLine()));
			z++;
		}
		po.print();
		po.remove(11);
		po.print();
		po.remove(7);
		po.print();
		po.search(7);
		po.search(5);
		po.search(15);
	}
}