import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int[][][] matrix;
	static int m;
	static int n;
	static int h;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	static class Node {
		public Node(int i, int j, int k, int cnt) { this.i = i; this.j = j; this.k = k; this.cnt = cnt;}
		int i;
		int j;
		int k;
		int cnt;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static int solution() {
		Queue<Node> queue = new ArrayDeque<>();
		for(int i=0; i<h; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<m; k++)
					if(matrix[i][j][k] == 1)
						queue.add(new Node(i, j, k, 0));
					
		Node node = null;
		while(!queue.isEmpty()) {
			node = queue.poll();
			int x = node.i;
			int y = node.j;
			int z = node.k;
			int cnt = node.cnt;
			for(int i=0; i<6; i++) {
				if(x+dx[i] < 0 || x+dx[i] >= h || y+dy[i] < 0 || y+dy[i] >= n || z+dz[i] < 0 || z+dz[i] >= m)
					continue;
				if(matrix[x+dx[i]][y+dy[i]][z+dz[i]] == 0) {
					matrix[x+dx[i]][y+dy[i]][z+dz[i]] = 1;
					queue.add(new Node(x+dx[i], y+dy[i], z+dz[i], cnt+1));
				}
			}
		}
		for(int i=0; i<h; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<m; k++)
					if(matrix[i][j][k] == 0)
						return -1;
		return node.cnt;
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		m = Integer.parseInt(temp[0]);
		n = Integer.parseInt(temp[1]);
		h = Integer.parseInt(temp[2]);
		matrix = new int[h][n][m];
		for(int i=0; i<h; i++)
			for(int j=0; j<n; j++)
				matrix[i][j] = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}