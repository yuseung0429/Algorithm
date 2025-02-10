import java.io.*;
import java.util.*;

class Main {
	
	static int[][] matrix;
	static int[] costs;
	
	static int n;
	static int m;
	
	public static int solution() {
		costs[0] = matrix[0][0];
		for(int i=1; i<m; i++) {
			costs[i] = costs[i-1] + matrix[0][i]; 
		}
		
		for (int r=1; r<n; r++) {
			int[] dp = new int[m];
			Arrays.fill(dp, Integer.MIN_VALUE/2);
			
			for (int i=0; i<m; i++) {
				int sum = costs[i];
				for(int j=i; j<m; j++) {
					sum += matrix[r][j];
					dp[j] = Math.max(dp[j], sum);
				}
				sum = costs[i];
				for(int j=i; j>=0; j--) {
					sum += matrix[r][j];
					dp[j] = Math.max(dp[j], sum);
				}
			}
			costs = dp;
		}
		return costs[m-1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		matrix = new int[n][m];
		costs = new int[m];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.println(solution());		
	}
	
}