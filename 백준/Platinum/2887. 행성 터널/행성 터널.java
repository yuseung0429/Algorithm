import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static class Planet{
		Planet(int v, int x, int y, int z){
			this.v = v;
			this.pos = new int[] {x, y, z};
		}
		int v;
		int[] pos;
	}
	static class Edge {
		Edge(int v1, int v2, int cost){
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		int v1;
		int v2;
		int cost;
	}
	
	static int n;
	static int[] root;
	
	static final int[] seq = new int[]{0, 1, 2};
	
	static ArrayList<Planet> planetList = new ArrayList<>();
	static ArrayList<Edge> edgeList = new ArrayList<>();
	
	public static int solution() {
		int cost = 0;
		for(int i: seq) {
			planetList.sort((o1, o2) -> o1.pos[i] - o2.pos[i]);
			int size = planetList.size();
			Planet pre = planetList.get(0);
			Planet current = null;
			for(int j=1; j<size; j++) {
				current = planetList.get(j);
				edgeList.add(new Edge(pre.v, current.v, Math.abs(pre.pos[i] - current.pos[i])));
				pre = current;
			}
		}
		edgeList.sort((o1, o2) -> o1.cost - o2.cost);
		
		for(Edge edge : edgeList) {
			if(find(edge.v1) != find(edge.v2)) {
				union(edge.v1, edge.v2);
				cost += edge.cost;
			}
		}
		return cost;
	}
	
	public static int find(int vertex) {
		if(root[vertex] == vertex)
			return vertex;
		return root[vertex] = find(root[vertex]);
	}
	
	public static void union(int v1, int v2) {
		int root1 = find(v1);
		int root2 = find(v2);
		if(root1 < root2)
			root[root2] = root1;
		else
			root[root1] = root2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		root = new int[n];
		for(int i=0; i<n; i++)
			root[i] = i;
		String[] temp = null;
		for(int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			int z = Integer.parseInt(temp[2]);
			Planet planet = new Planet(i, x, y, z);
			planetList.add(planet);
		}
		System.out.println(solution());	
	}
}
