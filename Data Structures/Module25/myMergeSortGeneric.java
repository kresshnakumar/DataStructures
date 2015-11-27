import java.util.*;
import java.lang.Comparable;
class MyMergeSort<E extends Comparable<? super E>> {
    private E[] array;
    private E[] tempMergArr;
    private int size;
    int k;
    public MyMergeSort(int size) {
        this.size = size;
        k = 0;
        array = (E[])new Comparable[size];
        tempMergArr = (E[])new Comparable[size];
    }
    public void insert(E num) {
        array[k] = num;
        k++;
    }
    public void print() {
        for(int i = 0 ; i < size ; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public void doMergeSort(int l, int r) {
        if (l < r) {
            int middle = l + (r - l) / 2;
            doMergeSort(l, middle);
            doMergeSort(middle + 1, r);
            mergeParts(l, middle, r);
        }
    }
    private void mergeParts(int l, int middle, int r) {
        for (int i = l; i <= r; i++) {
            tempMergArr[i] = array[i];
        }
        int i = l;
        int j = middle + 1;
        int k = l;
        while (i <= middle && j <= r) {
            if (tempMergArr[i].compareTo(tempMergArr[j]) == 0 || tempMergArr[i].compareTo(tempMergArr[j]) < 0 ) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
public class myMergeSortGeneric {
    public static void main(String[] krish){
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        //int[] myArray = new int[size];
        MyMergeSort<String> mms = new MyMergeSort<String>(size);
        for(int i = 0; i < size ; i++) {
            //myArray[i] = Integer.parseInt(input.nextLine());
            mms.insert(input.nextLine());
        }
        mms.doMergeSort(0, size - 1);
        mms.print();
    }
}
