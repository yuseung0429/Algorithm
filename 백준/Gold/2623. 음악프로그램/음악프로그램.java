import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static ArrayList<Integer>[] parent;
	static int[] leaf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		leaf = new int[n];
		parent = new ArrayList[n];
		
		for(int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int pre = Integer.parseInt(temp[1])-1;
			for(int j=2; j<temp.length; j++) {
				int cur = Integer.parseInt(temp[j])-1;
				if(parent[pre] == null) parent[pre] = new ArrayList<>();
				parent[pre].add(cur);
				leaf[cur]++;
				pre = cur;
			}
		}
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i=0; i<n; i++)
			if(leaf[i] == 0)
				queue.add(i);
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			bw.append(vertex+1+" ");
			if(parent[vertex] == null)
				continue;
			for(int p : parent[vertex])
				if(--leaf[p]==0)
					queue.add(p);
		}
		
		boolean flag = false;
		for(int i=0; i<n; i++)
			if(leaf[i] != 0) {
				flag = true;
				break;
			}
		if(flag)
			System.out.println(0);
		else
			bw.flush();
	}
} 