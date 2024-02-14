import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static char[][] matrix;
	static BufferedWriter bw;
	public static void solution() throws IOException {
		rec(0, 0, n);
	}
	public static void rec(int i, int j, int num) throws IOException {
		if(num == 1) {
			bw.append(matrix[i][j]);
			return;
		}
		char value = matrix[i][j];
		for(int k=i; k<i+num; k++)
			for(int l=j; l<j+num; l++) {
				if(matrix[k][l] != value) {
					int next = num/2;
					bw.append("(");
					rec(i, j, next);
					rec(i, j+next, next);
					rec(i+next, j, next);
					rec(i+next, j+next, next);
					bw.append(")");
					return;
				}
			}
		bw.append(value);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][];
		for(int i=0; i<n; i++)
			matrix[i] = br.readLine().toCharArray();
		solution();
		bw.flush();
	}
}
