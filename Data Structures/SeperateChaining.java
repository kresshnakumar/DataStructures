import java.util.*;
class hashNode {
	int word;
	hashNode next;
	public hashNode() {
		word = 0;
		next = null;
	}
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
		size = 10;
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
	public void remove(int element) {
		int genKey = generateKey(element);
		if(hs[genKey] == null) {
			//System.out.println("");
		}
		else {
			hashNode current = hs[genKey];
			hashNode prev = current;
			if((current.getWord() == element) && (current.getNext() == null)) {
				hs[genKey] = null;
				count --;
			}
			else {
				if(current.getWord() == element) {
					hs[genKey] = current.getNext();
					count--;
				}
				else {
					while(current.getNext() != null) {
						prev = current;
						current = current.getNext();
						if(current.getWord()== element) {
							prev.setNext(current.getNext());
							count--;
							break;
						}
					}
				}
			}
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
			System.out.print(i+" : ");
			if(hs[i] != null) {
				hashNode tempoo = hs[i];
				while(tempoo.getNext() != null) {
					System.out.print(tempoo.getWord() + ",");
					tempoo = tempoo.getNext();
				}
				System.out.print(tempoo.getWord());
			}
			System.out.println();
		}
	}
}
public class SeperateChaining {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// int size = Integer.parseInt(input.nextLine());
		hashTableOperations hash = new hashTableOperations();
		String str = input.nextLine();
		String s[] = str.split(",");
		int q= 0;
		while(q < s.length) {
			if(s[q].charAt(0) == 'I') {
				int sum = 0;
				for(int i = 1; i < s[q].length(); i++) {
					int k = (int)s[q].charAt(i) - 48;
					sum = (sum * 10) + k;
				}
				hash.insertIntoHashTable(sum);
			}
			if(s[q].charAt(0) == 'R') {
				int sum = 0;
				for(int i = 1; i < s[q].length(); i++) {
					int k = (int)s[q].charAt(i) - 48;
					sum = (sum * 10)+ k;
				}
				hash.remove(sum);
			}
			q++;
		}
		hash.print();
	}
}