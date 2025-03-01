import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	static int k;
	static boolean[][] matrix;
	static int[][][][] visited;
	
	static int DAY = 0;
	static int NIGHT = 1;
	
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, -1, 0, 1};
	
	public static int solution() {
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[]{0, 0, 0, DAY, 1});
		visited[0][0][0][DAY] = 1;
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			
			int destoryCnt = node[2];
			int clock = node[3];
			int time = node[4];
			
			if(node[0] == n-1 && node[1] == m-1) {
				return time;
			}
			
			if (visited[node[0]][node[1]][destoryCnt][1-clock] > time+1) {
				queue.add(new int[] {node[0], node[1], destoryCnt, 1-clock, time+1});
				visited[node[0]][node[1]][destoryCnt][1-clock] = time+1;
			}
			
			for (int i=0; i<4; i++) {
				int y = node[0] + dy[i];
				int x = node[1] + dx[i];
				
				if (y<0 || y>=n || x<0 || x>=m) {
					continue;
				}
				
				if (matrix[y][x] && clock == DAY && destoryCnt < k && visited[y][x][destoryCnt+1][1-clock] > time+1) {
					queue.add(new int[]{y, x, destoryCnt+1, 1-clock, time+1});
					visited[y][x][destoryCnt+1][1-clock] = time+1;
					continue;
				}
				
				if (!matrix[y][x] && visited[y][x][destoryCnt][1-clock] > time+1){
					queue.add(new int[] {y, x, destoryCnt, 1-clock, time+1});
					visited[y][x][destoryCnt][1-clock] = time+1;
					continue;
				} 
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		
		matrix = new boolean[n][m];
		visited = new int[n][m][k+1][2];

		for (int i=0; i<n; i++) {
			String line = br.readLine();
			for (int j=0; j<m; j++) {
				matrix[i][j] = (line.charAt(j) == '0') ? false : true;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				for (int l=0; l<=k; l++) {
					Arrays.fill(visited[i][j][l], Integer.MAX_VALUE);
				}
			}
		}
		
		System.out.println(solution());
	}
}
