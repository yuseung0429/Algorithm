import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static char[][] matrix;
	static boolean[] visited;
	static int result;
	static int r;
	static int c;
	
	public static void rec(int i, int j, int cnt) {
		for(int k=0; k<4; k++) {
			int x = j+dx[k];
			int y = i+dy[k];
			if(x<0 || x>= c || y<0 || y>= r || visited[matrix[y][x]-'A'])
				continue;
			visited[matrix[y][x]-'A'] = true;
			rec(y,x,cnt+1);
			visited[matrix[y][x]-'A'] = false;
		}
		result = Math.max(result, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		matrix = new char[r][];
		visited = new boolean[26];
		
		for(int i=0; i<r; i++)
			matrix[i] = br.readLine().toCharArray();
		
		visited[matrix[0][0]-'A'] = true;
		rec(0,0,1);
		System.out.println(result);
	}
	
}
