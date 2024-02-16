import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static char[][] matrix;
	static boolean[][][][] visited;
	static final boolean redFirst = true;
	static final boolean blueFirst = false;
	static int n;
	static int m;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static class Node {
		int ry;
		int rx;
		int by;
		int bx;
		int cnt;
		String path;
		Node(int ry, int rx, int by, int bx, int cnt, String path){
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.cnt = cnt;
			this.path = path;
		}
	}
	
	public static void solution(int[] red, int[] blue) {
		bfs(red, blue);
	}
	
	public static int[] move(int starty, int startx, int direction) {
		int y = starty;
		int x = startx;
		while(true) {
			y += dy[direction];
			x += dx[direction];
			if(matrix[y][x] == 'O')
				return new int[] {-1, -1};
			if(matrix[y][x] == '#')
				return new int[] {y-dy[direction], x-dx[direction]};
		}
	}
	
	public static void bfs(int[] red, int[] blue) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(red[0], red[1], blue[0], blue[1], 0, ""));
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			int[] changeR;
			int[] changeB;
			for(int i=0; i<4; i++) {
				changeR = move(node.ry, node.rx, i);
				changeB = move(node.by, node.bx, i);
				
				if(changeR[0] == node.ry && changeR[1] == node.rx && changeB[0] == node.by && changeB[1] == node.bx)
					continue;
				
				if(changeB[0] == -1 && changeB[1] == -1)
					continue;
				
				if(changeR[0] == -1 && changeR[1] == -1) {
					System.out.println(node.cnt+1);
					System.out.println(node.path+getDirectonAlpa(i));
					return;
				}
				
				if(changeR[0] == changeB[0] && changeR[1] == changeB[1]) {
					if(getPriority(node.ry, node.rx, node.by, node.bx, i)) {
						changeB[0] -= dy[i];
						changeB[1] -= dx[i];
					}
					else {
						changeR[0] -= dy[i];
						changeR[1] -= dx[i];
					}
					if(changeR[0] == node.ry && changeR[1] == node.rx && changeB[0] == node.by && changeB[1] == node.bx)
						continue;
				}
					
				if(!visited[changeR[0]][changeR[1]][changeB[0]][changeB[1]]) {
					queue.add(new Node(changeR[0], changeR[1], changeB[0], changeB[1], node.cnt+1, node.path+getDirectonAlpa(i)));
					visited[changeR[0]][changeR[1]][changeB[0]][changeB[1]] = true;
				}
			}
		}
		System.out.println(-1);
		return;
	}
	
	public static boolean getPriority(int ry, int rx, int by, int bx, int direction) {
		switch(direction) {
		case 0: return (ry <= by) ? redFirst : blueFirst;
		case 1: return (rx >= bx) ? redFirst : blueFirst;
		case 2: return (ry >= by) ? redFirst : blueFirst;
		case 3: return (rx <= bx) ? redFirst : blueFirst;
		}
		return redFirst;
	}
	
	public static char getDirectonAlpa(int direction) {
		switch(direction) {
		case 0: return 'U';
		case 1: return 'R';
		case 2: return 'D';
		case 3: return 'L';
		}
		return '0';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		visited = new boolean[n][m][n][m]; 
		int[] red = new int[2];
		int[] blue = new int[2];
		
		matrix = new char[n][];
		for(int i=0; i<n; i++)
			matrix[i] = br.readLine().toCharArray();
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				switch(matrix[i][j]) {
				case 'R': red[0] = i; red[1] = j; break;
				case 'B': blue[0] = i; blue[1] = j; break;
				}
		
		solution(red, blue);
	}
}