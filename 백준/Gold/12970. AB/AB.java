import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int k;
	
	public static String solution() {
		char[] arr = new char[n];
		Arrays.fill(arr, 'B');
		
		int localK = 0;
		int level = 0;
		
		while(level < n && localK <= k) {
			localK -= level;
			for (int i=n-1; i>=level; i--) {
				if (localK + (n-1)-i == k) {
					arr[i] = 'A';
					return String.valueOf(arr);
				}
			}
			arr[level++] = 'A';
			localK += Math.abs(n-level);
		}
		return "-1";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		System.out.println(solution());
	}
}