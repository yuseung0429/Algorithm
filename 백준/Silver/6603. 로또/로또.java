import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int k = 6;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void solution(int[] arr) throws IOException {
		boolean[] visited = new boolean[arr.length];
		rec(0, 0, arr, visited, new ArrayList<>());
		bw.newLine();
	}
	public static void rec(int step, int idx, int[] arr, boolean[] visited, List<Integer> list) throws IOException {
		if(step == k) {
			for(int a : list)
				bw.append(a+" ");
			bw.newLine();
		}
		for(int i=idx; i<arr.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				list.add(arr[i]);
				rec(step+1, i, arr, visited, list);
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length-1];
		for(int i=0; i<temp.length-1; i++)
			result[i] = Integer.parseInt(temp[i+1]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = null;
		while(!(temp = br.readLine()).equals("0")) {
			int[] arr = convert(temp.split(" "));
			solution(arr);
		}
		bw.flush();
	}
}