import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static int[][] matrix;
	static boolean[] selected;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static ArrayList<int[]> list;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static int solution() {
		rec(0, 0);
		return min;
	}
	
	public static void rec(int idx, int step) {
		if(step == m) {
			bfs();
			return;
		}
		if(idx >= list.size())
			return;
		
		rec(idx+1, step);
		selected[idx] = true;
		rec(idx+1, step+1);
		selected[idx] = false;
	}
	
	public static void bfs() {
		initVisited();
		queue.clear();
		for(int i=0; i<list.size(); i++)
			if(selected[i]) {
				int[] node = list.get(i);
				queue.add(node);
				visited[node[0]][node[1]] = true;
			}
				
		int sum=0;
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			if(matrix[node[0]][node[1]] == 1)
				sum += node[2];
			for(int j=0; j<4; j++) {
				int y = node[0] + dy[j];
				int x = node[1] + dx[j];
				if(x<0 || x>=n || y<0 || y>= n)
					continue;
				if(!visited[y][x]) {
					visited[y][x] = true;
					queue.add(new int[] {y,x,node[2]+1});
				}
					
			}
		}
		min = Math.min(min, sum);
	}
	
	
	public static int[] convert(String[] temp, int row) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
			if(result[i]==2) 
				list.add(new int[] {row, i, 0});
		}
		return result;
	}
	
	public static void initVisited() {
		for(int i=0; i<n; i++)
			Arrays.fill(visited[i], false);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		list = new ArrayList<>();
		queue = new ArrayDeque<int[]>();
		matrix = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++)
			matrix[i] = convert(br.readLine().split(" "), i);
		selected = new boolean[list.size()];
		System.out.println(solution());
	}
}
