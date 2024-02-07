import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int result;
	static int[][] matrix;
	
	public static void rec(int step) {
		if(step == n) {
			result++;
			return;
		}
		for(int i=0; i<n; i++)
			if(matrix[step][i] == 0) {
				setMatrix(step, i, true);
				rec(step+1);
				setMatrix(step, i, false);
			}
	}
	
	public static void setMatrix(int step, int i, boolean flag) {
		int start = step+1;
		while(start < n) matrix[start++][i] += (flag) ? 1 : -1;
		int k=1;
		while(step+k < n && i-k >=0) matrix[step+k][i-k++] += (flag) ? 1 : -1;
		k=1;
		while(step+k < n && i+k < n) matrix[step+k][i+k++] += (flag) ? 1 : -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		rec(0);
		System.out.println(result);
	}
}