import java.io.*;
import java.util.*;

class Main {
	static int H;
	static int W;
	static boolean[][] matrix;
	
	public static int solution() {
		int totalCnt = 0;
		
		for (int i=H-1; i>=0; i--) {
			int localCnt = 0;
			boolean flag = false;
			
			for (int j=0; j<W; j++) {
				if (matrix[i][j] && !flag) {
					flag = true;
					continue;
				}
				
				if (!matrix[i][j] && flag) {
					localCnt++;
					continue;
				}
				
				if (matrix[i][j] && flag) {
					totalCnt += localCnt;
					localCnt = 0;
				}

			}
		}
		
		return totalCnt;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for (int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] temp = convert(br.readLine().split(" "));
		H = temp[0];
		W = temp[1];
		matrix = new boolean[H][W];
		
		temp = convert(br.readLine().split(" "));
		
		for (int i=0; i<temp.length; i++)
			for(int j=0; j<temp[i]; j++)
				matrix[H-1-j][i] = true;
		
		System.out.println(solution());
	}
}
