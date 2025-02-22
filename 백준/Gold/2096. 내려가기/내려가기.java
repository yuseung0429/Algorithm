import java.io.*;
import java.util.*;

class Main {
	
	public static void solution(int[][] matrix, int n) {
		int[][][] dp = new int[2][n][3];
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<3; j++) {
				dp[i][0][j] = matrix[0][j];
			}
		}
		
		for (int i=1; i<n; i++) {
			dp[0][i][0] = matrix[i][0] + Math.max(dp[0][i-1][0], dp[0][i-1][1]);
			dp[0][i][1] = matrix[i][1] + Math.max(dp[0][i-1][0], Math.max(dp[0][i-1][1], dp[0][i-1][2]));
			dp[0][i][2] = matrix[i][2] + Math.max(dp[0][i-1][1], dp[0][i-1][2]);
			
			dp[1][i][0] = matrix[i][0] + Math.min(dp[1][i-1][0], dp[1][i-1][1]);
			dp[1][i][1] = matrix[i][1] + Math.min(dp[1][i-1][0], Math.min(dp[1][i-1][1], dp[1][i-1][2]));
			dp[1][i][2] = matrix[i][2] + Math.min(dp[1][i-1][1], dp[1][i-1][2]);
		}
		
		System.out.print(Math.max(dp[0][n-1][0], Math.max(dp[0][n-1][1], dp[0][n-1][2])));
		System.out.print(" ");
		System.out.print(Math.min(dp[1][n-1][0], Math.min(dp[1][n-1][1], dp[1][n-1][2])));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][3];
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j=0; j<3; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		solution(matrix, n);
	}
}