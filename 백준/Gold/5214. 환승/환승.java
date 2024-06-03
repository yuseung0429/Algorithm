import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int n;
	static int k;
	static int m;
	static boolean[] visited;
	static boolean[] tubeVisited;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer>[] tubes;

	public static int solution() {
		if(n==1)
			return 1;
		Queue<int[]> queue = new ArrayDeque<>();
		
		for(int tube : graph[0])
			queue.add(new int[] {tube, 1});

		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			if(tubeVisited[node[0]])
				continue;
			for(int vertex : tubes[node[0]]) {
				if(visited[vertex])
					continue;
				if(vertex == n-1)
					return node[1]+1;
				for(int tube : graph[vertex]) {
					if(tubeVisited[tube])
						continue;
					queue.add(new int[] {tube, node[1]+1});
				}
				visited[vertex] = true;
			}
			tubeVisited[node[0]] = true;
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		m = Integer.parseInt(temp[2]);
		graph = new ArrayList[n];
		tubes = new ArrayList[m];
		visited = new boolean[n];
		tubeVisited = new boolean[m];
		
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for(int i=0; i<m; i++)
            tubes[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			for(String str : br.readLine().split(" "))
				tubes[i].add(Integer.parseInt(str)-1);
			for(int vertex : tubes[i])
				graph[vertex].add(i);
		}
		System.out.println(solution());
	}
}
