import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int n, int m, int[][] matrix) {
		int maxValue = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			maxValue = Math.max(maxValue, matrix[i][0]);
		}
		
		for (int i=0; i<m; i++) {
			maxValue = Math.max(maxValue, matrix[0][i]);
		}
		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				if(matrix[i][j] == 0) {
					continue;
				}
				matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]))+1;
				maxValue = Math.max(maxValue, matrix[i][j]);
			}
		}
		
		return maxValue * maxValue;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[][] matrix = new int[n][m];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split("");
			for (int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		System.out.println(solution(n, m, matrix));
	}
}