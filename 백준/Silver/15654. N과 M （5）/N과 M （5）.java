import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int m;
	static BufferedWriter bw;
	
	public static void solution() throws IOException {
		Arrays.sort(arr);
		visited = new boolean[arr.length];
		rec(0, new ArrayList<>());
		bw.flush();
	}
	
	public static void rec(int step, List<Integer> list) throws IOException {
		if(step == m) {
			for(int a : list)
				bw.append(a + " ");
			bw.newLine();
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				list.add(arr[i]);
				rec(step+1, list);
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		arr = convert(br.readLine().split(" "));
		m = Integer.parseInt(temp[1]);
		solution();
	}
}
