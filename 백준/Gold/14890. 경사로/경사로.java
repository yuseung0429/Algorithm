import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int l;
	static int[][] matrix;
	static boolean[] setup;
	
	public static int solution() {
		int result = 0;
		result += getVaildRoadCnt();
		transpose();
		result += getVaildRoadCnt();
		return result;
	}
	
	public static void transpose() {
		int size = n-1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<size; j++)
				swap(i, j, (n-1)-j, (n-1)-i);
			size--;
		}
		
		for(int i=0; i<n/2; i++)
			for(int j=0; j<n; j++)
				swap(i, j, (n-1)-i, j);
	}
	
	public static void swap(int y1, int x1, int y2, int x2) {
		int temp = matrix[y1][x1];
		matrix[y1][x1] = matrix[y2][x2];
		matrix[y2][x2] = temp;
	}
	
	public static int getVaildRoadCnt() {
		int cnt=0;
		for(int i=0; i<n; i++) {
			boolean flag = false;
			initSetup();
			for(int j=0; j<n-1; ) {
				int diff = matrix[i][j] - matrix[i][j+1];
				if(Math.abs(diff) > 1) {
					flag = true;
					break;
				}
				if(Math.abs(diff) == 1) {
					if(diff == 1 && isPutLowerSlope(i, j)) {
						j+=l;
						continue;
					}
					if(diff == -1 && isPutUpperSlope(i, j)) {
						j++;
						continue;
					}
					flag = true;
					break;
				}
				if(Math.abs(diff) == 0)
					j++;
			}
			if(!flag)
				cnt++;
		}
		return cnt;
	}
	
	public static boolean isPutUpperSlope(int i, int j) {
		if(j+1-l<0)
			return false;
		for(int k = j; k>=j+1-l; k--)
			if(setup[k] || (matrix[i][j] != matrix[i][k]))
				return false;
		for(int k = j; k>=j+1-l; k--)
			setup[k] = true;
		return true;
	}
	
	public static boolean isPutLowerSlope(int i, int j) {
		if(j+l >= n)
			return false;
		for(int k = j+1; k<=j+l; k++)
			if(setup[k] || (matrix[i][j+1] != matrix[i][k]))
				return false;
		for(int k = j+1; k<=j+l; k++)
			setup[k] = true;
		return true;
	}
	
	public static void initSetup() {
		Arrays.fill(setup, false);
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
		n = Integer.parseInt(temp[0]);
		l = Integer.parseInt(temp[1]);
		matrix = new int[n][];
		setup = new boolean[n];
		for(int i=0; i<n; i++)
			matrix[i] = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}