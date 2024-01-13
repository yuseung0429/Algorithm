import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(boolean[][] matrix) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		int count = 0;
		for(int i=0; i<nrow; i++)
			for(int j=0; j<ncol; j++)
				if(matrix[i][j]) {
					search(matrix, i, j);
					count++;
				}
		return count;
	}
	public static void search(boolean[][] matrix, int i, int j) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		if(i>=nrow || i<0 || j>=ncol || j<0 || matrix[i][j] == false)
			return;
		matrix[i][j] = false;
		search(matrix, i, j+1);
		search(matrix, i, j-1);
		search(matrix, i+1, j);
		search(matrix, i-1, j);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean[][][] matrixs = new boolean[t][][];
		for(int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int ncol = Integer.parseInt(temp[0]);
			int nrow = Integer.parseInt(temp[1]);
			int n = Integer.parseInt(temp[2]);
			matrixs[i] = new boolean[nrow][ncol];
			for(int j=0; j<n; j++) {
				String[] pos = br.readLine().split(" ");
				int x = Integer.parseInt(pos[0]);
				int y = Integer.parseInt(pos[1]);
				matrixs[i][y][x] = true;
			}
		}
		for(int i=0; i<t; i++)
			System.out.println(solution(matrixs[i]));
	}
}