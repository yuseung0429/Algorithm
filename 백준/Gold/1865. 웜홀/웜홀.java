import java.io.*;
import java.util.*;

class Main {
	
	public static String solution(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				for (int k=0; k<matrix.length; k++) {
					matrix[k][j] = Math.min(matrix[k][j], matrix[k][i] + matrix[i][j]);
				}
			}
		}
		
		for (int i=0; i<matrix.length; i++) {
			if (matrix[i][i] < 0) {
				return "YES";
			}
		}
		return "NO";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			int[][] matrix = new int[n][n];
			for (int j=0; j<n; j++) {
				Arrays.fill(matrix[j], Integer.MAX_VALUE/4);
			}
			
			for (int j=0; j<m; j++) {
				temp = br.readLine().split(" ");
				int v1 = Integer.parseInt(temp[0])-1;
				int v2 = Integer.parseInt(temp[1])-1;
				int cost = Integer.parseInt(temp[2]);
				matrix[v1][v2] = Math.min(matrix[v1][v2], cost);
				matrix[v2][v1] = Math.min(matrix[v1][v2], cost);
			}
			for (int j=0; j<w; j++) {
				temp = br.readLine().split(" ");
				int v1 = Integer.parseInt(temp[0])-1;
				int v2 = Integer.parseInt(temp[1])-1;
				int cost = Integer.parseInt(temp[2]);
				matrix[v1][v2] = -cost;
			}
			sb.append(solution(matrix)).append("\n");
		}
		System.out.println(sb);
	}
}
