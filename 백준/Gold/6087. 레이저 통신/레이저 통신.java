import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int w;
	static int h;
	static char[][] matrix;
	static int[][][] mirror;
	
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	static class Node{
		Node(int y, int x, int cnt, int direction){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.direction = direction;
		}
		int y;
		int x;
		int cnt;
		int direction;
	}
	
	public static int solution(Node start, Node end) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(start);
		for(int i=0; i<4; i++)
			mirror[i][start.y][start.x] = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i=0; i<4; i++) {
				int y = node.y + dy[i];
				int x = node.x + dx[i];
				if(y<0||y>=h||x<0||x>=w||matrix[y][x]=='*')
					continue;
				if(matrix[y][x]=='.' || matrix[y][x]=='C') {
					if(node.direction == i) {
						if(mirror[i][y][x] > node.cnt) {
							queue.add(new Node(y,x,node.cnt,i));
							mirror[i][y][x] = node.cnt;
						}
					}
					else
						if(mirror[i][y][x] > node.cnt+1) {
							queue.add(new Node(y,x,node.cnt+1,i));
							mirror[i][y][x] = node.cnt+1;
						}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<4; i++)
			min = Math.min(mirror[i][end.y][end.x], min);
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		w = Integer.parseInt(temp[0]);
		h = Integer.parseInt(temp[1]);
		matrix = new char[h][];
		mirror = new int[4][h][w];
		for(int i=0; i<h; i++)
			matrix[i] = br.readLine().toCharArray();
		
		for(int i=0; i<4; i++)
			for(int j=0; j<h; j++)
				Arrays.fill(mirror[i][j], Integer.MAX_VALUE);
			
		Node start = null;
		Node end = null;
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++)
				if(matrix[i][j] == 'C')
					if(start == null)
						start = new Node(i, j, -1, -1);
					else
						end = new Node(i, j, -1, -1);
		System.out.println(solution(start, end));
	}
}
