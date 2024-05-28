import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Main {
	static int k;
	static int n;
	static int f;
	static TreeSet<Integer>[] graph;
	static boolean[] visited;
	static boolean isFinished;
	
	public static void solution() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			if(graph[i]==null || graph[i].size() < k-1)
				continue;
			rec(list, i);
		}
			
		if(!isFinished)
			System.out.println(-1);
	}
	
	public static void rec(List<Integer> list, int v) {
		
		if(isFinished)
			return;
		
		if(list.size() == k) {
			isFinished = true;
			list.sort(null);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<k; i++)
				sb.append(list.get(i)+1).append("\n");
			System.out.print(sb);
			return;
		}
		
		if(visited[v])
			return;
		
		boolean flag = false;
		for(int value : list) {
			if(graph[v]==null || !graph[v].contains(value)) {
				flag = true;
				break;
			}
		}

		if(graph[v]!=null && !flag) {
			list.add(v);
			visited[v] = true;
			Iterator<Integer> iter = graph[v].iterator();
			while(iter.hasNext()) {
				int value = iter.next();
				if(graph[value]==null || graph[value].size() < k-1)
					continue;
				rec(list, value);
			}
			list.remove(list.size()-1);
			visited[v] = false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		k = Integer.parseInt(temp[0]);
		n = Integer.parseInt(temp[1]);
		f = Integer.parseInt(temp[2]);
		graph = new TreeSet[n];
		visited = new boolean[n];
		for(int i=0; i<f; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0])-1;
			int y = Integer.parseInt(temp[1])-1;
			if(graph[x] == null) graph[x] = new TreeSet<Integer>();
			graph[x].add(y);
			if(graph[y] == null) graph[y] = new TreeSet<Integer>();
			graph[y].add(x);
		}
		solution();
	}
}
