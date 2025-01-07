import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int k;
	static int[][] matrix;
	static int[][] dp;
	
	public static int solution() {
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[]{k, 1<<k});
		dp[1<<k][k] = 0;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			
			for (int i=0; i<n; i++) {
				if (dp[node[1]|1<<i][i] == -1 || dp[node[1]][node[0]] + matrix[node[0]][i] < dp[node[1]|1<<i][i]) {
					dp[node[1]|1<<i][i] = dp[node[1]][node[0]] + matrix[node[0]][i];
					queue.add(new int[] {i, node[1]|1<<i});
				}
			}
		}
		
		int minCost = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			minCost = Math.min(minCost, dp[(1<<n)-1][i]);
		}
		
		return minCost;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		matrix = new int[n][n];
		dp = new int[1 << n][n];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i=0; i<(1 << n); i++) {
            Arrays.fill(dp[i], -1);
        }
        
		System.out.println(solution());
	}
}
