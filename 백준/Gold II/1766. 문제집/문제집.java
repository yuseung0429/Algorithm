import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static boolean[] visited;
	static int[] leafCnt;
	static int cnt;
	static int n;
	static ArrayList<Integer>[] parents;
	static PriorityQueue<Integer> pq;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void solution() throws IOException {
		for(int i=0; i<n; i++)
			if(leafCnt[i] == 0)
				pq.add(i);
		while(!pq.isEmpty()) {
			int value = pq.poll();
			if(parents[value] != null)
				for(int j : parents[value])
					if(--leafCnt[j] == 0)
						pq.add(j);
			bw.append(String.valueOf(value+1)).append(" ");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		visited = new boolean[n];
		leafCnt = new int[n];
		pq = new PriorityQueue<>();
		parents = new ArrayList[n];
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int child = Integer.parseInt(temp[0])-1;
			int parent = Integer.parseInt(temp[1])-1;
			if(parents[child]==null) parents[child] = new ArrayList<Integer>();
			parents[child].add(parent);
			leafCnt[parent]++;
		}
		solution();
	}
}
