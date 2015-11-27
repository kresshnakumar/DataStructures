import java.util.*;
class MergeOperations {
    private int[] array;
    private int[] tempMergArr;
    private int size;
    int k;
    public MergeOperations(int size) {
        this.size = size;
        k = 0;
        array = new int[size];
        tempMergArr = new int[size];
    }
    public void insert(int num) {
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
        int j = middle + 1;
        int i = l;
        int k = l;
        while (i <= middle && j <= r) {
            if (tempMergArr[i] <= tempMergArr[j]) {
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
            i++;
            k++;
        }
    }
}
public class myMergeSortNew {
    public static void main(String[] krish){
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        MergeOperations mms = new MergeOperations(size);
        for(int i = 0; i < size ; i++) {
            mms.insert(Integer.parseInt(input.nextLine()));
        }
        mms.doMergeSort(0, size - 1);
        mms.print();
    }
}
