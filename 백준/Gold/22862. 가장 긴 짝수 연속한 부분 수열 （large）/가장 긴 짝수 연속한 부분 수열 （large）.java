import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int[] arr, int k) {
		int start = 0;
		int end = 0;
		
		int length = 0;
		int chance = k;

		int max = 0;
		
		while (start < arr.length) {
			if (arr[start] % 2 == 0) {
				start++;
				length++;
				max = Math.max(max, length);
			} else {
				if (chance > 0) {
					start++;
					chance--;
				} else {
					if(arr[end++] % 2 == 0) {
						length--;
					} else {
						chance++;
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[] arr = new int[n];
		
		temp = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		System.out.println(solution(arr, k));
	}
}