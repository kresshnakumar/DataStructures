import java.util.*;
class insertion {
	int[] array;
	int size;
	int i = 0;
	public insertion(int size) {
		this.size = size;
		array = new int[size];
	}
	public void add(int k) {
		array[i] = k;
		i++;
	}
	public void sort() {
		int temp;
		int index = 0;
		for(int x = 1; x < size; x++) {
			for(int y = x; y > 0 ; y--) {
				if(array[y] < array[y-1]) {
					temp = array[y];
					array[y] = array[y-1];
					array[y-1] = temp;
				}
			}
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
public class insertionSortOneArray {
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