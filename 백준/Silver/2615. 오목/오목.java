
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] matrix;
	static int n = 19;
	static boolean[][][] checked;
	static int[] dx = {0,1,1,1};
	static int[] dy = {1,0,1,-1};
	
	public static void solution() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[j][i] != '0')
					if(check(j, i, matrix[j][i])) {
						System.out.println(String.valueOf(matrix[j][i]));
						System.out.println((j+1) +" "+ (i+1));
						return;
					}
			}
		}
		System.out.println(0);
	}
	
	public static boolean check(int i, int j, char c) {
		for(int k=0; k<4; k++) {
			if(checked[k][i][j])
				continue;
			int cnt = 1;
			checked[k][i][j] = true;
			for(int o=1; ; o++) {
				if(i+dx[k]*o <0 || i+dx[k]*o >=n || j+dy[k]*o<0 || j+dy[k]*o >=n)
					break;
				if(c == matrix[i+dx[k]*o][j+dy[k]*o]) {
					checked[k][i+dx[k]*o][j+dy[k]*o] = true;
					cnt += 1;
				}
				else
					break;
			}
			for(int o=1; ; o++) {
				if(i-dx[k]*o <0 || i-dx[k]*o >=n || j-dy[k]*o<0 || j-dy[k]*o >=n)
					break;
				if(c == matrix[i-dx[k]*o][j-dy[k]*o]) {
					checked[k][i-dx[k]*o][j-dy[k]*o] = true;
					cnt += 1;
				}
				else
					break;
			}
			if(cnt == 5)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		matrix = new char[n][n];
		checked = new boolean[4][n][n];
		for(int i=0; i<n; i++)
			matrix[i] = br.readLine().replace(" ", "").toCharArray();
		solution();
		br.close();
	}
}