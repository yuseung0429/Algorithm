import java.io.*;
import java.util.*;

class Main {
	static int row;
	static int col;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static String solution(int[][] oMatrix, int[][] cMatrix) {
		int startY = -1;
		int startX = -1;
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				cMatrix[i][j] -= oMatrix[i][j];
				if(startY == -1 && cMatrix[i][j] != 0) {
					startY = i;
					startX = j;
				}
			} 
		}
		
		if(startY == -1) { 
			return "YES";
		}

		bfs(startY, startX, oMatrix, cMatrix);
	
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (cMatrix[i][j] != 0) {
					return "NO";
				}
			}
		}
		return "YES";	
	}
	
	public static void bfs(int startY, int startX, int[][] oMatrix, int[][] cMatrix) {

		boolean[][] visited = new boolean[row][col];
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		
		queue.add(new int[]{startY, startX});
		visited[startY][startX] = true;
		
		int value = oMatrix[startY][startX];
		int diff = cMatrix[startY][startX];
		
		cMatrix[startY][startX] -= diff;
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int i=0; i<4; i++) {
				int y = node[0] + dy[i];
				int x = node[1] + dx[i];
				if(y<0 || y>=row || x<0 || x>=col || visited[y][x]) {
					continue;
				}
				if(oMatrix[y][x] == value) {
					queue.add(new int[] {y, x});
					visited[y][x] = true;
					cMatrix[y][x] -= diff;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		row = Integer.parseInt(temp[0]);
		col = Integer.parseInt(temp[1]);
		
		int[][] oMatrix = new int[row][col];
		int[][] cMatrix = new int[row][col];
		
		for(int i=0; i<row; i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<col; j++) {
				oMatrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<row; i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<col; j++) {
				cMatrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.println(solution(oMatrix, cMatrix));
	}
}