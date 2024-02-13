import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static class Cell {
		char value;
		Cell(char c){
			this.value = c;
		}
	}
	
	static class Plane {
		Cell[] owns;
		Cell[][] sides;
		Plane(char c){
			this.owns = new Cell[9];
			for(int i=0; i<9; i++)
				owns[i] = new Cell(c);
			this.sides = new Cell[4][3];
		}
		void rotate(boolean turn) {
			char[] clone = new char[9];
			for(int i=0; i<9; i++)
				clone[i] = owns[i].value;
			for(int i=0; i<3; i++) {
				owns[i].value = turn ? clone[6-3*i] : clone[2+3*i];
				owns[3+i].value = turn ? clone[7-3*i] : clone[1+3*i];
				owns[6+i].value = turn ? clone[8-3*i] : clone[3*i];
			}
			
			char t1, t2, t3 = 0;
			
			if(turn) {
				t1 = sides[W][0].value;
				t2 = sides[W][1].value;
				t3 = sides[W][2].value;
				for(int i=3; i>0; i--) {
					sides[i][0].value = sides[i-1][0].value;
					sides[i][1].value = sides[i-1][1].value;
					sides[i][2].value = sides[i-1][2].value;
				}
				sides[0][0].value = t1;
				sides[0][1].value = t2;
				sides[0][2].value = t3;
			}
			else {
				t1 = sides[0][0].value;
				t2 = sides[0][1].value;
				t3 = sides[0][2].value;
				for(int i=0; i<3; i++) {
					sides[i][0].value = sides[i+1][0].value;
					sides[i][1].value = sides[i+1][1].value;
					sides[i][2].value = sides[i+1][2].value;
				}
				sides[W][0].value = t1;
				sides[W][1].value = t2;
				sides[W][2].value = t3;
			}
		}
	}
	
	static final int UP = 0;
	static final int DOWN = 1;
	static final int FRONT = 2;
	static final int BACK = 3;
	static final int LEFT = 4;
	static final int RIGHT = 5;
	
	static final int N = 0;
	static final int E = 1;
	static final int S = 2;
	static final int W = 3;
	
	public static final boolean RTURN = true;
	public static final boolean LTURN = false;
	
	static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'};
	static BufferedWriter bw;
	
	public static void solution(String[] steps) throws IOException {
		Plane[] cube = new Plane[6];
		for(int i=0; i<6; i++)
			cube[i] = new Plane(color[i]);
		
		cube[UP].sides[N][0] = cube[BACK].owns[0];
		cube[UP].sides[N][1] = cube[BACK].owns[1];
		cube[UP].sides[N][2] = cube[BACK].owns[2];
		
		cube[UP].sides[E][0] = cube[RIGHT].owns[0];
		cube[UP].sides[E][1] = cube[RIGHT].owns[1];
		cube[UP].sides[E][2] = cube[RIGHT].owns[2];
		
		cube[UP].sides[S][0] = cube[FRONT].owns[0];
		cube[UP].sides[S][1] = cube[FRONT].owns[1];
		cube[UP].sides[S][2] = cube[FRONT].owns[2];
		
		cube[UP].sides[W][0] = cube[LEFT].owns[0];
		cube[UP].sides[W][1] = cube[LEFT].owns[1];
		cube[UP].sides[W][2] = cube[LEFT].owns[2];
		
		cube[DOWN].sides[N][0] = cube[FRONT].owns[6];
		cube[DOWN].sides[N][1] = cube[FRONT].owns[7];
		cube[DOWN].sides[N][2] = cube[FRONT].owns[8];
		
		cube[DOWN].sides[E][0] = cube[RIGHT].owns[6];
		cube[DOWN].sides[E][1] = cube[RIGHT].owns[7];
		cube[DOWN].sides[E][2] = cube[RIGHT].owns[8];
		
		cube[DOWN].sides[S][0] = cube[BACK].owns[6];
		cube[DOWN].sides[S][1] = cube[BACK].owns[7];
		cube[DOWN].sides[S][2] = cube[BACK].owns[8];
		
		cube[DOWN].sides[W][0] = cube[LEFT].owns[6];
		cube[DOWN].sides[W][1] = cube[LEFT].owns[7];
		cube[DOWN].sides[W][2] = cube[LEFT].owns[8];
		
		cube[FRONT].sides[N][0] = cube[UP].owns[6];
		cube[FRONT].sides[N][1] = cube[UP].owns[7];
		cube[FRONT].sides[N][2] = cube[UP].owns[8];
		
		cube[FRONT].sides[E][0] = cube[RIGHT].owns[0];
		cube[FRONT].sides[E][1] = cube[RIGHT].owns[3];
		cube[FRONT].sides[E][2] = cube[RIGHT].owns[6];
		
		cube[FRONT].sides[S][0] = cube[DOWN].owns[2];
		cube[FRONT].sides[S][1] = cube[DOWN].owns[1];
		cube[FRONT].sides[S][2] = cube[DOWN].owns[0];
		
		cube[FRONT].sides[W][0] = cube[LEFT].owns[8];
		cube[FRONT].sides[W][1] = cube[LEFT].owns[5];
		cube[FRONT].sides[W][2] = cube[LEFT].owns[2];
		
		cube[BACK].sides[N][0] = cube[UP].owns[2];
		cube[BACK].sides[N][1] = cube[UP].owns[1];
		cube[BACK].sides[N][2] = cube[UP].owns[0];
		
		cube[BACK].sides[E][0] = cube[LEFT].owns[0];
		cube[BACK].sides[E][1] = cube[LEFT].owns[3];
		cube[BACK].sides[E][2] = cube[LEFT].owns[6];
		
		cube[BACK].sides[S][0] = cube[DOWN].owns[6];
		cube[BACK].sides[S][1] = cube[DOWN].owns[7];
		cube[BACK].sides[S][2] = cube[DOWN].owns[8];
		
		cube[BACK].sides[W][0] = cube[RIGHT].owns[8];
		cube[BACK].sides[W][1] = cube[RIGHT].owns[5];
		cube[BACK].sides[W][2] = cube[RIGHT].owns[2];
		
		cube[LEFT].sides[N][0] = cube[UP].owns[0];
		cube[LEFT].sides[N][1] = cube[UP].owns[3];
		cube[LEFT].sides[N][2] = cube[UP].owns[6];
		
		cube[LEFT].sides[E][0] = cube[FRONT].owns[0];
		cube[LEFT].sides[E][1] = cube[FRONT].owns[3];
		cube[LEFT].sides[E][2] = cube[FRONT].owns[6];
		
		cube[LEFT].sides[S][0] = cube[DOWN].owns[0];
		cube[LEFT].sides[S][1] = cube[DOWN].owns[3];
		cube[LEFT].sides[S][2] = cube[DOWN].owns[6];
		
		cube[LEFT].sides[W][0] = cube[BACK].owns[8];
		cube[LEFT].sides[W][1] = cube[BACK].owns[5];
		cube[LEFT].sides[W][2] = cube[BACK].owns[2];
		
		cube[RIGHT].sides[N][0] = cube[UP].owns[8];
		cube[RIGHT].sides[N][1] = cube[UP].owns[5];
		cube[RIGHT].sides[N][2] = cube[UP].owns[2];
		
		cube[RIGHT].sides[E][0] = cube[BACK].owns[0];
		cube[RIGHT].sides[E][1] = cube[BACK].owns[3];
		cube[RIGHT].sides[E][2] = cube[BACK].owns[6];
		
		cube[RIGHT].sides[S][0] = cube[DOWN].owns[8];
		cube[RIGHT].sides[S][1] = cube[DOWN].owns[5];
		cube[RIGHT].sides[S][2] = cube[DOWN].owns[2];
		
		cube[RIGHT].sides[W][0] = cube[FRONT].owns[8];
		cube[RIGHT].sides[W][1] = cube[FRONT].owns[5];
		cube[RIGHT].sides[W][2] = cube[FRONT].owns[2];
		
		for(String step : steps) {
			switch(step) {
			case "U+": cube[UP].rotate(RTURN); break;
			case "U-": cube[UP].rotate(LTURN); break;
			case "D+": cube[DOWN].rotate(RTURN); break;
			case "D-": cube[DOWN].rotate(LTURN); break;
			case "F+": cube[FRONT].rotate(RTURN); break;
			case "F-": cube[FRONT].rotate(LTURN); break;
			case "B+": cube[BACK].rotate(RTURN); break;
			case "B-": cube[BACK].rotate(LTURN); break;
			case "L+": cube[LEFT].rotate(RTURN); break;
			case "L-": cube[LEFT].rotate(LTURN); break;
			case "R+": cube[RIGHT].rotate(RTURN); break;
			case "R-": cube[RIGHT].rotate(LTURN); break;
			}
		}
		Cell[] plane = cube[UP].owns;
		for(int i=0; i<9; i++) {
			bw.append(plane[i].value);
			if(i%3 == 2)
				bw.append("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			br.readLine();
			solution(br.readLine().split(" "));
		}
		bw.flush();
	}
}