import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int[] p, int[] q) {
		int x1 = p[0], x2 = q[0];
		int y1 = p[1], y2 = q[1];
		int r1 = p[2], r2 = q[2];

		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		if(x1==x2 && y1==y2 && r1==r2)
			return -1;
		else if(Double.compare(distance, r1+r2) > 0)
			return 0;
		else if(Double.compare(r1+r2, distance) == 0)
			return 1;
		else if(Double.compare(r1-r2, distance) == 0 || Double.compare(r2-r1, distance) == 0)
			return 1;
		else if(Double.compare(r1-r2, distance) > 0 || Double.compare(r2-r1, distance) > 0)
			return 0;
		else
			return 2;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] p = new int[t][3];
		int[][] q = new int[t][3];
		for(int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				p[i][j] = Integer.parseInt(temp[j]);
				q[i][j] = Integer.parseInt(temp[3+j]);
			}
		}
		for(int i=0; i<t; i++)
			System.out.println(solution(p[i], q[i])); 
	}
}
