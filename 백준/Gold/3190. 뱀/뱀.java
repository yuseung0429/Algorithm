import java.io.*;
import java.util.*;

class Main {
	static int n;
	static Boolean[][] matrix;
	static ArrayList<int[]> seq = new ArrayList<int[]>();
	
	static int direction = 0;
	
	static int[] dy = new int[] {0,-1,0,1};
 	static int[] dx = new int[] {1,0,-1,0};
	
	public static int solution() {
		ArrayDeque<int[]> snake = new ArrayDeque<int[]>();
		snake.addLast(new int[] {n-1, 0});
		
		int time = 0;
		int i = 0;
		
		while (true) {
			time++;
			
			int[] head = snake.peekFirst();
			int y = head[0] + dy[direction];
			int x = head[1] + dx[direction];
			
			if(y<0 || y>=n || x<0 || x>=n || (matrix[y][x] != null && !matrix[y][x])) {
				return time;
			}
			
			if (matrix[y][x] == null) {
				int[] tail = snake.pollLast();
				matrix[tail[0]][tail[1]] = null;
			}
			matrix[y][x] = false;
			snake.addFirst(new int[] {y, x});
			
			if (i<seq.size()) {
				int[] rotate = seq.get(i);
				if(rotate[0] == time) {
					direction += rotate[1] == 0 ? -1 : 1; 
					if (direction < 0) {
						direction += 4;
					} else {
						direction %= 4;
					}
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new Boolean[n][n];
		
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int y = n - Integer.parseInt(temp[0]);
			int x = Integer.parseInt(temp[1])-1;
			matrix[y][x] = true;
		}
		
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int time = Integer.parseInt(temp[0]);
			int rotate = temp[1].equals("L") ? 0 : 1;
			seq.add(new int[]{time, rotate});
		}
		
		System.out.println(solution());
	}
}