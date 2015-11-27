import java.util.*;
class selection {
	int[] array;
	int[] array2;
	int size;
	int i = 0;
	public selection(int size) {
		this.size = size;
		array = new int[size];
		array2 = new int[size];
	}
	public void add(int k) {
		array[i] = k;
		i++;
	}
	public void sort() {
		int min = 11111;
		final int max = 3233;
		int z = 0;		
		while(z < size) {
			int temp = 0;
			for(int x = 0; x < size; x++) {
				if(array[x] < min) {
					min = array[x];
					temp = x;
				}
			}
			array[temp] = max;
			array2[z] = min;
			min = max;
			z++;
		}
	}
	public void printArray() {
		int k;
		for(k = 0; k < size-1; k++) {
			System.out.print(array2[k] + " ");
		}
		System.out.print(array2[k]);
	}
}
public class selectionSort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = Integer.parseInt(input.nextLine());
		selection sel = new selection(size);
		System.out.println("Enter "+size+"elements : ");
		int i = 0;
		while(i < size) {
			sel.add(Integer.parseInt(input.nextLine()));
			i++;
		}
		sel.sort();
		sel.printArray();
	}
}