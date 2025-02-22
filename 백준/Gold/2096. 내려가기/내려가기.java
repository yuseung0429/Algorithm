import java.io.*;
import java.util.*;

class Main {
	
	public static void solution(int[][] matrix, int n) {
		int[][] dp = new int[2][3];
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<3; j++) {
				dp[i][j] = matrix[0][j];
			}
		}
		
		for (int i=1; i<n; i++) {
			int[] prevMax = dp[0].clone();
			int[] prevMin = dp[1].clone();
			
			dp[0][0] = matrix[i][0] + Math.max(prevMax[0], prevMax[1]);
			dp[0][1] = matrix[i][1] + Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
			dp[0][2] = matrix[i][2] + Math.max(prevMax[1], prevMax[2]);
			
			dp[1][0] = matrix[i][0] + Math.min(prevMin[0], prevMin[1]);
			dp[1][1] = matrix[i][1] + Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
			dp[1][2] = matrix[i][2] + Math.min(prevMin[1], prevMin[2]);
		}
		
		System.out.print(Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])));
		System.out.print(" ");
		System.out.print(Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])));
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