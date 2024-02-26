import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class Main {
	
	static char[][] matrix;
	static HashSet<Character> keys;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int r;
	static int c;
	
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	
	public static int solution() {
		int cnt = 0;
		
		ArrayList<int[]> list = new ArrayList<>();	
		
		int[] dr = new int[] {0, c-1};
		int[] dc = new int[] {0, r-1};
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<2; j++) {
				if(matrix[i][dr[j]] == '*')
					continue;
				if(matrix[i][dr[j]] >= 'A' && matrix[i][dr[j]] <= 'Z')
					if(!keys.contains((char) (matrix[i][dr[j]]+32))) {
						list.add(new int[] {i, dr[j]});
						visited[i][dr[j]] = true;
						continue;
					}
				if(matrix[i][dr[j]] >= 'a' && matrix[i][dr[j]] <= 'z')
					keys.add(matrix[i][dr[j]]);
				if(matrix[i][dr[j]] == '$')
					cnt++;
				queue.add(new int[] {i, dr[j]});
				visited[i][dr[j]] = true;
			}
		}
		
		for(int i=1; i<c-1; i++) {
			for(int j=0; j<2; j++) {
				if(matrix[dc[j]][i] == '*')
					continue;
				if(matrix[dc[j]][i] >= 'A' && matrix[dc[j]][i] <= 'Z')
					if(!keys.contains((char) (matrix[dc[j]][i]+32))) {
						list.add(new int[] {dc[j], i});
						visited[dc[j]][i] = true;
						continue;
					}
				if(matrix[dc[j]][i] >= 'a' && matrix[dc[j]][i] <= 'z')
					keys.add(matrix[dc[j]][i]);
				if(matrix[dc[j]][i] == '$')
					cnt++;
				queue.add(new int[] {dc[j], i});
				visited[dc[j]][i] = true;
			}
		}
		
		while(true) {
			while(!queue.isEmpty()) {
				int[] node = queue.poll();
				for(int i=0; i<4; i++) {
					int y = node[0]+dy[i];
					int x = node[1]+dx[i];
					if(y<0 || y>=r || x<0 || x>=c || visited[y][x])
						continue;
					if(matrix[y][x] == '*')
						continue;
					if(matrix[y][x] >= 'A' && matrix[y][x] <= 'Z')
						if(!keys.contains((char) (matrix[y][x]+32))) {
							list.add(new int[] {y, x});
							visited[y][x] = true;
							continue;
						}
					if(matrix[y][x] == '$')
						cnt++;
					if(matrix[y][x] >= 'a' && matrix[y][x] <= 'z')
						keys.add(matrix[y][x]);
					queue.add(new int[] {y, x});
					visited[y][x] = true;
				}
			}
			boolean flag = false;
			Iterator<int[]> iter = list.iterator();
			while(iter.hasNext()) {
				int[] doorPos = iter.next();
				if(keys.contains((char)(matrix[doorPos[0]][doorPos[1]]+32))) {
					queue.add(doorPos);
					iter.remove();
					flag = true;
				}
			}
			if(!flag)
				return cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		String[] temp;
		for(int i=0; i<t; i++) {
			temp = br.readLine().split(" ");
			r = Integer.parseInt(temp[0]);
			c = Integer.parseInt(temp[1]);
			matrix = new char[r][];
			visited = new boolean[r][c];
			keys = new HashSet<>();
			for(int j=0; j<r; j++)
				matrix[j] = br.readLine().toCharArray();
			for(char a : br.readLine().toCharArray())
				keys.add(a);
			bw.append(String.valueOf(solution())+"\n");
		}
		bw.flush();
	}
}
