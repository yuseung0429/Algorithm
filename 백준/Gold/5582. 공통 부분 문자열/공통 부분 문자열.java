import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(String str1, String str2) {
		int maxValue = 0;
		
		int[] current = new int[str1.length()+1];
		int[] next = new int[str1.length()+1];
		
		for (int i=0; i<str2.length(); i++) {
			for (int j=0; j<str1.length(); j++) {
				if(str2.charAt(i) != str1.charAt(j)) {
					next[j+1] = 0;
					continue;
				}
				next[j+1] = current[j]+1;
				maxValue = Math.max(maxValue, next[j+1]);
			}
			int[] temp = current;
			current = next;
			next = temp;
		}
		
		return maxValue;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		System.out.println(solution(str1, str2));
	}
}