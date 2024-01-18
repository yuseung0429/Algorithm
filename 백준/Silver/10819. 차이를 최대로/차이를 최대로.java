import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] arr;
	static boolean[] visited;
	
	public static int solution() {
		return rec(0, new ArrayList<>());
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static int rec(int step, List<Integer> list) {
		if(step == arr.length)
			return cal(list);
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				list.add(arr[i]);
				max = Math.max(max, rec(step+1, list));
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
		return max;
	}
	public static int cal(List<Integer> list) {
		int result = 0;
		for(int i=0; i<list.size()-1; i++)
			result += Math.abs(list.get(i) - list.get(i+1));
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = convert(br.readLine().split(" "));
		visited = new boolean[n];
		System.out.println(solution());
	}
}