import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int m;
	static int n;
	static int[][] matrix;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dp;
	
	public static int solution() {
		return dfs(0,0);
	}
	
	public static int dfs(int posY, int posX) {
		if(posY == m-1 && posX == n-1) {
			return 1;
		}
		if(matrix[posY][posX] <= matrix[m-1][n-1])
			return 0;
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int y = posY + dy[i];
			int x = posX + dx[i];
			if(y<0||y>=m||x<0||x>=n||(matrix[posY][posX] <= matrix[y][x]))
				continue;
			if(dp[y][x] != Integer.MIN_VALUE) {
				cnt += dp[y][x];
			}
			else
				cnt += dfs(y,x);
		}
		dp[posY][posX] = cnt;
		return dp[posY][posX];
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = convert(br.readLine().split(" "));
		m = arr[0];
		n = arr[1];
		matrix = new int[m][];
		dp = new int[m][n];
		for(int i=0; i<m; i++) {
			matrix[i] = convert(br.readLine().split(" "));
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
			
		System.out.println(solution());
	}
}
