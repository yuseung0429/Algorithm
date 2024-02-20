import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] matrix;
	static int[] papers;
	static int totalCnt;
	static int min = Integer.MAX_VALUE;
	
	public static int solution() {
		rec(0,0);
		if(min == Integer.MAX_VALUE)
			return -1;
		return min;
	}
	
	public static void rec(int y, int x) {
		int j=x;
		for(int i=y; i<10; i++) {
			while(j<10) {
				if(matrix[i][j]) {
					int m = vaildMax(i, j);
					for(int k=m; k>=0; k--) {
						if(papers[k]==0)
							return;
						setting(i, j, k, false);
						totalCnt -= k*k;
						papers[k]--;
						if(j==9)
							rec(i+1, 0);
						else
							rec(i, j+1);
						setting(i, j, k, true);
						papers[k]++;
						totalCnt += k*k;
					}
				}
				j++;
			}
			j=0;
		}
		if(totalCnt == 0)
			min = Math.min(min, usePaperCnt());
	}
	
	public static int vaildMax(int y, int x) {
		int i;
		for(i=0; i<=4; i++) {
			if(y+i>=10 || x+i>=10)
				return i;
			for(int j=y; j<=y+i; j++)
				if(!matrix[j][x+i])
					return i;
			for(int j=x; j<=x+i; j++)
				if(!matrix[y+i][j])
					return i;
		}
		return i;
	}
	
	public static void setting(int y, int x, int size, boolean setValue) {
		for(int i=y; i<y+size; i++)
			for(int j=x; j<x+size; j++)
				matrix[i][j] = setValue;
	}
	
	public static int usePaperCnt() {
		int sum = 0;
		for(int paper: papers)
			sum += paper;
		return 25-sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		matrix = new boolean[10][10];
		for(int i=0; i<10; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				if(temp[j].equals("1")) {
					matrix[i][j] = true;
					totalCnt++;
				}
			}
		}
		papers = new int[6];
		for(int i=1; i<6; i++)
			papers[i] = 5;
		System.out.println(solution());
	}
}
