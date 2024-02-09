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
	static int result;
	static int[][] matrix;
	static boolean[][] visited;
	static ArrayList<int[]> listVirus;
	static ArrayList<int[]> listSafety;
	static Queue<int[]> queue;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static int solution() {
		int size = listSafety.size();
		int[] first = null;
		int[] second = null;
		int[] third = null;
		for(int i=0; i<size; i++) {
			first = listSafety.get(i);
			for(int j=i+1; j<size; j++) {
				second = listSafety.get(j);
				for(int k=j+1; k<size; k++) {
					third = listSafety.get(k);
					matrix[first[0]][first[1]] = 1;
					matrix[second[0]][second[1]] = 1;
					matrix[third[0]][third[1]] = 1;
					result = Math.max(bfs() , result);
					matrix[first[0]][first[1]] = 0;
					matrix[second[0]][second[1]] = 0;
					matrix[third[0]][third[1]] = 0;
				}
			}
		}
		return result;
	}
	
	public static int bfs() {
		for(int i=0; i<n; i++)
			Arrays.fill(visited[i], false);
		int cnt = listSafety.size() - 3;
		queue.addAll(listVirus);
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			for(int i=0; i<4; i++) {
				int y = node[0]+dy[i];
				int x = node[1]+dx[i];
				if(x<0 || x>=m || y<0 || y>=n)
					continue;
				if(matrix[y][x] == 0 && !visited[y][x]) {
					visited[y][x] = true;
					queue.add(new int[] {y, x});
					cnt--;
				}
			}
		}
		return cnt;
	}
	public static int[] convert(int idx, String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
			switch(result[i]) {
			case 0: listSafety.add(new int[] {idx, i}); break;
			case 2: listVirus.add(new int[] {idx, i});
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		result = Integer.MIN_VALUE;
		matrix = new int[n][];
		visited = new boolean[n][m];
		listSafety = new ArrayList<>();
		listVirus = new ArrayList<>();
		queue = new ArrayDeque<>();
		for(int i=0; i<n; i++)
			matrix[i] = convert(i, br.readLine().split(" "));
		System.out.println(solution());
	}
}
