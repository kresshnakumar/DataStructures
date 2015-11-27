import java.util.*;
import java.lang.Comparable;
class sortByQuick<E extends Comparable<? super E>> {
    private E array[];
    private int length;
    private int size;
    public sortByQuick(int size) {
        this.size = size;
        array = (E[])new Comparable[size];
    }
    public void sort(E[] myArray) {
        if (myArray == null || myArray.length == 0) {
            return;
        }
        this.array = myArray;
        length = myArray.length;
        quickSort(0, length - 1);
    }
    private void quickSort(int l, int r) {
        int i = l;
        int j = r;
        E pivot = array[getPivotIndex(l,r)];
        while (i <= j) {
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (l < j) {
            quickSort(l, j);
        }
        if (i < r) {
            quickSort(i, r);
        }
    }
    public int getPivotIndex(int l, int r) {
        return (l + (int)Math.random()*(r - l));
    }
    public void print() {
        for(int i = 0; i < size ; i++) {
            System.out.print(array[i] + " ");
        }
    }
    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
public class MyQuickSortGeneric {
    public static void main(String[] krishna){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter size: ");
        int size = Integer.parseInt(inp.nextLine());
        System.out.println("Enter Type: ");
        String ch = inp.nextLine();
        if(ch.charAt(0) == 'I') {
            sortByQuick<Integer> sorter = new sortByQuick<Integer>(size);
            Integer[] input = new Integer[size];
            System.out.println("Enter "+size+ " elements");
            for(int i = 0; i < size ; i++) {
                input[i] = Integer.parseInt(inp.nextLine());
            }
            sorter.sort(input);
            sorter.print();
        }
        else if(ch.charAt(0) == 'C') {
            sortByQuick<Character> sorter = new sortByQuick<Character>(size);
            Character[] input = new Character[size];
            System.out.println("Enter "+size+ " elements");
            for(int i = 0; i < size ; i++) {
                input[i] = inp.nextLine().charAt(0);
            }
            sorter.sort(input);
            sorter.print();
        }
        else if(ch.charAt(0) == 'S') {
            sortByQuick<String> sorter = new sortByQuick<String>(size);
            String[] input = new String[size];
            System.out.println("Enter "+size+ " elements");
            for(int i = 0; i < size ; i++) {
                input[i] = inp.nextLine();
            }
            sorter.sort(input);
            sorter.print();
        }
    }
}