import java.io.*;
import java.util.*;

class Main {
	
	public static int[][] matrix;
	public static boolean[][] visited;
	
	public static int[] dx = new int[]{-1, 0, 1, 0};
	public static int[] dy = new int[]{0, -1, 0, 1};
	
	public static int max = Integer.MIN_VALUE;
	public static int n;
	
	public static int solution() {
		int result = 0;
		for(int k=0; k<=max; k++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(matrix[i][j] <= k || visited[i][j])
						continue;
					dfs(i, j, k);
					cnt++;
				}
			}
			result = Math.max(result, cnt);
		}
		return result;
	}
	
	public static void dfs(int y, int x, int k) {
		visited[y][x] = true;
		for(int i=0; i<4; i++){
			int posY = y + dy[i];
			int posX = x + dx[i];
			if(posX<0 || posX>=n || posY<0 || posY>=n 
				|| visited[posY][posX] || matrix[posY][posX] <= k)
				continue;
			dfs(posY, posX, k);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		for(int i=0; i<n; i++){
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<n; j++){
				matrix[i][j] = Integer.parseInt(temp[j]);
				max = Math.max(max, matrix[i][j]);
			}
		}
		System.out.println(solution());
	}
}