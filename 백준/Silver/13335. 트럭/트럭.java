import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int w;
	static int l;
	static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	
	public static void solution() {
		ArrayDeque<int[]> taskQueue = new ArrayDeque<int[]>();
		int time = 0;
		int cnt = 0;
		int weight = 0;
		
		while(!queue.isEmpty() || !taskQueue.isEmpty()) {
			time++;
		
			if (!taskQueue.isEmpty()) {
				if (time - taskQueue.peekFirst()[1] == w) {
					int[] node = taskQueue.pollFirst();
					weight -= node[0];
				}
			}
			
			if(taskQueue.size() < w) {
				if (queue.isEmpty() || weight + queue.peekFirst() > l) {
					continue;
				}
				taskQueue.addLast(new int[]{queue.peekFirst(), time});
				weight += queue.pollFirst();
			}
		}
		System.out.println(time);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		w = Integer.parseInt(temp[1]);
		l = Integer.parseInt(temp[2]);
		
		temp = br.readLine().split(" ");
		for (int i=0; i<temp.length; i++) {
			queue.addLast(Integer.parseInt(temp[i]));
		}
		
		solution();
	}
}