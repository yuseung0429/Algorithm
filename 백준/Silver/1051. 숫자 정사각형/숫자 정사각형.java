import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int[][] matrix) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		int size = Math.min(nrow, ncol);
		while(true) {
			for(int i=0; i<=nrow-size; i++)
				for(int j=0; j<=ncol-size; j++)
					if(vaildate(matrix, i, j, size))
						return size*size;
			size--;
			if(size == 0)
				return 1;
		}
	}
	public static boolean vaildate(int[][] matrix, int i, int j, int size) {
		int temp = matrix[i][j];
		if(temp != matrix[i+size-1][j] || temp != matrix[i][j+size-1] || temp != matrix[i+size-1][j+size-1])
			return false;
		return true;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
			
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int nrow = Integer.parseInt(temp[0]);
		int[][] matrix = new int[nrow][];
		for(int i=0; i<nrow; i++)
			matrix[i] = convert(br.readLine().split(""));
		System.out.println(solution(matrix));
	}
}