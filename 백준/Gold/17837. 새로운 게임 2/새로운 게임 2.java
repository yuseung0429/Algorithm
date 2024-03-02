import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int k;
	final static int WHITE = 0;
	final static int RED = 1;
	final static int BLUE = 2;
	
	final static int RIGHT = 1;
	final static int LEFT = 2;
	final static int UP = 3;
	final static int DOWN = 4;
	
	static int[] dx = new int[] {0, 1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 0, -1, 1};
	static int[][] color;
	static Piece[] pieces;
	static Piece[][][] matrix;
	
	static class Piece{
		Piece(int y, int x, int layer, int direction){
			this.y = y;
			this.x = x;
			this.layer = layer;
			this.direction = direction;
		}
		int y;
		int x;
		int layer;
		int direction;
	}
	
	public static int solution() {
		int turn = 1;
		while(turn <= 1000) {
			if(!moving())
				return turn;
			turn++;
		}
		return -1;
	}
	
	public static boolean moving() {
		for(Piece piece : pieces) {
			int y = piece.y + dy[piece.direction];
			int x = piece.x + dx[piece.direction];
			
			if(x>=n||x<0||y>=n||y<0||color[y][x]==BLUE) {
				piece.direction += (piece.direction%2==0) ? -1 : 1;
				y = piece.y + dy[piece.direction];
				x = piece.x + dx[piece.direction];
				if(x>=n||x<0||y>=n||y<0||color[y][x]==BLUE)
					continue;
			}
				
			int currentCnt = floorCnt(piece.y, piece.x);
			int nextCnt = floorCnt(y, x);
			
			if(nextCnt + (currentCnt-piece.layer) >= 4)
				return false;
			
			int preX = piece.x;
			int preY = piece.y;
			int preLayer = piece.layer;
			
			if(color[y][x]==WHITE) {
				int idx = nextCnt;
				for(int i=preLayer; i<currentCnt; i++) {
					Piece temp = matrix[i][preY][preX];
					temp.y = y;
					temp.x = x;
					temp.layer = idx;
					matrix[idx++][y][x] = temp;
					matrix[i][preY][preX] = null;
				}
			}
			else if(color[y][x]==RED){
				int idx = nextCnt;
				for(int i=currentCnt-1; i>=preLayer; i--) {
					Piece temp = matrix[i][preY][preX];
					temp.y = y;
					temp.x = x;
					temp.layer = idx;
					matrix[idx++][y][x] = temp;
					matrix[i][preY][preX] = null;
				}
			}
		}
		return true;
	}
	public static int floorCnt(int i, int j) {
		int cnt = 0;
		for(int k=0; k<3; k++) {
			if(matrix[k][i][j] == null)
				break;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		color = new int[n][n];
		pieces = new Piece[k];
		matrix = new Piece[3][n][n];
		for(int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int j=0; j<n; j++)
				switch(temp[j]) {
				case "0" : color[i][j] = WHITE; break;
				case "1" : color[i][j] = RED; break;
				case "2" : color[i][j] = BLUE; break;
				}
		}
		for(int i=0; i<k; i++) {
			temp = br.readLine().split(" ");
			int y = Integer.parseInt(temp[0]);
			int x = Integer.parseInt(temp[1]);
			int direction = Integer.parseInt(temp[2]);
			pieces[i] = new Piece(y-1, x-1, 0, direction);
			matrix[0][y-1][x-1] = pieces[i];
		}
		System.out.println(solution());
	}
}
