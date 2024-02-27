import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static double[][] stars;
	static double[][] matrix;
	static double[] cost;
	static boolean[] selected;
	public static double solution() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				if(i == j)
					matrix[i][j] = Double.MAX_VALUE;
				else
					matrix[i][j] = getDistance(stars[i], stars[j]);
			}
				
		int cnt = 1;
		double totalCost = 0;
		cost = matrix[0].clone();
		selected[0] = true;
		while(cnt != n) {
			int idx = getMinCostIdx();
			totalCost += cost[idx];
			selected[idx] = true;
			for(int i=0; i<n; i++)
				cost[i] = Math.min(cost[i], matrix[idx][i]);
			cnt++;
		}
		return totalCost;
	}
	
	public static int getMinCostIdx() {
		double min = Double.MAX_VALUE;
		int idx = -1;
		for(int i=0; i<n; i++) {
			if(selected[i])
				continue;
			if(min > cost[i]) {
				min = cost[i];
				idx = i;
			}
		}
		return idx;
	}
	
	public static double getDistance(double[] s1, double[] s2) {
		double a = Math.pow(s1[0]-s2[0], 2);
		double b = Math.pow(s1[1]-s2[1], 2);
		return Math.sqrt(a+b);
	}
	
	public static double[] convert(String[] temp) {
		double[] result = new double[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Double.parseDouble(temp[i]);
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stars = new double[n][];
		matrix = new double[n][n];
		selected = new boolean[n];
		cost = new double[n];
		for(int i=0; i<n; i++)
			stars[i] = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}