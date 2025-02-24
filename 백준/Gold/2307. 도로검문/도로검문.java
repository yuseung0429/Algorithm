import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	
	static ArrayList<int[]>[] graphs;
	
	public static int solution() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
		
		int[] costs = new int[n];
		int[] vertex = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE/2);
		costs[0] = 0;
		
		for (int[] node : graphs[0]) {
			pq.add(new int[]{0, node[0], node[1]});
		}
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (costs[node[1]] <= node[2]) {
				continue;
			}
			
			costs[node[1]] = node[2];
			vertex[node[1]] = node[0];
			
			for (int[] child : graphs[node[1]]) {
				pq.add(new int[]{node[1], child[0], costs[node[1]]+child[1]});
			}
		}
		
		int minCost = costs[n-1];
		
		int start = n-1;
		int end = vertex[start];
		
		int maxValue = Integer.MIN_VALUE;
		
		while (start != 0 || end != 0) {
			maxValue = Math.max(maxValue, dijkstra(start, end));
			start = end;
			end = vertex[end];
		}
		
		return (maxValue == Integer.MAX_VALUE/2) ? -1 : Math.abs(minCost-maxValue);
	}
	
	public static int dijkstra(int v1, int v2) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
		int[] costs = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE/2);
		costs[0] = 0;
		
		for (int[] node : graphs[0]) {
			pq.add(new int[]{0, node[0], node[1]});
		}
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if (costs[node[1]] <= node[2]) {
				continue;
			}
			
			if ((v1 == node[0] && v2 == node[1]) || (v1 == node[1] && v2 == node[0])) {
				continue;
			}
			
			costs[node[1]] = node[2];
			
			for (int[] child : graphs[node[1]]) {
				pq.add(new int[]{node[1], child[0], costs[node[1]]+child[1]});
			}
		}
		
		return costs[n-1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		graphs = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			graphs[i] = new ArrayList<int[]>();
		}
		
		for (int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int v1 = Integer.parseInt(temp[0])-1;
			int v2 = Integer.parseInt(temp[1])-1;
			int c = Integer.parseInt(temp[2]);
			graphs[v1].add(new int[]{v2, c});
			graphs[v2].add(new int[]{v1, c});
		}
		
		System.out.println(solution());
	}
}
