import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int q;
	
	static int[][] lines;
	static int[][] queries;
	static int[] subSet;
	
	public static void solution() {
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(lines, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});

		for (int i=0; i<n; i++) {
			subSet[i] = i;
		}
		
		int start = lines[0][0];
		int end = lines[0][1];
		
		for (int i=1; i<n; i++) {
			if (start <= lines[i][0] && end >= lines[i][0]) {
				end = Math.max(end, lines[i][1]);
				union(lines[i-1][3], lines[i][3]);
			} else {
				start = lines[i][0];
				end = lines[i][1];
			}
		}
		
		for (int i=0; i<q; i++) {
			if (find(queries[i][0]) == find(queries[i][1])) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void union(int v1, int v2){
		int rv1 = find(v1);
		int rv2 = find(v2);
		
		if (rv1 != rv2) {
			subSet[rv2] = rv1;
		}
	};
	
	public static int find(int vertex){
		if(subSet[vertex] == vertex) {
			return vertex;
		}
		return subSet[vertex] = find(subSet[vertex]);
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		q = Integer.parseInt(temp[1]);
		
		lines = new int[n][4];
		queries = new int[q][2];
		subSet = new int[n];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			lines[i][0] = Integer.parseInt(temp[0]);
			lines[i][1] = Integer.parseInt(temp[1]);
			lines[i][2] = Integer.parseInt(temp[2]);
			lines[i][3] = i;
		}
		
		for (int i=0; i<q; i++) {
			temp = br.readLine().split(" ");
			queries[i][0] = Integer.parseInt(temp[0])-1;
			queries[i][1] = Integer.parseInt(temp[1])-1;
		}
		solution();
	}
}