import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	
	static ArrayList<int[]> graph;
	static long MAX_VALUE = Long.MAX_VALUE/2;
	
	public static void solution() {
		long[] arr = new long[n];
		Arrays.fill(arr, MAX_VALUE);
		arr[0] = 0;
		
		for (int i=1; i<=n; i++) {
			for (int[] edge : graph) {
				if (arr[edge[0]] == MAX_VALUE || arr[edge[1]] <= arr[edge[0]]+edge[2]) {
					continue;
				}
				if (i == n) {
					System.out.println(-1);
					return;
				}
				arr[edge[1]] = arr[edge[0]] + edge[2];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<n; i++) {
			sb.append((arr[i] != MAX_VALUE) ? arr[i] : -1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		graph = new ArrayList<int[]>();
		
		for (int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0])-1;
			int end = Integer.parseInt(temp[1])-1;
			int cost = Integer.parseInt(temp[2]);
			graph.add(new int[]{start, end, cost});
		}
		
		solution();
	}
}
