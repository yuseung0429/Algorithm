import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int edge = Integer.parseInt(temp[1]);
		matrix = new boolean[n+1][n+1];
		
		for(int i=0; i<edge; i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			matrix[start][end] = true; 
		}
		
		for(int i=1; i<n+1; i++)
			for(int j=1; j<n+1; j++)
				for(int k=1; k<n+1; k++)
					matrix[j][k] = matrix[j][k] || (matrix[j][i] && matrix[i][k]);
		
		int problem = Integer.parseInt(br.readLine());
		for(int i=0; i<problem; i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			if(matrix[start][end])
				sb.append("-1\n");
			else if(matrix[end][start])
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb.toString());
	}
}