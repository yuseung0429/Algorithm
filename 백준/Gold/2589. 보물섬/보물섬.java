import java.io.*;
import java.util.*;

class Main {
	static int row;
	static int col;
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, -1, 0, 1};
	
	static char[][] matrix;
	static int maxDistance;
	
	public static int solution() {
		for (int i=0; i<col; i++) {
			for (int j=0; j<row; j++) {
				if (matrix[i][j] == 'W') {
					continue;
				}
				bfs(i, j);
			}
		}
		return maxDistance;
	}
	
	public static void bfs(int c, int r) {
		boolean[][] visited = new boolean[col][row];
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[]{c, r, 0});
		visited[c][r] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			maxDistance = Math.max(maxDistance, node[2]);
			for (int i=0; i<4; i++) {
				int y = node[0] + dy[i];
				int x = node[1] + dx[i];
				if(x < 0 || x >= row || y < 0 || y>= col || visited[y][x] || matrix[y][x] == 'W') {
					continue;
				}
				queue.add(new int[]{y, x, node[2]+1});
				visited[y][x] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		col = Integer.parseInt(temp[0]);
		row = Integer.parseInt(temp[1]);
		matrix = new char[col][];
		for (int i=0; i<col; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		System.out.println(solution());
	}
}