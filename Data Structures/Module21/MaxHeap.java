import java.util.*;
class hashNode {
    private String word;
    private int frequency;
    public hashNode(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public int getFrequeny() {
        return frequency;
    }
}
class hashTableOperations {
    MaxHeapAAAAA mx;
    int size;
    hashNode[] hs;
    int count;
    public hashTableOperations() {
        count = 0;
        size = 100;
        hs = new hashNode[size];
    }
    public void insertIntoHashTable(String iKey) {
        int genKey = (int)generateKey(iKey);
        //System.out.println(genKey);
        if(!contains(iKey)) {
            hs[genKey] = new hashNode(iKey,1);
            count++;
        }
        else {
            hs[genKey].setFrequency(hs[genKey].getFrequeny() + 1);
        }
    }
     public void insertIntoHeap() {
        mx = new MaxHeapAAAAA(count);
        for(int i = 0;i < size; i++) {
            if(hs[i] != null) {
                mx.insert(hs[i]);
            }
        }
        mx.print();
      }
    public boolean contains(String temp) {
        int genKey = (int)generateKey(temp);
        if(hs[genKey] != null && hs[genKey].getWord().equals(temp)) {
            return true;
        }
        return false;
    }
    public double generateKey(String string) {
        double sum = 0;
        //int m = string.length();
        for(int z = 0; z < string.length() ; z++) {
            sum = sum + (int)(string.charAt(z)) * Math.pow(31,z);
        }
        return (sum % size);
    }
}
class MaxHeapAAAAA {
    hashNode[] Heap ;
    //private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;
    public MaxHeapAAAAA(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new hashNode[this.maxsize + 1];
        //Heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos) {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }
    private void swap(int fpos,int spos) {
        hashNode tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) { 
            if ( Heap[pos].getFrequeny() < Heap[leftChild(pos)].getFrequeny()  || Heap[pos].getFrequeny() < Heap[rightChild(pos)].getFrequeny()) {
                if (Heap[leftChild(pos)].getFrequeny() > Heap[rightChild(pos)].getFrequeny()) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(hashNode element) {
        if(size == 0) {
            Heap[++size] = element;
        }
        else {
            Heap[++size] = element;
            int current = size;
            while(Heap[current].getFrequeny() > Heap[parent(current)].getFrequeny()) {
                swap(current,parent(current));
                current = parent(current);
                if(current == 1) {
                    break;
                }
            }
        }
    }
    public void print() {
        for (int i = 1; i <= size ; i++ ) {
            System.out.println(Heap[i].getWord()+"-->"+Heap[i].getFrequeny());
            // System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
            //       + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            // System.out.println();
        }
    }
    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }
    public hashNode remove() {
        hashNode popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        maxHeapify(FRONT);
        return popped;
    }
 }
 public class MaxHeap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // int size = Integer.parseInt(input.nextLine());
        hashTableOperations hash = new hashTableOperations();
        String str = input.nextLine();
        String s[] = str.split(" ");
        int q= 0;
        while(q < s.length) {
            hash.insertIntoHashTable(s[q]);
            q++;
        }
        hash.insertIntoHeap();
    }
}