import java.io.*;
import java.util.*;

class Main {
	
	static char[] arr;
	static int k;
	static int[] countArray = new int[(int)('z'-'a')+1];
	static int maxLength;
	static int useCount;
	static int length;
	static int start;
	static int end;
	
	public static int solution() {
		while (end < arr.length) {
			if (useCount < k) {
				append();
			} else if (useCount > k) {
				remove();
			} else {
				if (countArray[arr[end]-'a'] == 0) {
					remove();
				} else {
					append();
				}
			}
		}
		return maxLength;
	}
	
	public static void append() {
		if(countArray[arr[end]-'a'] == 0) {
			useCount++;	
		} 
		countArray[arr[end]-'a']++;
		length++;
		end++;
		maxLength = Math.max(maxLength, length);
	};
	
	public static void remove() {
		countArray[arr[start]-'a'] -= 1;
		if (countArray[arr[start]-'a'] == 0) {
			useCount--;
		}
		length--;
		start++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		System.out.println(solution());
	}
}