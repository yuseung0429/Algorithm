import java.io.*;
import java.util.*;

class Main {
	
	public static String solution(int[] arr, int max) {
		StringBuilder sb = new StringBuilder();
		
		int[][] matrix = new int[max+1][3];
		
		matrix[1][0] = 1;
		
		matrix[2][0] = 1;
		matrix[2][1] = 1;
		
		matrix[3][0] = 2;
		matrix[3][2] = 1;
		
		for(int i=4; i<=max; i++) {
			matrix[i][0] = matrix[i-1][0] + matrix[i-1][1] + matrix[i-1][2];
			matrix[i][1] = matrix[i-2][1] + matrix[i-2][2];
			matrix[i][2] = matrix[i-3][2];
		}
		
		for(int value : arr) {
			sb.append(matrix[value][0] + matrix[value][1] + matrix[value][2]).append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		} 
		System.out.println(solution(arr, max));
	}
	
}