import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static int[][] matrix;
	static int n;
	static int max;
		
	public static int solution() {
		for(int i=0; i<4; i++)
			rec(0, i, matrix);
		return max;
	}
	
	public static void rec(int step, int direction, int[][] preMatrix) {
		if(step == 5)
			return;
		
		int[][] matrix = new int[n][];
		for(int i=0; i<n; i++)
			matrix[i] = preMatrix[i].clone();
		
		int idx = 0;
		int preValue = -1;
		switch(direction) {
		case UP:
			for(int i=0; i<n; i++) {
				idx = 0;
				preValue = -1;
				for(int j=0; j<n; j++) {
					if(matrix[j][i] == 0)
						continue;
					if(preValue == -1) {
						preValue = matrix[j][i];
						continue;
					}
					if(preValue == matrix[j][i]) {
						matrix[idx++][i] = preValue*2;
						max = Math.max(max, preValue*2);
						preValue = -1;
					}
					else {
						matrix[idx++][i] = preValue;
						matrix[idx][i] = matrix[j--][i];
						preValue = -1;
					}
				}
				if(preValue != -1)
					matrix[idx++][i] = preValue;
				for(int k=idx; k<n; k++)
					matrix[k][i] = 0;
			}
			break;
		case DOWN:
			for(int i=0; i<n; i++) {
				idx = n-1;
				preValue = -1;
				for(int j=n-1; j>=0; j--) {
					if(matrix[j][i] == 0)
						continue;
					if(preValue == -1) {
						preValue = matrix[j][i];
						continue;
					}
					if(preValue == matrix[j][i]) {
						matrix[idx--][i] = preValue*2;
						max = Math.max(max, preValue*2);
						preValue = -1;
					}
					else {
						matrix[idx--][i] = preValue;
						matrix[idx][i] = matrix[j++][i];
						preValue = -1;
					}
				}
				if(preValue != -1)
					matrix[idx--][i] = preValue;
				for(int k=idx; k>=0; k--)
					matrix[k][i] = 0;
			}
			break;
		case LEFT:
			for(int i=0; i<n; i++) {
				idx = 0;
				preValue = -1;
				for(int j=0; j<n; j++) {
					if(matrix[i][j] == 0)
						continue;
					if(preValue == -1) {
						preValue = matrix[i][j];
						continue;
					}
					if(preValue == matrix[i][j]) {
						matrix[i][idx++] = preValue*2;
						max = Math.max(max, preValue*2);
						preValue = -1;
					}
					else {
						matrix[i][idx++] = preValue;
						matrix[i][idx] = matrix[i][j--];
						preValue = -1;
					}
				}
				if(preValue != -1)
					matrix[i][idx++] = preValue;
				for(int k=idx; k<n; k++)
					matrix[i][k] = 0;
			}
			break;
		case RIGHT:
			for(int i=0; i<n; i++) {
				idx = n-1;
				preValue = -1;
				for(int j=n-1; j>=0; j--) {
					if(matrix[i][j] == 0)
						continue;
					if(preValue == -1) {
						preValue = matrix[i][j];
						continue;
					}
					if(preValue == matrix[i][j]) {
						matrix[i][idx--] = preValue*2;
						max = Math.max(max, preValue*2);
						preValue = -1;
					}
					else {
						matrix[i][idx--] = preValue;
						matrix[i][idx] = matrix[i][j++];
						preValue = -1;
					}
				}
				if(preValue != -1)
					matrix[i][idx--] = preValue;
				for(int k=idx; k>=0; k--)
					matrix[i][k] = 0;
			}
			break;
		}
		
		for(int i=0; i<4; i++)
			rec(step+1, i, matrix);
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
			max = Math.max(max, result[i]);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][];
		for(int i=0; i<n; i++)
			matrix[i] = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}