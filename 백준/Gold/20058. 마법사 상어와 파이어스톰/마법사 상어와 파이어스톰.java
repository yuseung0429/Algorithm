import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static boolean[][] visited;
	public static int[][] matrix;
	public static int[] spells;
	public static int size;
	public static ArrayDeque<int[]> queue;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void solution() {
		for(int spell : spells) {
			rotate(spell);
			melt();
		}
			
		int totalSum = 0;
		int MaxCnt=0;
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++) {
				if(matrix[i][j] == 0 || visited[i][j])
					continue;
				int cnt = 0;
				int sum = 0;
				queue.add(new int[]{i, j});
				visited[i][j] = true;
				while(!queue.isEmpty()) {
					int[] node= queue.poll();
					cnt++;
					sum += matrix[node[0]][node[1]];
					for(int k=0; k<4; k++) {
						int x = node[1]+dx[k];
						int y = node[0]+dy[k];
						if(x<0 || x>=size || y<0 || y>=size || matrix[y][x] == 0 || visited[y][x])
							continue;
						visited[y][x] = true;
						queue.add(new int[] {y, x});
					}
				}
				MaxCnt = Math.max(MaxCnt, cnt);
				totalSum += sum;
			}
		System.out.println(totalSum);
		System.out.println(MaxCnt);
	}
	
	public static void rotate(int l) {
		int step = (int)Math.pow(2, l);
		for(int i=0; i<size; i+= step)
			for(int j=0; j<size; j+= step)
				srotate(i, j, step);
	}
	public static void srotate(int y, int x, int step) {
		int n = step;
		
		for(int i=y; i<y+step; i++) {
			for(int j=x; j<x+n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[y+(step-1)-(j-x)][x+(step-1)-(i-y)];
				matrix[y+(step-1)-(j-x)][x+(step-1)-(i-y)] = temp;
			}
			n--;
		}
		
		for(int i=y; i<y+step/2; i++)
			for(int j=x; j<x+step; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[y+(step-1)-(i-y)][j];
				matrix[y+(step-1)-(i-y)][j] = temp;
			}
	}
	
	public static void melt() {
		queue.clear();
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				if(matrix[i][j] != 0 && check(i,j))
					queue.add(new int[] {i, j});
		int[] element;
		while(!queue.isEmpty()) {
			element = queue.poll();
			matrix[element[0]][element[1]]--;
		}
	}
	
	public static boolean check(int i, int j) {
		int cnt = 0;
		for(int k=0; k<4; k++) {
			int y = i + dy[k];
			int x = j + dx[k];
			if(x<0 || x>=size || y<0 || y>= size || matrix[y][x] == 0)
				continue;
			cnt++;
		}
		if(cnt >= 3)
			return false;
		return true;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		size = (int)Math.pow(2, n);
		matrix = new int[size][];
		visited = new boolean[size][size];
		queue = new ArrayDeque<>();
		for(int i=0; i<size; i++)
			matrix[i] = convert(br.readLine().split(" "));
		spells = convert(br.readLine().split(" "));
		solution();
	}
}
