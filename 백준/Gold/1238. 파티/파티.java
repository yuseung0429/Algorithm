import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	static int x;
	static int[][] matrix;
	
	public static int solution(){
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++)
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
			
		int result = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			result = Math.max(result, matrix[i][x] + matrix[x][i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		x = Integer.parseInt(temp[2])-1;
		
		matrix = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(i == j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 100000000;
	
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0])-1;
			int b = Integer.parseInt(temp[1])-1;
			int c = Integer.parseInt(temp[2]);
			matrix[a][b] = c;
		}
		
		System.out.println(solution());
	}
}
