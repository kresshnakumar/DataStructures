import java.util.*;
class selection {
	int[] array;
	int size;
	int i = 0;
	public selection(int size) {
		this.size = size;
		array = new int[size];
	}
	public void add(int k) {
		array[i] = k;
		i++;
	}
	public void sort() {
		int k = 0;
		while(k < size) {
			int min = 1111;
			int temp;
			int index = 0;
			for(int x = k; x < size; x++) {
				if(array[x] < min) {
					//System.out.println("----------------");
					min = array[x];
					index = x;
				}
			}
			//System.out.println("min: " + min);
			temp = array[k];
			//System.out.println("Temp: " + temp);
			array[k] = min;
			//System.out.println("index: "+index);
			array[index] = temp;
			k++;
		}
	}
	public void printArray() {
		int k;
		for(k = 0; k < size-1; k++) {
			System.out.print(array[k] + " ");
		}
		System.out.print(array[k]);
	}
}
public class selectionSortOneArray {
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