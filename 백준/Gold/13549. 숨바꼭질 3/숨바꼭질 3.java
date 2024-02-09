import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int s = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);
		HashSet<Integer> visited = new HashSet<Integer>();
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {s, 0});
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int v = node[0];
			int h = node[1];
			
			if(v == b) {
				System.out.println(h);
				return;
			}
			
			if(visited.contains(v))
				continue;

			visited.add(v);
			
			if(v<=b && !visited.contains(2*v))
				queue.addFirst(new int[] {2*v, h});
			if(v+1<=b && !visited.contains(v+1))
				queue.addLast(new int[] {v+1, h+1});
			if(v-1>=0 && !visited.contains(v-1))
				queue.addLast(new int[] {v-1, h+1});
		}
	}
}
