import java.io.*;
import java.util.*;

class Main {
	static int n;
	static boolean[] visited;
	static int[] diggingWaters;
	static int[][] drawWaters;
	
	public static int solution() {
		
		int totalCost = 0;
		int minVertex = 0;
		int minCost = diggingWaters[0];
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		
		for (int i=0; i<n; i++) {
			pq.add(new int[] {i, diggingWaters[i]});
		}
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();	
			if (visited[node[0]]) {
				continue;
			}

			totalCost += node[1];
			visited[node[0]] = true;
			
			for (int i=0; i<n; i++) {
				if (visited[i]) {
					continue;
				}
				pq.add(new int[] {i, drawWaters[node[0]][i]});
			}
		}
		return totalCost;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n];
		drawWaters = new int[n][n];
		diggingWaters = new int[n];
		
		for (int i=0; i<n; i++) {
			diggingWaters[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				drawWaters[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		System.out.println(solution());
	}
}