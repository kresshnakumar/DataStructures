import java.util.*;
class MyArrayADT {
	int[] arrayADT;
	int index;
	int size;
	public MyArrayADT() {
		size = 20;
		arrayADT = new int[size];
		index = 0;
	}
	public void insert(int element) {
		if(index <= size) {
			index++;
			arrayADT[index] = element;
			heapifyup(index);
		}
		print();
	}
	
	public void modify(int id, int value) {
		arrayADT[id] = value;
		heapifyup(id);
		heapifydown(1);
		print();
	}
	public void extractMIN() {
		System.out.println(arrayADT[1]);
	}
	public void deleteMIN() {
		if(index > 0) {
			arrayADT[1] = arrayADT[index];
			index--;
			heapifydown(1);
		}
		print();
	}
	public void heapify() {
		for(int i = index/2; i>0 ;i--) {
			heapifydown(i);
		}
	}
	public void heapifyup(int index1) {
		if(index1 > 1) {
			if(arrayADT[index1 / 2] > arrayADT[index1]) {
				int temp = arrayADT[index1 / 2];
				arrayADT[index1 / 2] = arrayADT[index1];
				arrayADT[index1] = temp;
			}
			heapifyup((index1 / 2));
		}
	}
	public void heapifydown(int i) {
		int m;
		if((2*i) <= index) {
			if(((2*i)+1) > index || (arrayADT[2 * i]) <= (arrayADT[(2*1)+1])) {
				m = 2 * i;
			}
			else {
				m = (2 * i) + 1;
			}
			if(arrayADT[i]>arrayADT[m]) {
				int tmp = arrayADT[m];
				arrayADT[m] = arrayADT[i];
				arrayADT[i] = tmp;
				heapifydown(m);
			}
		}
	}
	public int[] print() {
		int[] array3 = new int[index];
		int i;
		for(i = 1 ; i < index; i++) {
			array3[i-1] = arrayADT[i];
			//System.out.print(arrayADT[i]+ " ");
		}
		array3[i-1] = arrayADT[i];
		//System.out.println(arrayADT[i]);
		return array3;
	}
}
public class MinHeap {
	public static void main(String[] args) {
		MyArrayADT obj = new MyArrayADT();
		Scanner input = new Scanner(System.in);
		int range = Integer.parseInt(input.nextLine());
		String str = input.nextLine();
		String s[] = str.split(",");
		int[] array = new int[s.length];
		for(int i = 0; i <s.length;i++) {
			array[i] =Integer.parseInt(s[i]);
		}
		int i = 0;
		while(i < s.length) {
			obj.insert(Integer.parseInt(s[i]));
			i++;
		}
		int[] array2 = obj.print();
		boolean flag = true;
		for(i = 0; i <array2.length;i++) {
			if(array[i] != array2[i]) {
				flag = false;
			}
		}
		if(flag == false) {
			for(i = 0; i <array2.length;i++) {
				System.out.println(array2[i]);
			}
		}
		else {
			System.out.println("True");
		}
	}
}