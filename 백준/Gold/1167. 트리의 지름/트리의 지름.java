import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<int[]>[] nodes;
	static boolean[] checked;
	static int max;

	public static int solution() {
		checked[0] = true;
		rec(nodes[0]);
		return max;
	}
	
	public static int rec(ArrayList<int[]> node) {
		
		int max1 = 0;
		int max2 = 0;
		
		for (int[] link : node) {
			if(checked[link[0]]) {
				continue;
			}
			checked[link[0]] = true;
			int num = rec(nodes[link[0]]) + link[1];
			if (num > max1) {
				max2 = max1;
				max1 = num;
			} else if (num > max2) {
				max2 = num;
			}
		}
		
		max = Math.max(max, max1 + max2);
		return max1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		nodes = new ArrayList[n];
		checked = new boolean[n];

		for (int i=0; i<n; i++) {
			nodes[i] = new ArrayList<int[]>();
		}		
				
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int vertex = Integer.parseInt(temp[0])-1;
			for (int j=1;;j+=2) {
				int child = Integer.parseInt(temp[j]);
				if (child == -1) {
					break;
				}
				child -= 1;
				int cost = Integer.parseInt(temp[j+1]);
				nodes[vertex].add(new int[]{child, cost});
			}
		}
		System.out.println(solution());
	}
}