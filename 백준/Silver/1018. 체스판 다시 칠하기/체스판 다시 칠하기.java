import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] wfirst = new boolean[8][8];
	static boolean[][] bfirst = new boolean[8][8];
	public static int solution(boolean[][] matrix) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		int min = 64;
		for(int i=0; i<=nrow-8; i++)
			for(int j=0; j<=ncol-8; j++) {
				int a = compare(wfirst, matrix, i, j);
				int b = compare(bfirst, matrix, i, j);
				if(min > Math.min(a, b))
					min = Math.min(a, b);					
			}
		return min;
	}
	
	public static int compare(boolean[][] base, boolean[][] target, int x, int y) {
		int count = 0;
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				if(base[i][j] != target[i+x][j+y])
					count++;
		return count;
	}
	
	public static void init() {
		boolean flag = true;
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++) {
				wfirst[i][j] = flag;
				bfirst[i][j] = !flag;
				flag = !flag;
			}
			flag = !flag;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		init();
		int nrow = Integer.parseInt(temp[0]);
		int ncol = Integer.parseInt(temp[1]);
		boolean[][] matrix = new boolean[nrow][ncol];
		for(int i=0; i<nrow; i++)
		{
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<arr.length; j++)
				matrix[i][j] = (arr[j]=='W') ? true : false;
		}
		System.out.println(solution(matrix));
	}
}
