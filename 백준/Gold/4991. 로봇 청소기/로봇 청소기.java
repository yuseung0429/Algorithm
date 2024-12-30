import java.io.*;
import java.util.*;

class Main {
	
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, -1, 0, 1};
	
	static char[][] matrix;
	static HashMap<Integer, Integer> searchNodeIndex;
	static ArrayList<int[]>[] nodeCosts;
	static int minCost;
	static int maxDepth;
	
	public static int solution(int row, int col) {
		int startX = 0;
		int startY = 0;
		searchNodeIndex = new HashMap<>();
		int searchNodeCount = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				switch(matrix[i][j]) {
				case 'o':
					startX = j;
					startY = i;
				case '*':
					searchNodeIndex.put(i*100+j, searchNodeCount++);
				}
			}
		}
		
		nodeCosts = new ArrayList[searchNodeCount];
		for (int i=0; i<searchNodeCount; i++) {
			nodeCosts[i] = new ArrayList<int[]>();
		}
		
		for (int key : searchNodeIndex.keySet()) {
			bfs(row, col, searchNodeIndex.get(key), key/100, key%100);
		}
		
		int startIdx = searchNodeIndex.get(startY*100+startX);
		minCost = Integer.MAX_VALUE;
		maxDepth = searchNodeCount;
		
		boolean[] check = new boolean[searchNodeCount];
		check[startIdx] = true;
		
		rec(check, 0, startIdx, 1);
		
		if(minCost == Integer.MAX_VALUE) {
			return -1;
		}
		
		return minCost;
	}
	
	public static void bfs(int row, int col, int startIdx, int startY, int startX) {
		boolean[][] visited = new boolean[row][col];
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.addLast(new int[]{startY, startX, 0});
		visited[startY][startX] = true;
		
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			for (int i=0; i<4; i++) {
				int y = node[0] + dy[i];
				int x = node[1] + dx[i];
				if(y<0 || y>=row || x<0 || x>=col || visited[y][x] || matrix[y][x] == 'x') {
					continue;
				}
				if(matrix[y][x] == 'o' || matrix[y][x] == '*') {
					int idx = searchNodeIndex.get(100*y+x);
					nodeCosts[startIdx].add(new int[]{idx, node[2]+1});
				}
				visited[y][x] = true;
				queue.addLast(new int[]{y, x, node[2]+1});
			}
		}
	}
	
	public static void rec(boolean[] visited, int cost, int currentIdx, int currentDepth) {
		if(cost >= minCost) {
			return;
		}
		
		if(currentDepth == maxDepth) {
			minCost = Math.min(minCost, cost);
			return;
		}
		
		for (int[] node : nodeCosts[currentIdx]) {
			if(visited[node[0]]) {
				continue;
			}
			visited[node[0]] = true;
			cost += node[1];
			rec(visited, cost, node[0], currentDepth+1);
			cost -= node[1];
			visited[node[0]] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] temp = br.readLine().split(" ");
			int col = Integer.parseInt(temp[0]);
			int row = Integer.parseInt(temp[1]);
			if (row == 0 && col == 0) {
				break;
			}
			matrix = new char[row][col];
			for (int i=0; i<row; i++) {
				matrix[i] = br.readLine().toCharArray();
			}
			sb.append(solution(row, col)).append("\n");	
		}
		System.out.println(sb);
	}
}
