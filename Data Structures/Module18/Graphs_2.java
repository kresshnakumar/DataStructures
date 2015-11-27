import java.util.*;
public class Graphs_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = Integer.parseInt(input.nextLine());
		int[][] array = new int[size][size];
		int count = 0;
		for(int i = 0; i < size; i++) {
			String string = input.nextLine();
			String[] str = string.split(" ");
			for(int j = 0 ; j < size ; j++) {
				array[i][j] = Integer.parseInt(str[j]);
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = i ; j < size ; j++) {
				if(array[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}