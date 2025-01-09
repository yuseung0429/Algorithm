import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int k, char[] arr) {
	
		int start = 0;
		int end = 0;
		
		int count = 0;
		int[] counter = new int['z'-'a'+1];
		
		int maxLength = 0;
		
		counter[arr[end]-'a']++;
		count++;
		
		while (++end < arr.length) {
			
			if (counter[arr[end]-'a']++ == 0) {
				count++;
			}
			
			while (count > k && start < end) {
				if (--counter[arr[start++]-'a'] == 0) {
					count--;
				}
			}
			
			maxLength = Math.max(maxLength, end - start + 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		System.out.println(solution(k, arr));
	}
}
