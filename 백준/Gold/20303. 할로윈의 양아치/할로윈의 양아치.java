import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static class Children implements Comparable<Children>{
		Children(int cnt, int candies){
			this.cnt = cnt;
			this.candies = candies;
		}
		int cnt;
		int candies;
		@Override
		public int compareTo(Children o) {
			if(this.cnt == o.cnt)
				return this.candies - o.candies;
			else
				return this.cnt - o.cnt;
		}
	}
	
	static int[] candies;
	static boolean[] visited;
	static int[] dp;
	static ArrayList<Integer>[] graph;
	static ArrayList<Children> list;
	static int n;
	static int m;
	static int k;
	static int candiesCnt;
	static int childCnt;
	
	public static int solution() {
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				candiesCnt = 0;
				childCnt = 0;
				visited[i] = true;
				dfs(i);
				list.add(new Children(childCnt, candiesCnt));
			}
		}
		dp();
		return dp[k-1];
	}
	
	public static void dfs(int child) {
		candiesCnt += candies[child];
		childCnt++;
		if(graph[child] == null) {
			return;
		}
		for(int c : graph[child])
			if(!visited[c]) {
				visited[c] = true;
				dfs(c);
			}
	}
	
	public static void dp() {
		dp = new int[k];
		list.sort(null);
		for(Children c : list)
			for(int i=k; i>=0; i--)
				if(i+c.cnt < k)
					dp[i+c.cnt] = Math.max(dp[i+c.cnt], dp[i]+c.candies);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		candies = new int[n];
		temp = br.readLine().split(" ");
		for(int i=0; i<temp.length; i++)
			candies[i] = Integer.parseInt(temp[i]);
		visited = new boolean[n];
		graph = new ArrayList[n];
		list = new ArrayList<>();
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int c1 = Integer.parseInt(temp[0])-1;
			int c2 = Integer.parseInt(temp[1])-1;
			if(graph[c1]==null) graph[c1] = new ArrayList<>();
			if(graph[c2]==null) graph[c2] = new ArrayList<>();
			graph[c1].add(c2);
			graph[c2].add(c1);
		}
		System.out.println(solution());
	}
}
