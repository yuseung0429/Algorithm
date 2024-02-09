import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	static HashMap<Integer, Integer> map;
	
	static boolean isInclude(int a, int b) {
		if(a == b) return true;
		int setA = find(a);
		int setB = find(b);
		return (setA == -1 || setB == -1) ? false : setA == setB;
	}
	
	static void union(int a, int b) {
		if(!map.containsKey(a)) map.put(a, a);
		if(!map.containsKey(b)) map.put(b, b);
		
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA < rootB)
			map.put(rootB, rootA);
		else
			map.put(rootA, rootB);
	}
	
	static int find(int n) {
		Integer parent = map.get(n);
		if(parent == null)
			return -1;
		if(n == parent.intValue())
			return n;
		else {
			int root = find(parent.intValue());
			map.put(n, root);
			return root;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new HashMap<Integer, Integer>();
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		for(int i =0; i<m; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[1]);
			int y = Integer.parseInt(temp[2]);
			if(temp[0].equals("0"))
				union(x,y);
			else
				if(isInclude(x,y)) bw.append("YES").append("\n");
				else bw.append("NO").append("\n");
		}
		bw.flush();
	}
}
