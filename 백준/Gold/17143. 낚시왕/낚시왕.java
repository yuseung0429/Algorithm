import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int UP = 1;
	static final int DOWN = 2;
	static final int RIGHT = 3;
	static final int LEFT = 4;
	static final int[] dx = {0, 0, 0, 1, -1};
	static final int[] dy = {0, -1, 1, 0 ,0};
	static Shark[][][] matrix;
	static int focus;
	static int r;
	static int c;
	static class Shark{
		Shark(int size, int speed, int direction){
			this.size = size;
			this.speed = speed;
			this.direction = direction;
		}
		int size;
		int speed;
		int direction;
	}
	
	public static int solution() {
		int result = 0;
		for(int i=0; i<c; i++) {
			result += fishing(i);
			moving();
		}
		return result;
	}
	
	public static int fishing(int col) {
		for(int j=0; j<r; j++)
			if(matrix[focus][j][col] != null) {
				int size = matrix[focus][j][col].size;
				matrix[focus][j][col] = null;
				return size;
			}
		return 0;
	}
	
	public static void moving() {
		int next = (focus==0) ? 1 : 0;
		for(int i=0; i<r; i++)
			for(int j=0; j<c; j++) {
				if(matrix[focus][i][j] == null)
					continue;
				Shark shark = matrix[focus][i][j];
				int y = i;
				int x = j;
				int speedMod = (shark.direction<=2) ? shark.speed%(2*(r-1)) : shark.speed%(2*(c-1));
				int step = 0;
				while(step < speedMod) {
					int tempY = y+dy[shark.direction];
					int tempX = x+dx[shark.direction];
					if(tempY>=r || tempY<0 || tempX>=c || tempX<0) {
						shark.direction += (shark.direction%2==0) ? -1 : 1;
						continue;
					}
					y = tempY;
					x = tempX;
					step++;
				}
				
				if(matrix[next][y][x] != null) {
					if(matrix[next][y][x].size < shark.size)
						matrix[next][y][x] = shark;
				}
				else
					matrix[next][y][x] = shark;
				matrix[focus][i][j] = null;
			}
		focus = next;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		int m = Integer.parseInt(temp[2]);
		matrix = new Shark[2][r][c];
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int row = Integer.parseInt(temp[0]);
			int col = Integer.parseInt(temp[1]);
			int speed = Integer.parseInt(temp[2]);
			int direction = Integer.parseInt(temp[3]);
			int size = Integer.parseInt(temp[4]);
			matrix[0][row-1][col-1] = new Shark(size, speed, direction);
		}
		System.out.println(solution());
	}
}