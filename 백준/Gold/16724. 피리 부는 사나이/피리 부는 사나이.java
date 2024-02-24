import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static int cnt;
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int n;
	static int m; 
	
	static Boolean[][] visited;
	static char[][] matrix;
	
	public static int solution() {
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(visited[i][j]==null)
					dfs(i, j, getDirection(matrix[i][j]));
		return cnt;
	}
	
	public static boolean dfs(int i, int j, int direction) {
		if(visited[i][j] == null) {
			visited[i][j] = false;
			int y = i+dy[direction];
			int x = j+dx[direction];
			return visited[i][j] = dfs(y, x, getDirection(matrix[y][x]));
		}
		if(!visited[i][j]) {
			cnt++;
			return true;
		}
		if(visited[i][j])
			return true;
		return true;
	}
	
	public static int getDirection(char d) {
		switch(d) {
		case 'D': return DOWN;
		case 'U': return UP;
		case 'L': return LEFT;
		case 'R': return RIGHT;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		matrix = new char[n][];
		visited = new Boolean[n][m];
		for(int i=0; i<n; i++)
			matrix[i] = br.readLine().toCharArray();
		System.out.println(solution());
	}
}