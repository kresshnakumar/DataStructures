import java.util.*;
class sortByQuick {
    private int array[];
    int[] array1;
    int[] array2;
    private int length;
    private int size;
    public sortByQuick(int size) {
     this.size = size;
        array1 = new int[1];
        array2 = new int[1];
        array = new int[size];
    }
    public void sort(int[] inputArr,int pivot) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1,pivot);
    }
    private void quickSort(int l, int r,int pivot) {
        int i = l;
        int j = r;
        //int pivot = array[getPivotIndex(l,r)];
        while (i <= j) {
            while (array[i] < pivot) {
                array1 = Arrays.copyOf(array1,array1.length+1);
                array1[i] = array[i];
                
                i++;
            }
            while (array[j] > pivot) {
                array2 = Arrays.copyOf(array2,array2.length+1);
                array2[i] = array[j];
                
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // if (l < j) {
        //     quickSort(r, j);
        // }
        // if (i < r) {
        //     quickSort(i, r);
        // }
    }
    public int getPivotIndex(int l, int r) {
        return ((l+r)/2);
    }
    public void print() {
        for(int i = 0; i < array1.length ;i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < array2.length ;i++) {
            System.out.print(array2[i] + " ");
        }
    }
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
public class MyQuickSort {
    public static void main(String a[]){
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String[] st1 = str1.split(",");
        int[] array1 = new int[st1.length];
        int k = 0;
        while(k < st1.length) {
            array1[k] = Integer.parseInt(st1[k]);
            k++;
        }
        int pivot = Integer.parseInt(input.nextLine());
        sortByQuick sorter = new sortByQuick(array1.length);
        sorter.sort(array1,pivot);
        sorter.print();

    }
}