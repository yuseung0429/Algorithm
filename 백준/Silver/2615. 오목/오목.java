
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] matrix;
	static int n = 19;
	
	static boolean[][] rowChecked;
	static boolean[][] colChecked;
	static boolean[][] rightDownChecked;
	static boolean[][] rightUpChecked;
	
	public static void solution() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[j][i] != '0')
					if(check(j,i)) {
						System.out.println(String.valueOf(matrix[j][i]));
						System.out.println((j+1) +" "+ (i+1));
						return;
					}
			}
		}
		System.out.println(0);
	}
	
	public static boolean check(int i, int j) {
		boolean result = false;
		if(!rowChecked[i][j]) result |= rowCheck(i, j, matrix[i][j]);
		if(result) return result;
		if(!colChecked[i][j]) result |= colCheck(i, j, matrix[i][j]);
		if(result) return result;
		if(!rightDownChecked[i][j]) result |= rightDownCheck(i, j, matrix[i][j]);
		if(result) return result;
		if(!rightUpChecked[i][j]) result |= rightUpCheck(i, j, matrix[i][j]);
		return result;
	}
	
	public static boolean rowCheck(int i, int j, char c) {
		int cnt = 1;
		rowChecked[i][j] = true;
		for(int k=1; j+k<n; k++) {
			if(c == matrix[i][j+k]) {
				rowChecked[i][j+k] = true;
				cnt += 1;
			}
			else
				break;
		}
		
		for(int k=1; j-k>=0; k++) {
			if(c == matrix[i][j-k]) {
				rowChecked[i][j-k] = true;
				cnt += 1;
			}
			else
				break;
		}
		if(cnt == 5)
			return true;
		return false;
	}
	
	public static boolean colCheck(int i, int j, char c) {
		int cnt = 1;
		colChecked[i][j] = true;
		for(int k=1; i+k<n; k++) {
			if(c == matrix[i+k][j]) {
				colChecked[i+k][j] = true;
				cnt += 1;
			}
			else
				break;
		}
		
		for(int k=1; i-k>=0; k++) {
			if(c == matrix[i-k][j]) {
				colChecked[i-k][j] = true;
				cnt += 1;
			}
			else
				break;
		}
		if(cnt == 5)
			return true;
		return false;
	}
	
	public static boolean rightDownCheck(int i, int j, char c) {
		int cnt = 1;
		rightDownChecked[i][j] = true;
		for(int k=1; i+k<n && j+k<n; k++) {
			if(c == matrix[i+k][j+k]) {
				rightDownChecked[i+k][j+k] = true;
				cnt += 1;
			}
			else
				break;
		}
		
		for(int k=1; i-k>=0 && j-k>=0; k++) {
			if(c == matrix[i-k][j-k]) {
				rightDownChecked[i-k][j-k] = true;
				cnt += 1;
			}
			else
				break;
		}
		if(cnt == 5)
			return true;
		return false;
	}
	
	public static boolean rightUpCheck(int i, int j, char c) {
		int cnt = 1;
		rightUpChecked[i][j] = true;
		for(int k=1; i-k>=0 && j+k<n; k++) {
			if(c == matrix[i-k][j+k]) {
				rightUpChecked[i-k][j+k] = true;
				cnt += 1;
			}
			else
				break;
		}
		
		for(int k=1; i+k<n && j-k>=0; k++) {
			if(c == matrix[i+k][j-k]) {
				rightUpChecked[i+k][j-k] = true;
				cnt += 1;
			}
			else
				break;
		}
		if(cnt == 5)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		matrix = new char[n][n];
		rowChecked = new boolean[n][n];
		colChecked = new boolean[n][n];
		rightDownChecked = new boolean[n][n];
		rightUpChecked = new boolean[n][n];
		for(int i=0; i<n; i++)
			matrix[i] = br.readLine().replace(" ", "").toCharArray();
		solution();
		br.close();
	}
}