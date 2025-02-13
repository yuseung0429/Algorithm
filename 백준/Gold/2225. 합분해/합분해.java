import java.io.*;
import java.util.*;

class Main {
	
	public static long solution(int n, int k) {
		
		long[] temp = null;
		
		long[] currentCounts = new long[n+1];
		long[] nextCounts = new long[n+1];
		
		Arrays.fill(currentCounts, 1);
		
		for (int i=0; i<k-1; i++) {
			for (int j=0; j<=n; j++) {
				for (int m=0; m<=n; m++) {
					if(j+m > n) {
						continue;
					}
					nextCounts[j+m] += currentCounts[j];
					nextCounts[j+m] %= 1000000000;
				}
			}
			temp = currentCounts;
			currentCounts = nextCounts;
			nextCounts = temp;
			Arrays.fill(nextCounts, 0);
		}
		
		return currentCounts[n];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		System.out.println(solution(n, k));
	}
}