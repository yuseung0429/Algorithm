import java.util.*;
import java.io.*;

class Main {
	
	static int n;
	static int t;
	
	static int[][] exams;
	
	public static int solution() {
		int[] dp = new int[t+1];
		for (int i=0; i<n; i++) {
			int k = exams[i][0];
			int s = exams[i][1];
			for (int j=t-k; j>=0; j--) {
				dp[j+k] = Math.max(dp[j+k], dp[j]+s);
			}
		}
		return dp[t];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		t = Integer.parseInt(temp[1]);
		
		exams = new int[n][2];
		
		for (int i=0; i<exams.length; i++) {
			temp = br.readLine().split(" ");
			exams[i][0] = Integer.parseInt(temp[0]);
			exams[i][1] = Integer.parseInt(temp[1]);
		}
		
		System.out.println(solution());
	}
}