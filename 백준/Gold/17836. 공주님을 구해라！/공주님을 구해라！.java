import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	static int t;
	static int[][] matrix;
	
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, -1, 0, 1};
	
	public static String solution() {
		boolean[][][] visited = new boolean[2][n][m];
		
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		
		queue.addLast(new int[] {0, 0, 0, 0});
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			
			int time = node[2];
			int weapon = node[3];
			
			if (time > t) {
				return "Fail";
			}
			
			if (node[0] == n-1 && node[1] == m-1) {
				return String.valueOf(time);
			}
			
			if (matrix[node[0]][node[1]] == 2) {
				weapon = 1;
			}
			
			for (int i=0; i<4; i++) {
				int y = node[0] + dy[i];
				int x = node[1] + dx[i];
				
				if (y<0 || y>=n || x<0 || x>=m || visited[weapon][y][x]) {
					continue;
				}
				
				if (weapon == 0 && matrix[y][x] == 1) {
					continue;
				}
				
				queue.addLast(new int[]{y, x, time+1, weapon});
				visited[weapon][y][x] = true;
			}
		}
		return "Fail";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		t = Integer.parseInt(temp[2]);
		
		matrix = new int[n][m];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
        
		System.out.println(solution());
	}
}