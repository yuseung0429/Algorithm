import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	static int n;
	static int m;
	static Node[] nodes;
	static int[] outDegree;
	
	static class Node {
		ArrayList<Integer> parents = new ArrayList<>();
		ArrayList<int[]> children = new ArrayList<>();
	}
	
	public static void solution() {
		ArrayList<Integer> originalLeafs = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
			if(outDegree[i] == 0)
				originalLeafs.add(i);
		
		HashMap<Integer, Integer>[] dp = new HashMap[n];
		for(int i=0; i<n; i++)
			dp[i] = new HashMap<>();
		for(int leaf : originalLeafs)
			dp[leaf].put(leaf, 1);
		
		ArrayList<Integer> leafs= new ArrayList<Integer>(originalLeafs);
		ArrayList<Integer> nextLeafs= new ArrayList<Integer>();
		
		while(!leafs.isEmpty()) {
			for(int leaf : leafs) {
				Node leafNode = nodes[leaf];
				for(int parent : leafNode.parents) {
					outDegree[parent] -= 1;
					if(outDegree[parent] == 0)
						nextLeafs.add(parent);
				}
				for(int[] child : leafNode.children) {
					for(Entry<Integer, Integer> entry : dp[child[0]].entrySet()) {
						int key = entry.getKey();
						int value = entry.getValue();
						if(dp[leaf].get(key) == null)
							dp[leaf].put(key, child[1] * value);
						else
							dp[leaf].put(key, dp[leaf].get(key) + child[1] * value);
					}
				}
			}
			leafs.clear();
			leafs.addAll(nextLeafs);
			nextLeafs.clear();
		}
		ArrayList<int[]> result = new ArrayList<>(); 
		for(Entry<Integer, Integer> entry : dp[n-1].entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			result.add(new int[] {key,value});
		}
		
		result.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		for(int[] base : result)
			System.out.println(base[0]+1+" "+base[1]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		nodes = new Node[n];
		outDegree = new int[n];
		for(int i=0; i<n; i++)
			nodes[i] = new Node();
		
		for(int i=0; i<m; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0])-1; // 부품
			int y = Integer.parseInt(temp[1])-1; // 필요 부품
			int k = Integer.parseInt(temp[2]); // 개수
			nodes[x].children.add(new int[] {y,k});
			nodes[y].parents.add(x);
			outDegree[x] += 1;
		}
		solution();
	}
}