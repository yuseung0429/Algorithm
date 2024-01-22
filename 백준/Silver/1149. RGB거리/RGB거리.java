import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int n, int[] r, int[] g, int[] b) {
		int[][] dp = new int[n][3];
		dp[0][0] = r[0];
		dp[0][1] = g[0];
		dp[0][2] = b[0];
		for(int i=1; i<n; i++) {
			dp[i][0] = r[i] + Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = g[i] + Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = b[i] + Math.min(dp[i-1][0],dp[i-1][1]);
		}
		int result = Integer.MAX_VALUE;
		for(int j=0; j<3; j++)
			if(result > dp[n-1][j])
				result = dp[n-1][j];
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] r = new int[n];
		int[] g = new int[n];
		int[] b = new int[n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			r[i] = Integer.parseInt(temp[0]);
			g[i] = Integer.parseInt(temp[1]);
			b[i] = Integer.parseInt(temp[2]);
		}
		System.out.println(solution(n,r,g,b));
	}
}