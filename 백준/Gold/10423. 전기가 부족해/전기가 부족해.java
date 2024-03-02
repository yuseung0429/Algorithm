import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
	
	static int n;
	static int m;
	static int k;
	
	static class Link implements Comparable<Link>{
		Link(int v1, int v2, int cost){
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		int v1;
		int v2;
		int cost;
		@Override
		public int compareTo(Link o) {
			return this.cost - o.cost;
		}
		
	}
	static PriorityQueue<Link> pq = new PriorityQueue<>();
	static HashSet<Integer> set = new HashSet<Integer>();
	static ArrayList<Link> list = new ArrayList<Link>();
	static int[] arr;
	
	public static int solution() {
		int minCost = 0;
		while(!pq.isEmpty()) {
			Link link = pq.poll();
			int rootV1 = find(link.v1);
			int rootV2 = find(link.v2);
			boolean isPoweredV1 = set.contains(rootV1);
			boolean isPoweredV2 = set.contains(rootV2);
			if(isPoweredV1 && isPoweredV2)
				continue;
			else if(!isPoweredV1 && !isPoweredV2) {
				list.add(link);
				continue;
			}
			union(rootV1, rootV2);
			minCost += link.cost;
			if(!list.isEmpty()) {
				pq.addAll(list);
				list.clear();
			}
		}
		return minCost;
	}
	
	public static int find(int vertex) {
		if(set.contains(vertex) || arr[vertex] == vertex)
			return vertex;
		return arr[vertex] = find(arr[vertex]);
	}
	
	public static void union(int vertex1, int vertex2) {
		if(set.contains(vertex1))
			arr[vertex2] = vertex1;
		else
			arr[vertex1] = vertex2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		arr = new int[n+1];
		for(int i=0; i<=n; i++)
			arr[i] = i;
		temp = br.readLine().split(" ");
		for(int i=0; i<temp.length; i++)
			set.add(Integer.parseInt(temp[i]));
		for(int j=0; j<m; j++) {
			temp = br.readLine().split(" ");
			int v1 = Integer.parseInt(temp[0]);
			int v2 = Integer.parseInt(temp[1]);
			int cost = Integer.parseInt(temp[2]);
			pq.add(new Link(v1, v2, cost));
		} 
		System.out.println(solution());
	}
}