import java.util.*;
class MyArrayADT {
	int[] arrayADT;
	int index;
	int size;
	public MyArrayADT() {
		size = 10;
		arrayADT = new int[size];
		index = 0;
	}
	public void insert(int element) {
		if(index <= size) {
			index++;
			arrayADT[index] = element;
			heapifyup(index);
		}
		//print();
	}
	public void heapify() {
		for(int i = index/2; i>0 ;i--) {
			heapifydown(i);
		}
	}
	public void modify(int id, int value) {
		arrayADT[id] = value;
		heapifyup(id);
		heapifydown(1);
		//print();
	}
	public void extractMIN() {
		System.out.println(arrayADT[1]);
	}
	public int deleteMIN() {
		int flag = 0;
		if(index > 0) {
			flag = arrayADT[1];
			arrayADT[1] = arrayADT[index];
			index--;
			heapifyup(index);
			heapifydown(1);
			heapify();
		}
		//print();
		return flag;
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
	public void sort() {
		int[] result= new int[index];
		int j;
		int k = index;
		for(j = 0; j < k; j++) {
			//System.out.println(arrayADT[1]);
			result[j] = deleteMIN();
			System.out.print(result[j] + " ");
		}
		//System.out.println(result[j]);
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
	public void print() {
		int i;
		for(i = 1 ; i < index; i++) {
			System.out.print(arrayADT[i]+ " ");
		}
		System.out.println(arrayADT[i]);
	}
}
public class prob2 {
	public static void main(String[] args) {
		MyArrayADT obj = new MyArrayADT();
		String str = "i 15,i 14,i 13,i 12,i 16,i 17,i 18,end";
		String s[] = str.split(",");
		int i = 0;
		while(i < s.length) {
			String s1[] = s[i].split(" ");
			if(s1[0].charAt(0) == 'i') {
				int val = Integer.parseInt(s1[1]);
				obj.insert(val);
			}
			if(s1[0].charAt(0) == 'd') {
				obj.deleteMIN();
			}
			if(s1[0].compareTo("mo") == 0) {
				int index = Integer.parseInt(s1[1]);
				int val = Integer.parseInt(s1[2]);
				obj.modify(index,val);
			}
			if(s1[0].charAt(0) == 'p') {
				obj.print();
			}
			if(s1[0].compareTo("end") == 0) {
				break;
			}
			i++;
		}
		obj.sort();
	}
}