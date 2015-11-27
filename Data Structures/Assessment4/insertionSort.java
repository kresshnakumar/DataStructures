import java.util.*;
class insertion {
	int[] array1;
	int[] array2;
	int size1;
	int size2;
	public insertion(int s1, int s2) {
		this.size1 = s1;
		this.size2 = s2;
		array1 = new int[size1];
		array2 = new int[size2];
	}
	public void add(int[] array1,int[] array2) {
		for(int i = 0 ; i< array1.length;i++) {
			this.array1[i] = array1[i];
		}
		for(int i = 0 ; i< array2.length;i++) {
			this.array2[i] = array2[i];
		}
	}
	public void insert() {
		for(int x = 0; x < size2; x++) {
			//System.out.println(array1.length + "--"+size1);
			size1++;
			array1 = Arrays.copyOf(array1,size1);
			array1[size1-1] = array2[x];
			//System.out.println(size1);
			//System.out.println(array1.length);
			sort();
			printArray();
			System.out.println();
		}
	}
	public void sort() {
		int temp;
		int index = 0;
		for(int x = 1; x < size1; x++) {
			for(int y = x; y > 0 ; y--) {
				if(array1[y] < array1[y-1]) {
					temp = array1[y];
					array1[y] = array1[y-1];
					array1[y-1] = temp;
				}
			}
		}
	}
	public void printArray() {
		int k;
		for(k = 0; k < size1-1; k++) {
			System.out.print(array1[k] + ",");
		}
		System.out.print(array1[k]);
	}
}
public class insertionSort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//System.out.println("Enter the size of array: ");
		String str1 = input.nextLine();
		String[] st1 = str1.split(",");
		int[] array1 = new int[st1.length];
		int k = 0;
		while(k < st1.length) {
			array1[k] = Integer.parseInt(st1[k]);
			k++;
		}
		String str2 = input.nextLine();
		String[] st2 = str2.split(",");
		int[] array2 = new int[st2.length];
		k = 0;
		while(k < st2.length) {
			array2[k] = Integer.parseInt(st2[k]);
			k++;
		}
	// 	for(int i = 0;i < array1.length; i++) {
	// 		System.out.println(array1[i]);
	// 	}
	// 	for(int i = 0; i < array2.length;i++) {
	// 		System.out.println(array2[i]);
	// 	}
		insertion sel = new insertion(array1.length, array2.length);
		sel.add(array1,array2);
		sel.insert();
		//sel.printArray();
	}
}