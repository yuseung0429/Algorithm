import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[][] matrix;
	static boolean[] visited;
	static int n = 0;
	public static int solution() {
		return rec(0, new ArrayList<>());
	}
	public static int rec(int step, List<Integer> list) {
		if(step == n) {
			int value = matrix[list.get(list.size()-1)][list.get(0)];
			if(value == 0)
				return Integer.MAX_VALUE;
			else {
				return cal(list) + value;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
			if (step == 0 || (visited[i] == false && matrix[list.get(list.size()-1)][i] != 0)){
				list.add(i);
				visited[i] = true;
				int temp = rec(step+1, list);
				if(min > temp)
					min = temp;
				visited[i] = false;
				list.remove(list.size()-1);
			}
		return min;
	}
	public static int cal(List<Integer> list) {
		int result = 0;
		for(int i=0; i<list.size()-1; i++) {
			result += matrix[list.get(i)][list.get(i+1)];
		}
		return result;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
			
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][];
		for(int i=0; i<n; i++)
			matrix[i] = convert(br.readLine().split(" "));
		visited = new boolean[n];
		System.out.println(solution());
	}
}
