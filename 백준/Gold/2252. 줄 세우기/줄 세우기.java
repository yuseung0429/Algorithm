import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int[] leafCnt;
	static boolean[] visited;
	static ArrayList<Integer>[] parent;
	
	public static void solution() throws IOException {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0; i<n; i++)
			if(leafCnt[i] == 0)
				queue.add(i);
			
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			bw.append(String.valueOf(vertex+1)+" ");
			if(parent[vertex] == null)
				continue;
			for(int v : parent[vertex])
				if(--leafCnt[v] == 0)
					queue.add(v);
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		parent = new ArrayList[n];
		leafCnt = new int[n];
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int s = Integer.parseInt(temp[0])-1;
			int t = Integer.parseInt(temp[1])-1;
			if(parent[s] == null)
				parent[s] = new ArrayList<Integer>();
			parent[s].add(t);
			leafCnt[t]++;
		}
		solution();
	}
}
