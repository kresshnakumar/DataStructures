import java.util.*;
class hashNode {
	private int word;
	private hashNode next;
	public hashNode(int word, hashNode next) {
		this.word = word;
		this.next = next;
	}
	public void setWord(int word) {
		this.word = word;
	}
	public int getWord() {
		return word;
	}
	public void setNext(hashNode next) {
		this.next = next;
	}
	public hashNode getNext() {
		return next;
	}
}
class hashTableOperations {
	int size;
	hashNode[] hs;
	int count;
	public hashTableOperations() {
		count = 0;
		size = 100;
		hs = new hashNode[size];
	}
	public void insertIntoHashTable(int iKey) {
		int genKey = generateKey(iKey);
		hashNode node = new hashNode(iKey,null);
		if(hs[genKey] == null) {
			hs[genKey] = node;
			count++;
		}
		else {
			hashNode tempo = hs[genKey];
			while(tempo.getNext() != null) {
				tempo = tempo.getNext();
			}
			tempo.setNext(node);
		}
	}
	public boolean contains(int temp) {
		int genKey =  generateKey(temp);
		if(hs[genKey] != null && (hs[genKey].getWord() == temp )) {
			return true;
		}
		return false;
	}
	public int generateKey(int sum) {
		return (sum % size);
	}
	public void print() {
		int i;
		for(i = 0 ; i< size; i++) {
			if(hs[i] != null) {
				hashNode tempoo = hs[i];
				while(tempoo.getNext() != null) {
					System.out.print(hs[i].getWord() + " ");
					tempoo = tempoo.getNext();
				}
				System.out.println(tempoo.getWord());
			}
		}
	}
}
public class SeperateChaining {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// int size = Integer.parseInt(input.nextLine());
		hashTableOperations hash = new hashTableOperations();
		String str = input.nextLine();
		String s[] = str.split(" ");
		int q= 0;
		while(q < s.length) {
			hash.insertIntoHashTable(Integer.parseInt(s[q]));
			q++;
		}
		hash.print();
	}
}