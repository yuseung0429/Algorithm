import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	static int[] subjects;
	static int[] semesters;
	static ArrayList<Integer>[] graph;
	
	public static void solution() {
		
		Queue<int[]> queue = new ArrayDeque();
		
		for(int i=0; i<n; i++)
			if(subjects[i] == 0)
				queue.add(new int[]{i, 1});
		
		while(!queue.isEmpty()){
			int[] node = queue.poll();
			semesters[node[0]] = node[1];
			if(graph[node[0]] == null)
				continue;
			
			for(int num : graph[node[0]])
				if(--subjects[num] == 0)
					queue.add(new int[]{num, node[1]+1});
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		subjects = new int[n];
		semesters = new int[n];
		graph = new ArrayList[n];
		
		for(int i=0; i<m; i++){
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0])-1;
			int b = Integer.parseInt(temp[1])-1;
			subjects[b]++;
			if(graph[a] == null)
				graph[a] = new ArrayList<Integer>();
			graph[a].add(b);
		}
		solution();
		
		for(int i=0; i<n; i++)
			sb.append(semesters[i]).append(" ");
		System.out.println(sb);
	}
}