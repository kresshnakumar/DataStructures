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
	MaxHeapOp mx = new MaxHeapOp();
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
		if(!contains(iKey)) {
			hs[genKey] = new hashNode(iKey,1);
			count++;
		}
		else {
			hs[genKey].setFrequency(hs[genKey].getFrequeny() + 1);
		}
	}
	 public void insertIntoHeap() {
      	for(int i = 0;i < size; i++) {
      		if(hs[i] != null) {
      			mx.insert(hs[i]);
      		}
      	}
      	mx.display();
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
		for(int z = 0; z < string.length() ; z++) {
			sum = sum + (int)(string.charAt(z)) * Math.pow(31,z);
		}
		return (sum % size);
	}
}
class MaxHeapOp {
	int i;
	hashNode[] heapArray ;
	int size;
	int current;
	int front;
	public MaxHeapOp() {
		front = 0;
		current= 0;
		i = 0;
		size = 1;
		heapArray = new hashNode[size];
	}
	public int parent(int position) {
		return (position-1)/2;
	}
	public int left(int position) {
		return position*2+1;
	}
	public int right(int position) {
		return (position*2)+2;
	}
	public void swap(int felement,int selement) {
		hashNode temp;
		temp = heapArray[felement];
		heapArray[felement] = heapArray[selement];
		heapArray[selement] = temp;
	}
	
	public void insert(hashNode element) {
		if(size == 1) {
			heapArray[i] = element;
			size++;
			heapArray = Arrays.copyOf(heapArray,size);
			i++;
		}
		else {
			heapArray[i] = element;
			current = i;
			size++;
			heapArray = Arrays.copyOf(heapArray,size);
			while((heapArray[current]).getFrequeny() > (heapArray[parent(current)]).getFrequeny()) {
				swap(current,parent(current));
				current = parent(current);
			}
			i++;
		}
		//display();
	}
	public void heapify(int position) {
	    int left, r, min;	
	    hashNode tmp;
		left = left(position);  
		r = right(position);   
	  	if(left < (size-1) && (heapArray[left].getFrequeny()>(heapArray[position]).getFrequeny())) {
	  		min = left;
	  	}  
	  	else {
	  		min = position;
	  	}
	  	if(r < (size-1) && heapArray[r].getFrequeny() > heapArray[min].getFrequeny()) {
	  		min = r;
	  	}
	  	if(min != position) {
      		tmp = heapArray[position]; 
      		heapArray[position] = heapArray[min];
      		heapArray[min] = tmp;
      		heapify(min);
	    }
    }
	public hashNode delete() {
    	hashNode popped = heapArray[front];
    	//System.out.println(popped.getWord());
        hashNode temp = heapArray[size-2];
        heapArray[front] = temp;
        size--;
        heapArray = Arrays.copyOf(heapArray,size);
        heapify(front);
        i--;
        return popped;
    }
    public void display() {
    	//System.out.println("-----------------"+heapArray.length);
    	int k = heapArray.length;
        for (int i = 1; i < k; i++ ) {
    		hashNode ele = delete();
    		System.out.println(ele.getWord()+"--->"+ele.getFrequeny());
        }
    }
}
public class myHashTableNew {
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
		//hash.print();
		hash.insertIntoHeap();
	}
}