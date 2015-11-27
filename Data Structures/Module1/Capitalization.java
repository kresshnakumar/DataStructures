import java.util.StringTokenizer;
import java.util.Scanner;
public class Capitalization {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = "";
		while(input.hasNext()) {
			text = text + input.nextLine() + "\n";
		}
		char[] ch = new char[text.length()];
		ch = text.toCharArray();
		if((ch[0] >= 97 && ch[0] <= 121)) {
			ch[0] = (char)(ch[0] - 32);
		}
		if(ch[0] == ' ') {
			for(int k = 0; k < text.length() ; k++) {
				if(ch[k] == ' ') {
					continue;
				}
				else if((ch[k] >= 97 && ch[k] <= 121)) {
					ch[k] = (char)(ch[k] - 32);
					break;
				}
				else if(ch[k] >= 65 && ch[k] <=97) {
					break;
				}
			}
		}
		for(int i = 0; i< text.length();  i++) {
			if(ch[i] == '.' || ch[i] == '!' || ch[i] == '?') {
				for(int j = i ; j < text.length(); j++) {
					if(ch[j] == ' ') {
						continue;
					}
					if((ch[j] >= 97 && ch[j] <= 121)) {
						ch[j] = (char)(ch[j] - 32);
						break;
					}
					if(ch[j] >= 65 && ch[j] <=97) {
						break;
					}
				}
			}
		}
		text = new String(ch);
		System.out.println(text);
	}
}